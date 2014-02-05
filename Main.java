
public class Main {
	
	public static void main(String args[]) {
		// Split array into two child threads to handle the two halves
		int[] array = new int[30];	
		for(int i=0; i < array.length; i++)
			array[i] = (int) (Math.random() * 50);
		
		Merger.printArray(array);
		
		Merger m = new Merger(array);
		Thread t = new Thread(m);
		t.start();

		try {
			Thread.currentThread().sleep(2000);
			System.out.println("Sorted Array------------");
			Merger.printArray(array);
		}
		catch (InterruptedException e) {
		}
	
	}
	
}
