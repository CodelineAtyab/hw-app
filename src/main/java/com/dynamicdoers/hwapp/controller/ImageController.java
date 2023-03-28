package com.dynamicdoers.hwapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {
    @PostMapping(path = "/api/upload")
    public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(new String(file.getBytes()));
    }
}
