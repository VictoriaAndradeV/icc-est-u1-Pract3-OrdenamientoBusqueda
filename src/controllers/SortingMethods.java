package controllers;
import models.Person;

public class SortingMethods {

    private Person[] persons;
    //todos los metodos ordenan el arreglo Person[] de forma ascendente 
    //Ordenar por nombre, con ordenamiento Burbuja Mejorado
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

    //Método Ordenamiento Selección 
    public void sortByNameWithSelection(Person[] persons){
        int indiceMin;

        for(int i = 0; i < persons.length - 1; i++){    //NO necesitamos llegar hasta el final del arreglo

            indiceMin = i; //Toma como si el número menor estuviera en la posición i

	        //SEGUNDO FOR, sirve para encontrar la posición del número menor del arreglo
            for(int j = i + 1; j < persons.length; j++){                 
                if(persons[j].getName().compareToIgnoreCase(persons[indiceMin].getName()) < 0){ //si el valor de j es menor al guardado en arreglo[indiceMin]
                        indiceMin = j;   //hacemos que indiceMin tome el valor de la posición de dicho numero
                        
                }
            } 
            
            //Se intercambia unicamente cuando se ha encontrado otro valor menor diferente al tomado por referencia (indiceMin = i)
            if(indiceMin != i){ 
                Person aux = persons[i]; 
                persons[i] = persons[indiceMin];
                persons[indiceMin] = aux;
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
