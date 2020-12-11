package com.example.converter;

public class UnitConvversion  {

    private String source,destination;
    double firstNumber,secondNumber;

    final double meter = 1;
    final double centimeter = 100;
    final double kilometer =0.001;
    final double inch = 39.37;
    final double feet = 3.281;
    final double miles = 0.0006214;
    final double millimeter = 1000;
    final double yard = 1.093613;


    public UnitConvversion(String source, String destination, double firstNumber) {
        this.source = source;
        this.destination = destination;
        this.firstNumber = firstNumber;
    }

    public double unitChecker(String unit){
        if(unit.equals("meter")){
            return meter;
        }
        else if (unit.equals("centimeter")){
            return centimeter;
        }
        else if (unit.equals("kilometer")){
            return kilometer;
        }
        else if (unit.equals("inch")){
            return inch;
        }
        else if (unit.equals("feet")){
            return feet;
        }
        else if (unit.equals("miles")){
            return miles;
        }
        else if (unit.equals("millimeter")){
            return millimeter;
        }
        else{
            return yard;
        }
    }

    public double conversion(){
        secondNumber=(1/unitChecker(source))*(unitChecker(destination))*firstNumber;
        return secondNumber;
    }

}
