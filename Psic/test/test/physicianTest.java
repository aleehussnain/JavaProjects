package test;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import psic.physician;



public class physicianTest {
    
    public physicianTest() {
    }
 
    @Test
    public void testGetExperties() {
        System.out.println("getExperties");
        physician instance = new physician();
        String[] expResult = {"Physiotherapy", "Osteopathy", "Rehabilitation","Osteopathy","Physiotherapy"};
        String[] result = instance.getExperties();
        assertArrayEquals(expResult, result);
        
    }

    @Test
    public void testGetTreatment() {
        System.out.println("getTreatment");
        physician instance = new physician();
        String[] expResult= {"Neural mobilisation", "Acupuncture", "Massage","Mobilisation of the spine and joints","Pool rehabilitation"};
        String[] result = instance.getTreatment();
        assertArrayEquals(expResult, result);
        
    }
    
}
