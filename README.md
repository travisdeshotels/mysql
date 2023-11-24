# mysql  
This project contains the database tables that were part of a group project that I reworked into my foodApp project. That project contains fewer tables. This was an exercise in mapping MySQL tables using Hibernate without Spring. Tested with MySQL version 8.0.28.

Project uses   
* Hibernate
* Lombok
* Junit

## Docker

### Start database
`docker build -t mysql-db .`
`docker run --net mysqlnet --name foodmysqldb -p 3306:3306 -e MYSQL_DATABASE=${MYSQL_DATABASE} -e MYSQL_USER=${MYSQL_USER} -e MYSQL_PASSWORD=${MYSQL_PASSWORD} -e MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD} mysql-db`

### Run tests with Maven
`docker build -t mysql-test-img .`
`docker run --net mysqlnet --name foodmysql mysql-test-img`
