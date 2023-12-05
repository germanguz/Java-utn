
package javaDisenio;

/**
 *
 * @author German
 */
public abstract class EquipoPlantilla implements java.io.Serializable{
    int resultado;
        
    //Método template
    public void metodoPrincipal() {
        
        if(this.resultado == 1) {
            sumarPuntosGanador();
        } else if(this.resultado == 2) {
            sumarPuntosEmpate();
        } else {
            Perdedor();
        }        
    }
    
    public abstract void sumarPuntosGanador();
    
    public abstract void sumarPuntosEmpate();
    
    public abstract void Perdedor();
    
}
