package com.ntn.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

	@GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }
}
