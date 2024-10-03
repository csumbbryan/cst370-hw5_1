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
    public static ArrayList<Integer> heapify(ArrayList<Integer> heapArray) {
        System.out.println("Heapify the Array");
        for (int i = heapArray.size()/2; i <= 1; i--) {
            int k = i;
            int v = heapArray.get(i);
            boolean isHeap = false;
            while (!isHeap && 2*k <= heapArray.size()) {
                int j = 2 * k;
                if(j < heapArray.size()) {
                    if (heapArray.get(j) < heapArray.get(j + 1)) {
                        j = j+1;
                    }
                }
                if(v >= heapArray.get(j)) {
                    isHeap = true;
                } else {
                    heapArray.set(k, heapArray.get(j));
                    k = j;
                }
                heapArray.set(k, v);
            }
        }
        return heapArray;
    }

    public static boolean heapCheck(ArrayList<Integer> heapArray) {
        boolean isHeap = false;
        System.out.println("Check if Array is a Heap");
        return isHeap;
    }

    public static void displayMax(ArrayList<Integer> heapArray) {
        System.out.println("Display the Max node");
    }

    public static void heapDisplay(ArrayList<Integer> heapArray) {
        System.out.println("Display the full heap in order");
        System.out.println(heapArray);
    }

    public static void insertNode(ArrayList<Integer> heapArray, int node) {
        System.out.println("Insert a node into Heap and ensure is still a heap. Node: " + node);
    }

    public static void deleteNode(ArrayList<Integer> heapArray, int node) {
        System.out.println("Delete a node from the Heap. Node: " + node);
    }



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

        //Heapify the array
        if(!heapCheck(heapArray)) {
            System.out.println("This is NOT a heap.");
            heapArray = heapify(heapArray); // do we need to clone instead?
        } else {
            System.out.println("This is a heap.");
        }



        //Process the commands
        int commandCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commandCount; i++) {
            String command = scanner.nextLine();
            String[] commandArr = command.split(" ");
            switch (commandArr[0]) {
                case "displayMax":
                    displayMax(heapArray);
                    break;
                case "display":
                    heapDisplay(heapArray);
                    break;
                case "insert":
                    insertNode(heapArray, Integer.parseInt(commandArr[1]));
                    break;
                case "deleteMax":
                    deleteNode(heapArray, heapArray.get(0));
                    break;
                case "delete":
                    deleteNode(heapArray, Integer.parseInt(commandArr[1]));
            }
        }



        //Insert nodes (then heapify)

        //Delete nodes (then heapify)

        //Delete the root node (then heapify)

    }
}

