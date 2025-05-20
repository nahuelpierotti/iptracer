# iptracer
Api desarrollada en Java para obtener datos del pais de origen de una direccion de ip

## Deployment

Para deployar el proyecto es necesario contar docker y en la raiz de la carpeta del proyecto ejecutar:

```bash
  ./mvnw clean package -DskipTests

  y una vez generado el .jar ejecutar:

  docker-compose up --build
```

La api cuenta con 2 enpoints:
- El primero que recibe el parametro de la ip y devuelve datos relacionados al pais

```bash
http://localhost:8080/api/country/info?ip=190.210.54.129
```

La respuesta sera un json con la siguiente informacion:

```bash
{
  "Hora: ": "06:33:36 (UTC) 03:33:36 (UTC-03:00)",
  "Cotization: ": "1281.70 Euros",
  "ISO Code: ": "AR",
  "Idiomas: ": "Spanish",
  "Pais: ": "Argentina",
  "Moneda: ": "ARS- Argentine peso",
  "IP: ": "190.210.54.129"
}
```
- El segundo que devuelve las estadisticas
```bash
http://localhost:8080/api/country/statistics
```
La respuesta sera un json con la siguiente informacion:

```bash
{
  {
  "Max Distance: ": 19432,
  "Min Distance: ": 4,
  "Average Distance: ": 5959.894736842105,
  "File3": {
    "country": "Argentina",
    "distance": 4,
    "invocations": 10
  },
  "File2": {
    "country": "Spain",
    "distance": 10045,
    "invocations": 2
  },
  "File1": {
    "country": "United States",
    "distance": 8703,
    "invocations": 4
  },
  "File0": {
    "country": "South Korea",
    "distance": 19432,
    "invocations": 3
  }
}
}
```
El proyecto cuenta con un servicio de Request Coalescing por ip para prevenir multiples llamadas desde la misma ip y cachear distribuidamente el resultado. 

Consideraciones pendientes de desarrollo:
- Tiene puestas unas credenciales gratuitas para los servicios de Fixer.io y ipapi, cuando las mismas lleguen a los 100 request el .jar dejara de funcionar.
- Resiliencia: generar un esquema de reintentos y prevencion de fallos en las llamadas a las apis.
- Manejo de errores centralizado, implementar un handler y a su vez generar un buen manejo de logging.
