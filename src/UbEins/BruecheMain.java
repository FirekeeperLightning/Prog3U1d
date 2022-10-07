package UbEins;

import java.util.Arrays;

public class BruecheMain {
    public static void main(String[] args) {
        Bruch[] BruchArray = new Bruch[10];
        for (int i = 0; i < BruchArray.length; i++) {
            BruchArray[i] = new Bruch(90 -8*i, i+1);
        }

        for (int i = 0; i < BruchArray.length; i++) {
            System.out.println(BruchArray[i].toString());
        }
        Arrays .sort(BruchArray);
        for (int i = 0; i < BruchArray.length; i++) {
            System.out.println(BruchArray[i].toString());
        }
    }

}
