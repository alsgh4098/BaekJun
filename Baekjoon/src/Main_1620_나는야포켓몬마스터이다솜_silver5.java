import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터이다솜_silver5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			map.put(i, str);
			map2.put(str,i);
		}
		
		String question = new String();
		
		for (int i = 0; i < M; i++) {
			question = br.readLine();
			if(Character.isDigit(question.charAt(0))) {
				System.out.println(map.get(Integer.parseInt(question)));
			}else {
				System.out.println(map2.get(question));
			}
		}
		
	}

}
