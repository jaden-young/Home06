/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home06;

import java.util.ArrayList;

/**
 *
 * @author jaden
 */
public class Train {
    
    //instance variable
    private ArrayList<Passenger> passengerList;
    
    
    
    /**
     * Default constructor
     * <p>
     * Creates a Train object with an ArrayList of Passenger type
     */
    public Train(){
        passengerList = new ArrayList<Passenger>();
    }
    
    
    /**
     * Adds a passenger object to the arraylist
     * @param xPassenger new passenger object
     */
    public void addPassenger(Passenger xPassenger){
        passengerList.add(xPassenger);
        passengerList.trimToSize();
    }
    
    
    /**
     * Returns the Passenger object at a specified index
     * @param index Index of the desired passenger object in the arraylist
     * @return Reference to passenger object at the specified index
     */
    public Passenger getPassenger(int index){
        return passengerList.get(index);
    }
    
    
    /**
     * Returns the number of passengers on the train
     * @return Number of passengers on the train
     */
    public int getNumberOfPassengers(){
        return passengerList.size();
    }
    
    
    /**
     * Returns the number of passengers in first class
     * @return Number of passengers in first class
     */
    public double getFirstClass(){
        int firstClass = 0;
        for(Passenger currentPassenger : passengerList){
            if (currentPassenger.getClassOfService() == 1)
                firstClass++;
        }
        return (firstClass / passengerList.size());
    }
    
    
    /**
     * Returns the revenue for the train by multiplying the number of passengers
     * in each class by the cost for that class
     * @param xFirstClassCost Cost for each passenger in first class
     * @param xSecondClassCost Cost for each passenger in second class
     * @return Total revenue for the train 
     */
    public double calculateCost(double xFirstClassCost, 
            double xSecondClassCost){
        int firstClass = 0;
        int secondClass = 0;
        
        //find the number of passengers in first and second class
        for(Passenger currentPassenger : passengerList){
            if (currentPassenger.getClassOfService() == 1)
                firstClass++;
            else
                secondClass++;
        }
        
        //calculate and return total revenue
        double revenue = firstClass * xFirstClassCost 
                + secondClass * xSecondClassCost;
        return revenue;
    }
    
    
    /**
     * Searches for a passenger by name
     * 
     * <p> Takes a name as a parameter and searches to see if that passenger 
     * is on the train
     * @param xName Name to be searched
     * @return True if the passenger is on the train, false if not
     */
    public boolean isAPassenger(String xName){
        for(Passenger currentPassenger : passengerList){
            if (currentPassenger.getName().equals(xName)){
                return true;
            }
        }
        return false;
    }
    
    
    
    
}
