# synch-demo

## Synopsis

This project demonstrates one possible solution for synchronising data to a RESTful web service from a legacy platform that is not exposed via a RESTful web service.

Customer data is used as the example domain. The legacy application exposes a database for integration. JDBC is used to access this database. The Spring Integration project is used to demonstrate how the details of the legacy application can be hidden for the rest of the integration process. So, if the legacy application is replaced, it should be easy to modify the integration to work with a new application.

## Installation

* Get the code

```
git clone https://github.com/donnd-t/synch-demo.git
cd synch-demo
```

* Build and run Microservice application

```
cd synch-demo-microservice
mvn package
java -jar ...
```

* Bulid and run Integration application

```
cd ../synch-demo-integration
mvn package
java -jar ...
```

## Demo

### Microservice application

* Check there are no customers

```
curl http://localhost:8080/customer
```

* Create a customer (Windows)

```
curl -i -X POST -H "Content-Type:application/json" -d "{  \"name\" : \"test\" }" http://localhost:8080/custome
```

* Check for your customer

```
curl http://localhost:8080/customer
```

* Search for your customer

```
curl http://localhost:8080/customer/search/findByName?name=test
```

### Integration application

* Connect with H2 Client

Download and install H2 client from [here](http://www.h2database.com/html/main.html). Start H2 console. A browser window will open. Login with the following details:

|Attribute|Value|
| ------------- |-------------|
|Driver Class| org.h2.Driver |
|JDBC URL| jdbc:h2:mem:testdb |
|User Name| sa |
|Password| <blank> |

Click "Connect".

* Insert a customer into the integration source database:

```sql
insert into customer(name) values ('new customer')
```

* Check customer has been created in Microservice

```
curl http://localhost:8080/customers
```



