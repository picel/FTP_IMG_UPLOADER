package com.ssafy.image_uploader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.image_uploader.util.FTPUtil;

@Service
public class ImageServiceImpl implements ImageService {

  @Autowired
  private FTPUtil ftpUtil;

  @Override
  public String uploadImage(byte[] image, String format) {
    String fileName = java.util.UUID.randomUUID().toString() + System.currentTimeMillis() + "." + format;
    return ftpUtil.uploadFile(image, fileName);
  }
}
