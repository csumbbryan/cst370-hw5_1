/*
 * INSTRUCTION:
 *     This is a Java staring code for hw5_1.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Abstract: Describe the main ideas of the program.
 * Name: Write your name
 * Date: MM/DD/YYYY
 */

import java.util.ArrayList;
import java.util.Scanner;

class Main
{
    public static void main(String[] args) {

        // Develop your program here.
        // The following is just a sample statement and and you need to replace it with your code
        ArrayList<Integer> heapArray = new ArrayList<>();

        //Read in Values
        Scanner scanner = new Scanner(System.in);
        int nodeCount = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        String arrLine = scanner.nextLine();
        String[] strArr = arrLine.split(" ");
        for (int i = 0; i < nodeCount; i++) {
            heapArray.add(Integer.parseInt(strArr[i]));
        }

        //Test Output:
        System.out.println(heapArray);

        //Process the commands

        //Heapify the array

        //Insert nodes (then heapify)

        //Delete nodes (then heapify)

        //Delete the root node (then heapify)


        
        System.out.println("Hello world!");
    }
}

