package com.group_22235;
import com.group_22235.services_management.CarriageType;
import com.group_22235.services_management.CarriageFactory;
import com.group_22235.services_management.CarriageType.Type;

public class MainFile {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        CarriageType car1 = CarriageFactory.createCarriage(Type.PASSENGER);

        System.out.println(car1.cleaningRoutine());
    }
}
