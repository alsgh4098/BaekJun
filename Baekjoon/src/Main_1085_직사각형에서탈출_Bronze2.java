import java.util.Scanner;

public class Main_1085_직사각형에서탈출_Bronze2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int resX = Math.abs(0-x);
		int resY = Math.abs(0-y);
		
		int resX2 = Math.abs(w-x);
		int resY2 = Math.abs(h-y);
		
		int res1 = Math.min(resX, resX2);
		int res2 = Math.min(resY, resY2);
		
		int res = Math.min(res1, res2);
		System.out.println(res);
	}

}
