import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1463_1로만들기_silver3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int res = Integer.MAX_VALUE;
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[] {N,0});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int number = temp[0];
			int count = temp[1];
			
			if(number == 1) {
				// 자동적으로 1에 도달한것중 가장 작은 카운트를 가진것이 들어간다.
				// queue는 가장 먼저들어간것이 가장 먼저 나오기 때문에.
				res = count;
				break;
			}
			
			if(number%3 == 0) {
				q.offer(new int[] {number/3,count+1});
			}
			if(number%2 == 0) {
				q.offer(new int[] {number/2,count+1});
			}
			if(number-1 >= 1) {
				q.offer(new int[] {number-1,count+1});
			}
		}
		
		System.out.println(res);

	}

}
