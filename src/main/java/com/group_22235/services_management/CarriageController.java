package com.group_22235.services_management;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarriageController {

    private final ICarriageService carriageService;

    public CarriageController(ICarriageService carriageService) {
        this.carriageService = carriageService;
    }

    @GetMapping("/carriages")
    public List<Carriage> getCarriages() throws Exception {
        return carriageService.findAll();
    }

    @GetMapping("/carriages/{id}")
    public Carriage getCarriagesById(@PathVariable("id") Long id) throws Exception {
        return carriageService.findById(id);
    }

}
