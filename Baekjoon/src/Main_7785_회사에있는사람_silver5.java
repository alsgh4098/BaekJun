import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 이름이 4글자 이하인경우 생각치 못함.

public class Main_7785_회사에있는사람_silver5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Set set = new HashSet<>();
		
		String name = "";
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			if(str.contains("enter")) {
				name = str.substring(0,str.indexOf("enter")-1);	
				set.add(name);
			}else {
				name = str.substring(0,str.indexOf("leave")-1);	
				set.remove(name);
			}
		}
		

		
		String[] list = new String[set.size()];
		
		Iterator<String> iter = set.iterator();
		
		int i = 0;
		
		while(iter.hasNext()) {
			list[i] = iter.next();
			i++;
		}
		
		// 어레이만 가능.
		Arrays.sort(list,Collections.reverseOrder());
		
		for (int j = 0; j < list.length; j++) {
			System.out.println(list[j]);
		}

	}

}
