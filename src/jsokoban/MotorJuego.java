
package jsokoban;

import java.awt.Graphics;

/**
 *
 * @author patricio
 */
public class MotorJuego
{
   private int[][] tablero;
   private Niveles  niveles;
   private int columnaJ,filaJ;
   private int contadorEtapa=1;
   private int pasos; 
   public MotorJuego()
   {
     this.niveles=new Niveles();
     this.tablero=this.niveles.etapa1();
     this.configuracionNivel(1);
     this.pasos=0;
   }

    /**
     * @return the tablero
     */
    public int[][] getTablero()
    {
        return tablero;
    }

    /**
     * @param tablero the tablero to set
     */
    public void setTablero(int nivel)
    {
        this.tablero = this.niveles.getEtapa(nivel);
    }
    
    public void configuracionNivel(int nivel)
    {
     this.tablero=this.niveles.getEtapa(nivel);
     this.buscarJugador();
    }
    
    /**
     * @return the niveles
     */
    public Niveles getNiveles()
    {
        return niveles;
    }
    
    public void buscarJugador()
    {
      for(int i = 0; i<11; i++)
        {
            for(int j = 0; j<13; j++)
            {
              if (this.tablero[i][j] == 5)
              {
                  this.columnaJ=j;
                  this.filaJ=i;
                  break;
              }
            }
        }
    }
    
    public void movJugadorDerecha()
    {
        
        if (this.tablero[this.filaJ][this.columnaJ + 1] == 2 && this.tablero[this.filaJ][this.columnaJ] != 7  )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ][this.columnaJ+1]=5; 
            columnaJ+=1;
            this.pasos+=1;
            
        }
        else if (this.tablero[this.filaJ][this.columnaJ + 1]==3 && this.tablero[this.filaJ][this.columnaJ + 2]==2
                && this.tablero[this.filaJ][this.columnaJ] != 7  )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ][this.columnaJ+1]=5;
            this.tablero[this.filaJ][this.columnaJ+2]=3;
            columnaJ+=1;
            this.pasos+=1;
        }
        
        else if (this.tablero[this.filaJ][this.columnaJ + 2]== 4 && this.tablero[this.filaJ][this.columnaJ +1]==3
                && this.tablero[this.filaJ][this.columnaJ] != 7)
        {
            
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ][this.columnaJ+1]=5;
            this.tablero[this.filaJ][this.columnaJ+2]=6;
            columnaJ+=1;
            this.pasos+=1;
        }
        //estoy sobre un hoyo con un hoyo a la derecha
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ][this.columnaJ+1] == 4)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ][this.columnaJ+1]=7; 
            columnaJ+=1;
           this.pasos+=1;
        }
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ][this.columnaJ+1] == 2)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ][this.columnaJ+1]=5; 
            columnaJ+=1;
            this.pasos+=1;
        }
        
        
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 5 && this.tablero[this.filaJ][this.columnaJ+1] == 6 
                && this.tablero[this.filaJ][this.columnaJ+2] == 4 )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ][this.columnaJ+1]=7; 
            this.tablero[this.filaJ][this.columnaJ+2]=6;
            columnaJ+=1;
            this.pasos+=1;
        }
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ][this.columnaJ+1] == 6 
                && this.tablero[this.filaJ][this.columnaJ+2] == 2 )
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ][this.columnaJ+1]=7; 
            this.tablero[this.filaJ][this.columnaJ+2]=3;
            columnaJ+=1;
            this.pasos+=1;
        }
        //a la derecha se encuentra un hoyo
        else if (this.tablero[this.filaJ][this.columnaJ + 1] == 4 && this.tablero[this.filaJ][this.columnaJ] != 7 )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ][this.columnaJ+1]=7; 
            columnaJ+=1;
            this.pasos+=1;
        }
        
        //a la derecha se encuentra un hoyo
        else if (this.tablero[this.filaJ][this.columnaJ] == 5 && this.tablero[this.filaJ][this.columnaJ+1] == 6
                && this.tablero[this.filaJ][this.columnaJ+2] == 2)
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ][this.columnaJ+1]=7; 
            this.tablero[this.filaJ][this.columnaJ+2]=3; 
            columnaJ+=1;
            this.pasos+=1;
        }
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ][this.columnaJ+1] == 3
                && this.tablero[this.filaJ][this.columnaJ+2] == 2)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ][this.columnaJ+1]=5; 
            this.tablero[this.filaJ][this.columnaJ+2]=3; 
            columnaJ+=1;
            this.pasos+=1;
        }
        
        ///Especial
       else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ][this.columnaJ+1] == 6
                && this.tablero[this.filaJ][this.columnaJ+2] == 4)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ][this.columnaJ+1]=7; 
            this.tablero[this.filaJ][this.columnaJ+2]=6; 
            columnaJ+=1;
            this.pasos+=1;
        }
    
        
    }
    
    public void movJugadorIzquierda()
    {
         
       if (this.tablero[this.filaJ][this.columnaJ - 1] == 2 && this.tablero[this.filaJ][this.columnaJ] != 7  )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ][this.columnaJ-1]=5; 
            columnaJ-=1;
            this.pasos+=1;
        }
        else if (this.tablero[this.filaJ][this.columnaJ - 1]==3 && this.tablero[this.filaJ][this.columnaJ - 2]==2
                && this.tablero[this.filaJ][this.columnaJ] != 7  )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ][this.columnaJ-1]=5;
            this.tablero[this.filaJ][this.columnaJ-2]=3;
            columnaJ-=1;
            this.pasos+=1;
        }
        
        else if (this.tablero[this.filaJ][this.columnaJ - 2]== 4 && this.tablero[this.filaJ][this.columnaJ -1]==3
                && this.tablero[this.filaJ][this.columnaJ] != 7)
        {
            
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ][this.columnaJ-1]=5;
            this.tablero[this.filaJ][this.columnaJ-2]=6;
            columnaJ-=1;
            this.pasos+=1;
        }
        //estoy sobre un hoyo con un hoyo a la derecha
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ][this.columnaJ-1] == 4)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ][this.columnaJ-1]=7; 
            columnaJ-=1;
            this.pasos+=1;
        }
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ][this.columnaJ-1] == 2)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ][this.columnaJ-1]=5; 
            columnaJ-=1;
            this.pasos+=1;;
        }
        
        
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 5 && this.tablero[this.filaJ][this.columnaJ-1] == 6 
                && this.tablero[this.filaJ][this.columnaJ-2] == 4 )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ][this.columnaJ-1]=7; 
            this.tablero[this.filaJ][this.columnaJ-2]=6;
            columnaJ-=1;
            this.pasos+=1;
        }
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ][this.columnaJ-1] == 6 
                && this.tablero[this.filaJ][this.columnaJ-2] == 2 )
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ][this.columnaJ-1]=7; 
            this.tablero[this.filaJ][this.columnaJ-2]=3;
            columnaJ-=1;
            this.pasos+=1;
        }
        //a la derecha se encuentra un hoyo
        else if (this.tablero[this.filaJ][this.columnaJ - 1] == 4 && this.tablero[this.filaJ][this.columnaJ] != 7 )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ][this.columnaJ-1]=7; 
            columnaJ-=1;
            this.pasos+=1;
        }
        
        //a la derecha se encuentra un hoyo
        else if (this.tablero[this.filaJ][this.columnaJ] == 5 && this.tablero[this.filaJ][this.columnaJ-1] == 6
                && this.tablero[this.filaJ][this.columnaJ-2] == 2)
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ][this.columnaJ-1]=7; 
            this.tablero[this.filaJ][this.columnaJ-2]=3; 
            columnaJ-=1;
            this.pasos+=1;
        }
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ][this.columnaJ-1] == 3
                && this.tablero[this.filaJ][this.columnaJ-2] == 2)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ][this.columnaJ-1]=5; 
            this.tablero[this.filaJ][this.columnaJ-2]=3; 
            columnaJ-=1;
           this.pasos+=1;
        }
       ///Especial
       else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ][this.columnaJ-1] == 6
                && this.tablero[this.filaJ][this.columnaJ-2] == 4)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ][this.columnaJ-1]=7; 
            this.tablero[this.filaJ][this.columnaJ-2]=6; 
            columnaJ-=1;
            this.pasos+=1;
        }
       
    }
    
    public void movJugadorArriba()
    {
     
        if (this.tablero[this.filaJ - 1][this.columnaJ] == 2 && this.tablero[this.filaJ][this.columnaJ] != 7  )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ- 1][this.columnaJ]=5; 
            filaJ-=1;
            this.pasos+=1;
            
        }
        else if (this.tablero[this.filaJ-1][this.columnaJ]==3 && this.tablero[this.filaJ-2][this.columnaJ]==2
                && this.tablero[this.filaJ][this.columnaJ] != 7  )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ-1][this.columnaJ]=5;
            this.tablero[this.filaJ-2][this.columnaJ]=3;
            filaJ-=1;
            this.pasos+=1;
        }
        
        else if (this.tablero[this.filaJ-2][this.columnaJ]== 4 && this.tablero[this.filaJ-1][this.columnaJ]==3
                && this.tablero[this.filaJ][this.columnaJ] != 7)
        {
            
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ-1][this.columnaJ]=5;
            this.tablero[this.filaJ-2][this.columnaJ]=6;
            filaJ-=1;
            this.pasos+=1;
        }
        //estoy sobre un hoyo con un hoyo a la derecha
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ-1][this.columnaJ] == 4)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ-1][this.columnaJ]=7; 
            filaJ-=1;
            this.pasos+=1;
        }
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ-1][this.columnaJ] == 2)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ-1][this.columnaJ]=5; 
            filaJ-=1;
            this.pasos+=1;
        }
        
        
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 5 && this.tablero[this.filaJ-1][this.columnaJ] == 6 
                && this.tablero[this.filaJ-2][this.columnaJ] == 4 )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ-1][this.columnaJ]=7; 
            this.tablero[this.filaJ-2][this.columnaJ]=6;
            filaJ-=1;
            this.pasos+=1;
        }
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ-1][this.columnaJ] == 6 
                && this.tablero[this.filaJ-2][this.columnaJ] == 2 )
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ-1][this.columnaJ]=7; 
            this.tablero[this.filaJ-2][this.columnaJ]=3;
            filaJ-=1;
           this.pasos+=1;
        }
        //a la derecha se encuentra un hoyo
        else if (this.tablero[this.filaJ-1][this.columnaJ] == 4 && this.tablero[this.filaJ][this.columnaJ] != 7 )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ-1][this.columnaJ]=7; 
            filaJ-=1;
            this.pasos+=1;
        }
        
        //a la derecha se encuentra un hoyo
        else if (this.tablero[this.filaJ][this.columnaJ] == 5 && this.tablero[this.filaJ-1][this.columnaJ] == 6
                && this.tablero[this.filaJ-2][this.columnaJ] == 2)
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ-1][this.columnaJ]=7; 
            this.tablero[this.filaJ-2][this.columnaJ]=3; 
            filaJ-=1;
            this.pasos+=1;
        }
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ-1][this.columnaJ] == 3
                && this.tablero[this.filaJ-2][this.columnaJ] == 2)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ-1][this.columnaJ]=5; 
            this.tablero[this.filaJ-2][this.columnaJ]=3; 
            filaJ-=1;
           this.pasos+=1;
        }
       ///Especial
       else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ-1][this.columnaJ] == 6
                && this.tablero[this.filaJ-2][this.columnaJ] == 4)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ-1][this.columnaJ]=7; 
            this.tablero[this.filaJ-2][this.columnaJ]=6; 
            filaJ-=1;
            this.pasos+=1;
        }
        
    }
    
    public void movJugadorAbajo()
    {
     
      if (this.tablero[this.filaJ + 1][this.columnaJ] == 2 && this.tablero[this.filaJ][this.columnaJ] != 7  )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ+ 1][this.columnaJ]=5; 
            filaJ+=1;
            this.pasos+=1;
            
        }
        else if (this.tablero[this.filaJ+1][this.columnaJ]==3 && this.tablero[this.filaJ+2][this.columnaJ]==2
                && this.tablero[this.filaJ][this.columnaJ] != 7  )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ+1][this.columnaJ]=5;
            this.tablero[this.filaJ+2][this.columnaJ]=3;
            filaJ+=1;
            this.pasos+=1;
        }
        
        else if (this.tablero[this.filaJ+2][this.columnaJ]== 4 && this.tablero[this.filaJ+1][this.columnaJ]==3
                && this.tablero[this.filaJ][this.columnaJ] != 7)
        {
            
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ+1][this.columnaJ]=5;
            this.tablero[this.filaJ+2][this.columnaJ]=6;
            filaJ+=1;
            this.pasos+=1;
        }
        //estoy sobre un hoyo con un hoyo a la derecha
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ+1][this.columnaJ] == 4)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ+1][this.columnaJ]=7; 
            filaJ+=1;
           this.pasos+=1;
            
        }
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ+1][this.columnaJ] == 2)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ+1][this.columnaJ]=5; 
            filaJ+=1;
            this.pasos+=1;
        }
        
        
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 5 && this.tablero[this.filaJ+1][this.columnaJ] == 6 
                && this.tablero[this.filaJ+2][this.columnaJ] == 4 )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ+1][this.columnaJ]=7; 
            this.tablero[this.filaJ+2][this.columnaJ]=6;
            filaJ+=1;
           this.pasos+=1;
        }
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ+1][this.columnaJ] == 6 
                && this.tablero[this.filaJ+2][this.columnaJ] == 2 )
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ+1][this.columnaJ]=7; 
            this.tablero[this.filaJ+2][this.columnaJ]=3;
            filaJ+=1;
            this.pasos+=1;
        }
        //a la derecha se encuentra un hoyo
        else if (this.tablero[this.filaJ+1][this.columnaJ] == 4 && this.tablero[this.filaJ][this.columnaJ] != 7 )
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ+1][this.columnaJ]=7; 
            filaJ+=1;
            this.pasos+=1;
        }
        
        //a la derecha se encuentra un hoyo
        else if (this.tablero[this.filaJ][this.columnaJ] == 5 && this.tablero[this.filaJ+1][this.columnaJ] == 6
                && this.tablero[this.filaJ+2][this.columnaJ] == 2)
        {
            this.tablero[this.filaJ][this.columnaJ]=2;
            this.tablero[this.filaJ+1][this.columnaJ]=7; 
            this.tablero[this.filaJ+2][this.columnaJ]=3; 
            filaJ+=1;
            this.pasos+=1;
        }
        
        else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ+1][this.columnaJ] == 3
                && this.tablero[this.filaJ+2][this.columnaJ] == 2)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ+1][this.columnaJ]=5; 
            this.tablero[this.filaJ+2][this.columnaJ]=3; 
            filaJ+=1;
            this.pasos+=1;
        }
       ///Especial
       else if (this.tablero[this.filaJ][this.columnaJ] == 7 && this.tablero[this.filaJ+1][this.columnaJ] == 6
                && this.tablero[this.filaJ+2][this.columnaJ] == 4)
        {
            this.tablero[this.filaJ][this.columnaJ]=4;
            this.tablero[this.filaJ+1][this.columnaJ]=7; 
            this.tablero[this.filaJ+2][this.columnaJ]=6; 
            filaJ+=1;
            this.pasos+=1;
        }
   
    }
    
    public boolean revisarMatriz()
    {
        boolean superada= false;
        int contador = 0;
        for(int i =0;i<11;i++)
        {
            for(int j=0; j<13; j++)
            {
                if(this.tablero[i][j] == 3)
                {
                    contador++;
                }
            }
        }
        if(contador == 0)
        {
            superada = true;
        }
    return superada;
    }
    
    public int getPasos()
    {
        System.out.println(this.pasos);
        return this.pasos;
    }
}
