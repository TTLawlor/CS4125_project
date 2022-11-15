package com.group_22235.ui;
import com.group_22235.ServicesManagement.CarriageType;
import com.group_22235.ServicesManagement.ConcCarTypeCreator;

public class MainFile {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        ConcCarTypeCreator carCreator = new ConcCarTypeCreator();

        CarriageType car1 = carCreator.createCarriage("PASSENGER");

        System.out.println(car1.cleaningRoutine());
    }
}
