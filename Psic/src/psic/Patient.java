
package psic;

public class Patient {
   private String appointment=null;

    public Patient(String obj) {
        setAppointment(obj);
    }
   
   //Set Appointment
   public void setAppointment(String apoint){
       this.appointment = apoint;
   }
   
   public String getAppointment(){
       return this.appointment;}
   
   public String toString(){
       return this.appointment;
   }
   //Change the status of pateint like checked or not
   public Patient StatusChange(Patient p,String status){
       String data = p.toString();
       switch(status){
           case "Cancel":
               if(data.contains("Booked")){
                   data = data.replace("Booked", status);
               }else if(data.contains("Attended")){
                   data = data.replace("Attended", status);
               }break;
           case "Booked":
               if(data.contains("Cancel")){
                   data = data.replace("Cancel", status);
               }else if(data.contains("Attended")){
                   data = data.replace("Attended", status);
               }break;
           case "Attended":
               if(data.contains("Cancel")){
                   data = data.replace("Cancel", status);
               }else if(data.contains("Booked")){
                   data = data.replace("Booked", status);
               }
               break;
               default:break;
       }
 return new Patient(data);
   }
}
