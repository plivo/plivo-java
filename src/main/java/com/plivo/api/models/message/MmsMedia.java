package com.plivo.api.models.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.plivo.api.models.base.BaseResource;

@JsonIgnoreProperties(value = {"id"})
public class MmsMedia extends BaseResource {
		
	private String contentType;
    private String fileName;
    private String mediaId;
    private String mediaUrl;
    private int size;
    private String messageUuid;
    private String uploadTime;
    
    public static MmsMediaLister getter(String id) {
	    return new MmsMediaLister(id);
	}
    
    public static MmsMediaLister lister(String id) {
	    return new MmsMediaLister(id);
	}
   
    public String getContentType() {
        return contentType;
    }
    
    public String getFileName() {
        return fileName;
    }
    
    public String getMediaId() {
        return mediaId;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public int getSize() {
        return size;
    }
    
    public String getMessageUuid() {
        return messageUuid;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    @Override
    public String getId() {
        return mediaId;
    }
}