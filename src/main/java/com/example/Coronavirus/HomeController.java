package com.example.Coronavirus;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage(ModelMap map){
        Coronavirus coronavirus = new Coronavirus();
        map.put("activeCases",coronavirus.getActiveCases());
        map.put("probability",format(coronavirus.getActiveCases()*100*500/(36*1000*1000)));
        return "corona";


    }
    static String format(double d){
        BigDecimal bigDecimal = new BigDecimal(d);
        return bigDecimal.setScale(3, RoundingMode.HALF_EVEN).toString();
    }

}
