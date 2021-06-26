package daniel.solid.juego;

import static daniel.solid.juego.OpcionesMenu.imprimirOpcionesMenuExceptoIndefinida;

public class ControladorJuego {

    private boolean iniciado;
    private final Jedi jedi;
    private final ControladorConsola consola;
    private final JediFactory jediFactory;

    public ControladorJuego(JediFactory jediFactory){
        this.jediFactory = jediFactory;
       consola = new ControladorConsola();
       jedi = this.jediFactory.crearJedi();
    }

    public void iniciar(){
        iniciado = true;
        ejecutar();
    }

    public void ejecutar() {

        int opcion;
        consola.limpiar();
        imprimirOpcionesMenuExceptoIndefinida(consola);
        do {
            opcion = consola.getEntrada();
            consola.limpiar();
            imprimirOpcionesMenuExceptoIndefinida(consola);
            if (opcion == 0)
                finalizar();
            jedi.render(opcion);
        } while (iniciado);
    }

    public void finalizar(){

        iniciado = false;

    }

}
