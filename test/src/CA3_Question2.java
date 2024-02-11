import java.util.*;

/**
 *  Name: John Nally
 *  Class Group: GD2b
 */
public class CA3_Question2
{
    public static int[][]  floodFillStart() {
        Scanner kb = new Scanner(System.in);

        int[][] arr = new int[10][10];
        int wall = 50;
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
        return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {
        Deque<Point> points = new ArrayDeque<>();
        int count = 1;

        points.push(new Point(r, c)); // row = x, column = y

        while(!points.isEmpty()){
            Point currentCell = points.pop();
            if(arr[currentCell.getR()][currentCell.getC()] == 0){
                arr[currentCell.getR()][currentCell.getC()] = count;
                count++;

                if(currentCell.getR() > 0) {
                    if (arr[currentCell.getR() - 1][currentCell.getC()] == 0) {//NORTH
                        points.push(new Point(currentCell.getR() - 1, currentCell.getC()));
                    }
                }

                if(currentCell.getR() < arr.length - 1) {
                    if (arr[currentCell.getR() + 1][currentCell.getC()] == 0) {//SOUTH
                        points.push(new Point(currentCell.getR() + 1, currentCell.getC()));
                    }
                }

                if(currentCell.getC() > 0) {
                    if (arr[currentCell.getR()][currentCell.getC() - 1] == 0) {//WEST FILL
                        points.push(new Point(currentCell.getR(), currentCell.getC() - 1));
                    }
                }

                if(currentCell.getC() < arr[0].length - 1 ){
                    if(arr[currentCell.getR()][currentCell.getC() + 1] == 0){//EAST
                        points.push(new Point(currentCell.getR(), currentCell.getC() + 1));
                    }
                }



            }
        }



    }

    public static void start()
    {
        Scanner kb = new Scanner(System.in);
        int r = 0;
        int c = 0;

        int[][] arr = floodFillStart();
        display(arr);

        System.out.print("Which Row do you want to start filling (y)?: ");
        r = kb.nextInt();

        System.out.print("Column (x): ");
        c = kb.nextInt();

        fill(r, c, arr);

        display(arr);


    }
    public static void main(String[] args) {
        start();
    }

}

class Point{
    private int r = 0;

    private int c = 0;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}
