/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee_t04_listas;

/**
 *
 * @author Victor Hugo Bolaños
 */
public class Nodo <T>{
    private  T dato;
    private  Nodo < T > siguiente;
     public   Nodo ( T  dato ) {
        this . dato = dato;
        siguiente = null ;
    }
    public void  setDato ( T  dato ) {
        this . dato = dato;
    }
    public T  getDato () {
        return dato;
    }
    public void  setSiguiente ( Nodo < T >  siguiente ) {
        this . siguiente = siguiente;
    }
    public Nodo < T > getSiguiente () {
        return siguiente;
    }   
}
