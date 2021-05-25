# bus

Build quarkus back-end:
```
cd bus-api
./mvnw clean verify
```
    
Then:

```
cd ..
docker-compose -f dev.yml build
docker-compose -f dev.yml up
```

You can also start the backend with:
```
cd bus-api
./mvnw compile quarkus:dev
```

And the front end:
```
cd bus-web
npm run start
```

When everything is started access the web-site on http://localhost:3000
