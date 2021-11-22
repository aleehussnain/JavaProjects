package psic;
//This class is for date and time 
public class Date_TIme {
    private final String [] date_Time = {"Saturday May 2021,10:00-12:00","Monday May 2021,09:00-12:00",
       "Tuesday May 2021,11:00-01:00","Wednesday May 2021,09:30-12:00",
       "Thursday May 2021,10:00-12:00","Friday May 2021,09:00-11:00" //details for calender
    };
    
    private String[] visitorHours = {"Week1: 2 hours on Monday afternoon","Week2: 2 hours on Friday afternoon","Week3: 2 hours on Tuesday morning","Week4: 2 hours on Wednesday Evening"};//all visting hours
    private final String[] slots = {"1st 30 mins","2nd 30 mins","3rd 30 mins","4th 30 mins"};//time slots
    //getter for date time
    public String[] getDateTime(){
        
        return this.date_Time;
    }
    public String[] getVisitHours(){
        return this.visitorHours;
    }public String[] getSlots(){
        return this.slots;
    }
}
