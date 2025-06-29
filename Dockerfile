# Usa una imagen con Java 21, ya que tu código requiere Java 21
FROM eclipse-temurin:21-jdk

# Establece la carpeta de trabajo dentro del contenedor
WORKDIR /app

# Copia todos los archivos del proyecto al contenedor
COPY . /app

# Da permisos de ejecución al wrapper de Maven (si usas ./mvnw)
RUN chmod +x ./mvnw

# Construye el proyecto (sin ejecutar pruebas)
RUN ./mvnw clean package -DskipTests

# Ejecuta el .jar generado (reemplaza el nombre si es distinto)
CMD ["java", "-jar", "target/users-service-0.0.1-SNAPSHOT.jar"]
