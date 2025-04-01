FROM eclipse-temurin:17-jdk-alpine AS build

COPY target/catalog-service-1.0-SNAPSHOT.jar catalog-service.jar

FROM eclipse-temurin:17-jre-alpine

COPY --from=build /catalog-service.jar /catalog-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/catalog-service.jar"]
