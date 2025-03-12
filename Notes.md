# Set Up
1. install oracle 
https://www.oicbasics.com/2020/01/download-oracle-database-11g-xe-express.html 11g

# JDBC
## jdbc type
1. JDBC-ODBC bridge
2. Native-API driver
3. Network-Protocol driver (Middleware driver)
4. Database-Protocol driver (Pure Java driver) or thin driver.

## sql 
```
DML:
  Select
  Insert
  Update
  Delete
  Merge

DDL:
  Create
  Alter
  Rename
  Truncate
  Drop


TCL:
 Commit
 Rollback
 Save
  

DCL:
 Grant
 Revoke

```

### create connection object
1. step 1: Load the driver
```
oracle:
download jar file: ojdbc8.jar
https://www.oracle.com/pk/database/technologies/appdev/jdbc-downloads.html

mysql:
https://dbschema.com/jdbc-driver/mysql.html?srsltid=AfmBOoogp05X9fTHxZ5TgTWYmhdRwufkUAPapt3QI_gClbdZSsrG1FwW

right click to the project -> build path -> configure build path
click on library tab , then click on classpath


```

![build path](image.png)

