package com.group_22235.ui;

import java.security.Principal;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import com.group_22235.user.UserService;
import com.group_22235.user.UserDto;
import com.group_22235.user.User;
import com.group_22235.services_management.RouteTimetableService;
import com.group_22235.services_management.Train;
import com.group_22235.services_management.TrainService;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private TrainService trainService;
    @Autowired
    private RouteTimetableService routeService;


    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/BookTicket")
    public String bookTicket() {
        return "BookTicket";
    }

    @GetMapping("/Index")
    public String index(Principal principal) {
        if(principal != null) {
            return "redirect:/IndexUser";
        }
        return "Index";
    }

    @GetMapping("/IndexUser")
    public String indexUser() {
        return "IndexUser";
    }

    @GetMapping("/Admin")
    public String add(Model model) {
        Train train = new Train();
        model.addAttribute("listTrain", trainService.findAll());
        model.addAttribute("train", train);
        return "Admin";
    }

    @PostMapping(value="/Admin/selectTrainID")
    public String routeByTrain(@Valid @ModelAttribute("train") Train train, BindingResult result, Model model) {
        System.out.println("train.id " + train.getId());

        long id = train.getId();
        if(id <= 0) {
            result.rejectValue("id", null, "No train with this id exists");
        }

        if(result.hasErrors()){
            return "/Admin";
        }

        model.addAttribute("listRoute", routeService.findAllByTrainID(id));
        return "redirect:/Admin";
    }
}