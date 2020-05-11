import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2003_수들의합2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		// 받을 배열의 길이
		int len = Integer.parseInt(line[0]);
		// 찾으려는 합
		int m = Integer.parseInt(line[1]);

		int[] arr = new int[len+1];

		line = br.readLine().split(" ");
		for (int i = 1; i <= len; i++) {
			arr[i] = Integer.parseInt(line[i-1]);
		}

		// 시작
		int s = 0;
		// 끝
		int e = 0;
		// 합
		int sum = 0;
		// 카운트
		int cnt = 0;

		// s가 끝에 다다르면 종료
		// e는 끝에 다다르면 더 이상 증가시키지 않는다.
		while (true) {

			if(sum >= m) {
				sum -= arr[s++];
			}else if(len == e) {
				break;
			}else {
				sum += arr[e++];
			}
			
			if(sum==m) {
				cnt++;
			}
		}// end logic
		
		System.out.println(cnt);
	}

}
