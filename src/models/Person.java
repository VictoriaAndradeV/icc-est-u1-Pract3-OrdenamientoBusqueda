package models;

/*
 * Representa el modelo de datos, permite crear objetos tipo Person, con atributos nombre y edad
 */

public class Person {
    private String name; //atributos de Person
    private int age;

    public Person(){ //Constructor vacío
    } 

    //Sobrecarga de constructores, pasamos parámetros
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

    @Override
    public String toString() {
        return "Person [Name = " + name + ", Age = " + age + "]";
    }
    
}
