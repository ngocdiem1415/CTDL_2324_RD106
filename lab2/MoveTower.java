package lab2;

public class MoveTower {

    public static void MoveTower ( int disk , String source, String dest, String square){
        if ( disk == 1 ){
            System.out.println("chuyen dia " + disk + " tu vi tri " + source +" sang vi tri " + dest);
            return ;
        }else{
            MoveTower(disk -1, source,  square ,dest);
            System.out.println("chuyen dia " + disk + " tu vi tri " + source +" sang vi tri " + square);
            MoveTower(disk -1, square, dest, source);
            return;
        }
    }

    public static void main(String[] args) {
        MoveTower(3,"A", "C", "B");
    }
}
