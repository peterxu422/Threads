import java.util.Arrays;


public class Merger implements Runnable {
	
	private int[] array;
	
	public Merger(int[] array) {
		this.array = array;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(array.length >= 2) {
			int left[] = Arrays.copyOfRange(array, 0, array.length/2);
			int right[] = Arrays.copyOfRange(array, array.length/2, array.length);

			Thread t1 = new Thread(new Merger(left));
			t1.start();
			
			Thread t2 = new Thread(new Merger(right));
			t2.start();
			
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException ie) {}
			
			merge(left, right, array);
		}
	}
	
	public synchronized void merge(int[] left, int[] right, int[] a) {
		int i1 = 0;
		int i2 = 0;
		for (int i = 0; i < a.length; i++) {
			if (i2 >= right.length || (i1 < left.length && left[i1] < right[i2])) {
				a[i] = left[i1];
				i1++;
			} else {
				a[i] = right[i2];
				i2++;
			}
		}
	}
	
	public static void printArray(int[] a) {
		for(int i=0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
