package tareaut8;

import java.time.LocalDate;
import tareaut8.Agenda;
import tareaut8.Cliente;
import tareaut8.Persona;
import tareaut8.Cita;


public class main {
    public static void main(String[] args) {
        Agenda a=Agenda.buildSampleAgenda();
        Cliente[] clientes={new Persona(8888, "ALEXA"),new Persona(8889, "ROBERT")};
        
     //System.out.println(a.listaCitas.get(1));
     //System.out.println(clientes[1]);
        
        System.out.println(a.noLaborable(1));
    }
  

}
