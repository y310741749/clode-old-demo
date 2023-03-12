package com.zict.controller;

import com.obs.services.ObsClient;
import com.obs.services.model.ObsObject;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

public class FileController {

    public static void main(String[] args) throws IOException {
        String endPoint = "obs.cn-north-4.myhuaweicloud.com";
        String ak = "BMGUVWTQUEKGAUT6AA3S";
        String sk = "FAFMRiv1qlB1QmLzSeYugnSiKHwkk6LYy2tu4kPJ";
//        // 创建ObsClient实例
//        ObsClient obsClient = new ObsClient(ak, sk, endPoint);
//
//        FileInputStream fis = new FileInputStream(new File("D:\\img\\test.jpg"));  // 待上传的本地文件路径，需要指定到具体的文件名
//        obsClient.putObject("bucketname1111", "test.jpg", fis);

        // 创建ObsClient实例
        final ObsClient obsClient = new ObsClient(ak, sk, endPoint);

        ObsObject obsObject = obsClient.getObject("bucketname1111", "Redis on Windows.docx");

// 读取对象内容
        System.out.println("Object content:");
        InputStream input = obsObject.getObjectContent();
        byte[] b = new byte[1024];
        FileOutputStream bos = new FileOutputStream("D:\\img\\Redis on Windows1.docx");
        int len;
        while ((len=input.read(b)) != -1){
            bos.write(b, 0, len);
        }

        bos.close();
        input.close();
    }
}
