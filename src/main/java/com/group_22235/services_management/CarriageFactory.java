package com.group_22235.services_management;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarriageFactory {
    @Autowired
    private List<Carriage> carriageList;

    private static final Map<String, Carriage> carriagesMap = new HashMap<String, Carriage>();
    
    @PostConstruct
    private List<Carriage> getCarriageList() {
        carriageList.stream().forEach(carriage ->carriagesMap.put(carriage.getCarriageType(), carriage));
        return carriageList;
    }
    
       
    public Carriage createCarriage(String carType) {
        Carriage carriage = carriagesMap.get(carType);
        if(carriage == null) throw new RuntimeException("Unknown carriage type: " + carType);
        return carriage;
    }
}
