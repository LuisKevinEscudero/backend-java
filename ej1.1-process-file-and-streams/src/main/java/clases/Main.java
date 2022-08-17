package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        List<Person> peopleList = new ArrayList<Person>();
        try
        {
            peopleList = readFile("C:\\Users\\luiskevin.escudero\\Desktop\\ejercicios java\\ej1.1-process-file-and-streams\\src\\main\\java\\people.csv");

            showPeople(peopleList);
        }
        catch(IOException e)
        {
            System.out.println("Error reading file");
        }

    }

    public static List<Person> readFile(String fileName) throws IOException
    {
        try
        {
            List<Person> peopleList = new ArrayList<Person>();
            List<String> people = new ArrayList<String>();

            Path path = Paths.get(fileName);

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
            System.out.println("Error reading file");
            return null;
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

