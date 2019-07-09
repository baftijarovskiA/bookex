package com.bookex.eBookExchange.FileUploader.Repository;

import com.bookex.eBookExchange.FileUploader.Payload.UploadFileResponse;

public interface FileRepository {

    UploadFileResponse getFileById(Long id);

    UploadFileResponse addNewFile(UploadFileResponse fileResponse);
}
