package test;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import psic.Date_TIme;





public class Date_TImeTest {
    
    public Date_TImeTest() {
    }
    
    @Test
    public void testGetDateTime() {
        System.out.println("getDateTime");
        Date_TIme instance = new Date_TIme();
        String[] expResult = {"Saturday May 2021,10:00-12:00","Monday May 2021,09:00-12:00",
       "Tuesday May 2021,11:00-01:00","Wednesday May 2021,09:30-12:00",
       "Thursday May 2021,10:00-12:00","Friday May 2021,09:00-11:00"
    };
        String[] result = instance.getDateTime();
        assertArrayEquals(expResult, result);
        
    }

    @Test
    public void testGetVisitHours() {
        System.out.println("getVisitHours");
        Date_TIme instance = new Date_TIme();
        String[] expResult = {"Week1: 2 hours on Monday afternoon","Week2: 2 hours on Friday afternoon","Week3: 2 hours on Tuesday morning","Week4: 2 hours on Wednesday Evening"};
        String[] result = instance.getVisitHours();
        assertArrayEquals(expResult, result);
        
    }

    @Test
    public void testGetSlots() {
        System.out.println("getSlots");
        Date_TIme instance = new Date_TIme();
        String[] expResult = {"1st 30 mins","2nd 30 mins","3rd 30 mins","4th 30 mins"};
        String[] result = instance.getSlots();
        assertArrayEquals(expResult, result);
        
    }
    
}
