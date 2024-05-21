# mysql  
This project contains the database tables that were part of a group project that I reworked into my foodApp project. That project contains fewer tables. This was an exercise in mapping MySQL tables using Hibernate without Spring. Tested with MySQL version 8.0.28.

Project uses   
* Hibernate
* Lombok
* Junit

## Docker

### Start database
```
docker build -t mysql-db .
```
```
docker run --net mysqlnet --name foodmysqldb -p 3306:3306 -e MYSQL_DATABASE=${MYSQL_DATABASE} -e MYSQL_USER=${MYSQL_USER} -e MYSQL_PASSWORD=${MYSQL_PASSWORD} -e MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD} mysql-db
```

### Run tests with Maven
```
docker build -t mysql-test-img .
```
```
docker run --net mysqlnet --name foodmysql mysql-test-img
```

## Docker Compose
Create .env file in the project root and define these variables
```
MYSQL_DATABASE=<fill_in>
MYSQL_USER=<fill_in>
MYSQL_PASSWORD=<fill_in>
MYSQL_ROOT_PASSWORD=<fill_in>
MYSQL_PORT=<fill_in>

DB_URL=<fill_in>
DB_USERNAME=<fill_in>
DB_PASSWORD=<fill_in>
```

Then run `docker-compose up`

Tests fail the first run since the database isn't up yet, so rerun them.
