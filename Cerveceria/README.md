# Trabajo Práctico Cervecería

![Trabajo practico cerveceria](https://github.com/rodrigofanjul/LabV-Git/blob/master/Cerveceria/image.png?raw=true)

## ¿Cuantos consumidores se necesitan para que el stock llegue a 0?

 - No hace falta más de un consumidor para que el stock llegue a 0.
 - Solo se debe tener en cuenta que se deben consumir más cantidad de las que se producen, o bien, que el productor debe frenar al llegar a determinado stock acumulado.

## Bloques synchronized ¿Por que deben serlo?

 - Los bloques deben ser synchronized para que no los acceda más de un proceso a la misma vez.
 - Un recurso compartido es aquel al que tienen acceso distintos procesos y pueden realizar cambios en el mismo.
 - Si no se gestiona el acceso se pueden perder datos durante la escritura.
 
## Formas de instanciar un Thread
Se puede instanciar un Thread de las siguientes formas:

 1. Mediante la imprementación de la Interfaz Runneable.

 `public class BeerConsumer implements Runnable`
 
 2. Extendiendo de la clase Thread.

 `public class BeerConsumer extends Thread`
 
 3. Creando un objeto Thread.
 
 `Thread hilo = new Thread();`