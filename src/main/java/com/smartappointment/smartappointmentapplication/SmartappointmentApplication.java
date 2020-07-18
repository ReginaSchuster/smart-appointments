package com.smartappointment.smartappointmentapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SmartappointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartappointmentApplication.class, args);
	}

}

@RestController
class HelloController {
	@GetMapping("/")
	String hello() {
		return "Hello World";
	}
}
