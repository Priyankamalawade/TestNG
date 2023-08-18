package parallelScripts;

import org.testng.annotations.Test;

public class Sampleone {
	
	@Test
	public void sampletestone() {
		long id = Thread.currentThread().getId();
		System.out.println("Executing sampleone.." + id);
	}
	
	@Test
	public void sampletesttwo() {
		long id = Thread.currentThread().getId();
		System.out.println("Executing sampletesttwo.." + id);
	}


}
