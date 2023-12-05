/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javautn;

import java.util.List;
import java.util.Scanner;
import javaDisenio.Boca;
import javaDisenio.EquipoPlantilla;
import javaDisenio.Riber;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author German
 */
public class JavaUtn {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            menu();
            System.out.print("Elegir opción de acuerdo al número: ");
            opcion = sc.nextInt();
            ejecutarEleccion(opcion);
        } while (opcion != 0);
    }

    public static void menu() {
        System.out.println("------ Menú ------");
        System.out.println("1: Listado de equipos");
        System.out.println("2: Agregar Equipo");
        System.out.println("3: Borrar Equipo");
        System.out.println("4: Cargar resultados");
        System.out.println("0: Salir");
        System.out.println("------------------");
    }

    public static void ejecutarEleccion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Listado de equipos:");
                listarEquipos();
                break;
            case 2:
                System.out.println("Agregar equipo");
                agregarEquipo();
                break;
            case 3:
                System.out.println("Eliminar equipo");
                eliminarEquipo();
                break;
            case 4:
                System.out.println("Esta opción es solo para -Boca- o -Riber-");
                cargarResultados();
                break;
            case 0:
                System.out.println("Fin del programa");
                System.out.println("Si no finaliza cerrar desde el 'stop' de la ejecución :)");
                break;
            default:
                System.out.println("Opción incorrecta. Reintente otra vez");
                break;
        }
    }

    public static void listarEquipos() {
        Session s = connection.Controller.getSessionFactory().openSession();
        Criteria c = s.createCriteria(pojos.Equipo.class);
        List<pojos.Equipo> emp = c.list();
        for (pojos.Equipo em : emp) {
            System.out.println("Nombre: " + em.getNombre() + " - Titulares: " + em.getTitulares() + " - Suplentes: " + em.getSuplentes()
                    + " - Director técnico: " + em.getDirectorTecnico() + " - Puntos: " + em.getPuntos() + " - Partidos jugados: " + em.getPartidosJugados());
        }
        System.out.println("Listado completo");
    }

    public static void agregarEquipo() {
        Scanner sc = new Scanner(System.in);
        try {
            Session s = connection.Controller.getSessionFactory().openSession();
            Transaction tr = s.beginTransaction();
            pojos.Equipo eq1 = new pojos.Equipo();
            System.out.println("Rellene los datos necesarios");
            System.out.println("Nombre equipo: ");
            eq1.setNombre(sc.next());
            System.out.println("Cantidad de titulares: ");
            eq1.setTitulares(sc.nextInt());
            System.out.println("Cantidad de suplentes: ");
            eq1.setSuplentes(sc.nextInt());
            System.out.println("Nombre entrenador: ");
            eq1.setDirectorTecnico(sc.next());
            eq1.setPuntos(0);
            eq1.setPartidosJugados(0);
            s.save(eq1);
            tr.commit();
            s.close();
            tr = null;
            System.out.println("Inicia sin puntos ni partidos jugados");
            System.out.println("Grabado exitoso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void eliminarEquipo() {
        Scanner sc = new Scanner(System.in);
        try {
            Session s = connection.Controller.getSessionFactory().openSession();
            Criteria c = s.createCriteria(pojos.Equipo.class);
            List<pojos.Equipo> emp = c.list();
            System.out.println("Escriba el nombre del equipo tal cual figura en el siguiente listado");
            for (pojos.Equipo em : emp) {
                System.out.println("Nombre: " + em.getNombre());
            }
            System.out.println("Escriba el nombre: ");
            Transaction tr = s.beginTransaction();
            pojos.Equipo stu = (pojos.Equipo) s.load(pojos.Equipo.class, sc.next());
            s.delete(stu);
            tr.commit();
            s.close();
            tr = null;
            System.out.println("Borrado exitoso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cargarResultados() {
        Scanner sc = new Scanner(System.in);
        EquipoPlantilla equipo = null;
        int opcion;
        try {
            System.out.println("Elija solamente Boca o Riber (escrito tal cual)");
            String equipoElegido = sc.next();
            System.out.println("Elija 1 si ganó, 2 si empató o 0 si perdió");
            opcion = sc.nextInt();

            if (equipoElegido.equals("Boca")) {
                equipo = new Boca(opcion);

            } else if (equipoElegido.equals("Riber")){
                equipo = new Riber(opcion);
            }

            equipo.metodoPrincipal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
