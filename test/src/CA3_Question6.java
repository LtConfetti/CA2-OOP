
import java.util.*;
/**
 *  Name:John Nally
 *  Class Group: GD2B
 */
public class CA3_Question6
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String command="";

        Queue<Share> shareQueue = new LinkedList<>();
        double profit = 0.00;

        do {
            System.out.println("COMMANDS: [buy (int) (double)] [sell (int) (double)]");
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();

                shareQueue.add(new Share(qty, price));
            }
            else if(command.equals("sell"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                int total = 0;

                while(qty > 0 && !shareQueue.isEmpty()) {
                    total = 0;
                    for (Share share: shareQueue) {
                        total += share.getQuantity();
                    }

                    if (qty >= total) {
                        Share currentShare = shareQueue.poll(); // Remove the current share from the shareQueue queue
                        profit += (price - currentShare.getPrice()) * currentShare.getQuantity();
                        qty -= currentShare.getQuantity(); // Update remaining quantity to sell
                    } else {
                        Share currentShare = shareQueue.peek(); // Get the current share without removing it from the queue
                        if (qty >= currentShare.getQuantity()) {
                            profit += (price - currentShare.getPrice()) * currentShare.getQuantity();
                            shareQueue.poll(); // Remove shares from the shareQueue
                            qty -= currentShare.getQuantity(); // Update remaining quantity to sell
                        } else {
                            profit += (price - currentShare.getPrice()) * qty;
                            currentShare.setQuantity(currentShare.getQuantity() - qty);
                            qty = 0; // No shares to sell
                        }
                    }
                }
                System.out.println("Gainz iz " +profit);

            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}

class Block {
    private int quantity;
    private double price;

    public Block(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


