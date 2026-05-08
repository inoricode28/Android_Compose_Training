# App Patitas Compose

Aplicación móvil Android desarrollada con Jetpack Compose para la gestión de mascotas y voluntarios.

## 1. INFORMACIÓN GENERAL DEL PROYECTO

| Campo | Valor |
|-------|-------|
| Nombre del Proyecto | App Patitas Compose |
| Paquete | pe.idat.apppatitas_compose |
| Versión | 1.0 |
| Versión de Código | 1 |

## 2. TECNOLOGÍAS UTILIZADAS

### 2.1 Framework y Lenguaje

| Tecnología | Versión | Descripción |
|------------|---------|-------------|
| Kotlin | 1.9.0 | Lenguaje de programación principal |
| Android SDK | Compile SDK 34 | SDK de compilación |
| Min SDK | 24 | Versión mínima de Android soportada (Android 7.0) |
| Target SDK | 34 | Versión objetivo de Android |
| Android Gradle Plugin | 8.5.0 | Plugin de Gradle para Android |

### 2.2 Frameworks y Librerías de Desarrollo

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| Jetpack Compose | BOM 2024.04.01 | Framework moderno de UI declarativa |
| Compose Material 3 | 1.6.8 | Biblioteca de componentes Material Design 3 |
| Hilt | 2.48 | Framework de inyección de dependencias |
| Retrofit | 2.9.0 | Cliente HTTP para APIs REST |
| Gson Converter | 2.9.0 | Serializador/Deserializador JSON |
| Room | 2.6.1 | Base de datos local SQLite |
| Navigation Compose | 2.7.7 | Biblioteca de navegación entre pantallas |
| Coil | 2.0.0 | Carga y cacheo de imágenes |
| Lifecycle Runtime | 2.8.3 | Ciclo de vida de componentes Android |
| Activity Compose | 1.9.0 | Integración de Compose con Activity |
| Material Icons Extended | 1.6.8 | Biblioteca extendida de iconos Material |

## 3. ARQUITECTURA DEL PROYECTO

### 3.1 Patrón de Diseño

La aplicación utiliza **Clean Architecture** con el patrón **MVVM** (Model-View-ViewModel), estructurado en tres capas:

- **UI Layer** (Capa de Presentación): Composables y ViewModels
- **Domain Layer** (Capa de Dominio): Casos de uso (Use Cases)
- **Data Layer** (Capa de Datos): Repositorios, Servicios y Entidades

### 3.2 Estructura de Capas

| Capa | Descripción |
|------|-------------|
| auth | Módulo de autenticación (Login y Registro) |
| home | Módulo principal (Gestión de mascotas y voluntarios) |
| core | Utilidades compartidas (BD, Retrofit, Navegación) |
| ui/theme | Tema visual de la aplicación |

## 4. ESTRUCTURA COMPLETA DEL PROYECTO

```
apppatitas-compose/
├── .gradle/
│   └── 8.7/
├── .idea/
├── app/
│   ├── build.gradle.kts
│   ├── proguard-rules.pro
│   └── src/
│       ├── main/
│       │   ├── AndroidManifest.xml
│       │   ├── java/pe/idat/apppatitas_compose/
│       │   │   ├── MiApp.kt
│       │   │   ├── MainActivity.kt
│       │   │   ├── auth/
│       │   │   │   ├── data/
│       │   │   │   │   ├── network/
│       │   │   │   │   │   ├── request/
│       │   │   │   │   │   │   ├── LoginRequest.kt
│       │   │   │   │   │   │   └── RegistroRequest.kt
│       │   │   │   │   │   └── response/
│       │   │   │   │   │       ├── LoginResponse.kt
│       │   │   │   │   │       └── RegistroResponse.kt
│       │   │   │   │   ├── service/
│       │   │   │   │   │   └── AuthService.kt
│       │   │   │   │   └── repository/
│       │   │   │   │       ├── AuthRepository.kt
│       │   │   │   │       └── PersonaAuthRepository.kt
│       │   │   │   ├── domain/
│       │   │   │   │   ├── LoginUseCase.kt
│       │   │   │   ���   ├── RegistroUseCase.kt
│       │   │   │   │   └── RegistroPersonaUseCase.kt
│       │   │   │   └── view/
│       │   │   │       ├── LoginScreen.kt
│       │   │   │       ├── RegistroScreen.kt
│       │   │   │       └── viewmodel/
│       │   │   │           ├── LoginViewModel.kt
│       │   │   │           └── RegistroViewModel.kt
│       │   │   ├── home/
│       │   │   │   ├── data/
│       │   │   │   │   ├── network/
│       │   │   │   │   │   ├── request/
│       │   │   │   │   │   └── VoluntarioRequest.kt
│       │   │   │   │   └── response/
│       │   │   │   │       ├── MascotaResponse.kt
│       │   │   │   │       └── VoluntarioResponse.kt
│       │   │   │   │   ├── service/
│       │   │   │   │   │   └── MascotaService.kt
│       │   │   │   │   └── repository/
│       │   │   │   │       ├── MascotaRepository.kt
│       │   │   │   │       └── PersonaHomeRepository.kt
│       │   │   │   ├── domain/
│       │   │   │   │   ├── MascotaUseCase.kt
│       │   │   │   │   ├── ObtenerPersonaUseCase.kt
│       │   │   │   │   ├── ActualizarPersonaUseCase.kt
│       │   │   │   │   ├── EliminarPersonaUseCase.kt
│       │   │   │   │   └── VoluntarioUseCase.kt
│       │   │   │   └── view/
│       │   │   │       ├── HomeScreen.kt
│       │   │   │       ├── MascotaScreen.kt
│       │   │   │       ├── VoluntarioScreen.kt
│       │   │   │       └── viewmodel/
│       │   │   │           ├── MascotaViewModel.kt
│       │   │   │           └── VoluntarioViewModel.kt
│       │   │   ├── core/
│       │   │   │   ├── bd/
│       │   │   │   │   ├── PersonaEntity.kt
│       │   │   │   │   ├── PersonaDao.kt
│       │   │   │   │   ├── PatitasDatabase.kt
│       │   │   │   │   └── PatitasDbModule.kt
│       │   │   │   ├── retrofit/
│       │   │   │   │   ├── PatitasClient.kt
│       │   │   │   │   └── RetrofitModule.kt
│       │   │   │   ├── ruta/
│       │   │   │   │   └── RutaPatitas.kt
│       │   │   │   └── util/
│       │   │   │       ├── Evento.kt
│       │   │   │       └── MenuItem.kt
│       │   │   └── ui/theme/
│       │   │       ├── Color.kt
│       │   │       ├── Theme.kt
│       │   │       └── Type.kt
│       │   └── res/
│       │       ├── drawable/
│       │       ├── mipmap-mdpi/
│       │       ├── mipmap-hdpi/
│       │       ├── mipmap-xhdpi/
│       │       ├── mipmap-xxhdpi/
│       │       ├── mipmap-xxxhdpi/
│       │       ├── mipmap-anydpi-v26/
│       │       ├── values/
│       │       │   ├── colors.xml
│       │       │   │   ├── strings.xml
│       │       │   │   └── themes.xml
│       │       └── xml/
│       │           ├── backup_rules.xml
│       │           └── data_extraction_rules.xml
│       ├── test/
│       └── androidTest/
├── gradle/
│   └── libs.versions.toml
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
└── local.properties
```

## 5. PERMISOS Y CONFIGURACIÓN

### 5.1 Permisos

| Permiso | Descripción |
|---------|-------------|
| INTERNET | Permite el acceso a red para consumir APIs REST |

### 5.2 Componentes de la Aplicación

| Componente | Clase | Descripción |
|------------|-------|-------------|
| Aplicación | MiApp | Clase principal con anotación @HiltAndroidApp |
| Actividad Principal | MainActivity | Actividad principal de la aplicación |

## 6. DESCRIPCIÓN DE MÓDULOS

### 6.1 Módulo auth (Autenticación)

Encargado de la gestión de usuarios:

- **Login**: Pantalla de inicio de sesión
- **Registro**: Pantalla de registro de nuevos usuarios
- **Servicios**: AuthService para comunicación con API
- **Repositorios**: AuthRepository, PersonaAuthRepository

### 6.2 Módulo home (Principal)

Gestión de contenido principal:

- **HomeScreen**: Pantalla principal de la aplicación
- **MascotaScreen**: Gestión de mascotas
- **VoluntarioScreen**: Gestión de voluntarios
- **Servicios**: MascotaService para comunicación con API
- **Repositorios**: MascotaRepository, PersonaHomeRepository

### 6.3 Módulo core (Utilidades)

Configuraciones y utilidades compartidas:

- **bd/**: Configuración de Room Database (PatitasDatabase)
- **retrofit/**: Configuración del cliente HTTP (PatitasClient)
- **ruta/**: Definición de rutas de navegación
- **util/**: Utilidades generales (Evento, MenuItem)

## 7. RECURSOS

### 7.1 Recursos de Valores

| Archivo | Descripción |
|---------|-------------|
| colors.xml | Definición de colores de la aplicación |
| strings.xml | Cadenas de texto de la aplicación |
| themes.xml | Definición de temas y estilos |

### 7.2 Recursos Drawable

- ic_launcher_background.xml
- ic_launcher_foreground.xml
- imgsplash.png
- imgperfil.png

### 7.3 Recursos mipmap

Iconos de la aplicación en diferentes densidades (mdpi, hdpi, xhdpi, xxhdpi, xxxhdpi) y versión adaptativa para Android 8.0+.

## 8. CONFIGURACIÓN DE BUILD

### 8.1 Build Types

- **Debug**: Configuración de desarrollo
- **Release**: Configuración de producción (minifyEnabled = false)

### 8.2 Compiladores

- Kotlin Compiler Extension: 1.5.1 (para Compose)
- Java Compatibility: VERSION_1_8

## 9. HERRAMIENTAS DE DESARROLLO

- **IDE**: Android Studio / IntelliJ IDEA
- **Build System**: Gradle (wrapper)
- **Control de Versiones**: Git