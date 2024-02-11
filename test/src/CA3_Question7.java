
import java.util.*;
/**
 *  Name: John Nally
 *  Class Group: GD2b
 */
public class CA3_Question7 {
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
        String command = "";

        Map<String, Queue<Share>> shareNamedQueue = new HashMap<>();
        double profit = 0.00;

        do {
            System.out.println("COMMANDS: [buy (string) (int) (double)] [sell (string) (int) (double)]");
            System.out.print(">");
            command = in.next();

            if (command.equalsIgnoreCase("buy")) {
                String shareName = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();

                Queue<Share> shareQueue = shareNamedQueue.getOrDefault(shareName, new LinkedList<>());
                shareQueue.add(new Share(qty, price));
                shareNamedQueue.put(shareName, shareQueue);
            }
            else if (command.equalsIgnoreCase("sell")) {
                String shareName = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                int total = 0;

                Queue<Share> shareQueue = shareNamedQueue.get(shareName);
                if (shareQueue == null || shareQueue.isEmpty()) {
                    System.out.println("No shares of " + shareName + " available for selling.");
                    continue;
                }

                while (qty > 0 && !shareQueue.isEmpty()) {
                    Share currentShare = shareQueue.peek();
                    int shareQuantity = currentShare.getQuantity();
                    double sharePrice = currentShare.getPrice();

                    if (qty >= shareQuantity) {
                        total += shareQuantity * price;
                        profit += (price - sharePrice) * shareQuantity;
                        shareQueue.poll(); // Remove shares from the queue
                        qty -= shareQuantity; // Update remaining quantity to sell
                    } else {
                        total += qty * price;
                        profit += (price - sharePrice) * qty;
                        currentShare.setQuantity(shareQuantity - qty);
                        qty = 0; // No shares to sell
                    }
                }
                System.out.println("Gainz iz" + profit);

            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}

