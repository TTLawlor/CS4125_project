package com.group_22235.ui;

import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/BookTicket")
    public String bookTicket() {
    return "BookTicket";
    }

    @GetMapping("/index")
    public String index() {
    return "index";
    }

    @GetMapping("/Admin")
    public String admin() {
        return "Admin";
    }
}