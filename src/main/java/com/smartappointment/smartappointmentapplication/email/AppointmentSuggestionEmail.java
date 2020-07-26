package com.smartappointment.smartappointmentapplication.email;

import com.smartappointment.smartappointmentapplication.car.CarEntity;

public class AppointmentSuggestionEmail {

  private final String recipient;
  private final CarEntity car;

  public AppointmentSuggestionEmail(String recipient, CarEntity car) {
    this.recipient = recipient;
    this.car = car;
  }

  public String getRecipient() {
    return recipient;
  }

  public String getSubject() {
    return "Appointment Suggestion";
  }

  public String getTemplateName() {
    return "email/appointment-suggestion";
  }

}
