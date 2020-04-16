import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_9205_맥주마시며걸어가기_9205 {
	
	//좌표의 범위가 -를 넘어간다.
	//이동거리가 1000이하여야 한다.
	
	//플로이드 마셜 알고리즘을 최단거리가 아닌 이동가능여부로 활용.
	
	static class Map{
		int x;
		int y;
		
		public Map(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	static ArrayList<Map> places;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	// 연결여부.
	static int[][] fm;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st;
			
			// 편의점의 수 N + 출발점 + 도착점
			fm = new int[N+2][N+2];
			
			places = new ArrayList<Map>();
			for (int j = 0; j < N+2; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y =Integer.parseInt(st.nextToken());
				Map pla = new Map(x,y);
				places.add(pla);
			}
			
			for (int i = 0; i < N+2; i++) {
				Map ths = places.get(i);
				
				for (int j = 0; j < N+2; j++) {
					Map tht = places.get(j);
					if(i!=j) {
						// 맨하탄 거리?
						if(Math.abs(ths.x - tht.x) + Math.abs(ths.y - tht.y) <= 1000) {
							// i에서 j로 연결가능하다.
							fm[i][j] = 1;
						}
					}
				}
			}
			
			//플로이드
			//k는 중간점
			//i출발 -> j목표
			//k를 거쳐서 갈 수 있는지 판별.
			for (int k = 0; k < N+2; k++) {
				for (int i = 0; i < N+2; i++) {
					for (int j = 0; j < N+2; j++) {
						if(fm[i][k] == 1
						  && fm[k][j] == 1) {
							fm[i][j] = 1;
						}
					}
				}
			}
		
			if(fm[0][N+1] == 1) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
		}

	}

}
