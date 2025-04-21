package controllers;
import models.Person; //importamos el paquete de la clase view
import views.View;

//Controla no muestra informacion ni implementa algoritmos de busqueda y ordenamiento, solo coordina
public class Controller {
    private View views;
    private Person[] persons;
    private SortingMethods sortingMethods; //no necesitamos importar la clase porque se encuentra en el mismo paquete
    private SearchMethods searchMethods;
    
    public Controller(View views, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.views = views;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
        this.persons = new Person[0];
    }

    public void start(){
        boolean a = true;

        while(a){
            int opcion = views.showMenu();

            switch(opcion){

                case 1:
                    inputPerson();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    a = false; 
                    break;
            }
        }
        
    }

    public void inputPerson(){
        Person newPerson = views.inputPerson();
        addPerson(newPerson);
    }

    public void addPerson(Person person){
        if(persons == null){ //si el arreglo esta vacio, se crea un arreglo con una posicion
            persons = new Person[1];
            persons[0] = person; //se asigna a la primera persona ingresada, a la primera posicion del arreglo
        } else { //si el arreglo ya contiene mas presonas 
            Person arreglo[] = new Person[persons.length + 1]; //guarda personas anteriores + la ingresada
            
            for(int i = 0; i < persons.length; i++){
                arreglo[i] = persons[i];
            }
            arreglo[arreglo.length - 1] = person;
            persons = arreglo;
        }
    }



}
