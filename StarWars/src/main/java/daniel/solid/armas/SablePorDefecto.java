package daniel.solid.armas;

import daniel.solid.juego.ControladorConsola;
import daniel.solid.juego.Sable;

public class SablePorDefecto implements Sable {

    private final ControladorConsola consola;

    public SablePorDefecto() {
        this.consola = new ControladorConsola();
    }

    public void render(int accion){
       consola.imprimirConSaltoLinea(accion == 1 ? "|====" : "");

    }

}
