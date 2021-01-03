package com.frankmoley.boot.essentials;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {
	private final Counter greetingsCounter;

	private final PresidentRepository presidentRepository;

	public ApiController(PresidentRepository presidentRepository, MeterRegistry registry) {
		this.presidentRepository = presidentRepository;
		this.greetingsCounter=Counter.builder("api.greeting").register(registry);
	}

	@GetMapping("greeting")
	public String getGreeting() {
		greetingsCounter.increment();
		return "Hello LinkedIn Learning Student";
	}

	@GetMapping("presidents")
	@Timed(value = "api.getAllPresidents")
	public List<President> getAllUSPresidents() {
		List<President> presidents = new ArrayList<>();
		this.presidentRepository.findAll().forEach(presidents::add);
		return presidents;
	}

}
