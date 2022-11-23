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

    @GetMapping("/UserTest")
    public String userTest() {
        return ("<h1>Welcome UserTest</h1>");
    }

    @GetMapping("/AdminTest")
    public String adminTest() {
        return ("<h1>Welcome AdminTest</h1>");
    }
}