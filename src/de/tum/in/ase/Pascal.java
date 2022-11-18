package de.tum.in.ase;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.tum.in.ase.InputReader.readInt;
/**
 * Represents the Pascal Triangle
 */
public class Pascal {
    /**
     * This method gets the input n and returns the corresponding 2D ArrayList that will hold the triangle
     * @param n     number of lines
     * @return      2D ArrayList of Integer holding the triangle
     */


    public static ArrayList<ArrayList<Integer>> pascalTriangle(int numberOfRows) {
        // Done: build and return 2D triangle list
        ArrayList<ArrayList<Integer>> total_rows = new ArrayList<>(); //result
        ArrayList<Integer> row = new ArrayList<>();
        for(int i = 0; i < numberOfRows; i++) {
            row.add(0, 1); //add element 1 at index 0.
            //now iterate the row, keep adding elements in pair, starting from j=1,
            // and set the sum at index j
            for(int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            //create a copy of row and store it in all_rows
            total_rows.add(new ArrayList<>(row));
        }
        return total_rows;
    }

    /**
     * Main method
     * @param args  arguments
     */
    public static void main(String[] args) {
        // Done: read user input n and print the triangle of height n
        int numberOfLines = InputReader.readInt("Enter the number of lines:");
        ArrayList<ArrayList<Integer>> triangle = pascalTriangle(numberOfLines);
//        Done: Print: All individual columns are separated by tabs \t.
        for (int i = 0; i <triangle.size() ; i++) {
            List<Integer> current = triangle.get(i);
            System.out.printf("n= %d\t", i);
            if (current.size() == 1) {
                System.out.print(current.get(0));
                System.out.print("\n");
            } else {
                for (int j = 0; j < current.size() - 1; j++) {
                    System.out.print(current.get(j));
                    System.out.print("\t");
                }
                System.out.print(current.get(current.size() - 1));
                System.out.print("\n");
            }
//            System.out.println(Arrays.toString(current.toArray()));
        }
    }
}