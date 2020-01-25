FROM node:latest as dev-stage

RUN mkdir /app
WORKDIR /app
COPY ./frontend/package.json .
RUN npm install
COPY ./frontend .
EXPOSE 8081
CMD ["npm", "run", "serve"]