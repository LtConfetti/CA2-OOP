import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: John Nally
 *  Class Group: GD2b
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException
    {
        File file = new File(filename);
        Scanner input = new Scanner(file);


        Stack<String> tags = new Stack<>();
        while (input.hasNext()){
            String tag = input.next();
            if(tags.isEmpty()){
                tags.push(tag);
            }
            else if(tag.equals(tags.peek().substring(0, 1) + "/" + tags.peek().substring(1))) {//if it is closing bracket for the top of the stack it removes it
                tags.pop();
            }
            else{
                tags.push(tag);
            }
        }
        if(tags.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }
    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;
     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}
