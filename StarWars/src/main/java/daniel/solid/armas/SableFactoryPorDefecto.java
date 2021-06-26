package daniel.solid.armas;

import daniel.solid.juego.Sable;
import daniel.solid.juego.SableFacotry;

public class SableFactoryPorDefecto implements SableFacotry {
    private static final String TIPO_SABLE_DIAMANTE = "DIAMANTE";
    public Sable crearSable(){
        if(TIPO_SABLE_DIAMANTE.equalsIgnoreCase(System.getProperty("SABLE", "")))
            return new SableDiamante();
        return new SablePorDefecto();
    }
}
