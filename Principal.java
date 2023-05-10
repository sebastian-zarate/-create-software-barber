import java.util.List;
import java.util.ArrayList;
import java.util.Iterator; 
import java.util.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class Principal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Principal
{
    List listaCorte = new ArrayList();
    List listaCliente = new ArrayList();
   public void menu()
   {
       System.out.println("0. Salir:");     
       System.out.println("1. Cargar cortes:");     
       System.out.println("2. Cargar clientes:" );
       System.out.println("3. Modificar clientes:");
       System.out.println("4. Eliminar cortes:");
       System.out.println("5. Buscar corte:");
   }
   public void bucle()
   {
       int op=0;
        
        
        do 
        {
          menu();  
         // Inicio();
          op= Console.readInt(" ingrese una opccion:");
          switch(op)
          {
              case 1:
                 new Ventana();
                 break;
              case 2:
                 cargarCliente();
                     break;
              case 3:
                  modificarCliente();
                 break;
                 case 4:
                     eliminarCorte();
                     break;
               case 5:
                   buscarCorte();
                   break;
                  
          }
          
        } while(op != 0);
   }
   
    public void buscarCorte()
  {
      listarCorte();
      String op = Console.readLine("Nombre del corte: ");
        buscarCorte(op);
  }
  
    public Cliente buscarCorte(String corte)
  {
      Cliente cli = new Cliente();
       Iterator it = listaCliente.iterator();
        
        while(it.hasNext())
        {
            Cliente titu = (Cliente) it.next();
            if(titu.getCorte().equals(corte))
            {
               System.out.println(titu + "echo");
            }
        }
       return cli;
  }

   
   
   
   //----------------CLIENTES----------
   public void cargarCliente()
   {
       Cliente cli = new Cliente();
        cli.setId(Console.readInt("Id: "));
        cli.setNombre(Console.readLine("Nombre: "));
        cli.setApellido(Console.readLine("Apellido: "));
        listaCliente.add(cli);
        listarCorte();
        int op = Console.readInt("Elija un corte: ");
        cli.setCorte(buscarPorIdCorte(op));
        
   }
   
   public Corte buscarPorIdCorte(int id)
  {
      Corte ti = new Corte();
       Iterator it = listaCorte.iterator();
        
        while(it.hasNext())
        {
            Corte titu = (Corte) it.next();
            if(titu.getId()==id)
            {
                ti = titu;
                break;
            }
        }
        return ti;
        
  }
  
   
    public void listarCliente()
    {
        Iterator it= listaCliente.iterator(); 
        while(it. hasNext())
        {
            Cliente cli = (Cliente) it.next();
            System.out.println(cli.getId()+ ". " + cli.getNombre()+". "+ cli.getApellido());
            
         
        }
    }
    public int buscarPosicionCliente(int id)
    {
        Cliente cli = new Cliente();
        int pos = 0;
        
        Iterator it = listaCliente.iterator();
        
        while(it.hasNext())
        {
            Cliente clien = (Cliente) it.next();
            if(clien.getId()==id)
            {
                break;
            }
            pos++;
        }
        
        return pos;
    }
   
   public void modificarCliente()
    {
        listarCliente();
        int op = Console.readInt("Elija un cliente a modificar: ");
        Cliente a = new Cliente();
        a.setId(Console.readInt("Id: "));
        a.setNombre(Console.readLine("Nombre: "));
        a.setApellido(Console.readLine("Apellido: "));
        int pos = buscarPosicionCliente(op);
        listaCliente.set(pos,a);
    }
   
    
    // ---------------- CORTES -----
    
     public void listarCorte()
    {
        Iterator it= listaCorte.iterator(); 
        while(it. hasNext())
        {
            Corte c = (Corte) it.next();
            System.out.println(c.getId()+ ". " + c.getNombre());
            
         
        }
    }
     public void eliminarCorte()
    {
        listarCorte();
        int op = Console.readInt("Elija un corte a eliminar: ");
        int pos = buscarPosicionCorte(op);
        listaCorte.remove(pos);
    
    }
    public int buscarPosicionCorte(int id)
    {
        Corte c = new Corte();
        int pos = 0;
        
        Iterator it = listaCorte.iterator();
        
        while(it.hasNext())
        {
            Corte cor = (Corte) it.next();
            if(cor.getId()==id)
            {
                break;
            }
            pos++;
        }
        
        return pos;
    }
    
   public class Ventana
{
public Ventana()
    {
        // ----------------------------------pasos de una ventana ---------
        Frame ventana = new Frame(" agregar cortes");
        Panel panel = new Panel();
       
        ventana.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.blue);// asignale el color
        componentes(panel);
        ventana.addWindowListener(new cerrar());
        ventana.setBounds(0,0,600,300);// lleva cuatro parametros de la pantalla
        ventana.setVisible(true);
       
        
     //--------------------- crear una ventana --------------------------------
    }
    
    
    
    
     public void componentes(Panel p)
    {
        //----------------TEXTO ID ------------
        TextField txtId = new TextField();
       txtId.setBounds(10,50,70,25);/// pocicion en x, poc en y largo(x) y ancha
         Label id= new Label("id"); // escribir en la pag
         id.setBounds(30,20,60,25);// meedida del cuadrado 
         id.setForeground(Color.white);
         id.setFont(new Font("Arial", Font.BOLD,12));//Font.BOLD poner en negro la letra
          
         //-------------TEXTO NOMBRE-------------
         TextField txtNombre = new TextField();
        txtNombre.setBounds(100,50,100,25);
         Label  nom = new Label("Nombre"); // escribir en la pag
        nom.setBounds(100,20,60,25);// ESCRIBE 
         nom.setForeground(Color.white);
         nom.setFont(new Font("Arial", Font.BOLD,12));//Font.BOLD poner en negro la letra
          
         
        //TextField resultadoSuma = new TextField();
        //resultadoSuma.setBounds(300,20,100,25);
        //resultadoSuma.setEditable(false);
        Button botonGuardar = new Button("guardar");
        //botonSumar.setBounds(450,90,100,25);
       // botonSumar.addActionListener(new grabar(textId, textNombre,textDni,textDomicilio,textTelefono ));
        botonGuardar.setBounds(450,90,100,25);
       botonGuardar.addActionListener(new Grabar(txtId, txtNombre));
         
        p.add(txtId);
         p.add(id);
         p.add(txtNombre);
         p.add(nom);
         
         
         p.add(botonGuardar);
        
        
        }
     class cerrar  extends WindowAdapter
        {

            
            public void windowClosing(WindowEvent e)
           {
                System.exit(0);// cierra las ventanas de las aplicacion
            }
        }
         class Grabar implements ActionListener
        {
            TextField id, nombre;
          
            public  Grabar(TextField id, TextField nombre)
            {
               
            this.id = id;
            this.nombre = nombre;
            
               //this.v = v;
            }
        
          public void actionPerformed(ActionEvent e)
            {
                     Corte c = new Corte();
                    c.setNombre(nombre.getText());
                    
                   c.setId(Integer.parseInt(id.getText()));   //convertir texto a entero //CASTEO 
                 
                 listaCorte.add(c);
            }      

}
}
   
}
