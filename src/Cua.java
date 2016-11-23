/**
 * Created by x3727349s on 18/11/16.
 */
public class Cua {


    private int nuncaixes;
    private boolean [] caixes;
    private double totalPagar=0;


    public Cua(int caixes) {
        this.nuncaixes= caixes;
        this.caixes = new boolean[nuncaixes];;
    }

    //Aquet hem torna el nombre de caixes
    public int getnuncaixes() {
        return nuncaixes;
    }

    //Fem que els clients passin a les caixes
    public synchronized void ocuparcua(int ocupar) throws InterruptedException {
        //Si la caixa esta buida entra, sino pasa a espera que estigui buida
        if (!caixes[ocupar]) {
            this.caixes[ocupar] = true;
        } else {
            wait();

        }
    }

    //Amb aquet metode fem que la caixa el buidi i que notifiqui amb el "notify" al altre Thread de que ja pot  procesarlo
    public synchronized void desocuparcua( int desocupar ) {
        this.caixes[desocupar] = false;
        notify();
    }

    //Aixo es per treure cuant a pagat
    public void pagar(int pagar, int temps ) {
         this.totalPagar = (pagar*temps)/100;
    }

    public double getTotalPagar(){
        return totalPagar;
    }

}























