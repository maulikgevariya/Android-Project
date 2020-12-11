package com.example.converter;

public class SpeedConverter {
    private String source,destination;
    double firstNumber,secondNumber;

    public SpeedConverter(String source, String destination, double firstNumber) {
        this.source = source;
        this.destination = destination;
        this.firstNumber = firstNumber;
    }

    public double conversion(){
        switch (source){
            case "Meters/Sec":{
                switch (destination){
                    case "Meters/Sec":{
                        secondNumber=firstNumber;
                        return secondNumber;
                    }
                    case "Km/hour":{
                        secondNumber=firstNumber*3.6;
                        return secondNumber;
                    }
                    case "Mies/hour":{
                        secondNumber=firstNumber*2.23694;
                        return secondNumber;
                    }
                    case "Feet/Sec":{
                        secondNumber=firstNumber*3.281;
                        return secondNumber;
                    }
                }
            }
            case "Km/hour":{
                switch (destination){
                    case "Meters/Sec":{
                        secondNumber=firstNumber/3.6;
                        return secondNumber;
                    }
                    case "Km/hour":{
                        secondNumber=firstNumber;
                        return secondNumber;
                    }
                    case "Mies/hour":{
                        secondNumber=firstNumber/1.609;
                        return secondNumber;
                    }
                    case "Feet/Sec":{
                        secondNumber=firstNumber/1.097;
                        return secondNumber;
                    }
                }
            }
            case "Mies/hour":{
                switch (destination){
                    case "Meters/Sec":{
                        secondNumber=firstNumber/2.237;
                        return secondNumber;
                    }
                    case "Km/hour":{
                        secondNumber=firstNumber*1.609;
                        return secondNumber;
                    }
                    case "Mies/hour":{
                        secondNumber=firstNumber;
                        return secondNumber;
                    }
                    case "Feet/Sec":{
                        secondNumber=firstNumber*1.467;
                        return secondNumber;
                    }
                }
            }
            case "Feet/Sec":{
                switch (destination){
                    case "Meters/Sec":{
                        secondNumber=firstNumber/3.281;
                        return secondNumber;
                    }
                    case "Km/hour":{
                        secondNumber=firstNumber*1.097;
                        return secondNumber;
                    }
                    case "Mies/hour":{
                        secondNumber=firstNumber/1.467;
                        return secondNumber;
                    }
                    case "Feet/Sec":{
                        secondNumber=firstNumber;
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
