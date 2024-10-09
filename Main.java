/*
 * INSTRUCTION:
 *     This is a Java staring code for hw5_1.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Abstract: Program accepts input from a user in the form of heap and heap instructions. Using this heap
 * and the corresponding instructions, the program reports back whether or not the input is a Heap,
 * then outputs based on the various Heap action instructions.
 * Name: Bryan Zanoli
 * Date: 10/08/2024
 */

import java.util.ArrayList;
import java.util.Scanner;

class Main
{
    public static ArrayList<Integer> heapify(ArrayList<Integer> heapArray) {
        //System.out.println("Heapify the Array");
        for (int i = (heapArray.size()-1)/2; i >= 1; i--) {
            int k = i;
            int v = heapArray.get(k);
            //System.out.println("k: " + k + " i: " + i + " v: " + v);
            boolean isHeap = false;
            while (!isHeap && 2*k <= heapArray.size()-1) {
                int j = 2 * k;
                //System.out.println(" j: " + j);
                if(j < heapArray.size() - 1) {
                    //System.out.println("Heap Array Size (outer loop): " + heapArray.size());
                    if (heapArray.get(j) < heapArray.get(j + 1)) {
                        //System.out.println("Inner loop. Heap Array at j: " + heapArray.get(j) + " Heap Array at j + 1: " + heapArray.get(j+1));
                        j = j+1;
                    }
                }
                if(v >= heapArray.get(j)) {
                    //System.out.println("Heap Array check. v: " + v + " heapArray at j: " + heapArray.get(j));
                    isHeap = true;
                } else {
                    //System.out.println("Heap array pre set if not heap. at k: " + heapArray.get(k) + " at j: " + heapArray.get(j));
                    heapArray.set(k, heapArray.get(j));
                    k = j;
                }
                //System.out.println("Heap array set at end. k: " + heapArray.get(k) + " v: " + v);
                heapArray.set(k, v);
            }
        }
        //heapDisplay(heapArray);
        return heapArray;
    }

    public static boolean heapCheck(ArrayList<Integer> heapArray) {
        boolean isHeap = true;
        //System.out.println("Check if Array is a Heap");

        for (int i = (heapArray.size()-1) / 2; i >= 1; i--) {
            if(2*i + 1 > heapArray.size()-1) {
                if (heapArray.get(2*i) > heapArray.get(i)) {
                    isHeap = false;
                    break;
                }
            } else {
                if (!(heapArray.get(i) >= heapArray.get(2*i) && heapArray.get(i) >= heapArray.get(2*i + 1))) {
                    isHeap = false;
                    break;
                }
            }
        }
        return isHeap;
    }

    public static void displayMax(ArrayList<Integer> heapArray) {
        if(heapArray.size() > 1) {
            System.out.println(heapArray.get(1));
        } else {
            System.out.println(heapArray.size());
            System.out.println(heapArray);
            System.out.println("No Max");
        }
    }

    public static void heapDisplay(ArrayList<Integer> heapArray) {
        //System.out.println("Display the full heap in order");
        String heapOutput = "";
        for(int i = 1; i <= heapArray.size() - 2; i++) {
            heapOutput += heapArray.get(i) + " ";
        }
        heapOutput += heapArray.get(heapArray.size() - 1);
        System.out.println(heapOutput);
    }

    public static void insertNode(ArrayList<Integer> heapArray, int node) {
        //TODO: Add functionality for parent check instead of full heapCheck?
        heapArray.add(node);
        //System.out.println("insert node, pre heapify: ");
        //heapDisplay(heapArray);
        if(!heapCheck(heapArray)) {
            heapify(heapArray);
        }
        //System.out.println("Insert a node into Heap and ensure is still a heap. Node: " + node);
    }

    public static void deleteNode(ArrayList<Integer> heapArray, int node) {
        int last = heapArray.get(heapArray.size()-1);
        //System.out.println("Last: " + last);
        //System.out.println("Node: " + node);
        //System.out.println("Index of Last: " + heapArray.indexOf(last));
        //System.out.println("Index of Node: " + heapArray.indexOf(node));
        if(node != last) {
            heapArray.set(heapArray.indexOf(last), node);
            heapArray.set(heapArray.indexOf(node), last);
        }
        heapArray.remove(heapArray.indexOf(node));
        heapify(heapArray);
        //System.out.println("Delete a node from the Heap. Node: " + node);
    }

    public static void main(String[] args) {

        // Develop your program here.
        // The following is just a sample statement and and you need to replace it with your code
        ArrayList<Integer> heapArray = new ArrayList<>();
        heapArray.add(null);

        //Read in Values
        Scanner scanner = new Scanner(System.in);
        int nodeCount = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        //int nodeCount = 5; //troubleshooting
        if(nodeCount > 0) {
            String arrLine = scanner.nextLine(); //troubleshooting
            //String arrLine = "10 20 30 40 70"; //troubleshooting
            String[] strArr = arrLine.split(" ");
            for (int i = 0; i < nodeCount; i++) {
                heapArray.add(Integer.parseInt(strArr[i]));
            }
        }

        //Test Output:
        //System.out.println(heapArray);

        //Heapify the array
        if(!heapCheck(heapArray)) {
            System.out.println("This is NOT a heap.");
            heapArray = heapify(heapArray); // do we need to clone instead?
        } else {
            System.out.println("This is a heap.");
        }

        //Process the commands
        int commandCount = Integer.parseInt(scanner.nextLine()); //troubleshooting
        //int commandCount = 0; //troubleshooting
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
                    deleteNode(heapArray, heapArray.get(1));
                    break;
                case "delete":
                    deleteNode(heapArray, Integer.parseInt(commandArr[1]));
            }
        }
    }
}

