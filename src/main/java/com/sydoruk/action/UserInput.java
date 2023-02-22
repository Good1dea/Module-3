package com.sydoruk.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class UserInput {

    final static Logger log = LoggerFactory.getLogger("UserInput");
    private static UserInput instance;

    public static UserInput getInstance() {
        if (instance == null) {
            instance = new UserInput();
        }
        return instance;
    }

    protected String inputGroupName(){
        System.out.print(" >> To search, enter the name of the group or part : ");
        final Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        log.info(" >>>> User input : {} for search group by name", name);
        return name;
    }

    public String inputLecturerName(){
        System.out.print(" >> To search, enter first name or last name : ");
        final Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        log.info(" >>>> User input : {} for search lecturer by name", name);
        return name;
    }

    public Double inputAvgPoints(){
        boolean bExecute = false;
        double average = 0.0;
        final Scanner scanner = new Scanner(System.in);
        do{
            System.out.print(" >> To search, enter the value average points : ");
            if(scanner.hasNextDouble()){
                average = scanner.nextDouble();
                bExecute = true;
            } else {
                System.out.println(" !! Incorrect value.");
                log.info(" >>>> User input incorrect value for average points");
                scanner.next();
            }
        }while(!bExecute);
        log.info(" >>>> User input : {} for search students with an average score higher", average);
        return average;
    }
}

