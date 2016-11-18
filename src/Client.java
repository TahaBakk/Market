import java.util.Random;

/**
 * Created by Dionis on 03/11/2015.
 */
public class Client extends Thread {

    int numero = 0;
    int temps = 0;
    Cua cua = null;


    public Client(int n, Cua cues) {
        this.numero = n;
        this.cua = cues;
    }

    public void run(){
        Random rd = new Random();
        temps = rd.nextInt(1500);
        try {
            sleep(temps);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int tria_cua = rd.nextInt(cua.getnuncaixes());

        try {
            cua.ocuparcua(tria_cua);
            sleep(rd.nextInt(150));
            cua.pagar(rd.nextInt(250));
            cua.desocuparcua(tria_cua);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Soc el client: "+this.numero+" i he trigat a comprar "+temps+" He pagat en la caixa "+tria_cua);


    }
}
