package com.olodyn;

public class Flight {
    private int passengers, seats = 150, totalCheckedBags;
    private int flightNumber;
    private char flightClass;
    private boolean[] isSeatAvailable = new boolean[seats];
    private static int allPassengers, maxPassengersPerFlight;

    {
        for (int i =0 ; i < seats; i++)
            isSeatAvailable[i] = true;
    }
    static{
      AdminService admin = new AdminService();
      admin.connect();
      maxPassengersPerFlight = admin.isRestricted() ?
              admin.getMaxFlightPassengers() :  Integer.MAX_VALUE;
      admin.close();
    }
    public Flight(){}
    public Flight(int flightNumber){this.flightNumber = flightNumber;}
    public Flight(char flightClass){this.flightClass = flightClass;}

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Flight))
            return false;

        Flight flight = (Flight) o;
        return flightNumber == flight.flightNumber && flightClass == flight.flightClass;
    }

    public int getSeats(){ return this.seats; }
    public void setSeats(int seats){ this.seats = seats; }
    public int getPassengers(){ return this.passengers; }
    public void setPassengers(int passengers){ this.passengers = passengers;}
    private boolean hasSeating(){ return  passengers < seats; }
    private boolean hasSeating(int count){return passengers + count <= seats;}
    public static int getAllPassengers(){ return allPassengers; }
    public static void resetAllPassengers(){ allPassengers = 0; }
    public int getTotalCheckedBags(){return this.totalCheckedBags;}
    public  int getFlightNumber(){ return  this.flightNumber; }
    public void setFlightNumber(int flightNumber){this.flightNumber = flightNumber;}
    private void handleTooMany(){
        System.out.println("Too Many ");
    }
    public boolean hasRoom(Flight f2){
        int total = this.passengers + f2.passengers;
        return  total <= seats;
    }
    static void swapNumbers(Flight i, Flight j){
        int k = i.getFlightNumber();
        i.setFlightNumber(j.getFlightNumber());
        j.setFlightNumber(k);
    }
    public void add1Passenger(){
        if(hasSeating() && passengers < maxPassengersPerFlight){
            passengers += 1;
            allPassengers +=1;
        } else { handleTooMany();}
    }
    public void add1Passenger(int bags){
        if(hasSeating()){
            add1Passenger();
            totalCheckedBags += bags;
        }
    }
    public void add1Passenger(Passenger p){
        add1Passenger(p.getCheckedBags());
    }
    public void add1Passenger(int bags, int carryOns){
    if(carryOns <= 2)
        add1Passenger(bags);
    }
    public void add1Passenger(Passenger p, int carryOns){
        add1Passenger(p.getCheckedBags(), carryOns);
    }
    public void addPassengers(Passenger... list){
        if(hasSeating(list.length)){
            passengers += list.length;
            for (Passenger passenger: list)
                totalCheckedBags += passenger.getCheckedBags();
        }
    }
}
