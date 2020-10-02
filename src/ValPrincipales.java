
import LIFO.Pila;
import javax.swing.JOptionPane;

/*
* Clase que contiene las validaciones principales que debe cumplir un automata.
 */
public class ValPrincipales {
    // Metodo que recibe dos vectores String donde b tiene que tener elementos estrictamente esten en a
    //si la condicion se cumple es metodo devolvera true.
    public boolean TiraLenguaje (String[]a , String[] b){
        
        boolean val1=true;
        String mod1="";
        String comp="";
        int ban=0;
        for (int i = 0; i < b.length; i++) {
            mod1=b[i];
            
            for (int j = 0; j < a.length; j++) {   
                comp=a[j];
                if(comp.equals( mod1)){
                 ban=1;       
                break;
                }
            }
            
            if(ban==0){
                val1=false;
                return val1; 
            }            
        } 
        return val1;
        
    }
    
            
   /*
    Metodo que recibe un vector String y rebiza que no haya elementos repetidos,
    en el caso de haber elementos repetidos devolvera el boolean true 
    caso contrario false
 */
    public boolean RepVec(String []a){
        boolean rep=false;
        String aux1="",aux2="";
        for (int i = 0; i < a.length; i++) {
            aux1=a[i];
            for (int j = 0; j < a.length; j++) {
                aux2=a[j];
                if( i!=j ){                 
                 if(aux1==aux2){
                   rep=true;
                    return rep;
                 }  
                }      
            }
        }
        return rep;
        
    }
    
    
    /*
    Metodo para recorrer la matriz desde un punto i,j guiado por el siguiente entrada al
    metodo que recibe los siguientes  parametros una matriz que contiene los acambios de estados 
    un vector que serviran para identificar los valores del lenguaje y otro vector 
    que contiene todos los estados que el automata posee un string que representa la 
    tira a reconocer , este metodo devolvera como retorno un 
    vector de tipo object con 3 datos y una posiciones en la posicion cero se tendrá un string que refleja
    los cambios en la pila LIFO, en  la posicion uno contendrá un string que refleja todos los cambios de estados.
    */
    
    public Object []RecoMatriz(String[] estados,String [] lenguaje, String [][] matriz,
                                String tira,String [] finales,String inicial){
        Object [] datos= new Object [2];
        String [][] matri=matriz;
        String[] estado=estados, lenguaj=lenguaje,finale=finales;
        String []tir=tira.split("");
        String inicia=inicial;
        Pila pil= new Pila ();
    String r0="--- AUTOMA DE PILA NO DETERMINISTA ---\n";//,r1="\n--- DESCRIPCION RECORRIDO DE LA PILA ---\n";
        int posf=0,posc=0;
        posf=this.Encontrarposicion(inicia, estado);
        posc=this.Encontrarposicion(tir[0], lenguaj);
    r0+="El Automata comienza en el estado inicial: "+ inicia+"\n";
    

          if(!matri[posf][posc].equals(""+null)){
       String est =matri[posf][posc];//.split("/")[0];
    r0+="por le valor de la Tira: "+tir[0]+"-> pasa a estado: "+est+"\n"; 
//    r1+=""+pil.desapilar(""+matri[posf][posc].split("/")[1])+"\n";
//    r1+=""+pil.apilar(""+matri[posf][posc].split("/")[2])+"\n";
          
        for (int i = 1; i < tir.length; i++) {            
            posf=this.Encontrarposicion(est, estados);
            posc=this.Encontrarposicion(tir[i], lenguaj);
            if(posf==99999999 || posc==99999999){
                JOptionPane.showMessageDialog(null, "Estado requerido en la matriz\n No ha sido encontrado");
               break;
            }else{
             if(!matri[posf][posc].equals(""+null)){
            est=matri[posf][posc];//.split("/")[0];
    r0+="por le valor de la Tira: "+tir[i]+"-> pasa a estado: "+est+"\n";  
//    r1+=""+pil.desapilar(""+matri[posf][posc].split("/")[1])+"\n";
//    r1+=""+pil.apilar(""+matri[posf][posc].split("/")[2])+"\n";
   
            
            if(i==tir.length-1){
//                String comp[]={tir[tir.length-1]};
                String comp[]={""+est};
                                
                if(this.TiraLenguaje(finale,comp )){                
        r0+="Estado terminal: "+comp[0]+" Forma parte de los finales"+"\n" ;
         r0+="LA TIRA  HA SIDO CORRECTAMENTE RECONOCIDA POR  EL AUTOMATA"+"\n" ;   
                }else{
    r0+="Estado terminal: "+comp[0]+" NO Forma parte de los finales"+"\n" ;
    r0+="LA TIRA NO HA SIDO RECONOCIDA POR  EL AUTOMATA"+"\n" ;
             
   
                }
            }     
             }else{
                JOptionPane.showMessageDialog(null, "Posicion requerida en la matriz\n No tiene ningun estado");
                r0+="\n TIRA NO HA SIDO RECONOCIDA";
                break;
          }
            }
        }
        }else{
                JOptionPane.showMessageDialog(null, "Posicion requerida en la matriz\n No tiene ningun estado");
                r0+="\n TIRA NO HA SIDO RECONOCIDA";
          }
        datos[0]=r0;//+r1+"\n*******************************\n"+pil.listar();
        return datos;
    }
    
    
    public int Encontrarposicion(String a, String []b){
           
        for (int i = 0; i < b.length; i++) {
            if (a.equals(b[i])){
                return i;
            }
        }
        return 99999999;
        
    }
    
    
    
}
