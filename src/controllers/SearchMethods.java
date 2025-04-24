package controllers;

import models.Person;

public class SearchMethods {

    //Busqueda por Edad
    public int binarySearchByAge(Person[] persons, int edad){
        int bajo = 0;
        int alto = (persons.length - 1);

        while(bajo <= alto){

            int central = (bajo + alto)/2;

            if(persons[central].getAge() == edad){ // caso en el que el numero buscado coincide con el central calculado
                return central;
            }

            if(persons[central].getAge() < edad){ //nos vamos a la derecha, se actualiza el bajo
                bajo = central + 1;
            }else {
                alto = central - 1;
            }
        }
        return -1;
    }

    //Busqueda por Nombre
    public int binarySearchByName(Person[] persons, String nombre){
        int bajo = 0;
        int alto = (persons.length - 1);

        while(bajo <= alto){

            int central = (bajo + alto)/2;

            if(persons[central].getName().compareToIgnoreCase(nombre) == 0){ //si es ==0 significa que las comparaciones entre ambos nombres coinciden 
                return central;
            }

            if(persons[central].getName().compareToIgnoreCase(nombre) < 0){ //si alfabeticamente se encuentra antes, va a la derecha
                bajo = central + 1;
            }else {
                alto = central - 1;
            }
        }
        return -1;
    }
    
    //Metodo que verifica si el arreglo esta ordenado, si lo está, pasamos directamente al metodo busqueda 
    public boolean isSortByAge(Person[] persons){ 
        for(int i = 0; i < persons.length - 1; i++){
            if(persons[i].getAge() > persons[i + 1].getAge()){ //si el valor en i es mayor al siguiente valor, quiere decir que
                return false;                                  //NO esta ordenado
            }
        }
        return true;
    }

    //Metodo que verifica si el arreglo está ordenado por nombre
    public boolean isSortByName(Person[] persons){
        for(int i = 0; i < persons.length - 1; i++){
            if(persons[i].getName().compareToIgnoreCase(persons[i + 1].getName()) > 0 ){
                return false; //  retorna false, si el arreglo esta desordenado
            }
        }
        return true; // no se debe ordenar
    }
}
