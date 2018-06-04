package com.jmts.controller;


import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value = "file")
public class FileController {


    @RequestMapping(
            value="upload",
            method= RequestMethod.POST
    )


    //文件上传
    public String upload(
            HttpServletRequest httpServletRequest,
            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile files
    ) throws IOException {

        String path = httpServletRequest.getServletContext().getRealPath("/images/");

        String filename = files.getOriginalFilename();

        File filepath = new File(path,filename);

        if(!filepath.getParentFile().exists()){

            filepath.getParentFile().mkdirs();

        }

        files.transferTo(new File(path+File.separator+filename));
        return "success";

    }

    //文件下载
    @RequestMapping(value="download")
    public ResponseEntity<byte[]> download(
            HttpServletRequest httpServletRequest,
            @RequestParam(value = "filename") String filename,
            Model model) throws IOException {

        String path = httpServletRequest.getServletContext().getRealPath("/statics");
        File file = new File(path+ File.separator+ filename);

        HttpHeaders headers = new HttpHeaders();

        String downloadFilename = new String( filename.getBytes("utf-8"),"iso-8859-1" );


        headers.setContentDispositionFormData("attachment",downloadFilename);

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity< byte [] >(FileUtils.readFileToByteArray(file), headers , HttpStatus.CREATED) ;

    }


}















