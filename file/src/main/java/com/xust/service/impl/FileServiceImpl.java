package com.xust.service.impl;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.xust.service.FileService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.apache.commons.compress.utils.FileNameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class FileServiceImpl implements FileService {

    @Value("${minio.url}")
    String url;

    @Value("${minio.username}")
    String username;

    @Value("${minio.password}")
    String password;

    @Override
    public String upload(String bucket, MultipartFile file) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        StringBuilder fileName = new StringBuilder(NanoIdUtils.randomNanoId());
        fileName.append(".").append(FileNameUtils.getExtension(file.getOriginalFilename()));

        MinioClient client = MinioClient.builder()
                .endpoint(url)
                .credentials(username,password)
                .build();

        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(bucket)
                .contentType(file.getContentType())
                .object(fileName.toString())
                .stream(file.getInputStream(),file.getSize(),0)
                .build();

        client.putObject(args);
        return "/" + bucket + "/" + fileName;
    }
}
