package parallelScripts;

import org.testng.annotations.Test;

public class Sampletwo {
	@Test
	public void sampletestA() {
		long id = Thread.currentThread().getId();
		System.out.println("Executing sampletestA..."+ id);
	}
	
	@Test
	public void sampletestB() {
		long id = Thread.currentThread().getId();
		System.out.println("Executing sampletestB.." + id);
	}


}
