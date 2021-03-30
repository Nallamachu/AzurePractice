### Execution Steps

* It can be directly executed from main() from the SyncMain.java file otherwise kindly follow the below steps to execute from Maven.
* You have to configure the HOST and MASTER_KEY/PRIMARY_KEY in codebase to connect with Cosmos DB.

```bash
git clone https://github.com/Azure-Samples/azure-cosmos-java-getting-started.git
```

* From a command prompt or shell, run the following command to compile and resolve dependencies.

```bash
cd azure-cosmos-java-getting-started
mvn clean package
```

* From a command prompt or shell, run the following command to run the application.

```bash
mvn exec:java -DACCOUNT_HOST=YOUR_COSMOS_DB_HOSTNAME -DACCOUNT_KEY=YOUR_COSMOS_DB_MASTER_KEY
```

### Execution Output:
JRE Oracle Corporation/12.0.2 is not supported, advanced source lookup disabled: Unsupported class file major version 56.

Using Azure Cosmos DB endpoint: https://cosmossqldatabase.documents.azure.com:443/

SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".

SLF4J: Defaulting to no-operation (NOP) logger implementation

SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.

======== Connected with HOST and MASTER_KEY ========

Create database ToDoList if not exists.

Checking database ToDoList completed!


Create container Items if not exists.

Checking container Items completed!

Scale container Items to 500 RU/s.

Scaled container to 500 completed!

* Adding families to create

Created item with request charge of 9.90 within duration PT13.7207226S

Created item with request charge of 15.05 within duration PT0.6874489S

Created 2 items with total request charge of 24.95

* Reading items.

Item successfully read with id Andersen-1617078692171 with a charge of 1.00 and within duration PT0.7811977S

Item successfully read with id Wakefield-1617078692171 with a charge of 1.00 and within duration PT0.6718358S

* Querying items.

Got a page of query result with 2 items(s) and request charge of 3.07

Item Ids [Andersen-1617078692171, Wakefield-1617078692171]

Demo complete, please hold while resources are released

Closing the client
