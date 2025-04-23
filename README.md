# Práctica 3 Métodos de Ordenamiento y Búsqueda Binaria

## 📌 Información General

- **Título:** Métodos Ordenamiento y Búsqueda
- **Asignatura:** Estructura de Datos
- **Carrera:** Computación
- **Estudiante:** Victoria Andrade
- **Fecha:** 22 de abril de 2025
- **Profesor:** Ing. Pablo Torres

---

## 🛠️ Descripción

Dentro de la práctica se han implementado clases como View, Controller, Person, en distintos paquetes, para poder organizar nuestro código y sus funcionaliades por paquete. De esta forma, dentro del método main, solo se llaman a los métodos implementados, lo que promueve a una mejor práctica de programación.

Dentro de la práctica se han implementado varios métodos como son:

- Método Burbuja
- Método Selección
- Método Inserción
- Método Burbuja Mejorado

Ordenando un objeto tipo persona, el cual tiene dos atributos, nombre y edad.
En donde algunos de los métodos de ordenamiento, ordenan el arreglo de personas ingresado, por nombre o edad.

Además de poder buscar un objeto Person, buscando por nombre y edad, con la ayuda de el Método de Búsqueda Binaria.

---

## 🚀 Ejecución

Para ejecutar el proyecto:

1. Compila el código:
    ```bash
    javac App.java
    ```
2. Ejecuta la aplicación:
    ```bash
    java App
    ```

---

## 🧑‍💻 Ejemplo de Entrada

```plaintext
Seleccione el método de ordenamiento:
--------- Menu --------- 
1. Agregar Persona
2. Mostrar personas agregadas
3. Seleccione un método de Ordenamiento
4. Seleccione un método de Busqueda
5. Salir
Ingrese una opcion: 1

Ingrese los siguientes datos: 
Nombre --> Victoria
Edad --> 20

--------- Menu ---------
1. Agregar Persona
2. Mostrar personas agregadas
3. Seleccione un método de Ordenamiento
4. Seleccione un método de Busqueda
5. Salir
Ingrese una opcion: 1
Nombre --> Erika
Edad --> 33

--------- Menu ---------
1. Agregar Persona
2. Mostrar personas agregadas
3. Seleccione un método de Ordenamiento
4. Seleccione un método de Busqueda
5. Salir
Ingrese una opcion: 1
Nombre --> Joaquin
Edad --> 53

--------- Menu ---------
1. Agregar Persona
2. Mostrar personas agregadas
3. Seleccione un método de Ordenamiento
4. Seleccione un método de Busqueda
5. Salir
Ingrese una opcion: 2

------ Listado de personas registradas ------
Persona 1--> Person [Name = Victoria, Age = 20]
Persona 2--> Person [Name = Erika, Age = 33]
Persona 3--> Person [Name = Joaquin, Age = 53]

--------- Menu ---------
1. Agregar Persona
2. Mostrar personas agregadas
3. Seleccione un método de Ordenamiento
4. Seleccione un método de Busqueda
5. Salir
Ingrese una opcion: 3

Seleccione un Método de Ordenamiento
1. Ordenamiento Burbuja, ordenado por nombre
2. Metodo de Seleccion, ordenado por nombre
3. Metodo Insercion, ordenado por edades
4. Metodo Insercion, ordenado por nombre
5. Salir
Ingrese una opcion: 2

Listado de personas ordenado correctamente
------ Listado de personas registradas ------
Persona 1--> Person [Name = Victoria, Age = 20]
Persona 2--> Person [Name = Joaquin, Age = 53]
Persona 3--> Person [Name = Erika, Age = 33]

--------- Menu ---------
1. Agregar Persona
2. Mostrar personas agregadas
3. Seleccione un método de Ordenamiento
4. Seleccione un método de Busqueda
5. Salir
Ingrese una opcion: 4
Ingrese la edad que desea buscar -->
Edad --> 53

Persona encontrada --> Person [Name = joaquin, Age = 53]

```

---
