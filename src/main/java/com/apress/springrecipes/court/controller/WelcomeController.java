package com.apress.springrecipes.court.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
// @RequestMapping("/welcome")
public class WelcomeController {

    // @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    @GetMapping("/welocome")
    public String welcome(Model model){
        Date today = new Date();
        model.addAttribute("today", today);
        return "welcome";
    }

}
