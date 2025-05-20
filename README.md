# iptracer
Api desarrollada en Java para obtener datos del pais de origen de una direccion de ip

## Deployment

Para deployar el proyecto es necesario contar docker y en la raiz de la carpeta del proyecto ejecutar:

```bash
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
