import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2941_크로아티아알파벳 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		String string = br.readLine();
		
		char[] chr_arr = string.toCharArray();
		
		int count = 0;
		
		for (int i = 0; i < chr_arr.length; i++) {
			if( i+1 < chr_arr.length) {
				if(chr_arr[i] == 'c'){
					if(chr_arr[i+1] == '-'
					   || chr_arr[i+1] == '=') {
						 continue;
					}
				}else if(chr_arr[i] == 'd'){
					if(chr_arr[i+1] == '-') {
						continue;
					}else if(chr_arr[i+1] == 'z') {
						if(i+2 < chr_arr.length
						   && chr_arr[i+2] == '=') {
							continue;
						}
					}
				}else if(chr_arr[i] == 'l'
						||chr_arr[i] == 'n') {
					if(chr_arr[i+1] == 'j') {
						continue;
					}
				}else if(chr_arr[i] == 's'
						||chr_arr[i] == 'z') {
					if(chr_arr[i+1] == '=') {
						continue;
					}
				}
			}
			count++;
		}
		
		System.out.println(count);
	}

}
