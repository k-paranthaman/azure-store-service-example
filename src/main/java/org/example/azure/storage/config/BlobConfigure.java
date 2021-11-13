package org.example.azure.storage.config;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlobConfigure {
    @Value("${azure.storage.account-key}")
    private String connectionString;

    @Bean
    public BlobContainerClient getBlobServiceClient(){
        return new BlobContainerClientBuilder().connectionString(connectionString).containerName("test").buildClient();
    }
}
