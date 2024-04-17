# MaskFX

## Descripción
El proyecto es una librería de JavaFX que proporciona una serie de componentes y utilidades para crear interfaces de usuario gráficas (GUI) de forma rápida y eficiente.

## Uso

## Ejemplos
```java
// Ejemplo de cómo crear un botón utilizando la librería JavaFX

En el pom.xml

Agregar repositorio jitpack paara poder usarla 

<repository>
   <id>jitpack.io</id>
   <url>https://jitpack.io</url>
</repository>    

Agregar dependecia

<dependency>
   <groupId>org.bitbucket.tanieska98</groupId>
   <artifactId>maskfx</artifactId>
   <version>1.2</version>
</dependency>

En el archivo xml

Importar el elemento
<?import com.crazycode.mask.elements.MaskField?>

Usar elemento 
<MaskField fx:id="txtIdentityCard" mask="NNN-NNNNNN-NNNNL" />
