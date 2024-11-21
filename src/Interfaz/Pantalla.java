
package Interfaz;

import Clases.SistemaOperativo;
import Clases.Cola;
import Clases.Personaje;
import Clases.Propiedades;
import Clases.Procesador;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.TOP;


public class Pantalla extends javax.swing.JFrame {

    //Desde aqui
    private static Personaje[] poolStarWars = new Personaje[20];
    private static Personaje[] poolStarTrek = new Personaje[20];

    public static void labelCreation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static int velocidadPelea;
    private static Cola SWColaP1;
    private static Cola SWColaP2;
    private static Cola SWColaP3;
    private static Cola SWRefuerzo;
    private static Cola STColaP1;
    private static Cola STColaP2;
    private static Cola STColaP3;
    private static Cola STRefuerzo;

    public static volatile Semaphore SWSemaforo;
    public static volatile Semaphore STSemaforo;

    public static Personaje SWFigther;
    public static Personaje STFigther;

    public static SistemaOperativo SO = new SistemaOperativo();
    public static Procesador IA = new Procesador();

    public static int SWWins = 0;
    public static int STWins = 0;

    public static int contador = 0;
    //hasta aqui ricardo

    /**
     * Creates new form Pantalla
     */
    public Pantalla() throws IOException {
        //Dese aqui
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        initComponents();

        //Personajes Star Wars
        Propiedades p1 = new Propiedades(4, 8, 7, 2);
        Propiedades p2 = new Propiedades(6, 7, 6, 4);
        Propiedades p3 = new Propiedades(7, 4, 7, 8);
        Propiedades p4 = new Propiedades(7, 3, 4, 8);
        Propiedades p5 = new Propiedades(5, 6, 4, 6);
        Propiedades p6 = new Propiedades(6, 4, 5, 8);
        Propiedades p7 = new Propiedades(7, 3, 6, 9);
        Propiedades p8 = new Propiedades(5, 7, 6, 4);
        Propiedades p9 = new Propiedades(6, 5, 7, 3);
        Propiedades p10 = new Propiedades(2, 6, 4, 7);
        Propiedades p11 = new Propiedades(3, 7, 8, 2);
        Propiedades p12 = new Propiedades(4, 6, 7, 5);
        Propiedades p13 = new Propiedades(8, 5, 5, 9);
        Propiedades p14 = new Propiedades(3, 10, 8, 1);
        Propiedades p15 = new Propiedades(2, 5, 7, 4);
        Propiedades p16 = new Propiedades(3, 4, 6, 10);
        Propiedades p17 = new Propiedades(4, 5, 7, 4);
        Propiedades p18 = new Propiedades(6, 6, 5, 4);
        Propiedades p19 = new Propiedades(4, 4, 7, 4);
        Propiedades p20 = new Propiedades(2, 6, 9, 2);
        
        //Personajes Star Trek
        Propiedades p21 = new Propiedades(4, 8, 7, 2);
        Propiedades p22 = new Propiedades(6, 7, 6, 4);
        Propiedades p23 = new Propiedades(7, 4, 7, 8);
        Propiedades p24 = new Propiedades(7, 3, 4, 8);
        Propiedades p25 = new Propiedades(5, 6, 4, 6);
        Propiedades p26 = new Propiedades(6, 4, 5, 8);
        Propiedades p27 = new Propiedades(7, 3, 6, 9);
        Propiedades p28 = new Propiedades(5, 7, 6, 4);
        Propiedades p29 = new Propiedades(6, 5, 7, 3);
        Propiedades p30 = new Propiedades(2, 6, 4, 7);
        Propiedades p31 = new Propiedades(3, 7, 8, 2);
        Propiedades p32 = new Propiedades(4, 6, 7, 5);
        Propiedades p33 = new Propiedades(8, 5, 5, 9);
        Propiedades p34 = new Propiedades(3, 10, 8, 1);
        Propiedades p35 = new Propiedades(2, 5, 7, 4);
        Propiedades p36 = new Propiedades(3, 4, 6, 10);
        Propiedades p37 = new Propiedades(4, 5, 7, 4);
        Propiedades p38 = new Propiedades(6, 6, 5, 4);
        Propiedades p39 = new Propiedades(4, 4, 7, 4);
        Propiedades p40 = new Propiedades(2, 6, 9, 2);

        poolStarWars[0] = new Personaje("SW1", "Luke", p1);
        poolStarWars[1] = new Personaje("SW2", "Leia", p2);
        poolStarWars[2] = new Personaje("SW3", "Han Solo", p3);
        poolStarWars[3] = new Personaje("SW4", "Darth Vader", p4);
        poolStarWars[4] = new Personaje("SW5", "Yoda", p5);
        poolStarWars[5] = new Personaje("SW6", "Obi-Wan", p6);
        poolStarWars[6] = new Personaje("SW7", "R2-D2", p7);
        poolStarWars[7] = new Personaje("SW8", "C-3PO", p8);
        poolStarWars[8] = new Personaje("SW9", "Chewbacca", p9);
        poolStarWars[9] = new Personaje("SW10", "Palpatine", p10);
        poolStarWars[10] = new Personaje("SW11", "Boba Fett", p11);
        poolStarWars[11] = new Personaje("SW12", "Lando", p12);
        poolStarWars[12] = new Personaje("SW13", "Qui-Gon", p13);
        poolStarWars[13] = new Personaje("SW14", "Ahsoka", p14);
        poolStarWars[14] = new Personaje("SW15", "Rey", p15);
        poolStarWars[15] = new Personaje("SW16", "Kylo Ren", p16);
        poolStarWars[16] = new Personaje("SW17", "Windu", p17);
        poolStarWars[17] = new Personaje("SW18", "Padme", p18);
        poolStarWars[18] = new Personaje("SW19", "Dooku", p19);
        poolStarWars[19] = new Personaje("SW20", "Jabba", p20);
        
        poolStarTrek[0] = new Personaje("ST1", "Benjamin", p21);
        poolStarTrek[1] = new Personaje("ST2", "Beverly", p22);
        poolStarTrek[2] = new Personaje("ST3", "Data", p23);
        poolStarTrek[3] = new Personaje("ST4", "Deanna", p24);
        poolStarTrek[4] = new Personaje("ST5", "Geordi", p25);
        poolStarTrek[5] = new Personaje("ST6", "Hikaru", p26);
        poolStarTrek[6] = new Personaje("ST7", "Jadzia", p27);
        poolStarTrek[7] = new Personaje("ST8", "Jean-Luc", p28);
        poolStarTrek[8] = new Personaje("ST9", "Kathryn", p29);
        poolStarTrek[9] = new Personaje("ST10", "Kira", p30);
        poolStarTrek[10] = new Personaje("ST11", "Kirk", p31);
        poolStarTrek[11] = new Personaje("ST12", "Leonard", p32);
        poolStarTrek[12] = new Personaje("ST13", "Montgomery", p33);
        poolStarTrek[13] = new Personaje("ST14", "Nyota", p34);
        poolStarTrek[14] = new Personaje("ST15", "Pavel", p35);
        poolStarTrek[15] = new Personaje("ST16", "Quark", p36);
        poolStarTrek[16] = new Personaje("ST17", "Seven of Nine", p37);
        poolStarTrek[17] = new Personaje("ST18", "Spock", p38);
        poolStarTrek[18] = new Personaje("ST19", "William", p39);
        poolStarTrek[19] = new Personaje("ST20", "Worf", p40);
        
        for (int i = 0; i < 20; i++) {
            poolStarWars[i].determinarTipo();
            poolStarTrek[i].determinarTipo();
        }

        SWColaP1 = new Cola(1);
        SWColaP2 = new Cola(2);
        SWColaP3 = new Cola(3);
        SWRefuerzo = new Cola(4);
        STColaP1 = new Cola(1);
        STColaP2 = new Cola(2);
        STColaP3 = new Cola(3);
        STRefuerzo = new Cola(4);
        SWSemaforo = new Semaphore(1);
        STSemaforo = new Semaphore(1);

        this.llenarColas();
        this.SO.setTurno(true);
        SO.start();
        IA.start();
        //Hasta aqui
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        STFigtherLabel = new javax.swing.JLabel();
        SWFighterLabel = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        STPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        STPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        STPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        STPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        SWPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SWPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        SWPanel2 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        ganadores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SWPanelP1 = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        bar1 = new javax.swing.JProgressBar();
        bar2 = new javax.swing.JProgressBar();
        velocidad = new javax.swing.JSlider();
        resultado = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        logBatalla = new javax.swing.JTextArea();
        estadoIA = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SWInfo2 = new javax.swing.JLabel();
        SWInfo3 = new javax.swing.JLabel();
        SWInfo4 = new javax.swing.JLabel();
        STInfo1 = new javax.swing.JLabel();
        STInfo2 = new javax.swing.JLabel();
        STInfo3 = new javax.swing.JLabel();
        STInfo4 = new javax.swing.JLabel();
        SWInfo1 = new javax.swing.JLabel();
        contVictoriasSW = new javax.swing.JLabel();
        contVictoriasST = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        STInfo5 = new javax.swing.JLabel();
        SWInfo5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        STFigtherLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        STFigtherLabel.setText("STAR TREK FIGHTER");
        STFigtherLabel.setToolTipText("");
        STFigtherLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        STFigtherLabel.setFocusable(false);
        STFigtherLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        STFigtherLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel1.add(STFigtherLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 180, 160));

        SWFighterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SWFighterLabel.setText("STAR WARS FIGHTER");
        SWFighterLabel.setToolTipText("");
        SWFighterLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        SWFighterLabel.setFocusable(false);
        SWFighterLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SWFighterLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel1.add(SWFighterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 180, 160));

        STPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane8.setViewportView(STPanel4);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 540, 290, 110));

        STPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane6.setViewportView(STPanel2);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 200, 290, 110));

        STPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane7.setViewportView(STPanel3);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 370, 290, 110));

        STPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane5.setViewportView(STPanel1);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 290, 110));

        SWPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(SWPanel4);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, 290, 100));

        SWPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(SWPanel3);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 290, 110));

        SWPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(SWPanel2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 290, 110));

        ganadores.setBackground(new java.awt.Color(0, 0, 0));
        ganadores.setForeground(new java.awt.Color(255, 255, 255));
        ganadores.setLayout(new java.awt.GridLayout(1, 0, 5, 0));
        jScrollPane9.setViewportView(ganadores);

        jPanel1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 500, 100));

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setVerifyInputWhenFocusTarget(false);

        SWPanelP1.setBackground(new java.awt.Color(0, 0, 0));
        SWPanelP1.setForeground(new java.awt.Color(0, 0, 0));
        SWPanelP1.setAutoscrolls(true);
        SWPanelP1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SWPanelP1.setLayout(new java.awt.GridLayout(1, 0, 5, 0));
        jScrollPane1.setViewportView(SWPanelP1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 290, 100));

        label1.setBackground(new java.awt.Color(231, 225, 211));
        label1.setFont(new java.awt.Font("Impact", 2, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(231, 225, 211));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label1.setText("Fuerza");
        label1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 540, 60, 30));

        label2.setBackground(new java.awt.Color(231, 225, 211));
        label2.setFont(new java.awt.Font("Impact", 2, 14)); // NOI18N
        label2.setForeground(new java.awt.Color(231, 225, 211));
        label2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label2.setText("Habilidad");
        label2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 570, 100, 30));

        label3.setBackground(new java.awt.Color(231, 225, 211));
        label3.setFont(new java.awt.Font("Impact", 2, 14)); // NOI18N
        label3.setForeground(new java.awt.Color(231, 225, 211));
        label3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label3.setText("Agilidad");
        label3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 600, 80, 30));

        label4.setBackground(new java.awt.Color(231, 225, 211));
        label4.setFont(new java.awt.Font("Impact", 2, 14)); // NOI18N
        label4.setForeground(new java.awt.Color(231, 225, 211));
        label4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label4.setText("Vida");
        label4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, 40, 30));

        label5.setBackground(new java.awt.Color(231, 225, 211));
        label5.setFont(new java.awt.Font("Impact", 2, 14)); // NOI18N
        label5.setForeground(new java.awt.Color(231, 225, 211));
        label5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label5.setText("Vida");
        label5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, 40, 30));

        label6.setBackground(new java.awt.Color(231, 225, 211));
        label6.setFont(new java.awt.Font("Impact", 2, 14)); // NOI18N
        label6.setForeground(new java.awt.Color(231, 225, 211));
        label6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label6.setText("Fuerza");
        label6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 540, 50, 30));

        label7.setBackground(new java.awt.Color(231, 225, 211));
        label7.setFont(new java.awt.Font("Impact", 2, 14)); // NOI18N
        label7.setForeground(new java.awt.Color(231, 225, 211));
        label7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label7.setText("Habilidad");
        label7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 570, 70, 30));

        label8.setBackground(new java.awt.Color(231, 225, 211));
        label8.setFont(new java.awt.Font("Impact", 2, 14)); // NOI18N
        label8.setForeground(new java.awt.Color(231, 225, 211));
        label8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label8.setText("Agilidad");
        label8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 600, 60, 30));

        bar1.setForeground(new java.awt.Color(51, 255, 0));
        bar1.setValue(50);
        jPanel1.add(bar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, 30));

        bar2.setForeground(new java.awt.Color(204, 102, 0));
        bar2.setValue(50);
        jPanel1.add(bar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, -1, 30));

        velocidad.setMajorTickSpacing(1000);
        velocidad.setMinimum(1);
        velocidad.setMinorTickSpacing(10);
        velocidad.setPaintTicks(true);
        velocidad.setOpaque(false);
        velocidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                velocidadStateChanged(evt);
            }
        });
        jPanel1.add(velocidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 750, 450, 50));

        resultado.setForeground(new java.awt.Color(231, 225, 211));
        resultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultado.setAutoscrolls(true);
        jPanel1.add(resultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, 180, 110));

        logBatalla.setColumns(20);
        logBatalla.setLineWrap(true);
        logBatalla.setRows(5);
        jScrollPane10.setViewportView(logBatalla);

        jPanel1.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 240, 110));

        estadoIA.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        estadoIA.setForeground(new java.awt.Color(231, 225, 211));
        estadoIA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estadoIA.setText("Estado");
        jPanel1.add(estadoIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 160, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("x2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 790, 30, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("x0.01");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 790, 50, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("x1");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 790, 40, -1));

        SWInfo2.setBackground(new java.awt.Color(231, 225, 211));
        SWInfo2.setFont(new java.awt.Font("Impact", 2, 24)); // NOI18N
        SWInfo2.setForeground(new java.awt.Color(231, 225, 211));
        SWInfo2.setText("0");
        jPanel1.add(SWInfo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 540, 60, 30));

        SWInfo3.setBackground(new java.awt.Color(231, 225, 211));
        SWInfo3.setFont(new java.awt.Font("Impact", 2, 24)); // NOI18N
        SWInfo3.setForeground(new java.awt.Color(231, 225, 211));
        SWInfo3.setText("0");
        jPanel1.add(SWInfo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 570, 60, 30));

        SWInfo4.setBackground(new java.awt.Color(231, 225, 211));
        SWInfo4.setFont(new java.awt.Font("Impact", 2, 24)); // NOI18N
        SWInfo4.setForeground(new java.awt.Color(231, 225, 211));
        SWInfo4.setText("0");
        jPanel1.add(SWInfo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 600, 60, 30));

        STInfo1.setBackground(new java.awt.Color(231, 225, 211));
        STInfo1.setFont(new java.awt.Font("Impact", 2, 24)); // NOI18N
        STInfo1.setForeground(new java.awt.Color(231, 225, 211));
        STInfo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        STInfo1.setText("0");
        jPanel1.add(STInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, 40, 30));

        STInfo2.setBackground(new java.awt.Color(231, 225, 211));
        STInfo2.setFont(new java.awt.Font("Impact", 2, 24)); // NOI18N
        STInfo2.setForeground(new java.awt.Color(231, 225, 211));
        STInfo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        STInfo2.setText("0");
        jPanel1.add(STInfo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 540, 40, 30));

        STInfo3.setBackground(new java.awt.Color(231, 225, 211));
        STInfo3.setFont(new java.awt.Font("Impact", 2, 24)); // NOI18N
        STInfo3.setForeground(new java.awt.Color(231, 225, 211));
        STInfo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        STInfo3.setText("0");
        jPanel1.add(STInfo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 570, 40, 30));

        STInfo4.setBackground(new java.awt.Color(231, 225, 211));
        STInfo4.setFont(new java.awt.Font("Impact", 2, 24)); // NOI18N
        STInfo4.setForeground(new java.awt.Color(231, 225, 211));
        STInfo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        STInfo4.setText("0");
        jPanel1.add(STInfo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 600, 40, 30));

        SWInfo1.setBackground(new java.awt.Color(231, 225, 211));
        SWInfo1.setFont(new java.awt.Font("Impact", 2, 24)); // NOI18N
        SWInfo1.setForeground(new java.awt.Color(231, 225, 211));
        SWInfo1.setText("0");
        jPanel1.add(SWInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 510, 50, 30));

        contVictoriasSW.setBackground(new java.awt.Color(255, 255, 255));
        contVictoriasSW.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        contVictoriasSW.setForeground(new java.awt.Color(255, 255, 255));
        contVictoriasSW.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contVictoriasSW.setText("0");
        jPanel1.add(contVictoriasSW, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 660, 70, 40));

        contVictoriasST.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        contVictoriasST.setForeground(new java.awt.Color(0, 0, 0));
        contVictoriasST.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contVictoriasST.setText("0");
        jPanel1.add(contVictoriasST, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 660, 70, 40));

        jLabel7.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("victorias");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 700, 70, -1));

        jLabel8.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("victorias");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 700, 70, -1));

        STInfo5.setFont(new java.awt.Font("Impact", 2, 24)); // NOI18N
        STInfo5.setForeground(new java.awt.Color(231, 225, 211));
        STInfo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(STInfo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 460, 160, -1));

        SWInfo5.setFont(new java.awt.Font("Impact", 2, 24)); // NOI18N
        SWInfo5.setForeground(new java.awt.Color(231, 225, 211));
        SWInfo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(SWInfo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 160, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pantalla_fondo - Copy.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 860));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 860));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void velocidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_velocidadStateChanged
        
    }//GEN-LAST:event_velocidadStateChanged
    //LLena las colas al inicio de la simulacion
    public void llenarColas() {

        for (Personaje x : poolStarWars) {
            if (x.getTipo() == 1) {
                SWColaP1.encolar(x);
                this.labelCreation(x, SWPanelP1);
            } else if (x.getTipo() == 2) {
                SWColaP2.encolar(x);
                this.labelCreation(x, SWPanel2);
            } else if (x.getTipo() == 3) {
                SWColaP3.encolar(x);
                this.labelCreation(x, SWPanel3);
            }
        }
        for (Personaje x : poolStarTrek) {
            if (x.getTipo() == 1) {
                STColaP1.encolar(x);
                this.labelCreation(x, STPanel1);
            } else if (x.getTipo() == 2) {
                STColaP2.encolar(x);
                this.labelCreation(x, STPanel2);
            } else if (x.getTipo() == 3) {
                STColaP3.encolar(x);
                this.labelCreation(x, STPanel3);
            }
        }
    }

    //Crea las labels que van a irse agregando a las colas que se muestran en interfaz
    public static void labelCreation(Personaje personaje, JPanel p) {
        String texto = personaje.getId();
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setSize(60, 60);
        etiqueta.setForeground(Color.white);
        etiqueta.setVerticalTextPosition(1);
        etiqueta.setVerticalAlignment(TOP);
        etiqueta.setHorizontalTextPosition(CENTER);
        etiqueta.setIconTextGap(3);
        etiqueta.setVerticalTextPosition(TOP);
        ImageIcon fot = new ImageIcon(personaje.getRutaIcon());
        ImageIcon icon = new ImageIcon(fot.getImage().getScaledInstance(etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_DEFAULT));

        etiqueta.setIcon(icon);
        etiqueta.repaint();

        p.add(etiqueta);
        p.updateUI();
    }

    //Monta los personajes en Las variables peleador 
    public static void pelea(Personaje p, JLabel l, JLabel info1, JLabel info2, JLabel info3, JLabel info4, JLabel info5) {

        ImageIcon fot = new ImageIcon(p.getRutaImagen());
        ImageIcon icon = new ImageIcon(fot.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
        l.setText(p.getNombre());
        l.setIcon(icon);
        l.repaint();
        
        int vida=p.getPropiedades().getPuntosVida();
        if(vida<0){
            vida=vida*-1;
        }
        info1.setText(Integer.toString(vida));
        info2.setText(Integer.toString(p.getPropiedades().getFuerza()));
        info3.setText(Integer.toString(p.getPropiedades().getHabilidades()));
        info4.setText(Integer.toString(p.getPropiedades().getAgilidad()));
        info5.setText(p.getNombre());
    }

    /**
     * @return the poolZelda
     */
    public static Personaje[] getPoolStarWars() {
        return poolStarWars;

    }

    /**
     * @param poolZelda the poolZelda to set
     */
    public void setPoolStarWars(Personaje[] poolZelda) {
        this.poolStarWars = poolZelda;
    }

    /**
     * @return the poolStreet
     */
    public static Personaje[] getPoolStarTrek() {
        return poolStarTrek;
    }

    /**
     * @param poolStreet the poolStreet to set
     */
    public void setPoolStarTrek(Personaje[] poolStreet) {
        this.poolStarTrek = poolStreet;
    }

    /**
     * @return the zColaP1
     */
    public static Cola getzColaP1() {
        return SWColaP1;
    }

    /**
     * @param azColaP1 the zColaP1 to set
     */
    public static void setzColaP1(Cola azColaP1) {
        SWColaP1 = azColaP1;
    }

    /**
     * @return the zColaP2
     */
    public static Cola getzColaP2() {
        return SWColaP2;
    }

    /**
     * @param azColaP2 the zColaP2 to set
     */
    public static void setzColaP2(Cola azColaP2) {
        SWColaP2 = azColaP2;
    }

    /**
     * @return the zColaP3
     */
    public static Cola getzColaP3() {
        return SWColaP3;
    }

    /**
     * @param azColaP3 the zColaP3 to set
     */
    public static void setzColaP3(Cola azColaP3) {
        SWColaP3 = azColaP3;
    }

    /**
     * @return the zRefuerzo
     */
    public static Cola getzRefuerzo() {
        return SWRefuerzo;
    }

    /**
     * @param azRefuerzo the zRefuerzo to set
     */
    public static void setzRefuerzo(Cola azRefuerzo) {
        SWRefuerzo = azRefuerzo;
    }

    /**
     * @return the stColaP1
     */
    public static Cola getStColaP1() {
        return STColaP1;
    }

    /**
     * @param aStColaP1 the stColaP1 to set
     */
    public static void setStColaP1(Cola aStColaP1) {
        STColaP1 = aStColaP1;
    }

    /**
     * @return the stColaP2
     */
    public static Cola getStColaP2() {
        return STColaP2;
    }

    /**
     * @param aStColaP2 the stColaP2 to set
     */
    public static void setStColaP2(Cola aStColaP2) {
        STColaP2 = aStColaP2;
    }

    /**
     * @return the stColaP3
     */
    public static Cola getStColaP3() {
        return STColaP3;
    }

    /**
     * @param aStColaP3 the stColaP3 to set
     */
    public static void setSTColaP3(Cola aStColaP3) {
        STColaP3 = aStColaP3;
    }

    /**
     * @return the stRefuerzo
     */
    public static Cola getStRefuerzo() {
        return STRefuerzo;
    }

    /**
     * @param aStRefuerzo the stRefuerzo to set
     */
    public static void setStRefuerzo(Cola aStRefuerzo) {
        STRefuerzo = aStRefuerzo;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Pantalla().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel STFigtherLabel;
    public static javax.swing.JLabel STInfo1;
    public static javax.swing.JLabel STInfo2;
    public static javax.swing.JLabel STInfo3;
    public static javax.swing.JLabel STInfo4;
    public static javax.swing.JLabel STInfo5;
    public static javax.swing.JPanel STPanel1;
    public static javax.swing.JPanel STPanel2;
    public static javax.swing.JPanel STPanel3;
    public static javax.swing.JPanel STPanel4;
    public static javax.swing.JLabel SWFighterLabel;
    public static javax.swing.JLabel SWInfo1;
    public static javax.swing.JLabel SWInfo2;
    public static javax.swing.JLabel SWInfo3;
    public static javax.swing.JLabel SWInfo4;
    public static javax.swing.JLabel SWInfo5;
    public static javax.swing.JPanel SWPanel2;
    public static javax.swing.JPanel SWPanel3;
    public static javax.swing.JPanel SWPanel4;
    public static javax.swing.JPanel SWPanelP1;
    public static javax.swing.JProgressBar bar1;
    public static javax.swing.JProgressBar bar2;
    public static javax.swing.JLabel contVictoriasST;
    public static javax.swing.JLabel contVictoriasSW;
    public static javax.swing.JLabel estadoIA;
    public static javax.swing.JPanel ganadores;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    public static javax.swing.JTextArea logBatalla;
    public static javax.swing.JLabel resultado;
    public static javax.swing.JSlider velocidad;
    // End of variables declaration//GEN-END:variables
}
