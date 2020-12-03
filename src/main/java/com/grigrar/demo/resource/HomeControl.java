package com.grigrar.demo.resource;

import com.grigrar.demo.model.Currency;
import com.grigrar.demo.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeControl {
    @Autowired
    public CurrencyService currencyService;

    @GetMapping("/test")
    public String getHome(Model model){
         List<Currency> list = currencyService.getCurs();
         model.addAttribute("currencies", list);
         return "home";
    }

    @GetMapping("/convert")
    public String convertCurrency(@RequestParam("currencys1") BigDecimal currency1, @RequestParam("currencys2") BigDecimal currency2,@RequestParam("money") BigDecimal money, Model model) {
        model.addAttribute("otvet",currencyService.conversionCurrency(currency1,currency2, money));
        return "convert";
    }

}
