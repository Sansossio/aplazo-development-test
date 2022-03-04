FROM nikolaik/python-nodejs:latest

WORKDIR /app

COPY . .

RUN yarn

RUN yarn build

CMD ["yarn", "start:prod"]
