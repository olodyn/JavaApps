package com.olodyn;

public class Passenger {
    private int checkedBags, freeBags;
    private double perBagFee;

    public Passenger(){}
    public Passenger(int freeBags){
        this(freeBags > 1 ? 25.0d : 50.0d);
        this.freeBags = freeBags;
    }

    public Passenger(int freeBags, int checkedBags){
        this(freeBags);
        this.checkedBags = checkedBags;
    }
    private Passenger(double perBagFee){this.perBagFee = perBagFee;}

    public int getCheckedBags(){return this.checkedBags;}

    public void setCheckedBags(int checkedBags) { this.checkedBags = checkedBags; }

    public int getFreeBags() { return freeBags; }

    public void setFreeBags(int freeBags) { this.freeBags = freeBags; }

    public double getPerBagFee() { return perBagFee; }

    private void setPerBagFee(double perBagFee) { this.perBagFee = perBagFee; }


}
