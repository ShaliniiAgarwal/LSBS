package com.LSB.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MainRestController {
	@GetMapping(value="/main")
public String Welcome() {
	return "Hello Shalini";
}
}
