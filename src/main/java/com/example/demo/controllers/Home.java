package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {

   static List<String> savedStrings = new ArrayList<>();

    @GetMapping("contact")
    public String index(){
        return "index";
    }

    @PostMapping("contact")
    public String contact(@RequestParam(name = "name") String input){
        savedStrings.add(input);
        return "redirect:/contact-list";
    }

    @GetMapping("contact-list")
    public String contactList(Model model){
        model.addAttribute("strings", savedStrings);
        return "contact";
    }

    @GetMapping("img")
    public String about(){
        return "img";
    }
}
