# Utiliser une image OpenJDK comme base
FROM openjdk:latest

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le jar de l'application Spring dans le conteneur
COPY target/amayasApp-0.0.1-SNAPSHOT.jar .

# Exposer le port 8080 sur le conteneur
EXPOSE 8080

# Commande pour démarrer l'application Spring
CMD ["java", "-jar", "amayasApp-0.0.1-SNAPSHOT.jar"]
