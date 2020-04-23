import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2985_세수_Bronze2 {
	
	static int[] arr;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int n3 = Integer.parseInt(st.nextToken());
		
		numbers = new int[] {n1,n2,n3};
		arr =  new int[3];
		
		combi(0,0);
		
	}
	
	static boolean combi(int start, int count) {
		if( count == 3) {
			int num1 = arr[0];
			int num2 = arr[1];
			int num3 = arr[2];
			
			if(num1 * num2 == num3) {
				System.out.printf("%d*%d=%d",num1,num2,num3); 
				return true;
			}
			if(num1 - num2 == num3) {
				System.out.printf("%d-%d=%d",num1,num2,num3); 
				return true;
			}
			if(num1 / num2 == num3) {
				System.out.printf("%d/%d=%d",num1,num2,num3); 
				return true;
			}
			if(num1 + num2 == num3) {
				System.out.printf("%d+%d=%d",num1,num2,num3); 
				return true;
			}
			
			if(num1 == num2 * num3) {
				System.out.printf("%d=%d*%d",num1,num2,num3); 
				return true;
			}
			if(num1 == num2 - num3) {
				System.out.printf("%d=%d-%d",num1,num2,num3); 
				return true;
			}
			if(num1 == num2 / num3) {
				System.out.printf("%d=%d/%d",num1,num2,num3); 
				return true;
			}
			if(num1 == num2 + num3) {
				System.out.printf("%d=%d+%d",num1,num2,num3); 
				return true;
			}
			
		}
		
		for (int i = start; i < 3; i++) {
			arr[count] = numbers[i];
			if(combi(start+1,count+1)) {
				return true;
			}
		}
		
		return false;
	}

}
