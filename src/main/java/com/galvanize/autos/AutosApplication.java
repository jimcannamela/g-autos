package com.galvanize.autos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutosApplication implements CommandLineRunner {

	public AutosApplication(AutosRepository autosRepository) {
		this.autosRepository = autosRepository;
	}

	private final AutosRepository autosRepository;

	public static void main(String[] args) {
		SpringApplication.run(AutosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		autosRepository.save(new Automobile("1967", "Ford", "Mustang"));
		autosRepository.save(new Automobile("1970", "AMC", "Gremlin"));
		autosRepository.save(new Automobile("1981", "Chrysler", "Imperial"));
		autosRepository.save(new Automobile("1972", "Chevrolet", "Impala"));
		autosRepository.save(new Automobile("1981", "DeLorean", "DMC-12"));
		autosRepository.save(new Automobile("1982", "Cadillac", "Cimarron"));
		autosRepository.save(new Automobile("1982", "Renault", "Fuego"));
		autosRepository.save(new Automobile("1982", "Alfa-Romeo", "Arna"));
		autosRepository.save(new Automobile("1984", "Ford", "Bronco II"));
		autosRepository.save(new Automobile("2022", "Tesla", "Model 3"));
	}
}
