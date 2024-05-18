package com.ssafy.image_uploader.util;

import java.io.ByteArrayInputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Component;

@Component
public class FTPUtil {

  private static FTPUtil instance = new FTPUtil();
  private FTPClient ftpClient;

  private String host = "";
  private int port = 0;
  private String username = "";
  private String password = "";
  private String basePath = "";
  private String url = "";

  private FTPUtil() {
    ftpClient = new FTPClient();
    try {
      ftpClient.connect(host, port);
      ftpClient.login(username, password);
      ftpClient.enterLocalPassiveMode();
      ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static FTPUtil getInstance() {
    return instance;
  }

  public String uploadFile(byte[] image, String fileName) {
    try {
      boolean res = ftpClient.storeFile(basePath + "/" + fileName, new ByteArrayInputStream(image));
      if (!res) {
        return null;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    return url + basePath + "/" + fileName;
  }
}
