package com.example.converter;

public class TemeratureConverter {

    private String source,destination;
    double firstNumber,secondNumber;

    public TemeratureConverter(String source, String destination, double firstNumber) {
        this.source = source;
        this.destination = destination;
        this.firstNumber = firstNumber;
    }

    public double conversion(){
        switch (source){
            case "celsius":{
                switch (destination){
                    case "celsius":{
                        secondNumber=firstNumber;
                        return secondNumber;
                    }
                    case "fahrenheit":{
                        secondNumber=(firstNumber*9/5)+32;
                        return secondNumber;
                    }
                    case "kelvin":{
                        secondNumber=firstNumber+273.15;
                        return secondNumber;
                    }
                    default:{
                        secondNumber=0;
                        return secondNumber;
                    }
                }
            }
            case "fahrenheit":{
                switch (destination){
                    case "celsius":{
                        secondNumber=(firstNumber-32)*(5/9);
                        return secondNumber;
                    }
                    case "fahrenheit":{
                        secondNumber=firstNumber;
                        return secondNumber;
                    }
                    case "kelvin":{
                        secondNumber=(firstNumber-32)*(5/9)+273.15;
                        return secondNumber;
                    }
                    default:{
                        secondNumber=0;
                        return secondNumber;
                    }
                }
            }
            case "kelvin":{
                switch (destination){
                    case "celsius":{
                        secondNumber=firstNumber-273.15;
                        return secondNumber;
                    }
                    case "fahrenheit":{
                        secondNumber=(firstNumber-273.15)*(9/5)+32;
                        return secondNumber;
                    }
                    case "kelvin": {
                        secondNumber = firstNumber;
                        return secondNumber;
                    }
                    default:{
                        return secondNumber;
                    }
                }
            }
            default:{
                secondNumber=0;
                return secondNumber;
            }
        }
    }
}
