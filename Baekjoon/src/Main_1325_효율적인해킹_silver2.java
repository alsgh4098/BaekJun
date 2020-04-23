import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간초과
// 원인 못찾음.
// DFS로 다시 해봐야겟다.

// 인접행렬.
// 인접리스트.

public class Main_1325_효율적인해킹_silver2 {
	
	static int N;
	static int M;
	
	static ArrayList<Integer>[] list;
	// 딸려있는 컴퓨터의 수를 입력받음.
	static int[] computer;
	static boolean[] visited;
	
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		// 노드의 수.
		N = Integer.parseInt(st.nextToken());
		// 간선의 수.
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		computer = new int[N+1];
		visited = new boolean[N+1];
		
		
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			// 한 방향 간선.
			list[n2].add(n1);
		}
		
		for (int i = 1; i < N+1; i++) {
				bfs(i);
				visited = new boolean[N+1];
		}
		
		for (int i = 1; i < computer.length; i++) {
			if(computer[i] == max) {
				System.out.print(i+" ");
			}
		}

	}
	

	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(node);
		int count = 0;
		visited[node] = true;
		
		while(!q.isEmpty()) {
			int ths = q.poll();
			count++;
			for (int i = 0; i < list[ths].size(); i++) {
				int tht = list[ths].get(i);
				if(!visited[tht]) {
					visited[tht] = true;
					q.offer(tht);
				}
			}
		}
		
		if(max < count) {
			max = count;
		}
		
		computer[node] = count;
	}

}