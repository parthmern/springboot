package com.cfs.BootP06Security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BankController {


    @GetMapping("/contactUs")
    public String contactUS()
    {
        return "PUBLIC: Contact US at :123456789";
    }

    @GetMapping("/transfer")
    public String transfer()
    {
        return "PRIVATE: money transfer successful";
    }

    @GetMapping("/admin")
    public String admin()
    {
        return "PRIVATE: welcome admin";
    }

    @GetMapping("/about")
    public String about()
    {
        return "PUBLIC: Suresh founder of Laxmi Chit Fund";
    }
}
