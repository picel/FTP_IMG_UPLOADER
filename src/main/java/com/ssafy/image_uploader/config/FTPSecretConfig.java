package com.ssafy.image_uploader.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:secret.properties")
public class FTPSecretConfig {

  @Value("${ftp.hostname}")
  private String host;

  @Value("${ftp.port}")
  private int port;

  @Value("${ftp.username}")
  private String username;

  @Value("${ftp.password}")
  private String password;

  @Value("${ftp.base_path}")
  private String basePath;

  @Value("${ftp.result_url}")
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

  public String getBasePath() {
    return basePath;
  }

  public String getUrl() {
    return url;
  }

}
