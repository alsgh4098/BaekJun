import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_1966_프린터큐_silver3 {
	
	// 문서의 개수.
	static int N;
	// 언제 출력될지 궁금한 문서의 현재 위치.
	static int M;
	
	
	// 클래스를 따로 만든 이유는 초기 인덱스 값도 갖고있어야 하기 때문이다.
	static class Node{
		int index;
		int val;
		
		public Node(int index, int val) {
			super();
			this.val = val;
			this.index = index;
		}
		
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			Node[] list = new Node[N];
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				list[i] = new Node(i,Integer.parseInt(st.nextToken()));
			}
			
			MaxVal(list, M);

			
		}

	}
	
	// 노드의 우선도(val)이 제일 높지 않으면 맨뒤로 보낸다.
	// 그 뒤에 노드들은 한 칸씩 땡긴다.
	
	static void MaxVal(Node[] list, int index) {

		for (int i = 0; i < list.length;) {
			int max = list[i].val;
			boolean max_true = true;
			
			for (int j = i+1; j < list.length; j++) {
				if(max < list[j].val) {
					max_true = false;
					break;
				}
			}
			
			// 초기인덱스가 우리가 확인하고자 하는 인덱스의 값과 일치하고
			// 우선도가 제일 높을때의 출력순서를 i로 출력한다.
			if(max_true && list[i].index == index) {
				System.out.println(i+1);
				i++;
			// 우리가 출력을 원하는 노드들 중 우선도가 제일 높은 노드들은 출력하지는 않지만,
			// 출력순서를 1더해준다.
			}else if(max_true) {
				i++;
			}
			
			if( !max_true ) {
				Node temp = list[i];
				
				for (int j = 0; j < list.length-1; j++) {
					list[j] = list[j+1];
				}
				
				list[list.length-1] = temp;
			}
		}
	}

}
