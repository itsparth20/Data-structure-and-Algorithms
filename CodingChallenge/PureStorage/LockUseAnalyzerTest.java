import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pureStorage.LockUseAnalyzer;

public class LockUseAnalyzerTest {
	LockUseAnalyzer lockUserAnalyzerObj = new LockUseAnalyzer();
	String[] correct = {"ACQUIRE 364",
			"ACQUIRE 84",
			"RELEASE 84",
			"ACQUIRE 1337",
			"RELEASE 1337",
			"RELEASE 364",
			};		
	
	String[] sequenceViolates = {"ACQUIRE 364",
			"ACQUIRE 84",
			"RELEASE 364",			
			"RELEASE 84",
			};

	String[] block = {"ACQUIRE 364",
			"ACQUIRE 84",
			"RELEASE 84",			
			};
	
	String[] misUse = {"ACQUIRE 364",			
			"RELEASE 84",			
			"RELEASE 364",
			};
	
	String[] alreadyAcquire = {"ACQUIRE 123",
"ACQUIRE 364",
"ACQUIRE 84",
"RELEASE 84",
"RELEASE 364",
"ACQUIRE 456"
			};


	
	@Before
	public void init(){
		lockUserAnalyzerObj = new LockUseAnalyzer();
		
	}
	
//	@Test
//	public void correctTest(){
//		// assert statements
//		assertEquals( 0, lockUserAnalyzerObj.check_log_history(correct));                		
//	}	
//	
//	@Test
//	public void sequenceViolatesTest(){
//		// assert statements
//		assertEquals( 3, lockUserAnalyzerObj.check_log_history(sequenceViolates));                		
//	}
//	
//	@Test
//	public void blockTest(){
//		// assert statements
//		assertEquals( 3, lockUserAnalyzerObj.check_log_history(block));                		
//	}
//	
//	@Test
//	public void misUseTest(){
//		// assert statements
//		assertEquals( 2, lockUserAnalyzerObj.check_log_history(misUse));                		
//	}
	
	@Test
	public void alreadyAcquireTest(){
		// assert statements
		assertEquals( 7, lockUserAnalyzerObj.check_log_history(alreadyAcquire));                		
	}

}

