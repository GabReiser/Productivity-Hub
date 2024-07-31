# Primeiro estágio: Construir o aplicativo Angular
FROM node:20.16.0 AS build-angular
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build --prod

# Segundo estágio: Servir o aplicativo Angular
FROM nginx:alpine
COPY --from=build-angular /app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
