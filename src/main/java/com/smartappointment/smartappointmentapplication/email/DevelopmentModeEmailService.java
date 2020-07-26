package com.smartappointment.smartappointmentapplication.email;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
@Profile({"default"})
public class DevelopmentModeEmailService implements EmailService {

  private final SpringTemplateEngine templateEngine;

  public DevelopmentModeEmailService(SpringTemplateEngine templateEngine) {
    this.templateEngine = templateEngine;
  }

  public void sendEmail(AppointmentSuggestionEmail email) {
      Context context = new Context();
      String emailAsHtml = templateEngine.process(email.getTemplateName(), context);
      System.out.println(emailAsHtml);
  }
}
