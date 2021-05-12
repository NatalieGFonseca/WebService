package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fuso")
public class FusosResource {
	
	@GetMapping("/{local}")
	public ZonedDateTime verificar(@PathVariable ZoneId local){
		LocalDateTime hora = LocalDateTime.now();
		local = ZoneId.of(local.getDisplayName(null, null));
		ZonedDateTime fuso = ZonedDateTime.of(hora, local);
		return fuso;
	}
}
