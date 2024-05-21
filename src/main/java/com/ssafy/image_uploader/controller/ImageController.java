package com.ssafy.image_uploader.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.image_uploader.config.FTPSecretConfig;
import com.ssafy.image_uploader.service.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ImageController {

  private ImageService imageService;

  public ImageController(ImageService imageService) {
    this.imageService = imageService;
  }

  @Autowired
  private FTPSecretConfig ftpSecretConfig;

  @PostMapping
  public ResponseEntity<?> uploadFile(@RequestParam("image") MultipartFile image) {

    try {
      byte[] file = image.getBytes();
      String format = image.getContentType().split("/")[1];

      if (!format.equals("jpeg") && !format.equals("png") && !format.equals("gif") && !format.equals("jpg")) {
        return ResponseEntity.badRequest().build();
      }

      String url = imageService.uploadImage(file, format);

      String json = "{\"url\":\"" + url + "\"}";

      if (url == null) {
        return ResponseEntity.badRequest().build();
      } else {
        return ResponseEntity.ok(json);
      }
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }

  }

  @GetMapping
  public ResponseEntity<?> test() {
    // get data from FTPSecretConfig
    String json = "{\"host\":\"" + ftpSecretConfig.getHost() + "\",\"port\":\"" + ftpSecretConfig.getPort()
        + "\",\"username\":\"" + ftpSecretConfig.getUsername() + "\",\"password\":\"" + ftpSecretConfig.getPassword()
        + "\",\"basePath\":\"" + ftpSecretConfig.getBasePath() + "\",\"url\":\"" + ftpSecretConfig.getUrl() + "\"}";
    return ResponseEntity.ok(json);
  }

}
