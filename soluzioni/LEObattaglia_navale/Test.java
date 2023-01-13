package battaglia_navale;
import java.util.*;



public class Test {

    public static void main(String[] args){
        List<Posizione> mosse1=new ArrayList<>();
        Set<Nave> flotta1=new HashSet<>();
        List<Posizione> mosse2=new ArrayList<>();
        Set<Nave> flotta2=new HashSet<>();;
        Osservatore o;
        Scanner input=new Scanner(System.in);
        while(input.hasNextLine()){
            String f1=input.nextLine();
            String m1=input.nextLine();
            String parse_f1[]=f1.split(",");
            String parse_m1[]=m1.split(",");
            for(int i=0;i<parse_f1.length;i++){
                String nave_param1[]=parse_f1[i].split(":");
                flotta1.add(new Nave(new Tipo(nave_param1[0].charAt(0) ), 
                new Posizione( nave_param1[1].charAt(0), ( (int)(nave_param1[1].charAt(1))-48)) , 
                nave_param1[2].charAt(0)));
            }
            for(int i=0;i<parse_m1.length;i++){   
                mosse1.add( new Posizione( parse_m1[i].charAt(0), ( (int)(parse_m1[i].charAt(1) ) -48) ) );
            }

            String f2=input.nextLine();
            String m2=input.nextLine();
            String parse_f2[]=f2.split(",");
            String parse_m2[]=m2.split(",");
            for(int i=0;i<parse_f2.length;i++){
                String nave_param2[]=parse_f2[i].split(":");
                flotta2.add(new Nave(new Tipo(nave_param2[0].charAt(0) ), 
                new Posizione( nave_param2[1].charAt(0), ( (int)(nave_param2[1].charAt(1))-48)) , 
                nave_param2[2].charAt(0)));
            }
            for(int i=0;i<parse_m2.length;i++){   
                mosse2.add( new Posizione( parse_m2[i].charAt(0), ( (int)(parse_m2[i].charAt(1)-48 ) ) ) );
            }
        }
        o=new Osservatore(flotta1,flotta2,mosse1,mosse2);
        System.out.println(o.toString()) ;
        o.moves();
        System.out.println(o.toString()) ;
        o.endgame();
        System.out.println(o.toString()) ;

    }
    
}
