package com.taotao.controller;

import com.taotao.utils.FtpUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
import org.springframework.stereotype.Controller;

import java.io.*;

/**
 * Created by syi on 2017-06-28.
 */
@Controller
public class TestContrller {
    @Test
    public void testFTPClient() throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("192.168.202.131");
        ftpClient.login("ftpuser", "ftpuser");
        FileInputStream upLoadFileStream = new FileInputStream(new File("C:\\Users\\syi\\Pictures\\river.jpg"));
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        ftpClient.storeFile("test01.jpg", upLoadFileStream);
        ftpClient.logout();
    }

    @Test
    public void testFTPUnit() throws FileNotFoundException {
        FileInputStream upLoadFileStream = new FileInputStream(new File("C:\\Users\\syi\\Pictures\\river.jpg"));
        FtpUtil.uploadFile("192.168.202.131", 21, "ftpuser", "ftpuser",
                "/home/ftpuser/www/images", "/2017/06/28", "test02.jpg", upLoadFileStream);
    }
}
