package daniel.solid.juego;

import java.util.Arrays;

public enum OpcionesMenu {

    INDEFINIDA (- 1,"Indefinida"),
    TERMINAR_JUEGO (0,"Terminar Juego"),
    ENCENDER_SABLE (1,"Encender sable"),
    APAGAR_SABLE (2,"Apagar sable");

    private int id;
    private String descripcion;

    OpcionesMenu(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    public String getInformacion(){
        return id + " " + descripcion;
    }

   public static void imprimirOpcionesMenuExceptoIndefinida (ControladorConsola consola) {
        consola.imprimirConSaltoLinea("----- Opciones -----");
        Arrays.stream(values()).filter(o -> o != INDEFINIDA)
                .forEach(opcion -> consola.imprimirConSaltoLinea(opcion.getInformacion()));
        consola.imprimirConSaltoLinea("----------------");
    }


}
