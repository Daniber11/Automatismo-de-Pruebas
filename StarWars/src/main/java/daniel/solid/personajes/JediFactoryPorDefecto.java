package daniel.solid.personajes;

import daniel.solid.juego.Jedi;
import daniel.solid.juego.JediFactory;
import daniel.solid.juego.Sable;
import daniel.solid.juego.SableFacotry;


public class JediFactoryPorDefecto implements JediFactory {

    private static final String TIPO_JEDI_YODA = "YODA";
    private SableFacotry sableFacotry;

    @Override
    public void setSableFactory(SableFacotry sableFactory) {
        this.sableFacotry = sableFactory;
    }

    public Jedi crearJedi() {
        validarSableFactory();
        Sable sable = sableFacotry.crearSable();
        if (TIPO_JEDI_YODA.equalsIgnoreCase(System.getProperty("JEDI", "")))
            return new JediYoda(sable);
        return new JediPorDefecto(sable);
    }

    private void validarSableFactory() {
        if (sableFacotry == null)
            throw new IllegalStateException("No existe un sable factory");
    }
}

