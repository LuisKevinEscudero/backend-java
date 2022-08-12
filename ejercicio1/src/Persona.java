public class Persona
{
    private String Nombre;
    private String Ciudad;
    private Integer Edad;

    public Persona() {

    }

    public Persona(String nombre, String ciudad, Integer edad)
    {
        this.Nombre = nombre;
        this.Ciudad = ciudad;
        this.Edad = edad;
    }

    public String getNombre()
    {
        return this.Nombre;
    }

    public String getCiudad()
    {
        return this.Ciudad;
    }

    public Integer getEdad()
    {
        return this.Edad;
    }

    public void setNombre(String nombre)
    {
        this.Nombre = nombre;
    }

    public void setCiudad(String ciudad)
    {
        this.Ciudad = ciudad;
    }

    public void setEdad(Integer edad)
    {
        this.Edad = edad;
    }

    public boolean Mostrar()
    {

        System.out.println("Nombre: " + this.Nombre + " ,Ciudad: " + this.Ciudad + " ,Edad: " + this.Edad);
        return true;
    }
}
