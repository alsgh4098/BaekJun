import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_숨바꼭질_silver1 {
	
	static int N;
	static int K;
	
	static Queue<int[]> q;
	static int[] memoi;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		memoi = new int[100001];
		
		q = new LinkedList<int[]>();
		
		solution(N,0);
		
		System.out.println(memoi[K]);
		
	}
	
	public static void solution(int start, int sec) {
		q.offer(new int[] {start,0});
		
		while( !q.isEmpty() ) {
			int[] temp = q.poll();
			int now = temp[0];
			int count = temp[1];
			memoi[now] = count;
			
			if(now == K) {
				break;
			}
			
			if(0<= now-1 && now -1 <= 100000
					&& memoi[now-1] == 0) {
				q.offer(new int[] {now-1,count+1});
			}
			
			if(0<= now+1 && now +1 <= 100000
					&& memoi[now+1] == 0) {
				q.offer(new int[] {now+1,count+1});
			}
			
			if(0<= now*2 && now*2 <= 100000
					&& memoi[now*2] == 0) {
				q.offer(new int[] {now*2,count+1});
			}
		}
		
	}

}
