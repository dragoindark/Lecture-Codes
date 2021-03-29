package arrayInterviews;

import java.util.Scanner;

public class ChaoticChristmas {
	// Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
    	int minBribes=0;
    	int briber=0;
    	boolean tooChaotic=false;
    	int[] indexChange=new int[q.length];
    	for(int i=0;i<q.length;i++) {
    		if(q[i]>(i+1)) {
    			minBribes+=q[i]-(i+1);
    			briber+=1;
    			if(q[i]-(i+1)>2) {
    				tooChaotic=true;
    			}
    		}else {
    			continue;
    		}
    		indexChange[i]=Math.abs(q[i]-(i+1));
    	}
    	for(int i=0;i<indexChange.length;i++) {
    		if(indexChange[i]>briber) {
    			minBribes+=indexChange[i]-briber;
    		}
    	}
    	if(tooChaotic) {
    		System.out.println("Too chaotic");
    	}else {
    		System.out.println(minBribes);
    	}
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
