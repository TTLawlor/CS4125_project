package com.group_22235.ui;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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
import com.group_22235.booking.TicketDto;
import com.group_22235.booking.TicketService;
import com.group_22235.services_management.RouteTimetable;
import com.group_22235.services_management.RouteTimetableService;
import com.group_22235.services_management.StationService;
import com.group_22235.services_management.Train;
import com.group_22235.services_management.TrainService;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private TrainService trainService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private StationService stationService;
    @Autowired
    private RouteTimetableService routeTimetableService;

    TicketDto ticketDto;
    List<RouteTimetable> routes;
    RouteTimetable chosenRoute;
    
    public HomeController() {
        ticketDto = new TicketDto();
        routes = new ArrayList<>();
    }


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
    public String bookTicket(Model model) {
        model.addAttribute("listStations", stationService.findAll());
        model.addAttribute("routes", routes);
        model.addAttribute("ticket", ticketDto);
        model.addAttribute("ticket2", ticketDto);

        return "BookTicket";
    }

    @PostMapping("/BookTicket/save")
    public String createTicket(@Valid @ModelAttribute("ticket2") TicketDto ticketDto,
                               BindingResult result,
                               Model model){
        
        
        
        if(result.hasErrors()){
            model.addAttribute("ticket2", ticketDto);
            return "redirect:/BookTicket";
        }

        ticketService.saveTicket(ticketDto);
        return "redirect:/BookTicket?success";
    }

    @PostMapping("/BookTicket/routes")
    public String showRoutes(@Valid @ModelAttribute("ticket") TicketDto ticketDto,
                               BindingResult result,
                               Model model){
        this.ticketDto = ticketDto;
        if(result.hasErrors()){
            model.addAttribute("ticket2", ticketDto);
            return "redirect:/BookTicket?empty";
        }
        chosenRoute = new RouteTimetable();
        this.routes = routeTimetableService.findByStationIDs(ticketDto.getDepStation().getId(), ticketDto.getArrStation().getId());
        model.addAttribute("routes", routes);
        model.addAttribute("ticket2", ticketDto);
        model.addAttribute("route", chosenRoute);
        return "redirect:/BookTicket?times";
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

        model.addAttribute("listRoute", routeTimetableService.findAllByTrainID(id));
        return "redirect:/Admin";
    }
}