import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_9095_123더하기_silver3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			int number = sc.nextInt();
			int count = 0;
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			q.offer(0);
			
			while(!q.isEmpty()) {
				int temp = q.poll();
				
				if(temp == number) {
					count++;
				}

				if(temp+1 <= number) {					
					q.offer(temp+1);
				}
				if(temp+2 <= number) {					
					q.offer(temp+2);
				}
				if(temp+3 <= number) {					
					q.offer(temp+3);
				}
			}
			
			System.out.println(count);
		}

	}


}
