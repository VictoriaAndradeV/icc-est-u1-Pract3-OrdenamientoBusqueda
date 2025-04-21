package models;

public class Person {
    private String name; //atributos de Person
    private int age;

    public Person(){ //Constructor vacío
    }

    public Person(String name, int age) { 
        this.name = name;
        this.age = age;
    }

    //Creacion de Getters y Setters 
    public String getName() { 
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    } 

    
}
