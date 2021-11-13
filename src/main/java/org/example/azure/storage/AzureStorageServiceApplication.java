package org.example.azure.storage;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AzureStorageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AzureStorageServiceApplication.class);
    }
}
