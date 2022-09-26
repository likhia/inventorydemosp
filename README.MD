# Set up Astra Database 

- Create 2 databases in Astra DB.   One is Transactional and another one is Analytical. 
- Create inventory_by_category table in both DB. 
```
CREATE TABLE inventory_by_category (
    category text,
    product_id uuid,
    price double,
    product_name text,
    quantity int,
    PRIMARY KEY (category, product_id)
) WITH CLUSTERING ORDER BY (product_id ASC);
```
- Enable CDC for inventory_by_category

# Set up Astra Streaming 

- Create Astra Streaming Tenant 
- Create a topic called inventory under default namespace
- Create a sink in default namespace with sink as AstraDB.  Select topic as inventory.  Select inventory_by_category table in Transactional DB. 
- Make the mapping is as below.  Make sure category and product_id are mapped to key.* as shown below. 
```
*category=key.category*, *product_id=key.product_id*, price=value.price, product_name=value.product_name, quantity=value.quantity
```
- Create another sink in astracdc namespace with sink as AstraDB. Select topic as data-*.inventory_by_category.  Set inventory_by_category table in Analytical DB. 
- Make the mapping is as below.  Make sure category and product_id are mapped to key.* as shown below. 
```
*category=key.category*, *product_id=key.product_id*, price=value.price, product_name=value.product_name, quantity=value.quantity
```

# Configure the src/main/resources/application.yml

- Configure Astra Streaming properties
``` 
pulsar: 
  url: <Astra Streaming URL>
  token: <Astra Streaming Token>
  topic: <Astra Stream Topic>
```

- Configure Astra DB (Transactional) properties
``` 
db: 
  id: <Astra DB Id>
  region: <Astra DB Region>
  keyspace: <Astra DB KeySpace>
  token: <Astra DB Token>
```
- Configure Astra DB (Analytical) properties
``` 
db2: 
  id: <Astra DB Id>
  region: <Astra DB Region>
  keyspace: <Astra DB KeySpace>
  token: <Astra DB Token>
```

# Run application

- Open Terminal.  Run mvn clean compile

- Run mvn spring-boot:run