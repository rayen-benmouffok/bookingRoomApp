# Utiliser une image Node.js comme base
FROM node:latest

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier les fichiers du projet Angular dans le conteneur
COPY . .

# Installer les dépendances du projet
RUN npm install

# Exposer le port 4200 sur le conteneur
EXPOSE 4200

# Commande pour démarrer l'application Angular
CMD ["npm", "start"]
