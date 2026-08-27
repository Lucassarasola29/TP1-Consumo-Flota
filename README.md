TP1 - Consumo de Flota

Materia: Programación II
Profesor: Fernández Carbonell, Cesar Augusto
Integrantes: Lucas sarasola

Descripción del Proyecto Este repositorio contiene una solución en Java para controlar el consumo de combustible y la eficiencia de una flota de camiones de transporte de carga.

Programas Incluidos Viaje.java: Registra los datos de un viaje individual, calcula el rendimiento y emite un informe formateado. Flota.java: Registra los viajes de una flota de 6 camiones, calcula estadísticas consolidadas y clasifica la eficiencia de cada unidad.

Instrucciones de Compilación y Ejecución desde Consola

Compilar bash javac Viaje.java javac Flota.java

PREGUNTAS 1- El problema viene por como maneja java los numeros enteros al hacer divisiones, Si el total de kilómetros o la cantidad de camiones hubieran sido variables de tipo entero (int), al hacer la división total / cantidad, Java hace una "división entera". Como lo resolvimos seria hacerlo con un double para que entienda que necesitamos como resultado numeros decimales. 
2-Protección del código estable: Si al escribir los cálculos o armar el informe el programa dejaba de compilar por algún error, el código de la carga de datos que ya funcionaba en main quedaba 100% a salvo. 
3-