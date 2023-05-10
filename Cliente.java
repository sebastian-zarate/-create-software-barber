
/**
 * Write a description of class Cliente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cliente
{
    int id;
    String nombre;
    String apellido;
    Corte corte;
    public Cliente()
    {
        
    }
    public void setId(int id)
   {
       this.id= id;
   }
   public int getId()
   {
       return id;
   }
   public void setNombre(String nombre)
   {
       this.nombre = nombre;
       
   }
    public String getNombre()
   {
       return nombre;
   }
   public void setApellido(String apellido)
   {
       this.apellido = apellido;
   }
   public String getApellido()
   {
       return apellido;
   }
   public void setCorte(Corte corte)
   {
       this.corte = corte;
   }
    public Corte getCorte()
    {
        return corte;
    }

}
