# DB2 Docker for iTests

 ## run db2 docker container
 ```
 docker rm -f db2
 docker run --name db2 -p 50000:50000 -d db2criminal db2start
 ```

 ## checking db2 db and schemas
 Connect to docker console
 ```
 docker exec -it db2 bash
 ```
 
 Substitute user
 ```
 su - db2inst1
 ```
 
 Connect to DB2 console
 ```
 db2
 ```
 
 Connect to iTest DB
 ```
 connect to criminal
 ```
 
 To get list of schemas execute next command:
 ```
 select schemaname from syscat.schemata
 ```
 
 To get list of table in particular schema execute next command:
 ```
 list tables for schema <schemaName>
 ```
 
 To get indexes for particular table execute next command:
 ```
 DESCRIBE INDEXES FOR TABLE <schemaName>.<tableName> SHOW DETAIL
 ```