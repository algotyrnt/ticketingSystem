package com.punjitha.TicketingSystem;

import com.google.gson.Gson;
import com.punjitha.TicketingSystem.config.SystemConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;

@SpringBootApplication
public class TicketingSystemApplication {

	public static void main(String[] args) throws FileNotFoundException {SpringApplication.run(TicketingSystemApplication.class, args);}

}
