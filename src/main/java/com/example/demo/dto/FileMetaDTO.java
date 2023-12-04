package com.celac.ecommerce.dto;/**
* @author scelac
*/
public class FileMetaDTO {
    private String fileName;
    private String urlPath;
    private String savedPath;
    private long size;

    public FileMetaDTO(String fileName, String urlPath, String savedPath, long size) {
        this.fileName = fileName;
        this.urlPath = urlPath;
        this.savedPath = savedPath;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getSavedPath() {
        return savedPath;
    }

    public void setSavedPath(String savedPath) {
        this.savedPath = savedPath;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
