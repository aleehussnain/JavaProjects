package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import psic.Patient;




public class PatientTest {
    
    public PatientTest() {
    }
    
   
    @Test
    public void testSetAppointment() {
        System.out.println("setAppointment");
        String apoint = "";
        Patient instance = new Patient("");
        instance.setAppointment(apoint);
        
    }


    @Test
    public void testGetAppointment() {
        System.out.println("getAppointment");
        Patient instance = new Patient("");
        String expResult = "";
        String result = instance.getAppointment();
        assertEquals(expResult, result);
        
    }


    @Test
    public void testToString() {
        System.out.println("toString");
        Patient instance = new Patient("");
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testStatusChange() {
        System.out.println("StatusChange");
        Patient p= new Patient("");
        String status = "";
         Patient instance = new Patient("");
        String expResult = "";
        String result = instance.getAppointment();
        assertEquals(expResult, result);
        
    }
    
}
