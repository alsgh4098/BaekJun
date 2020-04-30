import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_8980_택배_gold4 {

	static class Truck {
		int on = 0;
		int max = 0;
		// 해당 도시에서 박스를 실은 상태
		int[] cities = new int[2001];
	}

	static class City implements Comparable<City> {
		int s;
		int f;
		int box;

		@Override
		public int compareTo(City o) {
			if (this.f < o.f) {
				return -1;
			} else if (this.f == o.f) {
				if(this.s < o.s) {
					return 1;
				}else if(this.s == o.s) {
					return 0;
				}else {
					return -1;
				}
			} else {
				return 1;
			}
		}

		public City(int s, int f, int box) {
			super();
			this.s = s;
			this.f = f;
			this.box = box;
		}

	}

	static int N;
	static int C;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");

		// 마을 수
		N = Integer.parseInt(line[0]);
		// 제한 용량
		C = Integer.parseInt(line[1]);
		// 배송 수
		M = Integer.parseInt(br.readLine());

		PriorityQueue<City> pq = new PriorityQueue<City>();

		for (int i = 0; i < M; i++) {
			line = br.readLine().split(" ");
			int s = Integer.parseInt(line[0]);
			int f = Integer.parseInt(line[1]);
			int box = Integer.parseInt(line[2]);
			pq.add(new City(s, f, box));
		}

		int res = 0;

		Truck tr = new Truck();
//		System.out.println(C);
		tr.max = C;
		
		while(!pq.isEmpty()) {
			City ths = pq.poll();
			int s = ths.s;
			int f = ths.f;
			int box = ths.box;
//			System.out.println(box);
			// 도시는 1번 부터
			boolean loadPossible = true;
			for (int i = s; i < f; i++) {
				if(tr.cities[i] == tr.max) {
					loadPossible = false;
					break;
				}
			}
			
			if(loadPossible) {
				int max = 0;
				for (int i = s; i < f; i++) {
					if(tr.cities[i] > max) {
						max = tr.cities[i];
					}
				}
				
				if(max+box >= tr.max) {
					int on = tr.max-max;
					for (int i = s; i < f; i++) {
						tr.cities[i] += on;
					}
					res += on;
				}else {
					for (int i = s; i < f; i++) {
						tr.cities[i] += box;
					}
					res += box;
				}
			}
			
		}

		System.out.println(res);

	}

}
