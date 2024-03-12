package com.xust.service.impl;

import com.alibaba.nacos.common.util.Md5Utils;
import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.xust.entity.PmsFile;
import com.xust.service.FileService;
import com.xust.service.PmsFileService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.compress.utils.FileNameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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

    @Resource
    PmsFileService pmsFileService;
    @Override
    public String upload(String bucket, MultipartFile file) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        String md5 = DigestUtils.md5Hex(file.getInputStream());
        long size = file.getSize();
        String type = file.getContentType();
        PmsFile pmsFile = pmsFileService.get(md5, size, type);
        if (null != pmsFile){
            return pmsFile.getPath();
        }


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

        String path = "/" + bucket + "/" + fileName;
        pmsFile = new PmsFile(md5,size,type,path);
        pmsFileService.save(pmsFile);
        client.putObject(args);
        return path;
    }
}
