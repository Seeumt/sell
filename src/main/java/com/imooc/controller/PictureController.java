package com.imooc.controller;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.imooc.dataobject.TPicture;
import com.imooc.service.PictureService;
import com.imooc.utils.AliyunOssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/TPicture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    /**
     * 主页
     * @return
     */
//    @GetMapping("/")
//    public String toIndex() {
//        return "add";
//    }

    /**
     * 全
     * @return
     */
    @ResponseBody
    @GetMapping("/all")
    public List<TPicture> getAllPictures() {

        return pictureService.getAllPictures();
    }

    /**
     * 增
     * @param
     * @throws IOException
     * @throws ClientException
     * @throws OSSException
     */
    @PostMapping("/insert")
    @ResponseBody
    public Map<String,String> insertPicture(@RequestParam("fileupload") MultipartFile fileupload, String picName, HttpServletRequest request) throws OSSException, ClientException, IOException {
        TPicture TPicture=new TPicture();
        TPicture.setPicName(picName);
        String url = AliyunOssUtil.getUrl(fileupload);
        TPicture.setUrl(AliyunOssUtil.getSuffix(url));
        //虽然传来的是文件，但是保存到数据库的是路径
        pictureService.insertPicture(TPicture);
        Map<String,String> map = new HashMap<>();
        map.put("url", url);
        return map;
    }

    /**
     * 改
     * @param TPicture
     */
    @ResponseBody
    @PutMapping("/update")
    public void updatePicture(TPicture TPicture) {
        pictureService.updatePicture(TPicture);
    }

    /**
     * 删
     * @param id
     */
    @ResponseBody
    @DeleteMapping("/delete/{id}")
    public void deletePicture(@PathVariable("id") Integer id) {
        pictureService.deletePicture(id);
    }

    /**
     * 查
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/get/{id}")
    public TPicture getPicture(@PathVariable("id") Integer id) {
        return pictureService.getPicture(id);
    }

    /**
     * 把文件保存到阿里云OSS，返回路径保存到数据库
     * @param fileupload
     * @return
     * @throws OSSException
     * @throws ClientException
     * @throws IOException
     */


}
