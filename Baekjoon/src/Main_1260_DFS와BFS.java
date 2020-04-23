import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//어려웠던 점.
//입력을 받아 그래프를 그리는것,
//어떤 자료구조로 데이터를 입력받고 형성해야할지 고민이 됐다.

//정점의 숫자가 작은것부터 출력하라는 조건을 확인하지 못해서 고민이 되었다.

public class Main_1260_DFS와BFS {
	
	static ArrayList<Integer>[] list;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		// 1번부터 사용하기 위해서 N+1
		list = new ArrayList[N+1];
		
		//노드 개수 생성.
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		//간선의 수 만큼 입력
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for (int i = 0; i < N+1; i++) {
			java.util.Collections.sort(list[i]);
		}
		
		check = new boolean[N+1];
		dfs(V);
		System.out.println();
		check = new boolean[N+1];
		bfs(V);
		
	}
	
	static void dfs(int node) {
		if(check[node] == true) {
			return;
		}
		
		check[node] = true;
		System.out.print(node + " ");
		for (int next : list[node]) {
			if(!check[next]) {
				dfs(next);
			}
		}
	}
	
	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(node);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			if(check[temp] != true) {
				check[temp] = true;
				System.out.print(temp + " ");
				for(int next: list[temp]) {
					if(check[next] != true) {						
						q.offer(next);
					}
				}
			}
		}
	}

}
