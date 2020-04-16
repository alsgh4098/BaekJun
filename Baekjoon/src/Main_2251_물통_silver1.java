import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2251_물통_silver1 {
	
	static boolean[][][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		Queue<int[]> q = new LinkedList<int[]>();

		ArrayList<Integer> list = new ArrayList<Integer>();

		// 처음에 주어진 물통에서 A와 B에는 안들어있어야함.
		// C는 가득차있음.
		q.offer(new int[] { 0, 0, C });
		
		visited = new boolean[201][201][201];

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			int A2 = temp[0];
			int B2 = temp[1];
			int C2 = temp[2];
			
			if(!visited[A2][B2][C2]) {
				visited[A2][B2][C2] = true;

				// A는 비어있어야 함.
				if (!list.contains(C2) && A2 == 0) {
					list.add(C2);
				}

//				for (int i = 0; i < 3; i++) {
//					System.out.print(temp[i] + " ");
//				}
//				System.out.println();
				
				
				// C에서 B로
				int next = B - B2;
				if (B2 + next <= B && C2 - next >= 0) {
					q.offer(new int[] { A2, B2 + next, C2 - next });
				} else if (B2 + C2 <= B && next > C2) {
					q.offer(new int[] { A2, B2 + C2, 0 });
				}

				// C에서 A로
				next = A - A2;
				if (A2 + next <= A && C2 - next >= 0) {
					q.offer(new int[] { A2 + next, B2, C2 - next });
				} else if (A2 + C2 <= A && next > C2) {
					q.offer(new int[] { A2 + C2, B2, 0 });
				}

				// B에서 C로
				next = C - C2;
				if (C2 + next <= C && B2 - next >= 0) {
					q.offer(new int[] { A2, B2 - next, C2 + next });
				} else if (C2 + B2 <= C && next > B2) {
					q.offer(new int[] { A2, 0, C2 + B2 });
				}

				// A에서 C로
				next = C - C2;
				if (C2 + next <= C && A2 - next >= 0) {
					q.offer(new int[] { A2 - next, B2, C2 + next });
				} else if (C2 + A2 <= C && next > A2) {
					q.offer(new int[] { 0, B2, C2 + A2 });
				}

				// B에서 A로
				next = A - A2;
				if (A2 + next <= A && B2 - next >= 0) {
					q.offer(new int[] { A2 + next, B2 - next, C2 });
				} else if (A2 + B2 <= A && next > B2) {
					q.offer(new int[] { A2 + B2, 0, C2 });
				}

				// A에서 B로
				next = B - B2;
				if (B2 + next <= B && A2 - next >= 0) {
					q.offer(new int[] { A2 - next, B2 + next, C2 });
				} else if (B2 + A2 <= B && next > A2) {
					q.offer(new int[] { 0, A2 + B2, C2 });
				}
			}

		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
