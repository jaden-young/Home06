package Home06;
import java.util.ArrayList;

/**
 * Defines Train objects that contain a list of Passengers on the train. 
 * 
 * <p>Each Train object has one field: an array list of Passenger objects. 
 * There is only one constructor, the default constructor, which initializes
 * a new ArrayList of passenger type. Passengers are added to the list by using 
 * the addPassenger method. Accessor methods are provided to return the 
 * passenger object at a specified index, the number of passengers on the train,
 * the number of passengers in first class, the revenue generated (with 
 * parameters for the cost of first class and second class tickets), and a 
 * search by name function is also provided, along with toString and equals 
 * methods. 
 * 
 * @author Jaden Young
 */
public class Train {
    
    //instance variable
    private final ArrayList<Passenger> passengerList;
    
    
    
    /**
     * Default constructor
     * <p>
     * Creates a Train object with an ArrayList of Passenger type
     */
    public Train(){
        passengerList = new ArrayList<>();
    }
    
    
    /**
     * Adds a passenger object to the list of passengers
     * @param xPassenger New passenger object
     */
    public void addPassenger(Passenger xPassenger){
        passengerList.add(xPassenger);
        passengerList.trimToSize();
    }
    
    
    /**
     * Returns the Passenger object at a specified index
     * @param index Index of the desired passenger object in the list
     * @return Reference to passenger object at the specified index
     */
    public Passenger getPassenger(int index){
        if(index >= passengerList.size())
            throw new ArrayIndexOutOfBoundsException();
        else
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
     * Returns the percentage of passengers in first class
     * @return Number of passengers in first class
     */
    public double getFirstClass(){
        double firstClass = 0;
        
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
    public double getRevenue(double xFirstClassCost, 
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
        return firstClass * xFirstClassCost 
                + secondClass * xSecondClassCost;
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
    
    
    
    /**
     * Returns a printable version of the names of ever passenger on the train
     * @return A single string containing the names of each passenger
     */
    @Override
    public String toString(){
        String output = "";
        int count = 0;
       
        for(Passenger currentPassenger : passengerList){
            output += "Passenger " + count + ": " + currentPassenger.getName() +
                    "\n";
            count++;
        }
        return output;
    }
    
    
    
    /**
     * Compares two Train objects for equality
     * 
     * <p> The number of passengers on the train, the name of each passenger, 
     * and the class of service of each passenger are compared between the 
     * objects. If there are any differences, return false
     * @param xObj Object to be compared
     * @return True if all fields are equal, false if there are any differences
     */
    @Override
    public boolean equals(Object xObj){
        if(!(xObj instanceof Train))
            return false;
        Train Obj = (Train)xObj;
        
        //if the lengths are different, objects are not equal
        if (passengerList.size() != Obj.getNumberOfPassengers())
            return false;
        
        
        for (int i = 0; i < passengerList.size(); i++) {
            //return false if any name is different between the 2 objects
            if(!(passengerList.get(i).getName().equals(Obj.getPassenger(i)
                    .getName())))
                return false;
            //return flase if any class of service is different between the 2
            if(passengerList.get(i).getClassOfService() != 
                    Obj.getPassenger(i).getClassOfService())
                return false;
        }
        return true;
    }
}