import java.util.List;
import java.util.Scanner;

/**
 * Created by Dionis on 03/11/2015.
 */

public class Supermarket {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre de caixes:");
        int caixes = Integer.parseInt(sc.nextLine());
        System.out.println("Nombre de clients:");
        int clients = Integer.parseInt(sc.nextLine());

        Cua cues = new Cua(caixes);

        Client clientela[] = new Client[clients];
        for (int j = 0; j < clients; j++) {
            clientela[j] = new Client(j,cues);
            clientela[j].start();
        }

        sc.close();
    }

}
