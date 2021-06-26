package daniel.solid;

import daniel.solid.armas.SableFactoryPorDefecto;
import daniel.solid.juego.ControladorJuego;
import daniel.solid.juego.JediFactory;
import daniel.solid.personajes.JediFactoryPorDefecto;

public class App {

 public static void main(String[] arg){
     JediFactory jediFactory = new JediFactoryPorDefecto();
     jediFactory.setSableFactory(new SableFactoryPorDefecto());
     ControladorJuego juego = new ControladorJuego(jediFactory);
     juego.iniciar();
 }

}