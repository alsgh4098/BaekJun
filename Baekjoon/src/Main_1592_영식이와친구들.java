import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1592_영식이와친구들 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] people = new int[N];
		
		int ball_owner = 0; // 사람번호 / 인덱스니까 0부터

		int sum = 0;
		
		while(true) {
			
			//공을잡은 횟수 늘리기.
			people[ball_owner]++;
//			System.out.println(ball_owner);
			// 1인당 공받기 제한횟수 M
			if(people[ball_owner] >= M) {
				System.out.println(sum);
				break;
			}else {
				//짝수만큼 공을 받았다면
				if( people[ball_owner] % 2 == 0) {
					// 공을 잡은사람의 위치 조정.
					//절대값중요.
					ball_owner = (Math.abs(ball_owner + N-L))%N;
					sum++;
				//홀수만큼 공을 받았다면
				}else {
					ball_owner = (ball_owner + L)%N;
					sum++;
				}
			}
		}
	}

}
