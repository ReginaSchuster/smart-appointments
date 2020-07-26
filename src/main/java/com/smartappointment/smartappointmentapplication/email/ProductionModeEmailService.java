// Service adapted from https://www.quickprogrammingtips.com/spring-boot/how-to-send-email-from-spring-boot-applications.html and https://www.onlinetutorialspoint.com/spring-boot/how-to-send-spring-boot-mail-example.html
package com.smartappointment.smartappointmentapplication.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.ISpringTemplateEngine;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
@Slf4j
@Profile({"prod"})
public class ProductionModeEmailService implements EmailService {

  private final JavaMailSender emailSender;
  private final ISpringTemplateEngine templateEngine;
  private Executor executor;

  public ProductionModeEmailService(JavaMailSender emailSender, ISpringTemplateEngine templateEngine) {
    this.emailSender = emailSender;
    this.templateEngine = templateEngine;
  }

  @PostConstruct
  private void init() {
    this.executor = Executors.newSingleThreadExecutor();
  }

  @Async
  public void sendEmail(AppointmentSuggestionEmail email) {
    executor.execute(() -> {
      MimeMessage mimeMessage = createMimeMessage(email);
      sendEmail(mimeMessage);
    });
  }

  private void sendEmail(MimeMessage mimeMessage) {
    try {
      emailSender.send(mimeMessage);
    }
    catch (MailException e) {
      log.error("Error while sending email.", e);
    }
  }

  private MimeMessage createMimeMessage(AppointmentSuggestionEmail email) {
    MimeMessage mimeMessage = emailSender.createMimeMessage();
    Context context = new Context();
    String html = templateEngine.process(email.getTemplateName(), context);

    try {
      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
      helper.setTo(email.getRecipient());
      helper.setText(html, true);
      helper.setSubject(email.getSubject());
      helper.setFrom("no-reply@smartappointments.com");
      helper.setReplyTo("no-reply@smartappointments.com");
    }
    catch (MessagingException e) {
      log.error("Error while creating email.", e);
    }

    return mimeMessage;
  }

}
