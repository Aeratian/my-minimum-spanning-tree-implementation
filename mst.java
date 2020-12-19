import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class mst {
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N=in.nextInt();
        int mat[][]=new int[N+1][N+1];
        int cost[]=new int[N+1];
        boolean visited[]=new boolean[N+1];
        int a;
        int b;
        int c;
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=N; j++)
            {
               mat[i][j]=in.nextInt();
            }
        }
        int ans = 0;
        for(int i=0; i<=N; i++)
        {
            cost[i]=Integer.MAX_VALUE;
            cost[1]=0;
        }
        for(int i=1; i<=N; i++)
        {
            int x=0;
            for(int j=1; j<=N; j++)
            {
                if(!visited[j]&&cost[x]>cost[j])
                {
                    x=j;
                }
            }
            visited[x]=true;
            for(int j=1; j<=N; j++)
            {
                if(!visited[j] && mat[x][j]>0 && cost[j]>mat[x][j])
                {
                    cost[j]=mat[x][j];
                }
            }
        }
        for(int i=1; i<=N; i++)
        {
            ans+=cost[i];
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}
	