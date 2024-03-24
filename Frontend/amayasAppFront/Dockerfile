# Étape de construction
FROM node:16.19.0 as node
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

# Étape de production
FROM nginx:alpine
COPY --from=node /app/dist/amayas-app-front /usr/share/nginx/html
EXPOSE 4200