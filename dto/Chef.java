package dto;

import java.util.concurrent.Callable;

public class Chef {

    String nombre;
    Despensa despensa;
    int estrellasMichelin;

    public Chef() {}

    public Chef(String nombre, Despensa despensa, int estrellasMichelin) {
        this.nombre = nombre;
        this.despensa = despensa;
        this.estrellasMichelin = estrellasMichelin;
    }

    @Override
    public String toString() {
        return "Chef{" +
                "nombre='" + nombre + '\'' +
                ", despensa=" + despensa +
                ", estrellasMichelin=" + estrellasMichelin +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Despensa getDespensa() {
        return despensa;
    }

    public void setDespensa(Despensa despensa) {
        this.despensa = despensa;
    }

    public int getEstrellasMichelin() {
        return estrellasMichelin;
    }

    public void setEstrellasMichelin(int estrellasMichelin) {
        this.estrellasMichelin = estrellasMichelin;
    }

    public void cocinar (Cocinable cocinable) throws Exception{
            if (cocinable.sePuedeCocinar(despensa)){
                System.out.println("Cocinando ".concat(cocinable.getClass().getName()));
                wait(cocinable.getTiempoCoccion());
            }else{
                throw new Exception("No se puede cocinar ".concat(cocinable.getClass().getName()));
            }
    }


}
