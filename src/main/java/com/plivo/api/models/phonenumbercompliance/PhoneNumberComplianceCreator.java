package com.plivo.api.models.phonenumbercompliance;

import com.plivo.api.exceptions.ResourceNotFoundException;
import com.plivo.api.models.base.Creator;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PhoneNumberComplianceCreator extends Creator<PhoneNumberComplianceCreateResponse> {

    private MultipartBody.Builder body;

    PhoneNumberComplianceCreator(String dataJson) {
        this.body = new MultipartBody.Builder().setType(MultipartBody.FORM);
        this.body.addFormDataPart("data", dataJson);
    }

    public PhoneNumberComplianceCreator addDocument(int index, String filePath) throws ResourceNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new ResourceNotFoundException("File missing " + filePath);
        }
        try {
            String contentType = "";
            if (Files.probeContentType(file.toPath()) != null) {
                contentType = Files.probeContentType(file.toPath());
            } else {
                Path source = Paths.get(filePath);
                MimetypesFileTypeMap m = new MimetypesFileTypeMap(source.toString());
                contentType = m.getContentType(file);
            }
            this.body.addFormDataPart("documents[" + index + "].file", file.getName(),
                    RequestBody.create(MediaType.parse(contentType), file));
        } catch (IOException e) {
            throw new ResourceNotFoundException("Unable to read file " + filePath);
        }
        return this;
    }

    @Override
    protected Call<PhoneNumberComplianceCreateResponse> obtainCall() {
        return client().getApiService().phoneNumberComplianceCreate(client().getAuthId(), this.body.build());
    }
}
