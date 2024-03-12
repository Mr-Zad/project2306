package com.xust.controller;

import com.xust.service.FileService;
import io.minio.errors.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    FileService fileService;

    @PostMapping(value = "/{bucket}/upload")
    public String upload(@PathVariable String bucket, MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return fileService.upload(bucket,file);
    }
}
