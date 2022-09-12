package racionales; 

/**
*La clase Racionales representa numeros racionales
*Sus atributos son:
*<numerador>
*<denominador>
*/


public class Racionales {

    // numerador
    private long numerador;
    //denominador siempre positivo
    private long denominador;

    public Racionales(){
        numerador = 0;
        denominador = 1;
    }

    /**
    * Construye un nuevo numero racional.
    * @param numerador :es el numerador.
    * @param denominador :es el denominador siempre positivo.
    */
    public Racionales(long numerador, long denominador){
        this.numerador = numerador;
        this.denominador = denominador;
    }

    /**
    * set
    * Define el numerador del nro racional.
	* @param num : el nuevo numerador del nro racional.
	*/
    public void numerador(long num){
        this.numerador = num;
    }

    /**
    * get
	* Retorna el numerador del racional.
	* @return el numerador.
	*/
    public long numerador(){
        return numerador;
    }

    /**
	* Define el denominador del nro racional.
	* @param den : el nuevo denominador del nro racional.
	*/
    public void denominador(long den){
        this.denominador = den;
    }

    /**
	* Retorna el denominador del racional.
	* @return el denominador.
	*/
    public long denominador(){
        return denominador;
    }


    /**
    *Metodo que suma 2 racionales
    *@param r numero racional    
    */
    public Racionales suma(Racionales r){
        Racionales rac = new Racionales();
        long den=0;
        long num=1;

        if (this.denominador() == r.denominador()){
            den = r.denominador();
            num = this.numerador() + r.numerador(); 
        } else {
            den = (this.denominador() * r.denominador());
            num = ((this.denominador() * r.numerador()) + (this.numerador() * r.denominador()));
        }        
        
        rac.denominador(den);
        rac.numerador(num);
        
        return rac;       
    }

     /**
    *Metodo que resta 2 racionales
    *@param r numero racional    
    */
    public Racionales resta(Racionales r){
        Racionales rac = new Racionales();
        long den=0;
        long num=1;
        
        if (this.denominador() == r.denominador()){
            den = r.denominador();
            num = this.numerador() - r.numerador(); 
        } else {
            den = (this.denominador() * r.denominador());
            num = ((this.denominador() * r.numerador()) - (this.numerador() * r.denominador()));
        }    
        
        rac.denominador(den);
        rac.numerador(num);
        return rac;       
    }




    @Override
	public boolean equals(Object otro){
        if(!(otro instanceof Racionales)){
            return false;
        } else {
            Racionales otroRacional = (Racionales) otro;
            return (numerador * otroRacional.denominador()) == (denominador * otroRacional.numerador());
        }
    }



    @Override
    public String toString(){
        return numerador() + "/" + denominador();
    }













}