package com.example.converter;

public class AreaConverter {
    private String source,destination;
    double firstNumber,secondNumber;

    final double Square_Km = 0.000001;
    final double Hectare = 0.0001;
    final double Square_meter =1;
    final double Sqaure_mile = 0.0000003861;
    final double Acre = 0.000247105;
    final double Square_yard = 1.19599;
    final double Square_foot = 10.7639;
    final double Square_inch= 1550;

    public AreaConverter(String source, String destination, double firstNumber) {
        this.source = source;
        this.destination = destination;
        this.firstNumber = firstNumber;
    }

    public double AreaChecker(String current){
        if(current.equals("Square Km")){
            return Square_Km;
        }
        else if (current.equals("Hectare")){
            return Hectare;
        }
        else if (current.equals("Square meter")){
            return Square_meter;
        }
        else if (current.equals("Sqaure mile")){
            return Sqaure_mile;
        }
        else if (current.equals("Acre")){
            return Acre;
        }
        else if (current.equals("Square foot")){
            return Square_foot;
        }
        else if (current.equals("Square yard")){
            return Square_yard;
        }
        else {
            return Square_inch;
        }
    }

    public double conversion(){
        secondNumber=(1/AreaChecker(source))*(AreaChecker(destination))*firstNumber;
        return secondNumber;
    }
}
