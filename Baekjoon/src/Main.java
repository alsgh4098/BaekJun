import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		int i, a = 0, b = 0;
       
        //문자열로 한번에 받음
		String input = new BufferedReader(new InputStreamReader(System.in)).readLine(), tmp="";
		
        //plus는 '-'가 나오기 이전 값만 저장, minus는 '-' 뒤의 수 들을 더해 저장
        StringTokenizer plus, minus;
		for (i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '-') {
        
                //정규식을 이용해 - 또는 + 가 있을 시 전부 " "(띄어쓰기)로 바꿔준 뒤
                //StringTokenizer를 이용해 공백을 제거
				minus = new StringTokenizer(input.substring(i + 1).replaceAll("[-]|[+]", " "));
				
                //공백이 제거된 문자열들을 int로 형변환해 b에 저장
                while (minus.hasMoreTokens()) b+=Integer.parseInt(minus.nextToken());
				break;
			} 
            //'-'가 나오기 전 값들은 한글자씩 String tmp에 저장
            else tmp += input.charAt(i);
		}

        //위에서 저장했던 tmp에서 '+'를 제거한 뒤 plus에 담는다
		plus = new StringTokenizer(tmp, "+");

        //문자열 값들을 int로 형변환 하여 a에 저장
		while (plus.hasMoreTokens()) a += Integer.parseInt(plus.nextToken());

        //이 과정을 거치면 a에는 '-'가 처음 등장하기 전 값들만 저장되고,
        //b에는 최초 '-'가 나온 이후 값들이 저장된다.
		System.out.print(a-b);
	}
}