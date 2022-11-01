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
    private List<CarriageType> carriageList;

    private static final Map<CarriageType.Type, CarriageType> carriagesMap = new HashMap<CarriageType.Type, CarriageType>();
    
    @PostConstruct
    private List<CarriageType> getCarriageList() {
        carriageList.stream().forEach(carriage ->carriagesMap.put(carriage.getCarriageType(), carriage));
        return carriageList;
    }
       
    public static CarriageType createCarriage(CarriageType.Type carType) {
        return carriagesMap.get(carType);
    }
}
