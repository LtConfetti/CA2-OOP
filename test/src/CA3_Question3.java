import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

/**
 *  Name: John Nally
 *  Class Group: GD2b
 */

public class CA3_Question3
{
//use in Q4 John
    public static ArrayList<String> readFile(String fileName) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<>();
        File file = new File(fileName);
        Scanner input = new Scanner(file);

        input.useDelimiter("[^A-Za-z0-9_]+");

        while (input.hasNext()) { //checks if the there is another line while it goes through the file (reading the file)
            String line = input.nextLine();
            lines.add(line);
        }
        return lines;
    }



    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> lines = readFile("src/CA3_Question1.java"); //string key line is type

        Map<String, ArrayList<Integer>> map = new TreeMap<>(); //setting up map
        int lineNumber = 0; //establishing int

        for (String line: lines) { //goes through every line in the file
            lineNumber++;
            System.out.println(line);
            String[] words = line.split(" ");//split makes each line it's one array
            for (String word: words) { //goes through each word in the lines
                boolean identifier = !word.isEmpty();
                for (int i = 0; i < word.length() ; i++) {
                    char letter = word.charAt(i);

                    //checks for valid characters ONLY by checking for not valid characters
                    if(!((letter >= '0' && letter <= '9') || (letter >= 'A' && letter <= 'Z') || (letter >= 'a' && letter <= 'z') || (letter == '_')) ){
                        identifier = false;
                        break;
                    }

                }

                //for when no valid characters are found
                if(identifier){
                    if(!map.containsKey(word)){//checks hashmap if there is a not key for the same word and proceeds to add it
                        map.put(word, new ArrayList<>());
                    }
                    map.get(word).add(lineNumber); //adds line number next to word
                }
            }

        }

        System.out.print(map);
    }
}

