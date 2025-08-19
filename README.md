# Proyecto de ejemplo para Jenkins (Java + Maven + JUnit)

Este proyecto envuelve tu archivo Java (`Calculadora.java`) en una estructura Maven,
agrega una prueba JUnit y un `Jenkinsfile` que:
- Clona el repo desde GitHub (Pipeline from SCM).
- Compila y ejecuta pruebas.
- Publica **reportes JUnit** y archiva artefactos.

## Estructura
```
pom.xml
Jenkinsfile
src/main/java/Calculadora.java
src/test/java/CalculadoraTest.java
```

## Requisitos en Jenkins
- JDK (por ejemplo **jdk21**) configurado en *Manage Jenkins → Tools*.
- Maven (por ejemplo **Maven3**) configurado en *Manage Jenkins → Tools*.
- Plugins: Pipeline, Git, JUnit.

## Pasos
1. Sube este contenido a un repositorio público de GitHub.
2. En Jenkins: *New Item → Pipeline* → **Pipeline script from SCM** → **Git** → pega la URL del repo.
3. Asegúrate de que `Jenkinsfile` está en la raíz y que los nombres de tools
   del bloque `tools` coinciden con los que configuraste en Jenkins.
4. Ejecuta el build. Verás el reporte de pruebas en **Test Result**.

> El test prueba `dividir(8,4) == 2.0` si existe un método `dividir(int,int)`. 
> Si tu implementación actual realiza multiplicación, el build fallará mostrando el detalle del test.
