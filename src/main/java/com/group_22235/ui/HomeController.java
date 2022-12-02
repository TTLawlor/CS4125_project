package com.group_22235.ui;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.group_22235.user.UserService;
import com.group_22235.user.UserDto;
import com.group_22235.user.User;
import com.group_22235.booking.TicketDto;
import com.group_22235.booking.TicketFacade;
import com.group_22235.booking.TicketService;
import com.group_22235.generics.ABaseServiceImpl;
import com.group_22235.services_management.RouteTimetable;
import com.group_22235.services_management.RouteTimetableService;
import com.group_22235.services_management.Station;
import com.group_22235.services_management.StationService;
import com.group_22235.services_management.Train;
import com.group_22235.services_management.TrainController;
import com.group_22235.services_management.TrainService;




@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private TrainService trainService;
    @Autowired
    private TrainController trainController;
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
        // this.ticketDto = ticketDto;
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
    public String index() {
        return "Index";
    }

    @GetMapping("/IndexUser")
    public String indexUser() {
        return "IndexUser";
    }

    // @GetMapping("/Admin")
    // public String admin() {
    //     return "Admin";
    // }

    @GetMapping("/Admin")
    public String add(Model model) throws Exception {
        System.out.println("TESTINGGG");
        model.addAttribute("listTrain", trainService.findAll());
        return "Admin";
    }

    // @ModelAttribute("listTrain")

    // @RequestMapping("/edit/{trainid}")
    // public ModelAndView showEditTrainPage(@PathVariable(name="id") int id) {
    //     ModelAndView mav = new ModelAndView("new");
    //     TrainController trainID = trainController.getByID(id);
    //     mav.addObject("train", trainID);
    //     return mav;
    // }

    @GetMapping("/LoginTest")
    public String loginTest() {
        return "LoginTest";
    }
}