//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.*;

/**
 *  Name:John Nally
 *  Class Group: GD2b
 */
public class CA3_Question1
{
    public static void runSimulation()
    {
        Scanner kb = new Scanner(System.in);
        int selectedCar = 0;
        String announcement = "Press 0 to exit";

        Deque<Integer> driveway = new ArrayDeque<>();//Driveway Q
        Deque<Integer> streetway = new ArrayDeque<>();//Street Q

        for (int i = 1; i < 11 ; i++) {
            driveway.push(i); //Putting 10 cars in driveway
        }
        //System.out.println(driveway);
        boolean run = true;//While it is true, program is ran
        while(run) {
            System.out.println("Street" + streetway);//Displays Street amount
            System.out.println("Driveway" + driveway);//Displays Drivewy Amount
            System.out.println("What car do you want to add or leave? ("+announcement+").");//User input
            selectedCar = kb.nextInt();

            if (selectedCar < 0) {//remove car from driveway

                selectedCar = Math.abs(selectedCar);
                while (selectedCar != driveway.peek()) {

                    streetway.push(driveway.peek());
                    driveway.pop();
                }
                driveway.pop();
                while (streetway.size() > 0) {//puts cars back from street into driveway
                    driveway.push(streetway.pop());
                    System.out.println("Street" + streetway);
                    System.out.println("Driveway" + driveway);
                }
            } else if (selectedCar > 0) {//add car to driveway
                driveway.push(selectedCar);
            } else {
            run = false;
            }
        }
    }

    public static void main(String[] args) {
        runSimulation();
    }

}