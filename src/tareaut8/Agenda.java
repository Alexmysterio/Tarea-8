package tareaut8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.util.Arrays;
import java.util.Collection;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Alex
 */
public class Agenda {
    
    /**
     * Cantidad maxima de citas que puede tener una agenda en un mismo dia para cualquier agenda
     */
    public static int MAX_CITAS_DIA_CUALQUIER_AGENDA = 40;
    
    /**
     * Cantidad minima de citas que debe tener una agenda en un mismo dia para cualquier agenda.
     */
    public static int MIN_CITAS_DIA_CUALQUIER_AGENDA = 5;
    
    /**
     * Cantidad maxima de citas que puede tener la agenda asignada
     */
    public static int MAX_CITAS_DIA;
    
    /**
     * Nombre de la agenda
     */
    public static String nomAgenda;
    
    public List <Cita> listaCitas = new LinkedList<Cita>();
    public Set<DayOfWeek> noHabiles = new HashSet<DayOfWeek>();
    public HashMap<String, IntervaloFechas> noLaborable;
    public IntervaloFechas intervaloFechas;
    
    public Agenda(String nombreAgenda, int maximoCitas, Set diasNoHabiles, HashMap diasNoLaborables) throws IllegalArgumentException{
        if (nombreAgenda == null){
            this.nomAgenda = "DEFAULT";
        }else{
            this.nomAgenda = nombreAgenda;
        }
        
        if (maximoCitas > MAX_CITAS_DIA_CUALQUIER_AGENDA || maximoCitas < MIN_CITAS_DIA_CUALQUIER_AGENDA){
            throw new IllegalArgumentException("El numero de citas no esta comprendido entre los valores maximo y minimo permitidos");
        }else{
            this.MAX_CITAS_DIA = maximoCitas;
        }
        
        if (diasNoHabiles != null){
            this.noHabiles = diasNoHabiles;
        }

        if(diasNoLaborables != null){
            this.noLaborable = diasNoLaborables;
        }
            
    }
    
    public static Agenda buildSampleAgenda(){
        Set<DayOfWeek> noHabiles = new HashSet<DayOfWeek>();
        noHabiles.add(DayOfWeek.SATURDAY);
        noHabiles.add(DayOfWeek.SUNDAY);
        
        HashMap<String, IntervaloFechas> noLaborable = new HashMap<String, IntervaloFechas>();
        noLaborable.put("SEMANASANTA", IntervaloFechas.of(2020,4,4,2020,4,12));
        noLaborable.put("PUENTEDIC", IntervaloFechas.of(2019,12,5,2019,12,9));
        noLaborable.put("MERECIDASVACACIONES", IntervaloFechas.of(2019,11,3,2019,12,7));
        noLaborable.put("NAVIDADES", IntervaloFechas.of(2019,12,21,2020,1,7));
        noLaborable.put("PUENTENOV", IntervaloFechas.of(2019,11,1,2019,11,4));
        
        Agenda sample = new Agenda("SAMPLE", 10, noHabiles , noLaborable);
        
        Cliente[] clientes=Persona.buildSamplePersonas();
       
        Cita c1 = new Cita(clientes[0], LocalDateTime.parse("2019-02-19T20:00:00"), "Arreglar frigorífico.");
        Cita c2 = new Cita(clientes[1], LocalDateTime.parse("2019-02-19T18:00:00"), "Arreglar caldera.");
        Cita c3 = new Cita(clientes[2], LocalDateTime.parse("2019-02-19T17:00:00"), "Arreglar lavadora.");    
        Cita c4 = new Cita(clientes[3], LocalDateTime.parse("2019-02-19T21:00:00"), "Arreglar secador.");
        
        sample.listaCitas.add(c1);
        sample.listaCitas.add(c2);
        sample.listaCitas.add(c3);    
        sample.listaCitas.add(c4);
        
        
        return sample;
    }

    @Override
    public String toString(){
        String cadena = "AGENDA: "+ Agenda.nomAgenda +"\n"
            + "Citas máximas por día: "+ Agenda.MAX_CITAS_DIA +"\n"
            + "Días no hábiles: "+ this.noHabiles +"\n"
            + "Rango de fechas no laborables:\n"
            + "..............................\n"
            + noLaborable.toString().replaceAll(",","\n").replaceAll("=", ": ");
        return cadena;
    }
    
    public boolean esDiaHabil (DayOfWeek diaSemana){
        if(noHabiles.contains(diaSemana)){
            return false;
        }else{
            return true;
        }
    }
    
    
//    public String noLaborable(LocalDate dia){
//        if(noLaborable.containsValue(dia) == true){
//            return this.noLaborable.keySet();
//        }else {
//            return ""
//        }
//    }
//
//    
//    
    
    
    public Cita buscarCitaDeCliente(int idCliente){
      return
    }
    
    
}
    

