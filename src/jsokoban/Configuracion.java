
package jsokoban;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class Configuracion extends JFrame
{
    private final JLabel tecla_Up = new JLabel("Tecla Arriba: ");
    private final JLabel tecla_Down = new JLabel("Tecla Abajo: ");
    private final JLabel tecla_Left = new JLabel("Tecla Izquierda: ");
    private final JLabel tecla_Right = new JLabel("Tecla Derecha: ");
    private final JLabel jlabel = new JLabel("Configuracion de los botones");

    private final JTextField campo_teclaarriba = new JTextField( "",10 );
    private final JTextField campo_teclaabajo = new JTextField("",10 );
    private final JTextField campo_teclaizquierda = new JTextField( "",10 );
    private final JTextField campo_tecladerecha = new JTextField("",10 );
    
    private final JButton aceptar = new JButton ("Aceptar" );
    private final JButton cancelar = new JButton("Cancelar");
    
    public Configuracion()
    {
       setTitle("Configuracion de Teclado");
       setSize(500,300);
       setLocationRelativeTo(null);
       setResizable(false);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
       
       
       Container contenedor = getContentPane();
       SpringLayout layout = new SpringLayout();
       contenedor.setLayout( layout);
       ////Posicionando teclaup
       layout.putConstraint(SpringLayout.WEST, tecla_Up, 50, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, tecla_Up, 10, SpringLayout.NORTH, contenedor);
       
       ////Posicionando tecla down
       layout.putConstraint(SpringLayout.WEST, tecla_Down, 50, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, tecla_Down, 40, SpringLayout.NORTH, contenedor);
       
       ////Posicionando tecla down
       layout.putConstraint(SpringLayout.WEST, tecla_Left, 50, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, tecla_Left, 80, SpringLayout.NORTH, contenedor);
       
       ////Posicionando tecla down
       layout.putConstraint(SpringLayout.WEST, tecla_Right, 50, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, tecla_Right, 110, SpringLayout.NORTH, contenedor);
       
       
       
       
       
       
        ////Posicionando el campo_teclaarriba
       layout.putConstraint(SpringLayout.WEST, campo_teclaarriba, 130, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, campo_teclaarriba, 10, SpringLayout.NORTH, contenedor);

        ////Posicionando el campo_teclaabajo
       layout.putConstraint(SpringLayout.WEST, campo_teclaabajo, 130, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, campo_teclaabajo, 40, SpringLayout.NORTH, contenedor);
       
       ////Posicionando el campo_teclaizquierda
       layout.putConstraint(SpringLayout.WEST, campo_teclaizquierda, 130, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, campo_teclaizquierda, 70, SpringLayout.NORTH, contenedor);
       
       ////Posicionando el campo_tecladerecha
       layout.putConstraint(SpringLayout.WEST, campo_tecladerecha, 130, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, campo_tecladerecha, 100, SpringLayout.NORTH, contenedor);
       
        ////Posicionando tecla aceptar
       layout.putConstraint(SpringLayout.WEST, aceptar, 50, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, aceptar, 140, SpringLayout.NORTH, contenedor);
       
        ////Posicionando tecla cancelar
       layout.putConstraint(SpringLayout.WEST, cancelar, 150, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, cancelar, 140, SpringLayout.NORTH, contenedor);
       
       ////Posicionando el campo_nombre
       layout.putConstraint(SpringLayout.WEST, jlabel, 280, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, jlabel, 240, SpringLayout.NORTH, contenedor);
       
       contenedor.add(tecla_Up);
       contenedor.add(tecla_Down);
       contenedor.add(tecla_Left);
       contenedor.add(tecla_Right);
       contenedor.add(campo_teclaarriba);
       contenedor.add(campo_teclaabajo);
       contenedor.add(campo_teclaizquierda);
       contenedor.add(campo_tecladerecha);
       contenedor.add(aceptar);
       contenedor.add(cancelar);
       contenedor.add(jlabel);
      
       aceptar.setBackground(new Color(255,0,0));
       cancelar.setBackground(Color.BLACK);
       ////Oyentes a los botones
       aceptar.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent evento)
           {
               if(campo_teclaarriba.getText().isEmpty() || campo_teclaabajo.getText().isEmpty() 
                       || campo_teclaizquierda.getText().isEmpty() || campo_tecladerecha.getText().isEmpty())
               {
                    ///Concatenacion de nombre y apellido
                    JOptionPane.showMessageDialog(getContentPane(), "Debe llenar los 4 campos ", " Error", JOptionPane.ERROR_MESSAGE);
               }
               
               else 
               {
                   setVisible(false);
               }
           }
       });
       
       cancelar.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent evento)
           {
              
               
               
           }
       });       
    }
}
/* Para cambiar el tamaño por ejemplo del boto aceptar se coloca aceptar.setPreferredSize(new Dimension(100,50))
 * Para cambiar caracteristicas de un laber por ej la letra se usa nombre.setFond(new Font("Arial", Font.BOLD, 25))
 * Para cambiar color de la letra nombre.setForeground(new Color (105,50.255))
 */
    

