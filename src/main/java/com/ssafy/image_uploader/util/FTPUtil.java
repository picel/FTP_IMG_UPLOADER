package com.ssafy.image_uploader.util;

import java.io.ByteArrayInputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.image_uploader.config.FTPSecretConfig;

@Component
public class FTPUtil {

  private FTPClient ftpClient = new FTPClient();

  @Autowired
  private FTPSecretConfig ftpSecretConfig;

  public String uploadFile(byte[] image, String fileName) {
    try {
      boolean res = ftpClient.storeFile(ftpSecretConfig.getBasePath()
          + "/" + fileName, new ByteArrayInputStream(image));
      if (!res) {
        return null;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    return ftpSecretConfig.getUrl()
        + ftpSecretConfig.getBasePath()
        + "/" + fileName;
  }
}
