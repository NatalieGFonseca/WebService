package com.example.demo.repository;

import java.time.ZoneId;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Fuso;

public interface FusosRepository extends JpaRepository<Fuso, ZoneId>{
	
}
