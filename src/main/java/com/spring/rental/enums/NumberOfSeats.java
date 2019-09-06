package com.spring.rental.enums;

public enum NumberOfSeats {
    TWO(2),
    FOUR(4),
    FIVE(5),
    SEVEN(7),
    TWELVE(12);

    private int numVal;

    NumberOfSeats(int numVal){
        this.numVal= numVal;
    }

    public int getNumVal(){
        return numVal;
    }
}
