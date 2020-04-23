import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2606_바이러스_silver2 {
	
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//노드의 수
		int N = sc.nextInt();
		//간선의 수
		int L = sc.nextInt();
		
		list = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < L; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		visited = new boolean[N+1];
		
		//1번 컴퓨터 감염.
		bfs(1);
		
		//감염 수.
		int count = 0;
		
		for (int i = 0; i < N+1; i++) {
			if(visited[i] == true) {
				count++;
			}
		}
		
		//1번 컴퓨터 제외
		System.out.println(count-1);
	}
	
	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(node);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			if(visited[temp] != true) {
				visited[temp] = true;
				
				for (int next: list[temp]) {
					if(visited[next] != true) {
						visited[next] = false;
						q.offer(next);
					}
				}
			}
		}
		
		
	}

}
