import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11403_경로찾기_silver2 {
	
	static int N;
	
	static int[][] mat;
	
	static ArrayList<Integer>[] List;
	static int[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		mat = new int[N][N];
		
		List = new ArrayList[N];
		for (int i = 0; i < List.length; i++) {
			List[i] = new ArrayList<Integer>();
		}
		
		
		
		visited = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				
				// 연결되어 있는 인접행렬의 정보에 따라서 List에 담아준다.
				if(mat[i][j] == 1) {					
					List[i].add(j);
//					List[j].add(i);
				}
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 0; i < N; i++) {
			q.offer(i);
			for (int j = 0; j < N; j++) {
				Arrays.fill(visited, 0);
			}
			
			while(!q.isEmpty()) {
				int node = q.poll();
				if(visited[node] != 1) {
					visited[node] = 1;
					for (int j = 0; j < List[node].size(); j++) {
						mat[i][List[node].get(j)] = 1;
						q.offer(List[node].get(j));
					}
				}
			}
		}

		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}

	}

}
