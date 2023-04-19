//package com.itheima.controller;
//
//import com.itheima.pojo.Result;
//import com.itheima.utils.AliOSSUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.UUID;
//
//@RestController
//@Slf4j
//public class UploadController {
//
//    @Autowired
//    private AliOSSUtil aliOSSUtil;
//
////    @PostMapping("/upload")
////    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
////        log.info("文件上传：{}，{}，{}", username, age, image);
////        String originalFilename = image.getOriginalFilename();
////        int index = originalFilename.lastIndexOf(".");
////
////        String newFilename =  UUID.randomUUID().toString() + originalFilename.substring(index);
////        image.transferTo(new File("E:\\学习java的\\" + newFilename));
////
////        return Result.success();
////    }
//
//    @PostMapping("/upload")
//    public Result upload(MultipartFile image) {
//        log.info("文件上传：{}", image.getOriginalFilename());
//
//        // 调用阿里云 OSS
//        aliOSSUtil.
//
//    }
//
//}
