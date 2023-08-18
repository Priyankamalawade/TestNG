package parallelScripts;

import org.testng.annotations.Test;

public class Samplethree {
	@Test
	public void sampltestZ() {
		long id = Thread.currentThread().getId();
		System.out.println("Executing sampletestZ..."+ id);
	
	}
	
	@Test
	public void sampletestY() {
		long id = Thread.currentThread().getId();
		System.out.println("Executing sampletestY.." + id);
	}


}
