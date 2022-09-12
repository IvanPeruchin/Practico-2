package listas;

import lista.Lista;


public class ListaArray<T> implements Lista{

    //cantidad de elementos de la lista
    private int cantElem;

    //arreglo de enteros
    private T[] elemento;

    //capacidad maxima del arreglo 
    public static final int FULL=50;

     //Construye una nueva sublista
    public ListaArray(int cantidad){
        elemento = new T[cantidad];
        cantElem = 0;
    }

    /**
	* Agrega un elemento al final de la lista.
	* @param elem el elemento a agregar
	* @return {@code true} sii el elemento pudo ser agregado
	*/
	public boolean agregar(T elem){
        if(this.elementos() < FULL){
            elemento[cantElem] = elem;
            cantElem++;
            return true;
        } else {
            return false;
        }
    }

    /**
	* Agrega todos los elementos de otra lista, al final de esta lista.
	* @param otraLista lista conteniendo todos los elementos a agregar al final de esta lista
	* @return {@code true} sii todos los elementos en {@code otraLista} fueron agregados
	*/
	public boolean agregarTodos(Lista<T> otraLista){
            if((FULL - this.cantElem) >= otraLista.elementos()){
                for(int i = 0; i < otraLista.elementos(); i++){
                    this.agregar(otraLista.elemento[i]);
                }
                return true;
            } else {
                return false;
            }
    }

    /**
	* Agrega un elemento en una posicion particular de la lista.
	* @param elem el elemento a agregar
	* @param indice el indice donde se agrega el elemento(indice comenzado en 0).
	* @return {@code true} sii el elemento pudo ser agregado
	* @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0}
	*/
	public boolean insertar(T elem, int indice){
        //si la posicion no tiene elemento, lo inserta
        if (this.elemento[indice] == null){
            this.elemento[indice] = elem;
            this.cantElem++;
            return true;
        } else {    //sino se desplazan todos una posicion  a la derecha
            if ( !(this.cantElem == FULL) ){    //si el arreglo no esta lleno
                int i = this.cantElem-1;
                while (i >= indice){
                    this.elemento[i+1] = this.elemento[i];
                    i--;
                }
                this.elemento[indice] = elem;
                this.cantElem++;
                return true;                
            } else {
                throw new IndexOutOfBoundsException();     //ver como es esto
            }
        }
    }

    /**
	* Elimina un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a eliminar
	* @return el elemento eliminado
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	public T eliminar(int indice){
        T elemEliminado = this.obtener(indice);
        if((this.elemento[indice] != null) && (indice >= 0 && indice < this.cantElem)){
            int i = indice;
            while (i < this.cantElem){
                this.elemento[i] = this.elemento[i+1];
                i++;
            }
            this.cantElem = this.cantElem - 1;
            return elemEliminado;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
	* Obtiene un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a obtener
	* @return el elemento en la posición {@code indice}
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	public T obtener(int indice){
        if(indice >= 0 && indice < this.elementos()){
            return this.elemento[indice];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

   
        
    /**
	* Retorna la porción de esta lista entre los índice especificados {@code desdeInd}, inclusivo, y {@code hastaInd}, exclusivo, en una nueva lista.
	* Si {@code fromInd} es igual a {@code hastaInd} se retorna un a lista vacía.
	* @param desdeInd el índice inferior, inclusivo
	* @param hastaInd el índice superior, exclusivo
	* @return una nueva lista formada con los elementos entre {@code desdeInd} hasta {@code hastaInd - 1} de esta lista
	* @throws IndexOutOfBoundsException si ({@code fromInd} &lt; {@code 0} || {@code hastaInd} &gt; {@code #elementos()} || {@code desdeInd} &gt; {@code hastaInd})
	* @see #elementos() 
	*/
	public Lista<T> subLista(int desdeInd, int hastaInd){
        if (desdeInd >= 0 && hastaInd < this.elementos() && desdeInd < hastaInd){
            int cant = (hastaInd - desdeInd);
            ListaArray<T> nuevList = new ListaArray<T>(cant);
            if (desdeInd == hastaInd || this.elementos() == 0) {
                return nuevList;    
            } else {
                int j = 0;
                for (int i = desdeInd; i < hastaInd-1; i++){
                    nuevList.elemento[j] = this.elemento[i];
                    nuevList.cantElem++;
                    j++;
                }
                return nuevList;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        
    }

    /**
	* Evalua si esta lista contiene un elemento particular, utilizando el método {@code equals(Object)}.
	* @param elem el elemento a buscar
	* @return {@code true} sii, existe un elemento {@code e} en la lista, tal que {@code e == null && elem == null || e.equals(elem)}
	*/
	public boolean contiene(T elem){
        int i = 0;
        while(!( (this.elemento[i]).equals(elem) )){
            i++;
        }
        return true; //ver el retorno ???
    }

    
	/**
	* Remueve todos los elementos en la lista.
	*/
	public void vaciar(){
        this.cantElem = 0;
    }

    /**
	* Retorna la cantidad de elementos agregados a la lista.
	* @return cantidad de elementos en la lista
	*/
	public int elementos(){
        return this.cantElem;
    }

    /**
	* Permite evaluar si la lista no tiene elementos.
	* Este método es equivalente a:
	* <pre>lista.elementos() == 0</pre>
	* @return {@code true} sii la pila no tiene elementos
	*/
	public boolean esVacia(){
        if (this.cantElem == 0){
            return true;
        } else {
            return false;
        }
    }

    /**
	* Invariante de clase.
	* @return {@code true} sii la lista satisface su invariante de clase
	*/
	public boolean repOK(){
        boolean flag = true;
        if(this.elementos() > FULL && this.elementos() < 0){
           return false;
        } else {
            if(this.elemento[0]!=null){
                return false;
            } else {
                //agregar ver elementos
            }
        }

        
    }

    /**
	* Retorna una representación como {@code String} de esta lista. La representación como {@code String} consiste de los elementos en esta lista, en el orden correspondiente a la implementación de la misma, encerrados entre corchetes ("[]"). 
	* Elementos adyacentes están separados mediante los caractéres ", " (coma y espacio). Los elementos son convertidos mediante {@code String.valueOf(Object)}.
	* @return una representación como {@code String} de esta lista
	*/
	@Override
	public String toString(){
        String lib = "[";
        for(int i = 0; i < cantElem; i++){
            lib += elemento[i] + ", " ;
        }
        lib += "]";
        return lib;
    }
    

    /**
	* Evalúa igualdad entre esta y otra lista. La igualdad considera que el tamaño de ambas listas es el mismo, y que los elementos de ambas listas son iguales considerando el orden de los mismos de acuerdo a la implementación de cada lista.
	* La igualdad entre elementos se realiza considerando si ambos son {@code null} o, en caso contrario, mediante el método {@code equals(Object)}.
	* @return {@code true} sii ambas listas tienen los mismos elementos.
	*/
	@Override
	public boolean equals(Object otro){
        boolean flag = true;
        if( !(otro instanceof Lista<T>)){
            return false;   
        }
        Lista<T> otraList = (Lista<T>) otro;

         if (this.elementos() != otraList.elementos()){
            return false;
        } else {
            for (int i=0; i < otraList.elementos(); i++){
                if (this.elemento[i].equals(otraList.obtener(i))) {
                    flag = flag && true;
                } else {
                    flag = false;
                }
            }
            return flag;  
        }

                    
    } 
    /*
    @supresswarning ("uncheked")
    private T elemento(int index) {
        return (T) arreglo [index];
    } */

}