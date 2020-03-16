package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Fever {
    Integer savedTemperature;

    @GetMapping("fever")
    public String fever(){
        return "fever";
    }

    @PostMapping("fever")
    public String getTempAndCheckResult(@RequestParam(name = "temperature") Integer input, Model model){
        savedTemperature = input;
        model.addAttribute("temp", savedTemperature);
        if (savedTemperature > 37){
            return "gotFever";
        } else if (savedTemperature < 37){
            return "gotHypothermia";
        } else{
            return "normal";
        }
    }

}
