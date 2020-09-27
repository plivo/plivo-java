package com.plivo.api.models.compliancedocument;

import com.plivo.api.exceptions.ResourceNotFoundException;
import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.RequestBody;
import retrofit2.Call;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ComplianceDocumentCreator extends Creator<ComplianceDocumentCreateResponse> {

    private String endUserId;
    private String alias;
    private String documentTypeId;
    private String file;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;
    private String postalCode;
    private String lastName;
    private String firstName;
    private String dateOfBirth;

    private RequestBody filesAsRequestBody = null;

    ComplianceDocumentCreator(String endUserId, String documentTypeId, String alias) {
        if (!Utils.allNotNull(alias, endUserId)) {
            throw new IllegalArgumentException("alias, endUserId must not be null");
        }

        this.alias = alias;
        this.endUserId = endUserId;
        this.documentTypeId = documentTypeId;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDocumentTypeId(String documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public void setEndUserId(String endUserId) {
        this.endUserId = endUserId;
    }

    public void setFile(String file) throws ResourceNotFoundException {
        this.file = file;
        filesAsRequestBody = getFilesForFilenames(new String[]{file});
    }

    private RequestBody getFilesForFilenames(String[] fileNames) throws ResourceNotFoundException {
        Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
        for (int i = 0; i < fileNames.length; i++) {
            File tempFile = new File(fileNames[i]);
            boolean exists = tempFile.exists();
            if (!exists)
                throw new ResourceNotFoundException("File missing " + fileNames[i]);
            try {
                System.out.println(tempFile);
                System.out.println(tempFile.toPath());
                // handle for java 8
                String content_type = "";
                if (Files.probeContentType(tempFile.toPath()) != null) {
                    content_type = Files.probeContentType(tempFile.toPath());
                } else {
                    Path source = Paths.get(fileNames[i]);
                    MimetypesFileTypeMap m = new MimetypesFileTypeMap(source.toString());
                    content_type = m.getContentType(tempFile);
                }
                builder
                        .addFormDataPart("file", fileNames[i],
                                RequestBody.create(MediaType.parse(content_type), tempFile));
            } catch (IOException e) {
                throw new ResourceNotFoundException("Unable to read file " + fileNames[i]);
            }
        }
        return builder.build();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public RequestBody getFilesAsRequestBody() {
        return filesAsRequestBody;
    }

    @Override
    protected Call<ComplianceDocumentCreateResponse> obtainCall() {
        return client().getApiService().complianceDocumentCreate(client().getAuthId(), this, this.getFilesAsRequestBody());
    }
}
