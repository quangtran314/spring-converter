package com.amela.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConverterController {
    @RequestMapping(value = "/")
    public String getConvertForm(){
        return "index";
    }

    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    public ModelAndView showResult(@RequestParam("usd") double usd, @RequestParam("rate") double rate){
        ModelAndView modelAndView = new ModelAndView("converter");
        double vnd = usd * rate;
        modelAndView.addObject("vnd", vnd);
        modelAndView.addObject("rate", rate);
        modelAndView.addObject("usd", usd);
        return modelAndView;
    }
}
