package com.smartappointment.smartappointmentapplication.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class MailProperties {

  private final String applicationHostUrl;
  private final String applicationPort;
  private final String fromEmail;

  public MailProperties(@Value("${application.host.url}") String applicationHostUrl,
                        @Value("${server.port}") String applicationPort,
                        @Value("${spring.mail.properties.from}") String fromEmail) {
    this.fromEmail = fromEmail;
    this.applicationHostUrl = applicationHostUrl;
    this.applicationPort = applicationPort;
  }

  public String getApplicationHostUrl() {
    return applicationHostUrl;
  }

  public String getApplicationPort() {
    return applicationPort;
  }

  public String getFromEmail() {
    return fromEmail;
  }
}
