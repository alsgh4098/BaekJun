import java.util.Scanner;

public class Main_1780_종이의개수_silver2 {
	
	static int[][] paper;
	static int N;
	static int cnt;
	static int cnt2;
	static int cnt3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		
		find(0,0,N);
		
		System.out.println(cnt3);
		System.out.println(cnt);
		System.out.println(cnt2);
		
	}
	
	static void find(int x,int y,int n) {
		boolean check = true;
		
		int value = paper[x][y];
		
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if(paper[i][j] != value) {
					check = false;
					break;
				}
			}
		}

		if(check) {
			switch (value) {
			case 0:
				cnt++;
				break;
			case 1:
				cnt2++;
				break;
			case -1:
				cnt3++;
				break;
			}
			return;
		}else {
			find(x,y,n/3);
			find(x,y+2*n/3,n/3);
			find(x,y+n/3,n/3);

			find(x+n/3,y,n/3);
			find(x+n/3,y+2*n/3,n/3);
			find(x+n/3,y+n/3,n/3);

			find(x+2*n/3,y,n/3);
			find(x+2*n/3,y+2*n/3,n/3);
			find(x+2*n/3,y+n/3,n/3);
		}
	}

}
