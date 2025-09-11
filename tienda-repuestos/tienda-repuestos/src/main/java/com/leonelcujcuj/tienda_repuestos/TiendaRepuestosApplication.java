package com.leonelcujcuj.tienda_repuestos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TiendaRepuestosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TiendaRepuestosApplication.class, args);
	}
    @Override
    public void run(String... args) {
        System.out.println("Aplicación iniciada correctamente");
    }
}
