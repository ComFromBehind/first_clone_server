package com.packt.cardatabase;

import com.packt.cardatabase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

	@Autowired
	private UserRepository urepository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	private static final Logger logger =
			LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
	private CarRepository repository;
	@Autowired
	private OwnerRepository orepository;
	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		orepository.saveAll(Arrays.asList(owner1,owner2));


		Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000,owner1);
		Car car2 = new Car("Nissan","Leaf", "White", "SSJ-3002", 2019, 29000,owner2);
		Car car3 = new Car("Toyota","Prius","Silver","KKO-0212",2020,39000,owner2);
		repository.saveAll(Arrays.asList(car1,car2,car3));
		for(Car car: repository.findAll()){
			logger.info(car.getBrand() + " "+car.getModel());
		}

		urepository.save(new User("user", "$2y$04$eNQ.b0IcOTdm6656F.Eh0.w8hfkXRDUL7dXT0DAZP4V.zCfH2Du0m","USER"));
		urepository.save(new User("admin","$2y$04$GwbNv7OprBi1wpXeSvKpo.7hDXPoeAWAzRd7bqHW3I0MOR4U/po6q","ADMIN"));
	}
}
