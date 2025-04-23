package controllers;
import models.Person;

public class SortingMethods {

    /*
     * Metodo de ordenamiento burbuja mejorado, ordena por nombre el arreglo de personas
     * 
     * Dentro del if
     * cuando es > 0 quiere decir que persons[j] va despues de persons[j+1]
     */
    public void sortByNameWithBubble(Person[] persons){
      
        for(int i = 0; i < persons.length; i++){
            for (int j = 0; j < persons.length - i - 1; j++){ //SE OMITE comparar posiciones ya ordenadas 
                					                           
                if(persons[j].getName().compareToIgnoreCase(persons[j + 1].getName()) > 0){ 
                    Person aux = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = aux;  
                }
            } 
        }
    }

    /*
     * Método Ordenamiento Selección, ordena por nombre, es decir alfabéticamente
     * De forma DESCENDENTE
     */
    public void sortByNameWithSelection(Person[] persons){
        int indiceMax;

        for(int i = 0; i < persons.length - 1; i++){    //NO necesitamos llegar hasta el final del arreglo

            indiceMax = i; //Toma como si el número mayor estuviera en la posición i

	        //SEGUNDO FOR, sirve para encontrar la posición del número menor del arreglo
            for(int j = i + 1; j < persons.length; j++){                 
                if(persons[j].getName().compareToIgnoreCase(persons[indiceMax].getName()) > 0){ //si el valor de j es mayor al guardado en arreglo[indiceMax]
                        indiceMax = j;                                                          //hacemos que indiceMax tome el valor de la posición de dicho numero
                }
            } 
            
            //Se intercambia unicamente cuando se ha encontrado otro valor menor diferente al tomado por referencia (indiceMin = i)
            if(indiceMax != i){ 
                Person aux = persons[i]; 
                persons[i] = persons[indiceMax];
                persons[indiceMax] = aux;
            }
        }
    }

    public void sortByAgeWithInsertion(Person[] persons){

        for(int i = 1; i < persons.length; i++){
            Person pasajero = persons[i];
            int j = i - 1; 
	    
	        //j recorre hacia la izquierda 
	        //si j es mayor al valor de pasajero, se cambian de lugar

            while(j >=  0 && (persons[j].getAge() > pasajero.getAge())){ // si el arreglo[j] es mayor a pasajeros, entra dentro del bucle
                persons[j + 1] = persons[j];
                j--; 
            }
		
            persons[j + 1] = pasajero;
        }
    }

    public void sortByNameWithInsertion(Person[] persons){

        Person pasajero;
     
        for(int i = 1; i < persons.length; i++){
            pasajero = persons[i];
            int j = i - 1; 
	    
	        //j recorre hacia la izquierda 
	        //si j es mayor al valor de pasajero, se cambian de lugar

            while(j >=  0 && (persons[j].getName().compareToIgnoreCase(pasajero.getName()) > 0)){ // si el arreglo[j] es mayor a pasajeros, entra dentro del bucle
                persons[j + 1] = persons[j];
                j--; 
            }
		
	        //si encontre un valor mayor a la izquierda de pasajero, cambiamos de orden
            persons[j + 1] = pasajero;
        }
    }
}
