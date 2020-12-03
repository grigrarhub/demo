package com.grigrar.demo;

import com.grigrar.demo.model.Currency;
import com.grigrar.demo.parser.Parser;
import com.grigrar.demo.repository.CurrencyRepository;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	Parser parser;
	@Autowired
	CurrencyRepository currencyRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		parser.getPade();
		}
}
