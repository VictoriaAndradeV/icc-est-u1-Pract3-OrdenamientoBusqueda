package views;
import java.util.Scanner;
import models.Person;

/*
 * Interfaz que gestiona la interacción con el usuario, solicita entradas y muestra salidas
 */

public class View {
    private final Scanner scanner = new Scanner(System.in);

    //Menú de opciones, retorna un valor tipo int, al seleccionar una opción
    public int showMenu(){
        System.out.println("--------- Menu --------- ");
        System.out.println("1. Agregar Persona");
        System.out.println("2. Mostrar personas agregadas");
        System.out.println("3. Seleccione un método de Ordenamiento");
        System.out.println("4. Seleccione un método de Busqueda");
        System.out.println("5. Salir");
        int opcion = validarOpcion(scanner, 1, 5); //metodo que valida la entrada de numeros en el rango 1-5
        return opcion;                                     //valida el ingreso de numeros, no permite ingresar letras o caracteres especiales
    }

    /**
     *
     * Se asignan valores a los atributos de persona
     * @return objeto tipo Person con los valores agregados
     */
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
        System.out.println("5. Salir");
        int opcion = validarOpcion(scanner, 1, 5); 
        return opcion;
    }

    //seleccionamos el metodo de busqueda que el usuario desee
    public int selectSearchCriterion(){
        System.out.println("Seleccione un Método de Busqueda");
        System.out.println("1. Busqueda Binaria, por edad");
        System.out.println("2. Busqueda Binaria, por nombre");
        System.out.println("3. Salir");
        int opcion = validarOpcion(scanner, 1, 3);
        return opcion;
    }

    /*
     * Muestra el listado de las personas ingresadas
     */
    public void displayPersons(Person[] persons){
        if((persons == null) || (persons.length == 0)){ //condicion cuando no se ha registriado ninguna persona
            System.out.println("No existen personas registradas.");
        } else {
            System.out.println("------ Listado de personas registradas ------");
            for(int i = 0; i < persons.length; i++){
                System.out.println("Persona " +(i + 1)+ "--> " +persons[i]); //se imprime con ayuda del toString
            }
        }
    }
    
    /**
     * Metodo que nos muestra los resultados de busqueda
     *@param se está pasando un objeto persona, porque solo queremos imprimir
     *la persona si esta fue encontrada, mas no el arreglo de personas 
     */
    public void displaySearchResult(Person persons){
        if(persons != null){
            System.out.println("Persona encontrada --> " +persons);
        } else {
            System.out.println("La persona que buscaba, no ha sido encontrada" );
        }   
    }

    //inputAge sirve para ingresar la edad a buscar 
    public int inputAge(){
        System.out.println("Ingrese la edad que desea buscar -->");
        int edad = validarIngresoEdad(scanner); //valida el ingreso de numeros 
        return edad;
    }
    //ingresamos el nombre que se desea buscar
    public String inputName(){
        System.out.println("Ingrese el Nombre que desea buscar -->");
        String nombre = validarIngresoNombre(scanner);
        return nombre;
    }

    /**
     * Valida el ingreso de opciones 
     * al usar min y max, podemos usar este mismo método
     * para validar demas ingresos de opciones de los menus 
     * @param scanner, nos sirve para reutilizar la instancia de Scanner,
     * sin tener que crear una nueva en cada método
     * @return num cuando se ingresa un valor dentro del rango y que este sea numérico
     */
    
    public int validarOpcion(Scanner scanner, int min, int max){
        int num;                                                 

        do { 
            System.out.println("Ingrese una opcion: ");

            if(scanner.hasNextInt()){ //validar ingreso de numeros
                num = scanner.nextInt(); 
                scanner.nextLine(); //limpia el buffer de entrada del Scanner

                if((num < min) || (num > max)){ //condición cuando se ingresa un valor fuera de los mostrados en el menú
                    System.out.println("Ingrese una opcion valida desde -> " +min+" hasta " +max);
                }else{
                    return num;
                }
            } else{
                System.out.println("Ingrese unicamente numeros, NO letras NI caracteres especiales");
                scanner.nextLine(); //limpiar token invalido ingresado, para evitar que scanner se trabe 
            }   
        } while (true); //se cumple infinitamente hasta que se ingrese una opcion valida
    }

    /*
     * valida el ingreso de letras, en nombre
     * 
     */
    public String validarIngresoNombre(Scanner scanner){
        String nombre;

        do { 
            System.out.println("Nombre --> ");
            nombre = scanner.nextLine().trim(); //acepta el ingreso de nombres con espacios

            if(nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")){ //valida el ingreso de un string valido, con letras de todo el alfabeto
                return nombre;                                 //valida tildes, Ñ - ñ
            } else {
                System.out.println("Ingrese unicamente letras, no numeros, no caracteres especiales");
            }
        } while (true);//se cumple infinitamente hasta que se ingrese una cadena de caracteres válida
    }

    /*
     * Validar el ingreso de edad, para asignar valores a persons y para
     * ingresar la edad que se desea buscar 
     * Valida un rango de edad con 0, cuando la persona tiene meses de edad, hasta 110 anios
     */
    public int validarIngresoEdad(Scanner scanner){
        int edad;

        do { 
            System.out.println("Edad --> ");

            if(scanner.hasNextInt()){ //valida el ingreso de numeros
                edad = scanner.nextInt();

                if((edad < 0) || (edad > 110)){ //ingresa al if si la edad ingresada esta fuera del rango
                    System.out.println("Ingrese un rango de edad desde 0(si aun no ha cumplido un año) hasta 110");
                    scanner.nextLine(); 
                }else{
                    return edad;
                }
            } else{
                System.out.println("Ingrese unicamente numeros, no letras ni caracteres especiales");
                scanner.nextLine(); //limpiar token invalido ingresado, para evitar que scanner se trabe 
            }   
        } while (true);
    }
}
