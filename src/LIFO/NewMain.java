/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIFO;

/**
 *
 * @author Arturo Castro
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pila pil=new Pila();
          
      pil.apilar("ls");
      pil.apilar("&");
      pil.apilar("ap");
        pil.apilar("ap"); 

     System.out.println(""+ pil.desapilar("ap")); 
     System.out.println(""+ pil.desapilar("ap")); 
     System.out.println(""+ pil.desapilar("&")); 
     System.out.println(""+ pil.listar());
    }
    
}
