package com.olodyn;

public class CrewMember {
    FlightCrewJob job;
    String name;

    CrewMember(){}
   CrewMember(FlightCrewJob job, String name){
        this.job = job;
        this.name = name;
    }

   /* public <T> Comparable<T> getJob() {
        return
    } */

    public String getName() {
        return this.name;
    }
    public FlightCrewJob getJob(){
        return this.job;
    }
}
