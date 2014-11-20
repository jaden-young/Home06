package Home06;
import java.util.GregorianCalendar;


/**
 * 
 * @author Jaden Young
 * 
 * This class defines a Date object. Each date has a day, month, and year. The
 * class contains public accessor methods for each field, as well as private 
 * mutator methods for use in the constructor. The setYear() method allows year 
 * inputs only from the point of adoption of the Gregorian Calendar. The 
 * setMonth() method only allows values from 1-12, for the 12 months of the 
 * year. The setDay() method allows different values depending on the number
 * of days of the month, and whether or not the year is a leap year. The mutator
 * methods are private because the day relies on the month and year for validity
 * If the mutators were public, a change in month/year could result in an 
 * invalid date (i.e. 3/30/2014 > 2/30/2014). The class also contains equals()
 * and toString() methods that override those of the Object class.
 * 
 */
public class Date {
    
    //instance variables
    private int day;
    private int month;
    private int year;

    
    //default constructor
    public Date(){
        day = 1;
        month = 1;
        year = 1582;
    }
    
    //overloaded constructor
    public Date(int startDay, int startMonth, int startYear){
       setYear(startYear);
       setMonth(startMonth);
       setDay(startDay);
    }
    
    
//***************************** Mutator Methods ******************************//    
    
    
    //year must be greater than 1582 for Gregorian Calendar class
    private void setYear(int newYear){
        if(newYear >= 1582)
            year = newYear;
        else
            throw new IllegalArgumentException("We're using the Gregorian "
                    + "Calendar; The year needs to be greater than 1582.");
    }
    
    //only takes values 1-12 for 12 months
    private void setMonth(int newMonth){
        if(newMonth < 13 && newMonth > 0)
            month = newMonth;
        else
            throw new IllegalArgumentException("There are only 12 months in "
                    + "a year");
    }

    
    //setDay method, performs different checks for months with 30 and 31 days,
    //and checks for leap year for month of February
    private void setDay(int newDay){
        if(newDay > 0){
            switch(month){
                
                //months with 31 days
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if(newDay < 32)
                        day = newDay;
                     else
                        throw new IllegalArgumentException("There are only 31 days in "
                        + "that month.");
                    break;
                
                //months with 30 days
                case 4:
                case 6:
                case 9:
                case 11:
                    if(newDay < 31)
                        day = newDay;
                    else 
                        throw new IllegalArgumentException("There are only 30 days in "
                        + "that month.");
                    break;
                
                //February, checks for leap year
                case 2:
                    //create GregorianCalendar object
                    GregorianCalendar cal = new GregorianCalendar();
                    //first checks if day is in normal range of 1-28
                    if(newDay < 29)
                        day = newDay;
                    //if day is outside range, check if leap year
                    else if(cal.isLeapYear(year)){
                        if(newDay < 30)
                            day = newDay;
                        else
                            throw new IllegalArgumentException("There are 29 "
                                    + "days in February that year.");
                    } else
                        throw new IllegalArgumentException("There are 28 days "
                                + "in February that year.");
                    break;
                //default just in case
                default:
                    throw new IllegalArgumentException("The month is somehow "
                            + "invalid, meaning my setMonth() method sucks.");
            }
        } else {
            throw new IllegalArgumentException("You can't have a negative "
                    + "day.");
        }
    }
 
//***************************************************************************//
    
//************************** Accessor Methods *******************************//
    
    //getYear method
    public int getYear(){
        return year;
    }
    
    //getMonth method
    public int getMonth(){
        return month;
    }
        
    //getDay method
    public int getDay(){
        return day;
    }
    
//***************************************************************************//
    
    
    //toString method, the compiler yelled at me to add @Override, so I did.
    //after doing some research, this line keeps the program from defaulting to
    //the toString() method of the Object class, which can cause a world of 
    //issues
    @Override
    public String toString(){
        String str = this.getMonth() + "/" + this.getDay() + "/" 
                + this.getYear();
        return str;
    }
    
    //equals method, overrides the equals method of the Object class
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Date))
            return false;
        else {
            Date objDate = (Date)obj;
            return (day == objDate.day && month == objDate.month && 
                    year == objDate.year);
                
        }
    }    
}

