import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main_4179_불_Gold52 {
    
    static int R,C;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Node> man = new LinkedList<>();
    static Queue<Node> fire = new LinkedList<>();
    static int min = -1;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        visited = new boolean[R][C];
        
        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[j];
                if(temp[j] == 'J') {
                    visited[i][j] = true;
                    map[i][j] = '.';
                    man.add(new Node(i, j));
                }
                else if (temp[j] == 'F') {
                    visited[i][j] = true;
                    fire.add(new Node(i, j));
                }
            }
        }
        
        int cnt = 0;
        
        loop :while(!man.isEmpty()) {
            // fire
            int fs = fire.size();
            
            for (int s = 0; s < fs; s++) {
                Node cur = fire.poll();
                
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    
                    if(!isRange(nx, ny) || map[nx][ny] != '.')
                        continue;
                    map[nx][ny] = 'F';
                    fire.add(new Node(nx, ny));
                }
            }
            
            // man
            int ms = man.size();
            
            for (int s = 0; s < ms; s++) {
                Node cur = man.poll();
                
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    
                    if(!isRange(nx, ny)) {
                        min = ++cnt;
                        break loop;
                    }
                    
                    if(visited[nx][ny] || map[nx][ny] != '.')
                        continue;
                    visited[nx][ny] = true;
                    man.add(new Node(nx, ny));
                }
            }
            cnt++;
        }
        System.out.println(min == -1 ? "IMPOSSIBLE" : min);
    }
    
    static boolean isRange(int x, int y) {
        if( x < 0 || x >= R || y <  0 || y >= C) return false;
        return true;
    }
 
}
 
class Node {
    int x;
    int y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
