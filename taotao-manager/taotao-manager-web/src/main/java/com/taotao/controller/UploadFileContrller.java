package com.taotao.controller;

import com.taotao.JsonUtils;
import com.taotao.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by syi on 2017-06-29.
 */
@Controller
public class UploadFileContrller {
    @Autowired
    private UploadFileService uploadFileService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String upLoadPic(MultipartFile uploadFile){
        Map result = uploadFileService.upLoadPic(uploadFile);
        String json = JsonUtils.objectToJson(result);
        return json;
    }
}
