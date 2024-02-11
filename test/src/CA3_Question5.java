/**
 *  Name:
 *  Class Group:
 */
import java.util.*;
//John Nally
//GD2b

public class CA3_Question5
{

    public static void main(String[] args)
    {
        Queue<String> takeoffQ = new LinkedList<>();
        Queue<String> landingQ = new LinkedList<>();

        Scanner keyboard = new Scanner(System.in);
        boolean run = true;

        while(run){//running
            System.out.println("COMMANDS: [takeoff flightSymbol]. [land flightySymbol], [next], [quit] ");
            String command = keyboard.next();

            switch (command.toLowerCase()){
                case "takeoff":
                    String takeoffPlane = keyboard.next();
                    takeoffQ.offer(takeoffPlane);
                    break;

                case "land":
                    String landingPlane = keyboard.next();
                    landingQ.offer(landingPlane);
                    break;

                case "next":
                    if(landingQ.size() > 0){
                        System.out.println("Plane Landing: " +landingQ.peek());
                        landingQ.remove();
                    }
                    else if (takeoffQ.size() > 0) {
                        System.out.println("Plane Taking off: " + takeoffQ.peek());
                        takeoffQ.remove();
                    }
                    else{
                        System.out.println("No planes D:");
                    }
                    break;

                case "quit":
                    System.out.println("Turning off");
                    run = false;
                    break;
            }
        }


    }
}