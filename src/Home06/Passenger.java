package Home06;
/**
 * Defines Passenger objects that represent passengers on a train.
 * 
 * <p>Contains 1 constructor that initializes a passenger object with values for 
 * name and class of service. Name can be any string, class of service must be 
 * either 1 or 2. The class provides accessor and mutator methods for both 
 * name and class of service. The mutator method for the class of service checks
 * the validity of the input. toString and equals methods that override those of
 * the Object class are provided.
 * 
 * @author Jaden Young
 */
public class Passenger {
    
    //instance variables
    private String name;
    private int classOfService;
    
    
    /**
     * Creates a new Passenger object with a name and class of service
     * @param xName Name of the passenger
     * @param xClassOfService Class of service of the passenger
     */
    public Passenger(String xName, int xClassOfService){
        name = xName;
        setClassOfService(xClassOfService);
    }
    
    
/************************** Accessor Methods **********************************/
    
    
    /**
     * Accessor method for name
     * @return Name of the passenger
     */
    public String getName(){
        return name;
    }
    
    
    /**
     * Accessor method for classOfService
     * @return Class of service for the passenger, 1 or 2
     */
    public int getClassOfService(){
        return classOfService;
    }
    
    
/******************************************************************************/
/************************** Mutator Methods ***********************************/
    
    
    /**
     * Sets the name of the passenger 
     * @param xName new name for the passenger
     */
    public void setName(String xName){
        name = xName;
    }
    
    
    /**
     * Sets the class of service for the passenger
     * <p> Must be either 1 or 2, else throws exception
     * @param xClassOfService new class of service for the passenger
     */
    public final void setClassOfService(int xClassOfService){
        switch(xClassOfService){
            case 1:
                classOfService = xClassOfService;
                break;
            case 2:
                classOfService = xClassOfService;
                break;
            default:
                throw new IllegalArgumentException("Class of service must be "
                        + "1 or 2");
        }
    }
    
    
/******************************************************************************/
    
    /**
     * Returns a printable version of the data contained in the Passenger object
     * @return String containing the name and class of service of the passenger
     */
    @Override
    public String toString(){
        String output = "";
        
        output += "Passenger name: " + name;
        output += "\nClass of Service: " + classOfService;
        return output;
    }
    
    
    /**
     * Compares the fields of two Passenger objects for equality
     * @param xObj Object that this is compared to 
     * @return True if objects are equal, false if not 
     */
    @Override
    public boolean equals(Object xObj){
        if(!(xObj instanceof Passenger))
            return false;
        
        Passenger Obj = (Passenger)xObj;
        
        if(!(name.equals(Obj.getName())))
            return false;
        return(classOfService == Obj.getClassOfService());
    }
}