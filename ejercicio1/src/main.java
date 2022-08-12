import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.lang.*;
import java.util.Optional;
import java.util.Scanner;


public class main
{
    public static void main(String[] args) throws FileNotFoundException
    {

        filtrar(OpenFile());

    }


    public static List<Persona> OpenFile() throws FileNotFoundException
    {
        List<Persona> peopleList = new ArrayList<Persona>();
        List<String> people = new ArrayList<String>();

        File f = new File("ejercicio1/fichero.txt");
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine())
        {
            String s = sc.nextLine();
            String[] person= s.split(":");
            Persona p = new Persona();
            p.setNombre(person[0]);
            p.setCiudad(person[1]);
            p.setEdad(person.length>2?Integer.parseInt(person[2]):0);
            peopleList.add(p);
        }
        sc.close();
        return peopleList;
    }

    public static void mostrarPersonas(List<Persona> peopleList)
    {
        for (Persona p : peopleList)
        {
            p.Mostrar();
        }
    }

    public static void filtrar( List<Persona> lista)
    {
        lista.stream().filter(p -> p.getEdad()<25).filter(p->p.getEdad()>0).forEach(p -> p.Mostrar());
    }
}
