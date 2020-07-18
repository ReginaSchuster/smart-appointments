package com.smartappointment.smartappointmentapplication.email;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
@Profile({"default"})
public class ConsoleEmailService implements EmailService {

  private final SpringTemplateEngine templateEngine;
  private final MailProperties mailProperties;

  public ConsoleEmailService(SpringTemplateEngine templateEngine, MailProperties mailProperties) {
    this.templateEngine = templateEngine;
    this.mailProperties = mailProperties;
  }

  @Override
  public void sendEmail(AbstractEmail email) {
    Context context = new Context();
    String baseUrl = mailProperties.getApplicationHostUrl() + ":" + mailProperties.getApplicationPort();
    context.setVariables(email.getEnhancedViewModel(baseUrl));
    String messageAsHtml = templateEngine.process(email.getTemplateName(), context);

    System.out.println("From:" + mailProperties.getFromEmail());
    System.out.println("Recipient:" + email.getRecipient());
    System.out.println("Subject: " + email.getSubject());
    System.out.println("Message as HTML: " + messageAsHtml);
  }
}
