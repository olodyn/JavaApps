package com.olodyn;

import java.nio.channels.FileLock;
import java.util.Scanner;

import static com.olodyn.MathEquation.getAverageResult;
import static  com.olodyn.Flight.*;

public class Main {

    public static void main(String[] args) {

        Divider divider = new Divider();
        doCalculation(divider, 100.0d, 50.0d);

        Adder adder = new Adder();
        doCalculation(adder, 25.0d, 92.0d);

        Subtracter subtracter = new Subtracter();
        doCalculation(subtracter, 100.0d, 50.0d);

        Multiplier multiplier = new Multiplier();
        doCalculation(multiplier, 20.0d, 12.0d);

        /* Flight f1 = new Flight(175);
        Flight f2 = new Flight(175);
        boolean result = f1.equals(f2);
        System.out.println("Is f1 and f2 equal: "+ result);
        
        performMoreCalculations();

        FlightCrewJob job1 = FlightCrewJob.PILOT;
        FlightCrewJob job2 = FlightCrewJob.FLIGHT_ATTENDANT;

        if(job2 == FlightCrewJob.PILOT)
            System.out.println("job 1 is Pilot");
        if(job1 != job2)
            System.out.println("job1 and job 2 are different"); */

        CrewMember geetha = new CrewMember(FlightCrewJob.PILOT, "Geetha");
        CrewMember bob = new CrewMember(FlightCrewJob.FLIGHT_ATTENDANT, "Bob");
         CrewMember agatha = new CrewMember(FlightCrewJob.COPILOT, "Agatha");
       // performOperation();
        whoIsInCharge(agatha, bob);

        executeInteractively();
    }

     static void whoIsInCharge(CrewMember member1, CrewMember member2) {
        CrewMember theBoss = member1.getJob().compareTo(member2.getJob()) > 0 ?
         member1 : member2 ;
        System.out.println(theBoss.getJob().getTitle() + " " +
                theBoss.getName() + " is boss");
    }

    void displayJobResponsibilities(FlightCrewJob job){
        switch(job){
            case FLIGHT_ATTENDANT:
                System.out.println("Assures passenger safety");
                break;
            case COPILOT:
                System.out.println("Assists in flying the plane");
                break;
            case PILOT:
                System.out.println("Flies the plane");
                break;
        }
    }

    private static void performMoreCalculations() {
        CalculateBase[] calculations = {
                new Divider(120.0d, 60.0d ),
                new Adder(49.0d, 38.0d),
                new Subtracter(250.0d, 120.0d),
                new Multiplier(13.0d, 13.0d)
        };
        System.out.println();
        System.out.println("Array Calculations");
        for( CalculateBase calculation : calculations){
            calculation.calculate();
            System.out.println("result = "+ calculation.getResult());
        }
    }

    static void doCalculation(CalculateBase calculation, double leftVal, double rightVal){
        calculation.setLeftVal(leftVal);
        calculation.setRightVal(rightVal);
        calculation.calculate();
        System.out.println("Calculation result = "+ calculation.getResult());
    }

    static void performCalculations(){

        MathEquation[] equations = new MathEquation[4];
         equations[0] = new MathEquation('d', 100.0d, 50.0d);
         equations[1] = new MathEquation('a', 25.0d, 92.0d);
         equations[2] = new MathEquation('s', 225.0d, 17.0d);
         equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for(MathEquation equation : equations){
            equation.execute();
            System.out.println("result = "+ equation.getResult());
        }

        System.out.println("Average Result =" + getAverageResult());

    }

    private static CalculateBase createCalculation(MathOperation operation, double leftVal, double rightVal ){
        CalculateBase calculation = null;
        switch(operation){
            case ADD:
                calculation = new Adder(leftVal, rightVal);
                break;
            case SUBTRACT:
                calculation = new Subtracter(leftVal, rightVal);
                break;
            case MULTIPLY:
                calculation = new Multiplier(leftVal, rightVal);
                break;
            case DIVIDE:
                calculation = new Divider(leftVal, rightVal);
                break;
            default:
                System.out.println("No such operation exists try again ");
                calculation = null;
                break;
        }
        return calculation;
    }



    static void executeInteractively(){
        System.out.println("Enter an operation and two numbers: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static  void performOperation(String[] parts){
        MathOperation operation =  MathOperation.valueOf(parts[0].toUpperCase());
        double leftVal = Double.parseDouble(parts[1]);
        double rightVal = Double.parseDouble(parts[2]);

        CalculateBase calculation = createCalculation(operation,leftVal,rightVal);
        calculation.calculate();
        System.out.println("Operation performed: "+ operation);
        System.out.println(calculation.getResult());
    }


}
