package com.example.converter;

public class CurrencyConverter {
    private String source,destination;
    double firstNumber,secondNumber;

    final double US_Doller = 1;
    final double Ero = 0.8937;
    final double British_Pound =0.7893;
    final double Australian_Doller = 1.44458;
    final double Canadian_Doller = 1.34733;
    final double Singapore_Doller = 1.37776;
    final double Indian_Rupee = 69.6701;

    public CurrencyConverter(String source, String destination, double firstNumber) {
        this.source = source;
        this.destination = destination;
        this.firstNumber = firstNumber;
    }

    public double CurrencyChecker(String current){
        if(current.equals("US_Doller")){
            return US_Doller;
        }
        else if (current.equals("Ero")){
            return Ero;
        }
        else if (current.equals("British_Pound")){
            return British_Pound;
        }
        else if (current.equals("Australian_Doller")){
            return Australian_Doller;
        }
        else if (current.equals("Canadian_Doller")){
                return Canadian_Doller;
        }
        else if (current.equals("Singapore_Doller")){
                return Singapore_Doller;
        }
        else {
            return Indian_Rupee;
        }
    }

    public double conversion(){
        secondNumber=(1/CurrencyChecker(source))*(CurrencyChecker(destination))*firstNumber;
        return secondNumber;
    }
}
