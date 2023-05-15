package com.example.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.example.service.configuration.CloudStorageConfiguration;
import org.jbpm.document.Document;
import org.jbpm.document.service.DocumentStorageService;

import java.util.Date;
import java.util.List;
import java.util.Map;

//TODO: implement
public class CloudDocumentStorage implements DocumentStorageService {
    private final AmazonS3 amazonS3;

    private final TransferManager transferManager;

    private final String bucketName;

    private final String initialPath;

    public CloudDocumentStorage() {
        CloudStorageConfiguration configuration = new CloudStorageConfiguration();
        this.amazonS3 = configuration.getAmazonS3();
        this.transferManager = configuration.getTransferManager();
        this.bucketName = configuration.getBucketName();
        this.initialPath = configuration.getInitialPath();
    }

    @Override
    public Document buildDocument(String name, long size, Date lastModified, Map<String, String> params) {
        return null;
    }

    @Override // write
    public Document saveDocument(Document document, byte[] content) {
        return null;
    }

    @Override // read / setLoad service to 'this'
    public Document getDocument(String id) {
        return null;
    }

    @Override
    public byte[] loadContent(String id) {
        return new byte[0];
    }

    @Override
    public boolean deleteDocument(String id) {
        return false;
    }

    @Override
    public boolean deleteDocument(Document document) {
        return false;
    }

    @Override
    public List<Document> listDocuments(Integer page, Integer pageSize) {
        return null;
    }
}
