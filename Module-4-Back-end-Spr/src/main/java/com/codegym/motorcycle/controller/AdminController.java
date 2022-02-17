package com.codegym.motorcycle.controller;

import com.codegym.motorcycle.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/listCustomer")
    public ModelAndView showListCustomer() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/list");

        return modelAndView;
    }
}
