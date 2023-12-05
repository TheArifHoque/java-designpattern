package com.arifhoque.decorator_pattern;

import java.util.Map;

public class DecoratorPattern {
    public static void main(String[] args) {

    }
}

class Car {
    private String brand;
    private String model;
    private String color;
    private Integer wheelDiameter;
    private Boolean isElectric;
    private Boolean isSpecialEdition;
    private String editionName;

    public Car() {
    }

    public Car(String brand, String model, String color, Integer wheelDiameter, Boolean isElectric,
               Boolean isSpecialEdition, String editionName) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.wheelDiameter = wheelDiameter;
        this.isElectric = isElectric;
        this.isSpecialEdition = isSpecialEdition;
        this.editionName = editionName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWheelDiameter() {
        return wheelDiameter;
    }

    public void setWheelDiameter(Integer wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }

    public Boolean getElectric() {
        return isElectric;
    }

    public void setElectric(Boolean electric) {
        isElectric = electric;
    }

    public Boolean getSpecialEdition() {
        return isSpecialEdition;
    }

    public void setSpecialEdition(Boolean specialEdition) {
        isSpecialEdition = specialEdition;
    }

    public String getEditionName() {
        return editionName;
    }

    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", wheelDiameter=" + wheelDiameter +
                ", isElectric=" + isElectric +
                ", isSpecialEdition=" + isSpecialEdition +
                ", editionName='" + editionName + '\'' +
                '}';
    }
}

interface CarDecorator {
    void decorate(Map<String, Object> requirements, Car car);
}

class CarDecoratorImpl implements CarDecorator {

    @Override
    public void decorate(Map<String, Object> requirements, Car car) {
        String brand = (String) requirements.get("brand");
        String model = (String) requirements.get("model");
        String color = (String) requirements.get("color");

        car.setBrand(brand);
        car.setModel(model);
        car.setColor(color);
    }
}

abstract class DefaultCarDecorator implements CarDecorator {
    protected CarDecorator carDecorator;

    public DefaultCarDecorator(CarDecorator carDecorator) {
        this.carDecorator = carDecorator;
    }


     @Override
     public abstract void decorate(Map<String, Object> requirements, Car car);
 }

 class WheelDecorator extends DefaultCarDecorator {

     public WheelDecorator(CarDecorator carDecorator) {
         super(carDecorator);
     }

     @Override
     public void decorate(Map<String, Object> requirements, Car car) {
         carDecorator.decorate(requirements, car);

         Integer wheelDiameter = (Integer) requirements.get("wheelDiameter");
         car.setWheelDiameter(wheelDiameter);
     }
 }
