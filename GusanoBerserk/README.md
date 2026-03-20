# GusanoBerserk

Proyecto Maven base con Java 17, Spark Java y Patron Decorator.

## Requisitos

- Java 17
- Maven 3.8+

## Estructura

- `src/main/java/com/gusano/berserk`: interfaz `Personaje`, clases base, decorador abstracto y servidor.
- `src/main/java/com/gusano/berserk/armas`: decoradores de armas.
- `src/main/java/com/gusano/berserk/ropa`: decoradores de ropa.
- `src/main/java/com/gusano/berserk/poderes`: decoradores de poderes.

## Compilar

```bash
mvn clean compile
```

## Ejecutar servidor

Ejecuta `com.gusano.berserk.ServidorRPG` desde tu IDE y abre:

- `http://localhost:8080`

