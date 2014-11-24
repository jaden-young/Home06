/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Gmoe
 */
public class TrainTest 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        
        //setup the file class the input a text document
        File inputFile = new File("passengers.txt");
        
        //initialize the scanner class to input the grades.txt file
        Scanner scan = new Scanner(inputFile);
        
        Train train = new Train();
        
    while(scan.hasNext())
        {   
            train.addPassenger(scan.next(),scan.nextInt());  
        }
    
    for(int i = 0; i < train.size; i++)
        {
            if (scan.hasNext())
                System.out.println(scan.next());
        }   
    }
}
