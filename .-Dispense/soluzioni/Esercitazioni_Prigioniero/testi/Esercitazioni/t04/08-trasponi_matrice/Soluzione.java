import java.util.Scanner;

public class Soluzione {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int[][] a=new int[n][m];

        Scanner s = new Scanner(System.in);
        for (int r=0; r<n; r++)
            for (int c=0; c<m; c++)
                a[r][c]=s.nextInt();
        
        int T[][]=new int [m][n];
        for (int r=0; r<m; r++)
            for (int c=0; c<n; c++)
                T[r][c]=a[c][r];
            
        for (int r=0; r<m; r++){
            for (int c=0; c<n; c++)
                System.out.print(T[r][c] + " ");
            System.out.println();
        }
        s.close();
    }
}
