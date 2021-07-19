package com.avaliacaoestudos.avaliacaoestudos;

import com.avaliacaoestudos.avaliacaoestudos.service.Anagrama;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AvaliacaoestudosApplication {

	public static void main(String[] args) {

		SpringApplication.run(AvaliacaoestudosApplication.class, args);


		Anagrama anagrama = new Anagrama();
		try {
			anagrama.test();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
