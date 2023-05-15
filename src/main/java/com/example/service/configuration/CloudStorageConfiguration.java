package com.example.service.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;

public class CloudStorageConfiguration {

    private final String accessKeyS3 = "";
    private final String secretKeyS3 = "";
    private final String serviceEndpointS3 = "";
    private final String signingRegionS3 = "";
    private final String bucketName = "";
    private final String initialPath = "";

    private final AmazonS3 amazonS3;
    private final TransferManager transferManager;

    public CloudStorageConfiguration() {
        this.amazonS3 = amazonS3();
        this.transferManager = transferManager(this.amazonS3);
    }

    public AWSCredentials credentials() {
        return new BasicAWSCredentials(
                accessKeyS3,
                secretKeyS3
        );
    }

    public TransferManager transferManager(AmazonS3 amazonS3) {
        return TransferManagerBuilder.standard()
                .withS3Client(amazonS3)
                .build();
    }

    public AmazonS3 amazonS3() {
        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(serviceEndpointS3, signingRegionS3);
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials()))
                .withEndpointConfiguration(endpointConfiguration)
                .withPathStyleAccessEnabled(true)
                .build();
    }

    public String getBucketName() {
        return bucketName;
    }

    public String getInitialPath() {
        return initialPath;
    }

    public AmazonS3 getAmazonS3() {
        return amazonS3;
    }

    public TransferManager getTransferManager() {
        return transferManager;
    }
}
