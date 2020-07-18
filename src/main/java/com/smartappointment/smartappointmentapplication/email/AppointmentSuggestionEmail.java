package com.smartappointment.smartappointmentapplication.email;

import com.smartappointment.smartappointmentapplication.CarEntity;

public class AppointmentSuggestionEmail extends AbstractEmail {

  private final String recipient;
  private final CarEntity car;

  public AppointmentSuggestionEmail(String recipient, CarEntity car) {
    this.recipient = recipient;
    this.car = car;
  }

  @Override
  public String getRecipient() {
    return recipient;
  }

  @Override
  public String getSubject() {
    return "Appointment Suggestion";
  }

  @Override
  public String getTemplateName() {
    return "email/appointment-suggestion";
  }

  @Override
  void buildViewModel() {
    ViewModelEntry entry = new ViewModelEntry("car", car.getModel());
    addViewModelEntry(entry);
  }
}
