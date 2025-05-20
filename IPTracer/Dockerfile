FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app
# Copy source code and Maven wrapper
COPY . .

# Build the application without running tests
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine

COPY --from=builder /app/target/IPTracer-0.0.1-SNAPSHOT.jar iptracer.jar

# Run the application
ENTRYPOINT ["java","-jar","iptracer.jar"]