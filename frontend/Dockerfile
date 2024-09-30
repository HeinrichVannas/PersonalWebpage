FROM node:18
WORKDIR /react/
COPY package*.json /react/
RUN npm install
COPY /public/ /react/public
COPY /src/ /react/src
RUN npm run build
EXPOSE 3000
CMD ["npm", "start"]