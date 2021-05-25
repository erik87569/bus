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
