package com.sydoruk.util;

import com.sydoruk.action.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Menu {
    final static Logger log = LoggerFactory.getLogger("User menu");

    private static Menu instance;

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }
    public void userChoice(){
        log.info(" --> Start program <--");
        final Actions actions = Actions.getInstance();
        int userChoice = 0;
        final Scanner scanner = new Scanner(System.in);
        do {
            showMenu();
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                log.info(" >>>> User input : {}", userChoice);
                switch (userChoice){
                    case 1:
                        log.info(" >> 1 : Search group by name");
                        actions.findGroupByName();
                        break;
                    case 2:
                        log.info(" >> 2 : Number of students in each group");
                        actions.getStudentCountInGroups();
                        break;
                    case 3:
                        log.info(" >> 3 : Average score each group");
                        actions.getGroupAveragePoints();
                        break;
                    case 4:
                        log.info(" >> 4 : Search lecturer by name");
                        actions.findLecturer();
                        break;
                    case 5:
                        log.info(" >> 5 : Subjects with the worst and best results");
                        actions.findSubjectMinMax();
                        break;
                    case 6:
                        log.info(" >> 6 : Students with an average score higher than the value");
                        actions.getStudentWithAverage();
                        break;
                    case 0:
                        log.info(" --> 0 : Exit program <-- ");
                        break;
                    default:
                        log.warn(" !! Incorrect input {}", userChoice);
                        System.out.println(" !! Input number from 0 to 6");
                        continue;
                }
            } else {
                log.warn(" !! Value not integer {}",  scanner.next());
                System.out.println(" !! Incorrect value. Input number from 0 to 6");
            }
        } while (userChoice != 0);
        scanner.close();
    }

    private void showMenu(){
        System.out.println();
        System.out.println("User menu:");
        System.out.println("\t1) Search group by name");
        System.out.println("\t2) Number of students in each group");
        System.out.println("\t3) Average score each group");
        System.out.println("\t4) Search lecturer by name");
        System.out.println("\t5) Subjects with the worst and best results");
        System.out.println("\t6) Students with an average score higher than the value");
        System.out.println("\t0) Exit");
        System.out.print("Make your choice: ");
    }
}