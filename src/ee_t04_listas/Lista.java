/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee_t04_listas;

/**
 *
 * @author Bolaños Miguel Diego
 */
public class Lista<T extends Comparable<T>> {

    private Nodo<T> inicio;

    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }

    public Nodo<T> getInicio() {
        return inicio;
    }

    public void InsertarInicio(T dato) {
        Nodo<T> nuevo = new Nodo<T>(dato);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
    }

    public void InsertarFinal(T dato) {
        Nodo<T> temporal;
        temporal = inicio;
        if (inicio == null) {
            this.InsertarInicio(dato);
        } else {
            while (temporal.getSiguiente() != null) {
                temporal = temporal.getSiguiente();
            }
            temporal.setSiguiente(new Nodo(dato));
        }
    }

    
    public void InsertarDespuesDe(T dato, T referencia) {
        Nodo<T> aux, nuevo;
        boolean c = true;
        aux = inicio;
        while (aux.getDato() != referencia && c) {
            if (aux.getSiguiente() != null) {
                nuevo = aux;
                aux = aux.getSiguiente();
            } else {
                c = false;
                System.out.println("El Dato no existe \n");
            }
        }
        if (c) {
            if (aux == inicio) {
            } else {
                nuevo = new Nodo(dato);
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
            }
        }
    }
    
    public void InsertarAntesDe(T dato) {
        Nodo<T> aux, nodoEncontrado = null, nuevo;
        boolean c = true;
        aux = inicio;
        while (dato.compareTo(aux.getDato()) == -1 && c) {
            if (aux.getSiguiente() != null) {
                nodoEncontrado = aux;
                aux = aux.getSiguiente();
            } else {
                c = false;
            }
        }
        if (c) {
            if (aux == inicio) {
                InsertarInicio(dato);
            } else {
                nuevo = new Nodo(dato);
                nuevo.setSiguiente(aux);
                nodoEncontrado.setSiguiente(nuevo);
            }
        } else {
            InsertarFinal(dato);
        }
    }

    public void EliminarInicio() {
        Nodo<T> aux = inicio;
        if (aux.getSiguiente() != null) {
            inicio = aux.getSiguiente();
        } else {
            inicio = null;
        }
    }

    public void EliminarFin() {
        Nodo<T> aux, anterior = null;
        aux = inicio;
        if (inicio.getSiguiente() == null) {
            inicio = null;
        } else {
            while (aux.getSiguiente() != null) {
                anterior = aux;
                aux = aux.getSiguiente();
            }
            anterior.setSiguiente(null);
        }
    }

    public void EliminarDespues(T referencia) {
        Nodo<T> aux, nuevo, anterior = null;
        boolean c = true;
        aux = inicio;
        while (aux.getDato() != referencia && c) {
            if (aux.getSiguiente() != null) {
                nuevo = aux;
                anterior = aux;
                aux = aux.getSiguiente();
            } else {
                c = false;
                System.out.println("El Dato no existe  \n");
            }
        }
        if (c) {
            if (aux == inicio) {
            } else {
                nuevo = new Nodo(referencia);
                anterior.setSiguiente(nuevo);
            }
        }
    }

    public void recorreRecursivo(Nodo<T> aux){
		
         if (aux != null){
		 
             System.out.println(aux.getDato());
		
             recorreRecursivo(aux.getSiguiente());
		
         }
    }

     public void RecorreIterativo(){
        Nodo<T> temporal=inicio;
        if(inicio==null){
            System.out.println("Lista vacia");
        }
        else{
            while(temporal!=null){
                System.out.print(temporal);
                temporal=temporal.getSiguiente();
            }
        }
        System.out.print(temporal);
        System.out.println();
    }
  
  public void buscarRecursivo(T dato){
    Nodo aux;
    aux=inicio;
    if(aux!=null){
       if(aux.getDato()==dato){ 
          System.out.println("El Dato existe en la lista");
        }
         else{
          buscarRecursivo(dato);
          aux=aux.getSiguiente();
        }  
    }
      else{
          System.out.println("El Dato no existe en la lista");
        }
   }

    public String toString() {

        Nodo<T> aux = inicio;
        String s = "";
        while (aux != null) {
            s += "[" + aux.getDato() + "]" + "--->";
            aux = aux.getSiguiente();
        }
        return s + "" + null;
    }

}
