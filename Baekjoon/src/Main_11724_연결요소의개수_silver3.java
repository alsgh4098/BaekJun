import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수_silver3 {
	
	static ArrayList<Integer>[] list;
	static int[] visited;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		visited = new int[N+1];
		
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
//			System.out.println(index);
			int node = Integer.parseInt(st.nextToken());
			list[index].add(node);
			list[node].add(index);
		}
		
		count = 0;
		
		for (int i = 1; i < N+1; i++) {
			if(visited[i] != 1) {
				bfs(i);
//				System.out.println();
			}
		}
		
		System.out.println(count);
	}
	
	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(node);
		count++;

		while(!q.isEmpty()) {
			int index = q.poll();
			if(visited[index] != 1) {
				visited[index] = 1;
//				System.out.println(index);
				for (int i = 0; i < list[index].size(); i++) {
					q.offer(list[index].get(i));
				}
			}
		}
		
	}

}
