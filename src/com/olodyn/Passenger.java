package com.olodyn;

public class Passenger implements Comparable<Passenger>{
    private int checkedBags, freeBags;
    private double perBagFee;
    private String name;
    private int memberLevel; // 3 (first priority), 2 , 1
    private int memberDays;  // How long has been a member

    public Passenger(){}
    public Passenger(int freeBags){
        this(freeBags > 1 ? 25.0d : 50.0d);
        this.freeBags = freeBags;
    }

    public Passenger(int freeBags, int checkedBags){
        this(freeBags);
        this.checkedBags = checkedBags;
    }
    public Passenger(String name){this.name = name; }
    public Passenger(String name, int memberLevel, int memberDays){
        this(name);
        this.memberLevel = memberLevel;
        this.memberDays = memberDays;
    }
    private Passenger(double perBagFee){this.perBagFee = perBagFee;}

    public int getCheckedBags(){return this.checkedBags;}

    public void setCheckedBags(int checkedBags) { this.checkedBags = checkedBags; }

    public int getFreeBags() { return freeBags; }

    public void setFreeBags(int freeBags) { this.freeBags = freeBags; }

    public double getPerBagFee() { return perBagFee; }
    public String getName(){return name;}
    public int getMemberLevel(){return memberLevel;}
    public int getMemberDays(){return memberDays;}

    private void setPerBagFee(double perBagFee) { this.perBagFee = perBagFee; }

    public int compareTo(Passenger p){
        // Passenger p = (Passenger) o;
        int returnValue = p.memberLevel - memberLevel;
        if(returnValue == 0)
            returnValue = p.memberDays - memberDays;

        return returnValue;
    }


}
