package com.bookex.eBookExchange.FileUploader.Repository;

import com.bookex.eBookExchange.FileUploader.Payload.UploadFileResponse;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepositoryImpl implements FileRepository {

    private FileJpaRepository repository;

    public FileRepositoryImpl(FileJpaRepository repository) { this.repository = repository; }

    @Override
    public UploadFileResponse getFileById(Long id) {
        return repository.getFileById(id);
    }

    @Override
    public UploadFileResponse addNewFile(UploadFileResponse fileResponse) {
        repository.save(fileResponse);
        return fileResponse;
    }
}
