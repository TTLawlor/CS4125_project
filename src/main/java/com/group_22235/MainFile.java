package com.group_22235;
import com.group_22235.services_management.Carriage;
import com.group_22235.services_management.CarriageFactory;

public class MainFile {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        CarriageFactory cFactory = new CarriageFactory();
        Carriage car1 = cFactory.createCarriage("Dining");

        System.out.println(car1.cleaningRoutine());
    }
}
