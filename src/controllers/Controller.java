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
                case 1 -> inputPerson();
                case 2 -> views.displayPersons(persons);
                case 3 -> sortPersons();
                case 4 -> searchPerson();
                case 5 -> {
                }
                case 6 -> {
                }
                case 7 -> a = false;
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

    public void sortPersons(){
        if((persons == null) || (persons.length == 0)){
            System.out.println("No hay registros de personas por ordenar");
        }
        int opcion = views.selectSortingMethod();

        switch(opcion){
            case 1 -> sortingMethods.sortByNameWithBubble(persons);
            case 2 -> sortingMethods.sortByNameWithSelection(persons);
            case 3 -> sortingMethods.sortByAgeWithInsertion(persons);
            case 4 -> sortingMethods.sortByNameWithInsertion(persons);
            case 5 -> {
            }
        }

        System.out.println("Listado de personas ordenado correctamente");
        views.displayPersons(persons);
    }

    public void searchPerson(){
        if((persons == null) || (persons.length == 0)){
            System.out.println("No hay registros de personas por buscar");
        }

        int opcion = views.selectSearchCriterion();

        switch(opcion){
            case 1 -> {
                //Busqueda por edad
                if(!searchMethods.isSortByAge(persons)){ //
                    sortingMethods.sortByAgeWithInsertion(persons);
                }
                int edadBuscada = views.inputAge();
                int index = searchMethods.binarySearchByAge(persons, edadBuscada);

                if(index >= 0){ //quiere decir que si se encontro la persona
                    views.displaySearchResult(persons[index]);
                }else{ //si no la encuentra es porque retorno -1
                    views.displaySearchResult(null);
                }
            }
            case 2 -> {
                //Busqueda por nombre
                if(!searchMethods.isSortByName(persons)){
                    sortingMethods.sortByNameWithSelection(persons);
                }
                String nombreBuscado = views.inputName();
                int index = searchMethods.binarySearchByName(persons, nombreBuscado);

                if(index >= 0){ //quiere decir que si se encontro la persona 
                    views.displaySearchResult(persons[index]);
                }else{
                    views.displaySearchResult(null);
                }
            }
            case 3 -> {
            }
        }

        

    }

}
