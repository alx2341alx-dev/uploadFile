package com.example.upload.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.example.upload.helper.EncodeHelper;
import com.example.upload.services.UpoladFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Controller that responsible for file uploading
 */
@RestController
public class FileUploadController {

    @Autowired
    private UpoladFileService upoladFileService;

    /**
     * @return help information
     */
    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public String provideUploadInfo() {
        return "Используете метод Post для получения хэша файла";
    }

    /**
     * @param file file to calculate hash that satisfy gost 2012 requirements
     * @return hash of file that satisfy gost 2012 requirements
     */
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException, NoSuchAlgorithmException {
        String hash = upoladFileService.GetHashFromFile(file);
        return hash;
    }

}
