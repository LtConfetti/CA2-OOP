import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  Name:John Nally
 *  Class Group: GD2b
 */

/*
Direction enum used to indicate direction.
 l*/
enum DIRECTION {NORTH, SOUTH,EAST,WEST};

public class CA3_Question9
{
    public static void display(int[][] image)
    {
        for (int x = 0; x < image.length; x++)
        {
            for (int y = 0; y < image[0].length; y++)
            {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }
    public void solve(int x, int y, DIRECTION dir)
    {


    }

    private static void fill(int r, int c, int[][] arr)
    {
        Deque<Point> points = new ArrayDeque<>();
        int count = 1;

        points.push(new Point(r, c)); // row = x, column = y

        boolean mazeSolved = false;

        while(!mazeSolved){
            Point currentCell = points.pop();
            if(arr[currentCell.getR()][currentCell.getC()] == 0){
                arr[currentCell.getR()][currentCell.getC()] = count;
                count++;

                if(currentCell.getR() > 0) {
                    if (arr[currentCell.getR() - 1][currentCell.getC()] == 0) {//NORTH
                        points.push(new Point(currentCell.getR() - 1, currentCell.getC()));
                        if (currentCell.getR() == 0){
                            mazeSolved = true;
                        }
                    }
                }

                if(currentCell.getR() < arr.length - 1) {
                    if (arr[currentCell.getR() + 1][currentCell.getC()] == 0) {//SOUTH
                        points.push(new Point(currentCell.getR() + 1, currentCell.getC()));
                        if (currentCell.getR() == 7){
                            mazeSolved = true;
                        }
                    }
                }

                if(currentCell.getC() > 0) {
                    if (arr[currentCell.getR()][currentCell.getC() - 1] == 0) {//WEST FILL
                        points.push(new Point(currentCell.getR(), currentCell.getC() - 1));
                        if (currentCell.getC() == 0){
                            mazeSolved = true;
                        }
                    }
                }

                if(currentCell.getC() < arr[0].length - 1 ){
                    if(arr[currentCell.getR()][currentCell.getC() + 1] == 0){//EAST
                        points.push(new Point(currentCell.getR(), currentCell.getC() + 1));
                        if (currentCell.getC() == 7){
                            mazeSolved = true;
                        }
                    }
                }
            }
            arr[currentCell.getR()][currentCell.getC()] = 2;
        }
        display(arr);
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,1},
                {1,1,1,1,0,1,1,1},
                {0,0,0,0,0,0,0,1},
                {1,1,1,1,0,1,1,1},
                {1,0,0,0,0,1,1,1},
                {1,1,1,1,0,1,1,1},
                {1,1,1,1,1,1,1,1}
        };

        display(maze);
        fill(4,3,maze);
    }
}

