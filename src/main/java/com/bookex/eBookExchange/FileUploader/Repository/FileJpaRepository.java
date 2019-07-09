package com.bookex.eBookExchange.FileUploader.Repository;

import com.bookex.eBookExchange.FileUploader.Payload.UploadFileResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FileJpaRepository extends JpaRepository<UploadFileResponse, Long> {

    @Query(value = "select f from UploadFileResponse f where f.id = id")
    UploadFileResponse getFileById(Long id);
}
