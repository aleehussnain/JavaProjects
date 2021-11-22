package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import psic.Visitors;



public class VisitorsTest {
    
    public VisitorsTest() {
    }

    @Test
    public void testSetAppointment() {
        System.out.println("setAppointment");
        String apoint = "";
        Visitors instance =new Visitors("");
        instance.setAppointment(apoint);
        
    }

  
    @Test
    public void testGetAppointment() {
        System.out.println("getAppointment");
        Visitors instance =new Visitors("");
        String expResult = "";
        String result = instance.getAppointment();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Visitors instance=new Visitors("");
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
