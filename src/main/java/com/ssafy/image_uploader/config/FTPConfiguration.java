package com.ssafy.image_uploader.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:config.yaml")
public class FTPConfiguration {
  @Value("${ftp.host}")
  private String host;

  @Value("${ftp.port}")
  private int port;

  @Value("${ftp.username}")
  private String username;

  @Value("${ftp.password}")
  private String password;

  @Value("${ftp.path}")
  private String path;

  @Value("${ftp.url}")
  private String url;

  public String getHost() {
    return host;
  }

  public int getPort() {
    return port;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getPath() {
    return path;
  }

  public String getUrl() {
    return url;
  }

}
