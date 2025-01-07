# Rick And Morty App

Una aplicación desarrollada en Kotlin que lista a los personajes de la popular serie **Rick and Morty**. Permite buscar personajes por nombre y consultar información detallada de cada uno de ellos.

## Características

- Listado completo de personajes de la serie.
- Búsqueda por nombre de personajes.
- Información detallada de cada personaje, incluyendo:
  - Imagen del personaje.
  - Estado (vivo, muerto o desconocido).
  - Especie.
  - Origen.
  - Localización actual.
- Interfaz amigable desarrollada con **Jetpack Compose**.

## Tecnologías utilizadas

- **Lenguaje:** Kotlin
- **Arquitectura:** MVVM (Model-View-ViewModel)
- **Interfaz de usuario:** Jetpack Compose
- **Consumo de API:** Retrofit
- **Gestión de dependencias:** Hilt

## Capturas de Pantalla

### Pantalla Principal
![Pantalla Principal](screensshots/screenshot_home.png)

### Pantalla de Búsqueda
![Pantalla de Búsqueda](screenshots/screenshot_search.png)

### Detalle del Personaje
![Detalle del Personaje](screenshots/screenshot_single.png)

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/DMNOscar/RickAndMortyApp.git
   ```

2. Abre el proyecto en Android Studio.

3. Sincroniza las dependencias con Gradle.

4. Ejecuta la aplicación en un dispositivo o emulador compatible.

## Uso

1. Abre la aplicación y explora la lista de personajes.
2. Usa la barra de búsqueda para encontrar un personaje específico.
3. Selecciona un personaje para ver información detallada.

## API utilizada

Esta aplicación consume los datos de la API pública de **Rick and Morty**:

- [Rick and Morty API](https://rickandmortyapi.com/)

## Estructura del Proyecto

La aplicación sigue una estructura basada en el patrón MVVM:

- **UI (View):** Manejo de la interfaz de usuario usando Jetpack Compose.
- **ViewModel:** Manejo del estado de la UI y lógica de negocio.
- **Model:** Datos obtenidos de la API y representación local.
- **Repositorio:** Fuente de datos para interactuar con la API y/o almacenamiento local.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tus cambios:
   ```bash
   git checkout -b mi-nueva-funcionalidad
   ```
3. Realiza tus cambios y confirma los cambios:
   ```bash
   git commit -m "Añadida nueva funcionalidad"
   ```
4. Envía un pull request.

## Autor

Desarrollado por [Oscar Daniel Martinez Nuñez](https://github.com/DMNOscar).

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

