# FitLog MVP

## Integrantes
- Alexander Manuel Vilca Tapia
- Camila Fuentes Zuniga

## Brief
FitLog - Tracker personal de rutinas offline

## Descripción
Aplicación Android desarrollada con Kotlin y Jetpack Compose que permite registrar sesiones de entrenamiento, visualizar historial y consultar detalles de cada rutina sin conexión a internet.

## Funcionalidades
- Registro de sesiones con ejercicios
- Visualización de historial ordenado
- Detalle de sesión con ejercicios
- Cambio de estado (completado / pendiente)
- Eliminación de sesiones

## Arquitectura
Se utilizó el patrón MVVM:
- ViewModel maneja el estado con StateFlow
- UI observa cambios reactivos
- Repository simula persistencia en memoria

## Decisiones técnicas

1. Se utilizó StateFlow en ViewModel para mantener la UI reactiva sin acoplar lógica de negocio.
2. Se modeló la relación sesión-ejercicio como 1:N usando listas, permitiendo escalar a ROOM.
3. Se implementó Navigation Compose con paso de parámetros (ID) para navegación desacoplada entre pantallas.
4. Se utilizó Material Design 3 para mantener consistencia visual.

## Video
(agregar link)

## Screenshots
<img width="1080" height="2400" alt="Screenshot_20260504_142718_FitLog" src="https://github.com/user-attachments/assets/7df5ee36-b73e-49b9-bec0-6e574a154307" />
<img width="1080" height="2400" alt="Screenshot_20260504_142712_FitLog" src="https://github.com/user-attachments/assets/9dc699f4-5a18-4613-b448-def15e8ecaf3" />
<img width="1080" height="2400" alt="Screenshot_20260504_142706_FitLog" src="https://github.com/user-attachments/assets/d6515929-b8a7-4730-b0c7-8aa127e5f68a" />
