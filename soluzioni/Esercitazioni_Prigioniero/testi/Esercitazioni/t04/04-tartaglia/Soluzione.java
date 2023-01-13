import java.util.Scanner;

public class Soluzione {
    public static void main(String[] args) {
        int r;
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        s.close();
        int tartaglia[][]=new int[n][n];
        for (int count=0; count<n; count++){
            for (r=0; r<count; r++){
                for (int c=0; c<count; c++){
                    if (c==0)
                        tartaglia[r][c]=1;
                    else if (r>0 && c>0)
                        tartaglia[r][c]=tartaglia[r-1][c]+ tartaglia[r-1][c-1];
                }
            }
        } 
        
        for (int i=0; i<n; i++){
            for (int j=0; i<n; j++){
                System.out.print(tartaglia[i][j] + " ");
            
            System.out.println("\n");
        }
    }
}
