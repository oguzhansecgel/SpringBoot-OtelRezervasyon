package com.turizm.OtelRezervasyon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.turkcell.tcell.exception.annotations.EnableException;

@SpringBootApplication
@EnableException
public class OtelRezervasyonApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtelRezervasyonApplication.class, args);
	}

}
