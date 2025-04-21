package controllers;

public class SortingMethods {

    //Ordenar por nombre, con ordenamiento Burbuja Mejorado
    public void sortByNameWithBubble(int[] arreglo){
        int aux;
      
        for(int i = 0; i < arreglo.length; i++){

            for (int j = 0; j < arreglo.length - i - 1; j++){ //SE OMITE comparar posiciones ya ordenadas 
                					                           
                if(arreglo[j] > arreglo[j + 1]){
                    aux = arreglo[j]; 
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;  
                }
            } 
        }
    }

    //Método Ordenamiento Selección 
    public void sortByNameWithSelection(int[] arreglo){
        int aux;
        int indiceMin;

        for(int i = 0; i < arreglo.length - 1; i++){    //NO necesitamos llegar hasta el final del arreglo

            indiceMin = i; //Toma como si el número menor estuviera en la posición i

	        //SEGUNDO FOR, sirve para encontrar la posición del número menor del arreglo
            for(int j = i + 1; j < arreglo.length; j++){                 
                if(arreglo[j] < arreglo[indiceMin]){ //si el valor de j es menor al guardado en arreglo[indiceMin]
                        indiceMin = j;   //hacemos que indiceMin tome el valor de la posición de dicho numero
                        
                }
            } 
            
            //Se intercambia unicamente cuando se ha encontrado otro valor menor diferente al tomado por referencia (indiceMin = i)
            if(indiceMin != i){ 
                aux = arreglo[i]; 
                arreglo[i] = arreglo[indiceMin];
                arreglo[indiceMin] = aux;
            }
        }
    }

    public void sortByAgeWithInsertion(int[] arreglo){

        int pasajero;
     
        for(int i = 1; i < arreglo.length; i++){
            pasajero = arreglo[i];
            int j = i - 1; 
	    
	        //j recorre hacia la izquierda 
	        //si j es mayor al valor de pasajero, se cambian de lugar

            while(j >=  0 && (arreglo[j] > pasajero)){ // si el arreglo[j] es mayor a pasajeros, entra dentro del bucle
                arreglo[j + 1] = arreglo[j];
                j--; 
            }
		
	        //si encontre un valor mayor a la izquierda de pasajero, cambiamos de orden
            if(arreglo[j + 1] != pasajero){
                arreglo[j + 1] = pasajero;
            }
        }
    }

    public void sortByNameWithInsertion(int[] arreglo){

        int pasajero;
     
        for(int i = 1; i < arreglo.length; i++){
            pasajero = arreglo[i];
            int j = i - 1; 
	    
	        //j recorre hacia la izquierda 
	        //si j es mayor al valor de pasajero, se cambian de lugar

            while(j >=  0 && (arreglo[j] > pasajero)){ // si el arreglo[j] es mayor a pasajeros, entra dentro del bucle
                arreglo[j + 1] = arreglo[j];
                j--; 
            }
		
	        //si encontre un valor mayor a la izquierda de pasajero, cambiamos de orden
            if(arreglo[j + 1] != pasajero){
                arreglo[j + 1] = pasajero;
            }
        }
    }

}
