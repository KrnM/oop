package ua.khpi.oop.boksho13;

public class ThreadThree extends Thread {
	
	/**
	 * Takes a list in an array view.
	 */
	private int[] listToArr;
	
	/**
	 * Timeout value for thread lifetime.
	 * Thread is on, until its runtime reaches timeout.
	 */
	private double timeOut;
	
	/**
	 * Simple constructor.
	 */
	public ThreadThree() {
		
	}
	
	/**
	 * Argument constructor.
	 * Sets the list to process and timeout bound.
	 * 
	 * @param list a data range to process
	 * @param timeOut sets a timeout bound
	 */
	public ThreadThree(Container<Integer> list, double d) {
		
		this.timeOut = d;
		
		Object[] temp = list.toArray();
		this.listToArr = new int[temp.length];
		
		for(int i = 0; i < temp.length; i++) {
			
			this.listToArr[i] = (int) temp[i];
		}
	}
	
	/* 
	 * Overrided thread running method.
	 * Starts execution when thread starts.
	 * Searches for even and odd numbers in the integer data range.
	 */
	@Override 
	public void run() {
		
		try {
			
			ThreadThree.sleep(1000);
			
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
		long timeStart = System.nanoTime();
		
		int max = listToArr[0];
		
		for (int i = 0; i < listToArr.length; i++) {
			
			if (max < listToArr[i]) {
				
				max = listToArr[i];
			}
			
			long timeTotal = System.nanoTime() - timeStart;
			
			try {
				
				double convert = timeTotal*10e-9;
				
				if(convert > timeOut) {
					throw new Exception();
				} 
				
			} catch (Exception e) {
				
				this.interrupt();
				System.out.println("ThreadThree has been interrupted!");
				return;
			}
		}
		
		System.out.println("Max value : " + max);
	}

}