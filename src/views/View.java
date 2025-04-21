package views;
import java.util.Scanner;
import models.Person;

public class View {
    private Scanner scanner = new Scanner(System.in);

    public int showMenu(){
        System.out.println("--------- Menu --------- ");
        System.out.println("1. Agregar Persona");
        System.out.println("2. Mostrar personas agregadas");
        System.out.println("3. Seleccione un método de Ordenamiento");
        System.out.println("4. Seleccione un método de Busqueda");
        System.out.println("5. Mostrar resultados de Busqueda");
        System.out.println("6. Salir");
        int opcion = validarOpcion(scanner, 1, 6);
        return opcion;
    }

    //se crea un objeto persona
    public Person inputPerson(){
        System.out.println("Ingrese los siguientes datos: ");
        String name = validarIngresoNombre(scanner);
        int age = validarIngresoEdad(scanner);
        return new Person(name, age);
    }

    //Permite seleccionar el Metodo de Ordenamiento
    public int selectSortingMethod(){
        System.out.println("Seleccione un Método de Ordenamiento");
        System.out.println("1. Ordenamiento Burbuja, ordenado por nombre");
        System.out.println("2. Metodo de Seleccion, ordenado por nombre");
        System.out.println("3. Metodo Insercion, ordenado por edades");
        System.out.println("4. Metodo Insercion, ordenado por nombre");
        int opcion = validarOpcion(scanner, 1, 4); 
        return opcion;
    }
    //seleccionamos el metodo de busqueda que el usuario desee
    public int selectSearchCriterion(){
        System.out.println("Seleccione un Método de Busqueda");
        System.out.println("1. Busqueda Binaria, por edad");
        System.out.println("2. Busqueda Binaria, por nombre");
        int opcion = validarOpcion(scanner, 1, 2);
        return opcion;
    }

    //Muestra el listado de personas
    public void displayPersons(Person[] persons){
        if((persons == null) || (persons.length == 0)){
            System.out.println("No existen personas registradas.");
        } else {
            System.out.println("------ Listado de personas registradas ------");
            for(int i = 0; i < persons.length; i++){
                System.out.println("Persona " +(i + 1)+ "--> " +persons[i]); //se imprime con ayuda del toString
            }
        }
    }

    //inputAge sirve para ingresar la edad a buscar 
    public int inputAge(){
        System.out.println("Ingrese la edad que desea buscar -->");
        int edad = validarIngresoEdad(scanner);
        return edad;
    }
    //ingresamos el nombre que se desea buscar
    public String inputName(){
        System.out.println("Ingrese el Nombre que desea buscar -->");
        String nombre = validarIngresoNombre(scanner);
        return nombre;
    }

    //Valida el ingreso de opciones 
    public int validarOpcion(Scanner scanner, int min, int max){ //al usar min y max, podemos usar este mismo metodo
        int num;                                                 // para validar demas ingresos de opciones de los menus 

        do { 
            System.out.println("Ingrese una opcion: ");

            if(scanner.hasNextInt()){ //validar ingreso de numeros
                num = scanner.nextInt();
                scanner.next();

                if((num < min) || (num > max)){ //validar que el rango de edad
                    System.out.println("Ingrese una opcion valida desde -> " +min+" hasta " +max);
                }else{
                    return num;
                }
            } else{
                System.out.println("Ingrese unicamente numeros, no letras ni caracteres especiales");
                scanner.next(); //limpiar token invalido ingresado, para evitar que scanner se trabe 
            }   
        } while (true);
    }


    //valida el ingreso de letras, en nombre
    public String validarIngresoNombre(Scanner scanner){
        String nombre;

        do { 
            System.out.println("Nombre --> ");
            nombre = scanner.nextLine().trim(); //acepta el ingreso de nombres con espacios

            if(nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")){ //valida el ingreso de un string valido, con letras de todo el alfabeto
                
                return nombre;                                 //valida tildes, Ñ - ñ
            } else {
                System.out.println("Ingrese unicamente letras, no numeros");
            }
            
        } while (true);
    }

    //Validar el ingreso de edad
    public int validarIngresoEdad(Scanner scanner){
        int edad;

        do { 
            System.out.println("Edad --> ");

            if(scanner.hasNextInt()){ //validar ingreso de numeros
                edad = scanner.nextInt();

                if((edad < 0) || (edad > 110)){ //validar que el rango de edad
                    System.out.println("Ingrese un rango de edad desde 0(aun no ha cumplido un año) hasta 110");
                }else{
                    return edad;
                }
            } else{
                System.out.println("Ingrese unicamente numeros, no letras ni caracteres especiales");
                scanner.next(); //limpiar token invalido ingresado, para evitar que scanner se trabe 
            }   
        } while (true);
    }
}
