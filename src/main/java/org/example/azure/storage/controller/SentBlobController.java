package org.example.azure.storage.controller;

import com.azure.core.annotation.Get;
import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@RestController
public class SentBlobController {

    @Value("azure-blob://test/Help.txt")
    private Resource blobFile;

    @Autowired
    private BlobContainerClient containerClient;

    @PostMapping("/writeBlobFile")
    public ResponseEntity<String> writeBlobFile(@RequestParam MultipartFile data) throws IOException {
        try  {
            BlobClient blobUploadClient=containerClient.getBlobClient("profile/authuser/"+data.getOriginalFilename());
            blobUploadClient.upload(data.getInputStream(),data.getSize());
            return ResponseEntity.ok().body("Upload Success");
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }
}
