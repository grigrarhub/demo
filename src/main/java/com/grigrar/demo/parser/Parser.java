package com.grigrar.demo.parser;

import com.grigrar.demo.model.Currency;
import com.grigrar.demo.repository.CurrencyRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
@Configuration
public class Parser {
    @Autowired
    CurrencyRepository currencyRepository;
    @Bean
    public void getPade() throws Exception {
        String url = "http://www.cbr.ru/scripts/XML_daily.asp";
        Document page = Jsoup.parse(new URL(url),300);
        Element table = page.select("ValCurs").first();
        Elements valutes = table.select("Valute");
        ArrayList<Currency> arrayList = new ArrayList<>();

        NumberFormat formatter = new DecimalFormat("#0.0000");
        for(Element element:valutes) {
            Currency currency = new Currency();
            currency.setName(element.select("Name").text());
            String str = element.select("Value").text().replace(",",".");
            currency.setValue(BigDecimal.valueOf(Double.parseDouble(str)));
            arrayList.add(currency);
        }
        currencyRepository.saveAll(arrayList);
        currencyRepository.findAll();
    }
}
