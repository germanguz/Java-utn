
package javaDisenio;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author German
 */
public class Riber extends EquipoPlantilla implements java.io.Serializable{
    public Riber(){}
    
    public Riber(int resultado){
        this.resultado = resultado;
    }
    
    @Override
    public void sumarPuntosGanador() {
        try {
            System.out.println("Riber ganó y suma 3 puntos (ayuda arbitral)");
            Session s = connection.Controller.getSessionFactory().openSession();
            Transaction tr = s.beginTransaction();
            pojos.Equipo stu = (pojos.Equipo) s.load(pojos.Equipo.class, "River Plate");
            stu.setPuntos(stu.getPuntos() + 3);
            stu.setPartidosJugados(stu.getPartidosJugados() + 1);
            s.update(stu);
            tr.commit();
            s.close();
            tr = null;
            System.out.println("Actualización exitosa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sumarPuntosEmpate() {
        
        try {
            System.out.println("Riber ganó y suma 1 punto");
            Session s = connection.Controller.getSessionFactory().openSession();
            Transaction tr = s.beginTransaction();
            pojos.Equipo stu = (pojos.Equipo) s.load(pojos.Equipo.class, "River Plate");
            stu.setPuntos(stu.getPuntos() + 1);
            stu.setPartidosJugados(stu.getPartidosJugados() + 1);
            s.update(stu);
            tr.commit();
            s.close();
            tr = null;
            System.out.println("Actualización exitosa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Perdedor() {
        try {
            System.out.println("Riber perdió!!! y no suma puntos");
            Session s = connection.Controller.getSessionFactory().openSession();
            Transaction tr = s.beginTransaction();
            pojos.Equipo stu = (pojos.Equipo) s.load(pojos.Equipo.class, "River Plate");
            stu.setPartidosJugados(stu.getPartidosJugados() + 1);
            s.update(stu);
            tr.commit();
            s.close();
            tr = null;
            System.out.println("Actualización exitosa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
