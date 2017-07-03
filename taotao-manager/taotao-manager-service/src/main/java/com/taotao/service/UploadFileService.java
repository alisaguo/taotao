package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by syi on 2017-06-29.
 */
public interface UploadFileService {
    Map upLoadPic(MultipartFile multipartFile);
}
