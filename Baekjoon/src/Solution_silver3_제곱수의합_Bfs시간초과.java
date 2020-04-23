import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_silver3_제곱수의합_Bfs시간초과 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {N,0});
		
		int res = 0;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int num = temp[0];
			int cnt = temp[1];
			
			if(num == 0) {
				res = cnt;
				break;
			}
			
			System.out.println(num);
			
			int index = (int) Math.sqrt(num);
			
			for (int i = index; i >= 1; i--) {
				int num2 = (int) (num-Math.pow(i, 2));
				if(num2 >= 0) {					
					queue.offer(new int[] {num2,cnt+1});
				}
			}
			
		}
		
		System.out.println(res);
	}

}
