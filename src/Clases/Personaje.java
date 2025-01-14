
package Clases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;


public class Personaje {
    
    private String id;
    private String nombre;
    private BufferedImage imagen;
    private BufferedImage icono;
    private String rutaIcon;
    private String rutaImagen;
    private int tipo; // tipo puede ser excepcional (1), promedio (2) o deficiente (3)
    private Propiedades propiedades;
    private int contador;
    
    public Personaje(String id, String nombre, Propiedades propiedades) throws IOException {
        this.id = id;
        this.nombre = nombre;

        String rutaImagen = "src\\Imagenes\\" + nombre + ".png";
        this.imagen = ImageIO.read(new File(rutaImagen));
        String rutaIcono = "src\\Imagenes\\" + nombre + "2.png";
        this.rutaIcon=rutaIcono;
        this.rutaImagen=rutaImagen;
        this.imagen = ImageIO.read(new File(rutaIcono));

        this.propiedades = propiedades;
        this.contador = 0;
    }

    public void aumentarPrioridad() {
        if (this.getContador() == 8) {
            if (this.getTipo() != 1) { // tipo es lo mismo que prioridad
                this.setContador(0);
                this.setTipo(this.getTipo() - 1);
            }
        }
    }
    
    public void determinarTipo() {
        int contadorCalidad = 0;
        
        Propiedades props = this.getPropiedades();
        
        // Se determina la calidad de manera aleatoria
        Random random = new Random();
        
        int randHabilidades = random.nextInt(101);
        int randVida = random.nextInt(101);
        int randFuerza = random.nextInt(101);
        int randAgilidad = random.nextInt(101);
        
        props.setHabilidades(randHabilidades);
        props.setAgilidad(randAgilidad);
        props.setFuerza(randFuerza);
        props.setPuntosVida(randVida);
        
        if (randHabilidades > 40) {
            // Si se selecciona que es de calidad, se deja el valor
            contadorCalidad++;
        } else {
            
        }
        if (randVida > 30) {
            contadorCalidad++;
        } else {
            
        }
        if (randFuerza > 50) {
            contadorCalidad++;
        } else {
            
        }
        if (randAgilidad > 60) {
            contadorCalidad++;
        } else {
            
        }
        if (contadorCalidad >= 3) {
            this.setTipo(1);
        } else if (contadorCalidad == 2){
            this.setTipo(2);
        } else {
            this.setTipo(3);
        }
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the imagen
     */
    public BufferedImage getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the propiedades
     */
    public Propiedades getPropiedades() {
        return propiedades;
    }

    /**
     * @param propiedades the propiedades to set
     */
    public void setPropiedades(Propiedades propiedades) {
        this.propiedades = propiedades;
    }

    /**
     * @return the contador
     */
    public int getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public void setContador(int contador) {
        this.contador = contador;
    }

    /**
     * @return the icono
     */
    public BufferedImage getIcono() {
        return icono;
    }

    /**
     * @param icono the icono to set
     */
    public void setIcono(BufferedImage icono) {
        this.icono = icono;
    }

    /**
     * @return the rutaIcon
     */
    public String getRutaIcon() {
        return rutaIcon;
    }

    /**
     * @param rutaIcon the rutaIcon to set
     */
    public void setRutaIcon(String rutaIcon) {
        this.rutaIcon = rutaIcon;
    }

    /**
     * @return the rutaImagen
     */
    public String getRutaImagen() {
        return rutaImagen;
    }

    /**
     * @param rutaImagen the rutaImagen to set
     */
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    

    
   
}
