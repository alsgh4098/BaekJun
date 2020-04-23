import java.util.Scanner;

public class Main_1712_손익분기점_Bronze5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Long A = sc.nextLong();
		Long B = sc.nextLong();
		Long C = sc.nextLong();
		
		Long res = 0L;
		
		if(B>= C) {
			res = -1L;
		}else {
			res = A/(C-B) + 1;			
		}
		
		System.out.println(res);

	}

}
