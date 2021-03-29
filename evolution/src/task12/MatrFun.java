package task12;

public class MatrFun implements Runnable{
    
	private int[][] matrix;
	private int startIndex, threadPriority;
	private String threadName;

	Thread myThread;

	public MatrFun(int[][] matrix,String threadName,int startIndex, int threadPriority) {
		this.matrix = matrix;
		this.startIndex = startIndex;
		this.threadName = threadName;
		this.threadPriority = threadPriority;
		myThread = new Thread(this);
		myThread.setName(threadName);
		myThread.setPriority(threadPriority);
		myThread.start();
	}

	public Thread getThread() {
		return myThread;
	}

	public int getPriority() {
		return threadPriority;
	}

	public int getIndex() {
		return startIndex;
	}

	public String getName() {
		return threadName;
	}
	public int[][] getMatrix(){
		return matrix;
	}

	@Override
	public void run() {
		synchronized(getMatrix()) {
			int i=startIndex;
			while (i<getMatrix().length){
				printRow(getMatrix(),i);
				i+=2;
			}
		}		
	}
	
	public synchronized void printRow(int[][] matrix,int row) {
		System.out.print("Row: "+row+". Elements: ");
		for(int i=0;i<matrix[row].length;i++) {
			System.out.print(matrix[row][i]+" ");
		}
		System.out.println();
	}
}
