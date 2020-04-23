import java.util.Scanner;

public class Main_6359_만취한상범_Bronze2 {
	
	static boolean[] jail;

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			int N = sc.nextInt();
			
			jail = new boolean[N+1];
			
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					if( j%i == 0) {
						jail[j] = (jail[j]==true)?false:true;
					}
				}
			}
			
			int count = 0;
			
			for (int i = 1; i < N+1; i++) {
				if(jail[i]) {
					count++;
				}
			}
			
			System.out.println(count);
		}

	}

}
