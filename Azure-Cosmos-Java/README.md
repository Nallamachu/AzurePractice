### Execution Steps

* It can be directly executed from main() from the SyncMain.java file otherwise kindly follow the below steps to execute from Maven.

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
