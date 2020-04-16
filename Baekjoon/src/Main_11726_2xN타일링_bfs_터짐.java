import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11726_2xN타일링_bfs_터짐 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int count = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(0);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			if(temp == N) {
				count++;
			}
			
			if(temp+1 <= N) {
				q.offer(temp+1);
			}
			
			if(temp+2 <= N) {
				q.offer(temp+2);
			}
			
		}
		
		System.out.println(count%10007);
		
	}

}
