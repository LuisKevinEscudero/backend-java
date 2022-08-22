package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws InvalidLineFormatException {
        List<Person> peopleList = new ArrayList<Person>();
        String fileName= args[0];

        //String fileName= "ej1.1-process-file-and-streams/src/main/java/people.csv";
        Path path = Paths.get(fileName);

        try
        {
            peopleList = readFile(path);

            modificarDatos(peopleList);
            System.out.println("############ FLITRO A ############");
            flitroA(peopleList);
            System.out.println("############ FLITRO B ############");
            filtroB(peopleList);
            System.out.println("############ FLITRO C ############");
            filtroC(peopleList);
            System.out.println("############ FLITRO D ############");
            filtroD(peopleList);

        } catch (InvalidLineFormatException e) {
            throw new InvalidLineFormatException("Error reading file", e);
        }

    }

    public static void flitroA(List<Person> peopleList)
    {
        peopleList.stream().filter(p -> p.getAge()<25).filter(p->p.getAge()>0).forEach(p -> p.showPerson());
    }

    public static void filtroB(List<Person> peopleList)
    {
        peopleList.stream().filter(p->!p.getName().startsWith("A")).forEach(p -> p.showPerson());
    }

    public static  void filtroC(List<Person> peopleList)
    {
        Optional<Person> optionalPerson = peopleList.stream()
                .filter(p -> p.getAge() < 25)
                .filter(p -> p.getAge() > 0)
                .filter(p -> p.getTown().equals("Madrid"))
                .findFirst();
        if(optionalPerson.isPresent())
        {
            optionalPerson.get().showPerson();
        }
        else
        {
            System.out.println("No hay ninguna persona con esos datos");
        }
    }

    public static  void filtroD(List<Person> peopleList)
    {

        Optional<Person> optionalPerson = peopleList.stream()
                .filter(p -> p.getAge() < 25)
                .filter(p -> p.getAge() > 0)
                .filter(p -> p.getTown().equals("Barcelona"))
                .findFirst();
        if(optionalPerson.isPresent())
        {
            optionalPerson.get().showPerson();
        }
        else
        {
            System.out.println("No hay ninguna persona con esos datos");
        }

    }



    public static void modificarDatos(List<Person> peopleList)
    {
        for (Person person : peopleList) {
            if (person.getTown().equals("")) {
                person.setTown("unknown");
            }
        }
    }

    public static List<Person> readFile(Path path) throws InvalidLineFormatException
    {
        try
        {
            List<Person> peopleList = new ArrayList<Person>();
            List<String> people = new ArrayList<String>();

            BufferedReader reader = Files.newBufferedReader(path);
            String line = reader.readLine();
            while (line != null)
            {
                String[] person= line.split(":");
                Person p = new Person();
                p.setName(person[0]);

                if (person.length > 1)
                {
                    p.setTown(person[1]);
                }
                else
                {
                    p.setTown("");
                }
                //p.setTown(person[1]);
                //p.setAge(person.length>2?Integer.parseInt(person[2]):0);//mirar si el tercer elemento es un numero o no
                if (person.length>2)
                {
                    p.setAge(Integer.parseInt(person[2]));
                }
                else {
                    p.setAge(0);
                }
                peopleList.add(p);
                line = reader.readLine();
            }

            reader.close();
            return peopleList;
        }
        catch(IOException e)
        {
           throw new InvalidLineFormatException("Error reading file", e);
        }

    }

    public static void showPeople(List<Person> peopleList)
    {
        for (Person p : peopleList)
        {
            p.showPerson();
        }
    }
}

