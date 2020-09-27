package com.plivo.api.models.compliancedocument;

import com.plivo.api.exceptions.ResourceNotFoundException;
import com.plivo.api.models.base.Updater;
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

public class ComplianceDocumentUpdater extends Updater<ComplianceDocumentUpdateResponse> {

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


    public ComplianceDocumentUpdater(String id) {
        super(id);
    }

    public ComplianceDocumentUpdater setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public ComplianceDocumentUpdater setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ComplianceDocumentUpdater setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ComplianceDocumentUpdater setFile(String file) throws ResourceNotFoundException {
        this.file = file;
        filesAsRequestBody = getFilesForFilenames(new String[]{file});
        return this;
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

    public ComplianceDocumentUpdater setEndUserId(String endUserId) {
        this.endUserId = endUserId;
        return this;
    }

    public ComplianceDocumentUpdater setDocumentTypeId(String documentTypeId) {
        this.documentTypeId = documentTypeId;
        return this;
    }

    public ComplianceDocumentUpdater setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public ComplianceDocumentUpdater setCountry(String country) {
        this.country = country;
        return this;
    }

    public ComplianceDocumentUpdater setCity(String city) {
        this.city = city;
        return this;
    }

    public ComplianceDocumentUpdater setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public ComplianceDocumentUpdater setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public ComplianceDocumentUpdater setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public RequestBody getFilesAsRequestBody() {
        return filesAsRequestBody;
    }

    @Override
    protected Call<ComplianceDocumentUpdateResponse> obtainCall() {
        return client().getApiService().complianceDocumentUpdate(client().getAuthId(), id, this, this.getFilesAsRequestBody());
    }
}
