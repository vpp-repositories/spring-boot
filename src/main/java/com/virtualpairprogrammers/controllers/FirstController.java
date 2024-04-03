package com.virtualpairprogrammers.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

    @RequestMapping("/home.html")
    public ModelAndView firstPage() {
        Date dateAndTime = new Date();
//        return new ModelAndView("/WEB-INF/jsp/welcome.jsp", "dateAndTime", dateAndTime);
        return new ModelAndView("welcome", "dateAndTime", dateAndTime);
    }

}
