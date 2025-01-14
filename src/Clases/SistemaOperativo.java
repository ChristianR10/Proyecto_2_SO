package Clases;

import Clases.Cola;
import Clases.Personaje;
import Clases.Propiedades;
import Interfaz.Pantalla;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class SistemaOperativo extends Thread {

    private Personaje fighterSW;
    private Personaje figtherST;

    int zIds = 10;
    int stIds = 10;
    int cicloCont;  //Variable para contar los ciclos de revision
    private boolean turno;

    public SistemaOperativo() {
        this.cicloCont = 0;
        this.turno = false;
    }

    @Override
    public void run() {
        while (true) {
            if (this.isTurno() == true) {
                try {

                    if (Pantalla.contador >= 8) {
                        this.agregarRefuerzo(Pantalla.getzColaP1(), Pantalla.getzColaP2(), Pantalla.getzColaP3(), Pantalla.getzRefuerzo(), Pantalla.SWPanelP1, Pantalla.SWPanel2, Pantalla.SWPanel3, Pantalla.SWPanel4);
                        this.agregarRefuerzo(Pantalla.getStColaP1(), Pantalla.getStColaP2(), Pantalla.getStColaP3(), Pantalla.getStRefuerzo(), Pantalla.STPanel1, Pantalla.STPanel2, Pantalla.STPanel3, Pantalla.STPanel4);
                        Pantalla.contador = 0;
                    }

                    if(cicloCont>=2){
                           Random r = new Random();
                            int decision = r.nextInt(10);
                            if (decision >= 1) {
                            this.zIds+=1;
                            this.stIds+=1;
                            this.agregarPersonaje(Pantalla.getPoolStarWars(), Pantalla.getzColaP1(), Pantalla.getzColaP2(), Pantalla.getzColaP3(), Pantalla.SWPanelP1, Pantalla.SWPanel2, Pantalla.SWPanel3,this.zIds, "SW");
                            this.agregarPersonaje(Pantalla.getPoolStarTrek(), Pantalla.getStColaP1(), Pantalla.getStColaP2(), Pantalla.getStColaP3(), Pantalla.STPanel1, Pantalla.STPanel2, Pantalla.STPanel3, this.stIds, "ST");
                            this.cicloCont = 0;
                        }

                    }
                    this.actualizarColas();
                    this.revisarColas(Pantalla.getzColaP1(), Pantalla.getzColaP2(), Pantalla.getzColaP3(), Pantalla.getzColaP3(), Pantalla.SWSemaforo, Pantalla.SWPanelP1, Pantalla.SWPanel2, Pantalla.SWPanel3);
                    this.revisarColas(Pantalla.getzColaP1(), Pantalla.getzColaP2(), Pantalla.getzColaP3(), Pantalla.getzColaP2(), Pantalla.SWSemaforo, Pantalla.SWPanelP1, Pantalla.SWPanel2, Pantalla.SWPanel3);
                    this.revisarColas(Pantalla.getStColaP1(), Pantalla.getStColaP2(), Pantalla.getStColaP3(), Pantalla.getStColaP3(), Pantalla.STSemaforo, Pantalla.STPanel1, Pantalla.STPanel2, Pantalla.STPanel3);
                    this.revisarColas(Pantalla.getStColaP1(), Pantalla.getStColaP2(), Pantalla.getStColaP3(), Pantalla.getStColaP2(), Pantalla.STSemaforo, Pantalla.STPanel1, Pantalla.STPanel2, Pantalla.STPanel3);
                    this.fighterSW = this.escogerPersonajes(Pantalla.getzColaP1(), Pantalla.getzColaP2(), Pantalla.getzColaP3(), Pantalla.SWSemaforo, Pantalla.SWPanelP1, Pantalla.SWPanel2, Pantalla.SWPanel3);
                    this.figtherST = this.escogerPersonajes(Pantalla.getStColaP1(), Pantalla.getStColaP2(), Pantalla.getStColaP3(), Pantalla.STSemaforo, Pantalla.STPanel1, Pantalla.STPanel2, Pantalla.STPanel3);
                    if (this.fighterSW == null && this.figtherST == null) {
                        this.llenarColas(Pantalla.getPoolStarWars(), Pantalla.getzColaP1(), Pantalla.getzColaP2(), Pantalla.getzColaP3(), Pantalla.SWPanelP1, Pantalla.SWPanel2, Pantalla.SWPanel3);
                        this.llenarColas(Pantalla.getPoolStarTrek(), Pantalla.getStColaP1(), Pantalla.getStColaP2(), Pantalla.getStColaP3(), Pantalla.STPanel1, Pantalla.STPanel2, Pantalla.STPanel3);
                        this.fighterSW = this.escogerPersonajes(Pantalla.getzColaP1(), Pantalla.getzColaP2(), Pantalla.getzColaP3(), Pantalla.SWSemaforo, Pantalla.SWPanelP1, Pantalla.SWPanel2, Pantalla.SWPanel3);
                        this.figtherST = this.escogerPersonajes(Pantalla.getStColaP1(), Pantalla.getStColaP2(), Pantalla.getStColaP3(), Pantalla.STSemaforo, Pantalla.STPanel1, Pantalla.STPanel2, Pantalla.STPanel3);
                    }
                    Pantalla.pelea(fighterSW, Pantalla.SWFighterLabel, Pantalla.SWInfo1, Pantalla.SWInfo2, Pantalla.SWInfo3, Pantalla.SWInfo4, Pantalla.SWInfo5);
                    Pantalla.pelea(figtherST, Pantalla.STFigtherLabel, Pantalla.STInfo1, Pantalla.STInfo2, Pantalla.STInfo3, Pantalla.STInfo4, Pantalla.STInfo5);
                    Pantalla.SWFigther = fighterSW;
                    Pantalla.STFigther = figtherST;
                    this.setTurno(false);
                    Pantalla.IA.setTurno(true);
                    this.cicloCont += 1;
                } catch (InterruptedException ex) {
                    Logger.getLogger(SistemaOperativo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SistemaOperativo.class.getName()).log(Level.SEVERE, null, ex);
                }

            }else{
                System.out.println("Batallando");
            }
        }
    }

    public void actualizarColas() {
        //metodo de prueba para aumentar la prioridad de los personajes 
        Pantalla.getzColaP2().actualizarPersonajesCont();
        Pantalla.getzColaP3().actualizarPersonajesCont();
        Pantalla.getStColaP2().actualizarPersonajesCont();
        Pantalla.getStColaP3().actualizarPersonajesCont();
    }

    //Revisa las colas y las mete en otra lista si su prioridad cambio 
    public void revisarColas(Cola p1, Cola p2, Cola p3, Cola revisada, Semaphore semaforo, JPanel zP1, JPanel zP2, JPanel zP3) throws InterruptedException {
        try {
            while (true) {
                Personaje aux = revisada.getNodoCabeza().getDatos();
                if (revisada.getTipo() == 3) {
                    if (aux.getTipo() == 2) {
                        semaforo.acquire(1);
                        revisada.desencolar();
                        p2.encolar(aux);
                        semaforo.release();

                        zP2.add(zP3.getComponent(0));
                        zP3.updateUI();
                        zP2.updateUI();
                    } else {
                        break;
                    }
                } else if (revisada.getTipo() == 2) {
                    if (aux.getTipo() == 1) {
                        semaforo.acquire(1);
                        revisada.desencolar();
                        p1.encolar(aux);
                        semaforo.release();
                        zP1.add(zP2.getComponent(0));
                        zP1.updateUI();
                        zP2.updateUI();
                    } else {
                        break;
                    }
                }
            }
        } catch (Exception err) {
        }
    }

    //Saca un personaje de su cola de prioridad, si no hay elementos en una cola pasa a la siguiente. Si no hay elementos en ninguna cola pasa al protocolo de emergencia(no ha sido definido)
    public Personaje escogerPersonajes(Cola P1, Cola P2, Cola P3, Semaphore Semaforo, JPanel zP1, JPanel zP2, JPanel zP3) throws InterruptedException {
        try {
            Personaje aux = null;
            if (!P1.esVacia()) {
                aux = P1.getNodoCabeza().getDatos();
                Semaforo.acquire(1);
                P1.desencolar();
                Semaforo.release();
                zP1.remove(zP1.getComponent(0));
                zP1.updateUI();
            } else if (!P2.esVacia()) {
                aux = P2.getNodoCabeza().getDatos();
                Semaforo.acquire(1);
                P2.desencolar();
                Semaforo.release();
                zP2.remove(zP2.getComponent(0));
                zP2.updateUI();
            } else if (!P3.esVacia()) {
                aux = P3.getNodoCabeza().getDatos();
                Semaforo.acquire(1);
                P3.desencolar();
                Semaforo.release();
                zP3.remove(zP3.getComponent(0));
                zP3.updateUI();
            }
            return aux;
        } catch (Exception err) {
            return null;
        }
    }

    //Agregar personajes cada dos ciclos de revision
    public void agregarPersonaje(Personaje[] pool, Cola P1, Cola P2, Cola P3, JPanel P1UI, JPanel P2UI, JPanel P3UI, int zId, String l) throws InterruptedException, IOException {
        Random r = new Random();
        int posicion = r.nextInt(10);
        Propiedades props = new Propiedades(r.nextInt(11), r.nextInt(11),r.nextInt(11),r.nextInt(zId));
        Personaje elegido = pool[posicion];

        Personaje nuevo = new Personaje(l+Integer.toString(zId),elegido.getNombre(),props);
        nuevo.determinarTipo();
        
        if (nuevo.getTipo() == 3) {
            P3.encolar(nuevo);
            Pantalla.labelCreation(nuevo, P3UI);
        } else if (nuevo.getTipo() == 2) {
            P2.encolar(nuevo);
            Pantalla.labelCreation(nuevo, P2UI);

        } else {
            P1.encolar(nuevo);
            Pantalla.labelCreation(nuevo, P1UI);
        }

    }

    public void agregarRefuerzo(Cola p1, Cola p2, Cola p3, Cola p4, JPanel zP1, JPanel zP2, JPanel zP3, JPanel zP4) {
        if (!p4.esVacia()) {
            Random rand = new Random();
            if (rand.nextInt(101) > 60) {
                Personaje aux = p4.getNodoCabeza().getDatos();
                p4.desencolar();
                aux.setTipo(1);
                p1.encolar(aux);
                zP1.add(zP4.getComponent(0));
                zP4.updateUI();
                zP1.updateUI();
            }
        }
    }

    public void llenarColas(Personaje[] pool, Cola P1, Cola P2, Cola P3, JPanel P1UI, JPanel P2UI, JPanel P3UI) {
        for (Personaje p : pool) {
            if (p.getTipo() == 1) {
                P1.encolar(p);
                Pantalla.labelCreation(p, P1UI);
            } else if (p.getTipo() == 2) {
                P2.encolar(p);
                Pantalla.labelCreation(p, P2UI);
            } else if (p.getTipo() == 3) {
                P3.encolar(p);
                Pantalla.labelCreation(p, P3UI);
            }
        }
    }

    /**
     * @return the fighterZ
     */
    public Personaje getFighterZ() {
        return fighterSW;
    }

    /**
     * @param fighterZ the fighterZ to set
     */
    public void setFighterZ(Personaje fighterZ) {
        this.fighterSW = fighterZ;
    }

    /**
     * @return the figtherST
     */
    public Personaje getFigtherST() {
        return figtherST;
    }

    /**
     * @param figtherST the figtherST to set
     */
    public void setFigtherST(Personaje figtherST) {
        this.figtherST = figtherST;
    }

//    /**
//     * @return the zColaP1
//     */
//    public Cola getzColaP1() {
//        return zColaP1;
//    }
//
//    /**
//     * @param zColaP1 the zColaP1 to set
//     */
//    public void setzColaP1(Cola zColaP1) {
//        this.zColaP1 = zColaP1;
//    }
//
//    /**
//     * @return the zColaP2
//     */
//    public Cola getzColaP2() {
//        return zColaP2;
//    }
//
//    /**
//     * @param zColaP2 the zColaP2 to set
//     */
//    public void setzColaP2(Cola zColaP2) {
//        this.zColaP2 = zColaP2;
//    }
//
//    /**
//     * @return the zColaP3
//     */
//    public Cola getzColaP3() {
//        return zColaP3;
//    }
//
//    /**
//     * @param zColaP3 the zColaP3 to set
//     */
//    public void setzColaP3(Cola zColaP3) {
//        this.zColaP3 = zColaP3;
//    }
//
//    /**
//     * @return the zRefuerzo
//     */
//    public Cola getzRefuerzo() {
//        return zRefuerzo;
//    }
//
//    /**
//     * @param zRefuerzo the zRefuerzo to set
//     */
//    public void setzRefuerzo(Cola zRefuerzo) {
//        this.zRefuerzo = zRefuerzo;
//    }
//
//    /**
//     * @return the stColaP1
//     */
//    public Cola getStColaP1() {
//        return stColaP1;
//    }
//
//    /**
//     * @param stColaP1 the stColaP1 to set
//     */
//    public void setStColaP1(Cola stColaP1) {
//        this.stColaP1 = stColaP1;
//    }
//
//    /**
//     * @return the stColaP2
//     */
//    public Cola getStColaP2() {
//        return stColaP2;
//    }
//
//    /**
//     * @param stColaP2 the stColaP2 to set
//     */
//    public void setStColaP2(Cola stColaP2) {
//        this.stColaP2 = stColaP2;
//    }
//
//    /**
//     * @return the stColaP3
//     */
//    public Cola getStColaP3() {
//        return stColaP3;
//    }
//
//    /**
//     * @param stColaP3 the stColaP3 to set
//     */
//    public void setStColaP3(Cola stColaP3) {
//        this.stColaP3 = stColaP3;
//    }
//
//    /**
//     * @return the stRefuerzo
//     */
//    public Cola getStRefuerzo() {
//        return stRefuerzo;
//    }
//
//    /**
//     * @param stRefuerzo the stRefuerzo to set
//     */
//    public void setStRefuerzo(Cola stRefuerzo) {
//        this.stRefuerzo = stRefuerzo;
//    }
//    
    /**
     * @return the turno
     */
    public boolean isTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(boolean turno) {
        this.turno = turno;
    }

}
