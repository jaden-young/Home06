package Home06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;

/**
 * This is a client program of the Train and Passenger classes. A text file is 
 * used to define the Passengers in a Train object. A while loop uses a scanner 
 * to read the data from the file object. We don't need to worry about the 
 * format of the file, since the assignment sheet gives an assumed format. A 
 * for loop prints the names of each passenger, even though the toString method
 * of the Train class yields the exact same result. A menu is printed giving 
 * the user options to:
 *      Quit
 *      Print a list of passengers
 *      Find the percentage of passengers in first class
 *      Find the total number of passengers
 *      Search to see if a passenger is on the train
 *      Search for a passenger by number 
 *      Calculate the revenue generated by the train
 * Each of these use methods from the Train class.
 * 
 * <p>The first while loop there is our best option for reading the file. Don't
 * have to worry about testing the formatting since the assignment said we can 
 * assume that the file is laid out a certain way. It's quick, it's easy, it 
 * works. If you want to write another test class go ahead, I just got bored. 
 * We still need screen shots from your computer nonetheless.
 *
 * @author Grant Moe
 */
public class TrainTest 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        DecimalFormat percent = new DecimalFormat("%0.##");
        
        File inputFile = new File("passengers.txt");
        
        Scanner scanFile = new Scanner(inputFile);
        Scanner scanCons = new Scanner(System.in);
        
        Train train = new Train();
        

        //parses over the file, using the name and class of service from each 
        //line to define a Passenger, then adding that passenger to the train 
        while(scanFile.hasNextLine()){
            String tmpName = scanFile.next();
            int tmpClassOfService = scanFile.nextInt();
            Passenger tmpPassenger = new Passenger(tmpName, tmpClassOfService);
            train.addPassenger(tmpPassenger);
        }

        
        
        //prints the names of each passenger
        for (int i = 0; i < train.getNumberOfPassengers(); i++) {
            System.out.println("Passenger " + i + ": " + 
                    train.getPassenger(i).getName());
            
        }
        
        
        
        //Menu for user action
        String menu = "";
        menu += "\nWhat would you like to do?";
        menu += "\n0: Quit";
        menu += "\n1: Print a list of passengers on the train";
        menu += "\n2: Add a new passenger";
        menu += "\n3: Percentage of passengers in first class";
        menu += "\n4: Total number of passengers";
        menu += "\n5: Search to see if a passenger is on the train";
        menu += "\n6: Search for a passenger by number";
        menu += "\n7: Calculate the revenue generated by the train";
        menu += "\n> ";
        
        
        //loop control variables
        int SENTINAL = 0;
        int input = -1;
        
        
        //where the magic happens
        while(input != SENTINAL){
            
            //prints menu with options
            System.out.print(menu);
            
            //typesafing
            while(!scanCons.hasNextInt()){
                String garbage = scanCons.nextLine();
                System.out.print("Your options are 1-7, or 0 to quit.\n > ");
            }
            input = scanCons.nextInt();

            
            //switch on user input 
            switch(input){
                case 0:
                    break;
                
                    
                //prints list of passengers
                case 1:
                    System.out.print(train.toString());
                    break;
                    
                    
                //adds a new passenger
                case 2:
                    System.out.print("\nName of the passenger > ");
                    String tmpName = scanCons.next();
                    System.out.print("\nClass of service of the passenger > ");
                    
                    //keeps prompting until the user chooses 1 or 2 for class
                    while(!(scanCons.hasNextInt())){
                        System.out.print("\nYour choices are 1 or 2\n> ");
                    }
                    int tmpClassOfService = scanCons.nextInt();
                    
                    //creates a new passenger object to add to the train
                    Passenger tmpPassenger = new Passenger(tmpName, 
                        tmpClassOfService);
                    
                    train.addPassenger(tmpPassenger);
                    System.out.println("Passenger added");
                    break;
                
                
                //finds percentage of passengers in first class
                case 3:
                    System.out.println("Percentage of passengers in first " +
                            "class: " + percent.format(train.getFirstClass()));
                    break;
                
                    
                //finds the total number of passengers
                case 4: 
                    System.out.println("Total number of passengers: " + 
                            train.getNumberOfPassengers());
                    break;
                
                
                //searches for a passenger by name and outputs whether or not 
                //they are a passenger
                case 5:
                    System.out.print("Name of the passenger to search > ");
                    String searchName = scanCons.next();
                    if(train.isAPassenger(searchName))
                        System.out.println(searchName + " is a passenger.");
                    else
                        System.out.println(searchName + " is not a passenger.");
                    break;
                
                
                //search for passenger by number and output name    
                case 6:
                    System.out.print("Number of the passenger to search > ");
                    while(!(scanCons.hasNextInt())){
                        String garbage = scanCons.nextLine();
                        System.out.print("Need to input a whole number > ");
                    }
                    int searchInt = scanCons.nextInt();
                
                    System.out.println("Passenger number " + searchInt + ": " + 
                            train.getPassenger(searchInt).getName());
                    break;
                
                
                //calculates revenue for the train
                case 7:
                    System.out.print("Cost per first class ticket > ");
                    while(!scanCons.hasNextDouble()){
                        String garbage = scanCons.nextLine();
                        System.out.print("\nNeeds to be a number\n> ");
                    }
                    double firstClassCost = scanCons.nextDouble();
                    
                    System.out.print("Cost per second class ticket > ");
                    while(!scanCons.hasNextDouble()){
                        String garbage = scanCons.nextLine();
                        System.out.print("\nNeeds to be a number\n> ");
                    }
                    double secondClassCost = scanCons.nextDouble();
                    
                    System.out.println("\nRevenue generated by the train: " + 
                            money.format(train.getRevenue(firstClassCost, 
                                    secondClassCost)));
                    break;
                
                    
                    
                default:
                    System.out.print("Your options are 1-7, or 0 to quit.");
            }
        }
    }
}