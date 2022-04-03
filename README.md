# PolePositionCR


### ¿Cómo compilar el programa?

* Instalar __C__ (MinGW)
* Descargar CSFML
* Desde el directorio src, ejecutar en cmd:

      C:\MinGW\bin\gcc main.c -L"C:\csfml\lib\gcc" -lcsfml-system -lcsfml-window -lcsfml-graphics -lcsfml-audio -lcsfml-network -I"C:\csfml\include" -o main.exe

Nota: 

La estructura del comando anterior se puede estructurar como: 
1. Dirección a la carpeta gcc en el directorio donde se encuentra instalado C. (C:\MinGW\bin\gcc)
2. Archivo a compilar. (main.c)
3. Dirección a carpeta gcc en el directorio donde se encuentra descargado CSFML. (-L"C:\Users\caman\Downloads\csfml\lib\gcc")
4. Archivos requeridos de la dirección anterior. ( -lcsfml-system -lcsfml-window -lcsfml-graphics -lcsfml-audio -lcsfml-network)
5. Dirección a carpeta include, en el direcotorio donde se encuentra descargado CSFML. (-I"C:\Users\caman\Downloads\csfml\include")
6. Nombre del ejecutable a crear. (-o main.exe)

__La anterior estuctura es solo una interpretación simplificada y no exacta de los comandos mencionados.__

### ¿Cómo ejecutar el programa?

Antes de ejecutar el archivo .exe generado al compilar el programa, será necesario agregar todos los archivos.dll
que se encuentran en la carpeta bin de CSFML, al directorio en el que se encuentre el ejecutable.
Una vez hecho esto, basta con abrir el programa ejecutable(.exe).