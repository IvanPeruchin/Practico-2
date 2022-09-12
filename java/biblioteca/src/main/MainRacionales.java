package main;

import racionales.Racionales;

public class MainRacionales{
    public static void main(String[] args){
        Racionales rac1 = new Racionales(1,3);
        Racionales rac2 = new Racionales(5,7);
        Racionales rac3 = new Racionales(2,4);
        Racionales rac4 = new Racionales(1,3);
        Racionales rac5 = new Racionales(2,3);
        System.out.println("Los numeros racionales son: \n" + rac1 + "\n" + rac2 + "\n" + rac3 + "\n" + rac4 );

        System.out.println("La suma de " + rac1 + " y " + rac3 + " es: " + rac1.suma(rac3));
        System.out.println("La suma de " + rac1 + " y " + rac1 + " es: " + rac1.suma(rac1));
        System.out.println("La resta de " + rac2 + " y " + rac3 + " es: " + rac2.resta(rac3));
        System.out.println("La resta de " + rac1 + " y " + rac3 + " es: " + rac1.resta(rac3));
        System.out.println("La resta de " + rac5 + " y " + rac4 + " es: " + rac5.resta(rac4));

        System.out.println(rac2 + " y " + rac3 + " son iguales? " + "\n RESPUESTA: " + rac2.equals(rac3));
        System.out.println(rac1 + " y " + rac4 + " son iguales? " + "\n RESPUESTA: " + rac1.equals(rac4));
    }


}