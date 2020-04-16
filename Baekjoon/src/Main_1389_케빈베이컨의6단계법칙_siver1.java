import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙_siver1 {
	
	// 행이 원래 노드, 열이 도착 노드.
	// 그 안의 값은 원래 노드에서 도착노드 까지 가는데 걸리는 최소 거리가 담겨있다.
	static int[][] node_arr;
	
	static int N;
	static int M;

	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		visited = new boolean[N];
		node_arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(node_arr[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 배열을 처음부터 사용하기 위해 1을 빼준다.
			int ths = Integer.parseInt(st.nextToken())-1;
			int that = Integer.parseInt(st.nextToken())-1;
			
			// 친구관계는 양방향.
			if(list[ths].contains(that)) {
				continue;
			}
			if(list[that].contains(ths)) {
				continue;
			}
			list[ths].add(that);
			list[that].add(ths);
			
		}
		
		for (int i = 0; i < N; i++) {
				bfs(i);
				visited = new boolean[N];
		}

		int res = 0;
		
		for (int i = 0; i < N; i++) {
			int sum = 0;
			
			for (int j = 0; j < N; j++) {
				sum += node_arr[i][j];
			}
			
			if(min > sum) {
				min = sum;
				res = i+1;
			}
		}
		
//		printMap();
		
		System.out.println(res);

	}
	
	static void bfs(int nd) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[] {nd,0});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			int ths = temp[0];
			int cnt = temp[1]+1;
			if(visited[ths] == false) {

				visited[ths] = true;
				for (int i = 0; i < list[ths].size(); i++) {
					int tat = list[ths].get(i);
					node_arr[nd][tat] = Math.min(node_arr[nd][tat], cnt);
					if(Math.min(node_arr[nd][tat], cnt) == node_arr[nd][tat]) {						
						q.offer(new int[] {tat,cnt});
					}
				}
			}
		}
		
	}
	
	static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(node_arr[i][j]);
			}
			System.out.println();
		}
	}

}
