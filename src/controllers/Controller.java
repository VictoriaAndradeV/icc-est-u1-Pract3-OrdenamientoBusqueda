package controllers;
import models.Person; //importamos el paquete de la clase view
import views.View;

//Controller no muestra informacion ni implementa algoritmos de busqueda y ordenamiento, solo coordina
public class Controller {
    private final View views;
    private Person[] persons;
    private final SortingMethods sortingMethods; //no necesitamos importar la clase porque se encuentra en el mismo paquete
    private final SearchMethods searchMethods;
    
    public Controller(View views, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.views = views;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
        this.persons = new Person[] {};
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
                    views.displayPersons(persons);
                    break;
                case 3:
                    sortPersons();
                    break;
                case 4:
                    searchPerson();
                    break;
                case 5: 
                    a = false;
            }
        }
    }

    public void inputPerson(){
        Person newPerson = views.inputPerson();
        addPerson(newPerson);
    }
    /*
     * cada que el usuario seleccione la opción 1 del menu
     * se irán agregando nuevos objetos persona al arreglo
     */
    public void addPerson(Person person){
        Person arreglo[] = new Person[persons.length + 1]; //guarda personas anteriores + la ingresada
            
        for(int i = 0; i < persons.length; i++){
            arreglo[i] = persons[i];
        }
        arreglo[arreglo.length - 1] = person;
        persons = arreglo;
    
    }
    //Método que ordena el arreglo de personas, por los diferentes métodos de ordenamiento
    public void sortPersons(){
        if((persons == null) || (persons.length == 0)){
            System.out.println("No hay registros de personas por ordenar");
        }
        int opcion = views.selectSortingMethod();

        switch(opcion){
            case 1: 
                sortingMethods.sortByNameWithBubble(persons);
                break;
            case 2:
                sortingMethods.sortByNameWithSelection(persons);
                break;
            case 3:
                sortingMethods.sortByAgeWithInsertion(persons);
                break;
            case 4:
                sortingMethods.sortByNameWithInsertion(persons);
                break;
            case 5:
                break;
        }

        System.out.println("Listado de personas ordenado correctamente");
        views.displayPersons(persons); //imprime el arreglo de personas ordenado
    }
    
    public void searchPerson(){
        if((persons == null) || (persons.length == 0)){
            System.out.println("No hay registros de personas por buscar");
        }

        int opcion = views.selectSearchCriterion();

        switch(opcion){
            case 1:
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
                break;
            case 2:
                //Busqueda por nombre
                if(!searchMethods.isSortByName(persons)){
                    sortingMethods.sortByNameWithSelection(persons);
                }
                String nombreBuscado = views.inputName();
                int indice = searchMethods.binarySearchByName(persons, nombreBuscado);

                if(indice >= 0){ //quiere decir que si se encontro la persona 
                    views.displaySearchResult(persons[indice]);
                }else{
                    views.displaySearchResult(null);
                }
                break;
            case 3:
                break;
        }
    }
}
