package psic;

//Visitor 
public class Visitors {
    private String visitor=null;

    public Visitors(String obj) {
        setAppointment(obj);
    }
   
   
   public void setAppointment(String apoint){
       this.visitor = apoint;
   }
   
   public String getAppointment(){
       return this.visitor;}
   
   public String toString(){
       return this.visitor;
   }
}
