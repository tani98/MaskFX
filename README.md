# MaskFX

## Descripción
El proyecto es una librería de JavaFX que proporciona una serie de componentes y utilidades para crear interfaces de usuario gráficas (GUI) de forma rápida y eficiente.

## Uso

En el pom.xml

Agregar repositorio jitpack para poder usarla 

```xml
<repository>
   <id>jitpack.io</id>
   <url>https://jitpack.io</url>
</repository>
```

Agregar dependecia

```xml
<dependency>
   <groupId>org.bitbucket.tanieska98</groupId>
   <artifactId>maskfx</artifactId>
   <version>1.2</version>
</dependency>
```

En el archivo fxml

Importar el elemento
```xml
<?import com.crazycode.mask.elements.MaskField?>
```

Aplicar elemento, en mask se debe definir el patrón 
```xml
<MaskField fx:id="txtIdentityCard" mask="NNN-NNNNNN-NNNNL" />
```
