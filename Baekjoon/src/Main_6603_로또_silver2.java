import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_6603_로또_silver2 {
	
	static ArrayList<ArrayList<int[]>> list = new ArrayList<ArrayList<int[]>>();
	static ArrayList<int[]> li;
	static int[] arr;
	static int[] select;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			N = sc.nextInt();
			
			if(N == 0) {
				break;
			}
			
			arr = new int[N];
			select = new int[6];
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			li = new ArrayList<int[]>();
			
			combi(0,0);
			
//			for (int i = 0; i < li.size(); i++) {
//				for (int j = 0; j < li.get(i).length; j++) {
//					System.out.print(li.get(i)[j]+" ");
//				}
//				System.out.println();
//			}
			
			list.add(li);
			
		}
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				for (int j2 = 0; j2 < list.get(i).get(j).length; j2++) {
					System.out.print(list.get(i).get(j)[j2] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		

	}
	
	static void combi(int start, int count) {
		if( count == 6) {
			int[] n_select = Arrays.copyOf(select, 6);
			li.add(n_select);
			return;
		}
		
		for (int i = start; i < N; i++) {
			select[count] = arr[i];
			combi(i+1,count+1);
		}
	}

}
