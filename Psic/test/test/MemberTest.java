package test;


import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import psic.Member;


public class MemberTest {
    
    public MemberTest() {
    }
    
    @Test
    public void testGetId() {
        System.out.println("getId");
        Member instance = new Member();
        String[] expResult  = {"1","2","3","4","5"};
        String[] result = instance.getId();
        assertArrayEquals(expResult, result);
        
    }
  
    @Test
    public void testGetName() {
        System.out.println("getName");
        Member instance = new Member();
        String[] expResult = {"MR.David","MR.Ron","MR.Eric","Mr.Ali","Mr.Shoun"};
        String[] result = instance.getName();
        assertArrayEquals(expResult, result);
        
    }

    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Member instance = new Member();
        String[] expResult = {"St# 5, NY212","St# 8,Chicago","St# 1, Grandorchard","St# 6, LA"};
        String[] result = instance.getAddress();
        assertArrayEquals(expResult, result);
        
    }

    @Test
    public void testGetTelp() {
        System.out.println("getTelp");
        Member instance = new Member();
        String[] expResult= {"123456","456231","789456","987654"};
        String[] result = instance.getTelp();
        assertArrayEquals(expResult, result);
        
    }
    
}
