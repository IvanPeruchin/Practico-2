package colecciones; 

import colecciones.Nodo;

public class ListaDinamic<T> implements Lista{
        //atributo para cantidad de nodos
        private int cantNodo;

        //atributo para un puntero cabeza.
        private Nodo<T> head;   


	public boolean agregar(T elem){
        Nodo<T> nodo = new Nodo<T>(elem);

        if(esVacia()){
            head.setNext(nodo);
        } else {
            Nodo<T> aux = head;
            while(aux.getNext() != null){
                aux.setNext(aux.getNext());
            }
            aux.setNext(nodo);           
        }
        cantNodo++;
        return true;
    }

  
  	public boolean agregarTodos(Lista<T> otraLista){
        if(esVacia()){
            head.setNext(otraLista.head);
        } else {
            Nodo<T> aux = head;
            while(aux.getNext() != null){
                aux.setNext(aux.getNext());
            }
            aux.setNext(otraLista.head);
        }
        cantNodo = cantNodo + otraLista.cantNodo;
        return true;
    }

    
	public boolean insertar(T elem, int indice){
        Nodo<T> nodo = new Nodo<T>(elem);
        if(indice >= 0 && indice < elementos()){
            if(esVacia()){
                head.setNext(nodo);
            } else {
                Nodo<T> aux = head;
                for(int i=0; i < indice; i++){
                    aux.setNext(aux.getNext);
                }
                aux.setNext(nodo);
            }
            cantNodo++;
            return true;
        }else{
            throw new IndexOutOfBoundsException("Indice fuera de rango.");
        }
    }

    
	public T eliminar(int indice){
        T eliminado;
        if(indice >= 0 && indice < elementos()){

            if(esVacia()){  //si la lista es vacia no se elimina nada.
                throws new NotFoundException("La lista esta vacia");
            } else if(head.getNext() != null){  //si no es una lista unitaria

                if(indice > 0){   
                    Nodo<T> aux = head; //puntero para hacer el "puente"                 
                    for(int i=0; i< indice; i++){
                        aux.setNext(aux.getNext());
                    }
                    Nodo<T> puntBorrar = aux.getNext();   //puntero para pararse sobre el elemento a borrar 
                    eliminado = puntBorrar.getInfo();
                    aux.setNext(puntBorrar.getNext());
                } else {
                    Nodo<T> puntBorrar = head;   //puntero para pararse sobre el elemento a borrar
                    eliminado = puntBorrar.getInfo(); 
                    head = (puntBorrar.getNext());
                }

            } else {
                eliminado = head.getInfo();
                head = null;
            }
            return eliminado;
             
        } else {
           throw new IndexOutOfBoundsException("Indice fuera de rango.");
        }
    }


	public T obtener(int indice){
        if(indice >= 0 && indice < elementos()){
            Nodo<T> aux = head;
            for(int i=0; i < indice; i++){
                aux.setNext(aux.getNext());
            }
            return aux.getInfo();
        } else {
            throw new IndexOutOfBoundsException("Indice fuera de rango.");
        }
    }

   
	public Lista<T> subLista(int desdeInd, int hastaInd){
        if(desdeInd >= 0 && hastaInd < elementos()){
            Nodo<T> aux = head;     //puntero para posicionarme en el comienzo de la sublista
            int i=0;
            while(i < desdeInd){
                aux.setNext(aux.getNext());
                i++;
            }
            Nodo<T> puntAgreg = null;
            for(i = desdeInd; i < (hastaInd-1); i++){
                puntAgreg.agregar(head.obtener(i));
            }
            return puntAgreg;
        } else {
            throw new IndexOutOfBoundsException("Indice fuera de rango.");
        }

    }


	public boolean contiene(T elem){
        Nodo<T> aux = head;
        while(aux.getNext() != null && aux.getInfo() != elem){
            aux.setNext(aux.getNext());
        }
        if(aux.getNext() == null){
            return false;
        }
        if((aux.getInfo()).equals(elem)){
            return true;
        } else {
            return false;
        }
    }

	
	public void vaciar(){
        head = null;
    }
	

	public int elementos(){
        return cantNodo;
    }

	
	public boolean esVacia(){
        return (head == null);
    }

    
	public boolean repOK(){
    
    }

    @Override
	public String toString(){
        String lib = "[";
        if(head == null){
            lib += " ]";
        } else {
            Nodo<T> aux = head;
            while(aux.getNext() =! null){
                lib += aux.getInfo() + ", ";
                aux.setNext(aux.getNext());
            }
            lib + "]"
        }
        return lib;
    }
	
    @Override
	public boolean equals(Object otro){
        if(!(otro instanceof Lista<T>)){
            return false;
        }
        
        Lista<T> otroNuevo = (Lista<T>) otro;
        Node<T> aux = head;
        
        if(aux.elementos() != otroNuevo.elementos()){
            return false;
        } else {
            for(int i=0; i < aux; i++){
                if(aux.getInfo().equals(otraList.obtener(i))){
                    aux.setNext(aux.getNext());
                } else {
                    return false:
                }
            }
            return true:
        }
    }

    
}


