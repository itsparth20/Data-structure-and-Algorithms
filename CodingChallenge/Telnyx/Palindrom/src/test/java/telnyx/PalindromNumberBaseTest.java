package telnyx;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import telnyx.PalindromicNumberBase;

public class PalindromNumberBaseTest {
	PalindromicNumberBase palindromicNumberBaseObj;
	
	@Before
	public void init(){
		palindromicNumberBaseObj = new PalindromicNumberBase();	
	}
	
	@Test
    public void numberBaseTwoTest() {             
		// assert statements
		assertEquals( 2, palindromicNumberBaseObj.numberBase(0));                        
    }
	
	@Test
    public void numberBaseThreeTest() {             
        // assert statements
		assertEquals( 3, palindromicNumberBaseObj.numberBase(2));                        
    }	
	
	@Test
    public void numberBaseFiveTest() {             
        // assert statements
		assertEquals(5, palindromicNumberBaseObj.numberBase(6));                       
    }
	
	@Test
    public void numberBaseSixTest() {             
        // assert statements
		assertEquals(6, palindromicNumberBaseObj.numberBase(14));                       
    }
	
	@Test
    public void numberBaseTenTest() {             
        // assert statements
		assertEquals(10, palindromicNumberBaseObj.numberBase(101));                       
    }
	
	@Test
    public void numberBaseEighteenTest() {             
        // assert statements
		assertEquals(18, palindromicNumberBaseObj.numberBase(19));                       
    }
	
	
	@Test
    public void numberNagativeTest() {             
        // assert statements
		assertEquals(-1, palindromicNumberBaseObj.numberBase(-1));                       
    }
	
	@Test
	public void palindromEvenTrueTest(){
		// assert statements
		assertEquals(true, palindromicNumberBaseObj.checkPalindrome("22"));
	}
	
	@Test
	public void palindromOddTrueTest(){
		// assert statements
		assertEquals(true, palindromicNumberBaseObj.checkPalindrome("121"));
	}
	
	@Test
	public void palindromEvenFalseTest(){
		// assert statements
		assertEquals(false, palindromicNumberBaseObj.checkPalindrome("21"));
	}
	
	@Test
	public void palindromOddFalseTest(){
		// assert statements
		assertEquals(false, palindromicNumberBaseObj.checkPalindrome("123"));
	}
}
