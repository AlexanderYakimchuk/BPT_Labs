package labs.lab1;

import java.util.Scanner;

/**
 * Created by User on 09.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        short n=0;
        System.out.printf("n=");
        if (scanner.hasNextShort()){
            n=scanner.nextShort();
        }
        short m=0;
        System.out.printf("m=");
        if (scanner.hasNextShort()){
            m=scanner.nextShort();
        }
        float S=0f;
        short C=0;
        for (short i=0; i<=n; i++){
            for (short j=0; j<=m; j++){
                if (i-C!=0){
                    S+=(float)(i+j)/(float)(i-C);
                }
            }
        }
        System.out.println("Sum="+S);
    }
}
