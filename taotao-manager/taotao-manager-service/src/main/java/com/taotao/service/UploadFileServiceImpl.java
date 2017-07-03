package com.taotao.service;

import com.taotao.utils.FtpUtil;
import com.taotao.utils.IDUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by syi on 2017-06-29.
 */
@Service
public class UploadFileServiceImpl implements UploadFileService {

//    todo     完成idea 注释配置

    @Value("${server_host}")
    private String HOST;

    @Value("${server_port}")
    private int PORT;
    @Value("${server.username}")
    private String USERNAME;
    @Value("${server.password}")
    private String PASSWORD;
    @Value("${server.basePath}")
    private String BASEPATH;
    @Value("${pic.baseUrl}")
    private String PIC_BAST_URL;


    String PicPath = new DateTime().toString("/yyyy/MM/dd/");

    @Override
    public Map upLoadPic(MultipartFile multipartFile) {
        /*
        *   1.得到旧名字
        *   2.生成新名字：id+就名字
        *   3.上传
        *
        * */

        String oldName = multipartFile.getOriginalFilename();
        String newName = IDUtils.genImageName() + oldName.substring(oldName.lastIndexOf("."));
        Map resultMap = new HashMap();
        try {
            InputStream inputStream = multipartFile.getInputStream();
            boolean result = FtpUtil.uploadFile(HOST, PORT, USERNAME, PASSWORD, BASEPATH,
                    PicPath, newName, inputStream);

            /*  返回的json数据格式
            * //成功时
{
        "error" : 0,
        "url" : "http://www.example.com/path/to/file.ext"
}
//          失败时
{
        "error" : 1,
        "message" : "错误信息"
}

            * */
            if (result) {
                resultMap.put("error", 0);
                resultMap.put("url", PIC_BAST_URL+PicPath+newName);
            } else {
                resultMap.put("error", 1);
                resultMap.put("messege", "上传失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultMap;
    }
}
