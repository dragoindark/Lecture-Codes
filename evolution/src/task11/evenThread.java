package task11;

public class evenThread implements Runnable {

	private int[][] matrix;
	private int startIndex, threadPriority, threadDelay;
	private String threadName;
	private int totalSum = 0;

	Thread myEvenThread;

	public evenThread(int[][] matrix, int startIndex, String threadName, int threadPriority, int threadDelay) {
		this.matrix = matrix;
		this.startIndex = startIndex;
		this.threadDelay = threadDelay;
		this.threadName = threadName;
		this.threadPriority = threadPriority;
		myEvenThread = new Thread(this);
		myEvenThread.setName(threadName);
		myEvenThread.setPriority(threadPriority);
		myEvenThread.start();
	}

	public int getSum() {
		return totalSum;
	}
	public void setSum(int newSum) {
		totalSum+=newSum;
	}
	public void printSum() {
		System.out.println(myEvenThread.toString()+" Sum:" + getSum() + ".");
	}

	public Thread getThread() {
		return myEvenThread;
	}

	public int getPriority() {
		return threadPriority;
	}

	public int getDelay() {
		return threadDelay;
	}

	public int getIndex() {
		return startIndex;
	}

	public String getName() {
		return threadName;
	}

	@Override
	public void run() {
		for (int i = startIndex; i < matrix.length; i++) {
			int rowSum = 0;
			if ((i % 2) == 0) {
				for (int j = 0; j < matrix[i].length; j++) {
					rowSum += matrix[i][j];
				}
				totalSum += rowSum;
				System.out.println(myEvenThread.toString()+" Row:" + i + ", Sum:" + rowSum);
			}
			try {
				myEvenThread.sleep(threadDelay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
