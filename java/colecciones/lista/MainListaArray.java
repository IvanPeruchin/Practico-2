public class MainListaArray{
    public static void main(String[] args){
        
        ListaArray<Integer> arr1 = new ListaArray<Integer>(10);
        ListaArray<Integer> arr2 = new ListaArray<Integer>(5);
        ListaArray<Integer> arr3 = new ListaArray<Integer>(8);
        ListaArray<Integer> arr4 = new ListaArray<Integer>(5);
        ListaArray<Integer> arr5 = new ListaArray<Integer>(66);

        System.out,println("Agregamos elementos de tipo enteros: \n");
        arr1.agregar(9);
        arr1.agregar(8);
        arr1.agregar(7);
        System.out.println("El arreglo es:" + arr1.toString());

        arr2.agregar(1);
        arr2.agregar(2);
        arr2.agregar(3);
        arr2.agregar(4);
        arr2.agregar(5);
        System.out.println("El arreglo 2 es:" + arr2.toString());

        System.out.println("Agregamos el arreglo 2 en el arreglo 1 \n");
        System.out.println(arr1.agregarTodos(arr2));
        System.out.println("\n");

        int indice = 4
        System.out.println("Insertamos el nro 6 en la posicion " + indice+1);
        arr1.insertar(6, indice);
        System.out.println("El arreglo es:" + arr1.toString());
        System.out.println("\n");

        System.out.println("Eliminamos el 1er elemento");
        arr1.eliminar(0);
        System.out.println("El arreglo es:" + arr1.toString());
        System.out.println("\n");

        int esta = 3;
        System.out.println("Que elemento estara en la posicion " + (esta+1) + "? ");
        System.out.println("Esta el numero " + arr1.obtener(esta));
        System.out.println("\n");

        System.out.println("La sublista es: " + arr1.subLista(2,6));
        System.out.println("\n");

        esta = 5;
        System.out.println("La lista contiene el elemento " + esta + "? " + arr1.contiene(esta));
        System.out.println("\n");

        arr2.vaciar(); 
        System.out.println("La lista 2 es vacia? " + arr2.esVacia());
        System.out.println("\n");


        arr4.agregar(6);
        arr4.agregar(4);
        arr4.agregar(7);
        arr4.agregar(9);
        arr4.agregar(3);
        arr4.agregar(5);

        System.out.println("La lista 1 es una lista? " + arr3.repOK());
        System.out.println("\n");
        System.out.println("Y la lista 4? " + arr5.repOK());

        System.out.println("La lista 1 es igual a la lista 2? " + arr1.equals(arr2));
        System.out.println("La lista 1 es igual a la lista 1? " + arr1.equals(arr1));
        





    }



}