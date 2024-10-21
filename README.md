# Proyecto: API de Reservas y Pagos - Spring Boot + GraphQL

## Descripción del Proyecto

Este proyecto consiste en una API que permite gestionar reservas de vuelos y pagos, utilizando **Spring Boot** para el backend, **GraphQL** como tecnología para las consultas y mutaciones, **Docker** para contenerización, y herramientas de monitoreo como **Prometheus** y **Grafana**.

## Requisitos Previos

Asegúrate de tener instaladas las siguientes herramientas en tu sistema:

- **Git**: Para clonar el repositorio.
- **JDK 11**: Para compilar y ejecutar la aplicación Spring Boot.
- **Maven**: Para gestionar las dependencias del proyecto.
- **Docker** y **Docker Compose**: Para ejecutar los contenedores de la aplicación y las herramientas de monitoreo.
- **Prometheus** y **Grafana**: Para monitorear el estado del sistema.

## Clonar el Repositorio

Primero, clona este repositorio en tu máquina local:

```bash
git clone https://github.com/usuario/proyecto-reservas-pagos.git
cd proyecto-reservas-pagos
```

Instrucciones para Ejecución con Docker
El proyecto está configurado para ejecutarse en contenedores Docker. Sigue los pasos a continuación para desplegarlo:

Asegúrate de tener Docker y Docker Desktop instalados en tu máquina. Construye y levanta los contenedores:

```bash
docker-compose up --build
```

Este comando hará lo siguiente:

1. Levantará el backend con Spring Boot.
2. Creará la base de datos MySQL en un contenedor.
3. Configurará Prometheus para recopilar métricas del sistema.
4. Desplegará Grafana para visualizar las métricas recopiladas.

## Monitoreo del Sistema:

Para acceder a las caracteristicas de monitoreo, tenemos las rutas disponibles de:

1. Prometheus
Prometheus estará ejecutándose en el puerto `9090`. Accede a través de:

```bash
http://localhost:9090
```

2. Grafana estará disponible en el puerto 3000. Como el proyecto es meramente académico, puedes utilizar las siguientes credenciales para iniciar sesión:

- **Usuario**: `admin`
- **Contraseña**: `admin`

Accede a Grafana a través de:

```bash
http://localhost:3000
```

