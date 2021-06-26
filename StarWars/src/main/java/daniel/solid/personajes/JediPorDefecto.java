package daniel.solid.personajes;

import daniel.solid.juego.ControladorConsola;
import daniel.solid.juego.Jedi;
import daniel.solid.juego.Sable;

public class JediPorDefecto implements Jedi {

    private final ControladorConsola consola;

    private final Sable sable;

    public JediPorDefecto(Sable sable) {
        this.consola = new ControladorConsola();
        this.sable = sable;
    }

    public  void render(int accion ){
        if(accion < 0 || accion > 2){
            preguntar();
        }
        if(accion == 0)
            despedirse();
        consola.imprimirConSaltoLinea(" [] ");
        consola.imprimirConSaltoLinea("----");
        usarSable(accion);
        consola.imprimirConSaltoLinea(" /\\");
    }

    public  void  preguntar(){
        consola.imprimirConSaltoLinea("  ? ");
    }

    public  void despedirse(){
        consola.imprimirConSaltoLinea("Que la fuerza te acompa\u00f1e");
    }

    public void usarSable(int accion){
        sable.render(accion);
    }
}
