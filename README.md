# Cinco Noches en la Poli

Un juego de terror inspirado en la saga de juegos indie FIVE NIGTHS AT FREDDYS desarrollado por Scott Cawthon y leyendas urbanas de la Escuela Politécnica Nacional (EPN). Desarrollado con [libGDX](https://libgdx.com/) y generado con [gdx-liftoff](https://github.com/libgdx/gdx-liftoff), este proyecto busca sumergir a los jugadores en una experiencia aterradora basada en eventos paranormales y desapariciones dentro del campus.

## Sinopsis

> **DIARIO EL COMERCIO**\
> *"Prefiero perder la vida a perder el semestre y perdió los dos"*
>
> Dos jóvenes de la EPN son encontrados desvividos y desaparecen los poliperros...

En *Cinco Noches en la Poli*, tomas el papel de un estudiante que quedó atrapado dentro de la EPN tras una larga jornada de estudio. Sin embargo, lo que parecía una simple noche de desvelo se convierte en una lucha por la supervivencia cuando descubres que no estás solo. Criaturas misteriosas, leyendas urbanas de la Politécnica y los inquietantes "poliperros" acechan en cada esquina. ¿Podrás sobrevivir cinco noches y descubrir la verdad?

![poliFNAF](https://github.com/user-attachments/assets/66acab9c-33a1-4293-bb1c-b17d4d03982c)


---

## Plataformas

Este proyecto está dividido en los siguientes módulos:

- ``: Módulo principal con la lógica del juego compartida entre todas las plataformas.
- ``: Plataforma de escritorio principal utilizando LWJGL3.
- ``: Plataforma móvil para dispositivos Android (requiere SDK de Android).
- ``: Plataforma para iOS usando RoboVM.
- ``: Versión web usando GWT y WebGL (solo soporta proyectos en Java).

---

## Instalación y Ejecución

Este proyecto utiliza [Gradle](https://gradle.org/) para gestionar dependencias. Se incluye el Gradle Wrapper, por lo que puedes ejecutar tareas de Gradle con `gradlew.bat` en Windows o `./gradlew` en macOS/Linux.

### Comandos Útiles

- `build`: Compila el proyecto y genera los archivos ejecutables.
- `clean`: Elimina la carpeta `build` con archivos compilados.
- `lwjgl3:run`: Inicia la versión de escritorio.
- `android:lint`: Realiza una validación del proyecto Android.
- `html:dist`: Compila la versión web, disponible en `html/build/dist`.
- `html:superDev`: Ejecuta la versión web en modo desarrollo ([localhost:8080/html](http://localhost:8080/html)).

Para ejecutar una versión específica del proyecto, usa `nombre_modulo:tarea`, por ejemplo:

```sh
./gradlew lwjgl3:run  # Ejecutar versión de escritorio
./gradlew android:assembleDebug  # Compilar APK para Android
```

---

## Descarga

📥 **Descarga el APK**: [Enlace de descarga](#) *(Próximamente)*

📺 **Gameplay**: [Ver en YouTube](#) *(Próximamente)*

---

## Autores

- **[Mateo Garzon]** - Programación y diseño.
- **[Luis Guaygua]** - Programación y diseño.
- **[Eduardo Caza]** - Historia y sonido.
- **[Yuverly Verdezoto]** - Arte e Interfaces.

¿Tienes preguntas o sugerencias? Contáctanos en [*teamkhaoselmly@gmail.com*](mailto\:teamkhaoselmly@gmail.com).

---

## Licencia

Este proyecto está bajo la licencia MIT.
Desarrollado por el Team Khaos

![Game Store](https://github.com/user-attachments/assets/c3f9d08d-edcf-417f-8d26-a3a22791d604)

