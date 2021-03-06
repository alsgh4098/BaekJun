import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11559_PuyoPuyo {

	static char[][] map;
	static char[][] visited;

	// 상 우 하 좌
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	// 같은 색상이 4개이상임을 세기위한 변수
	static int color_cnt;
	// 총 몇번 뿌요들이 터졌는지 담기위한 변수
	static int puyo;
	// 동시에 터진 뿌요들을 한 카운트로 세기위한 변수
	static boolean puyo_chck;
	
	static boolean left_puyo;
	static boolean down;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[14][8];
		
		visited = new char[14][8];
		
		

		// 뿌요의 색
		// R G B P Y

		// 빈공간
		// .

		// *로 패딩
		for (int i = 0; i < 14; i++) {
			map[i][0] = '*';
			map[i][7] = '*';
		}

		for (int j = 0; j < 8; j++) {
			map[0][j] = '*';
			map[13][j] = '*';
		}

		// input
		StringTokenizer st;
		for (int i = 1; i < 13; i++) {
			// 공백없는 입력.
			char[] chr_arr = br.readLine().toCharArray();
			for (int j = 1; j < 7; j++) {
				map[i][j] = chr_arr[j - 1];
			}
		}
		
		
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 8; j++) {
				visited[i][j] = map[i][j];
			}
		}
		
		
		
		color_cnt = 0;
		puyo = 0;

		char val;
		
		while(true) {
			down = false;
			for (int k = 12; k >= 0; k--) {
				for (int n = 1; n < 7; n++) {
					if (map[k][n] != '*' || map[k][n] != '.') {
						val = map[k][n];
						solution2(k, n, val);
						
					}
				}
			}
			left_puyo = false;
			for (int i = 1; i < 13; i++) {
				for (int j = 1; j < 7; j++) {
					color_cnt = 0;
					val = map[i][j];
					if(val != '.') {
						solution(i, j, val);
						solution_(i,j,val);
					}
				}
			}
			
			init_visit();
			
			if (puyo_chck) {
				puyo++;
				puyo_chck = false;

			}
			
			if(!left_puyo && !down) {
				break;
			}
			
		}

		// output
		System.out.printf("%d\n", puyo);

	}

	// 뿌요맵 출력
	static void printMap() {
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	// 같은 알파벳이 4개이상 있을 때 터짐.
	// 동시에 여러 쌍이 터질 수 있음. 위의 for문에서 구현.
	// 쌍이 맞는 뿌요를 터트리는 솔루션.

	// 좌표 x와 y 그리고 처음에 들어온 색의 값 val
	static void solution(int x, int y, char val) {
		if(map[x][y] != val){
			return;
		}else if(visited[x][y] != 'v') {
			color_cnt++;
			visited[x][y] = 'v';
			for (int i = 0; i < 4; i++) {
				solution(x+dx[i],y+dy[i],val);
			}
		}else {
			return;
		}
	}
	
	static void solution_(int x, int y, char val) {
		if(visited[x][y] == 'v'
		   && color_cnt >= 4 && map[x][y] == val) {
			map[x][y] = '.';
			for (int i = 0; i < 4; i++) {
				solution_(x+dx[i],y+dy[i],val);
			}
			left_puyo = true;
			puyo_chck = true;
		}else {
			return;
		}
	}

	// 공중에 떠있는 뿌요를 아래로 내려보내는 솔루션.
	// 아래방향만 탐색.
	// 빈공간이 있으면 바닥이나 다른 뿌요에 닿을 때 까지 계속 내려감.
	static void solution2(int x, int y, char val) {
		if (map[x][y] == '*') {
			return;
		} else if (map[x][y] == '.') {
			return;
		}

		// 아래로 탐색
		if (map[x][y] == val) {
			if (map[x + 1][y] == '.') {
				down = true;
				map[x][y] = '.';
				map[x + 1][y] = val;
				solution2(x + 1, y, val);
			} else {
				return;
			}
		}
	}
	
	static void init_visit() {
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 8; j++) {
				visited[i][j] = map[i][j];
			}
		}
	}

}
