package com.olodyn;

public class CargoFlight extends Flight{
    float maxCargoSpace = 1000.0f;
    float usedCargoSpace;
    private int seats = 12;
    public CargoFlight(){}
    public CargoFlight(int flightNumber){
        super(flightNumber);
    }

    public CargoFlight(float maxCargoSpace){
        this.maxCargoSpace = maxCargoSpace;
    }

    public CargoFlight(int flightNumber, float maxCargoSpace){
        this(flightNumber);
        this.maxCargoSpace = maxCargoSpace;
    }

    public int getSeats(){ return  seats;}

    public void add1Package(float h, float w, float d){
        float size = h * w * d;
        if(hasCargoSpace(size))
            usedCargoSpace += size;
        else
            handleNoSpace();
    }

    private boolean hasCargoSpace(float size) {
        return  usedCargoSpace + size <= maxCargoSpace;
    }

    private void handleNoSpace() {
        System.out.println("Not enough space");
    }
}
