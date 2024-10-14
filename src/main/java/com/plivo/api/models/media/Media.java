package com.plivo.api.models.media;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.plivo.api.exceptions.ResourceNotFoundException;
import com.plivo.api.models.base.BaseResource;

// @JsonIgnoreProperties(value = {"id"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Media extends BaseResource {

    private String mediaId;
    private String fileName;
    private String contentType;
    private int size;
    private String uploadTime;
    private String mediaUrl;

    public static MediaUploader creator(
            String[] fileNames) throws ResourceNotFoundException {
        return new MediaUploader(fileNames);
    }

    public static MediaGetter getter(String id) {
        return new MediaGetter(id);
    }

    public static MediaLister lister() {
        return new MediaLister();
    }
    

    public String getMediaId() {
        return mediaId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public int getSize() {
        return size;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    @Override
    public String getId() {
        return mediaId;
    }
}
