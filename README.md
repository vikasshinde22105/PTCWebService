#### Technologies used in the project
* __Java__
* __Jersey WS Framework__
* __Spring Framework__
* __Hibernate__
* __Maven__
* __Liquibase__
* __MySQL__
* __Mongo DB__

#### Sample test CURL calls (http://localhost:8400/demows/user - this uses MySQL for persistence)
* __POST__ _Request:_
```
	curl -i -H "Content-Type: application/json" -X POST -d \
	'{
		"username":"johndoe",
		"password":"ǝopuɥoɾ",
		"name_first":"John",
		"name_middle":"M",
		"name_last":"Doe",
		"date_of_birth":14,
		"month_of_birth":10,
		"year_of_birth":1978
	}' 'http://localhost:8400/demows/user'
```

* _Response:_
```
	'{
		"id": 1,
		"username": "johndoe",
		"password": "41a87d0faca541b691f11c6d51874f37b989f0cb1b0075cce599e94f82cbbdfc",
		"name_first": "John",
		"name_middle": "M",
		"name_last": "Doe",
		"user_status": "PENDING",
		"user_status_code": "P",
		"date_of_birth": 14,
		"month_of_birth": 10,
		"year_of_birth": 1978,
		"created_at": 1355386501092,
		"updated_at": 1355386501092
	}'
```

* __PUT__ _Request:_
```
	curl -i -H "Content-Type: application/json" -X PUT -d \
	'{
		"id":"1",
		"username":"johndoe",
		"password":"ǝopuɥoɾ",
		"name_first":"John",
		"name_middle":"M",
		"name_last":"Doe",
		"user_status":"ACTIVE",
		"date_of_birth":14,
		"month_of_birth":10,
		"year_of_birth":1978
	}' 'http://localhost:8400/demows/user/1'
```

* _Response:_
```
	'{
		"id": 1,
		"username": "johndoe",
		"password": "41a87d0faca541b691f11c6d51874f37b989f0cb1b0075cce599e94f82cbbdfc",
		"name_first": "John",
		"name_middle": "M",
		"name_last": "Doe",
		"user_status": "ACTIVE",
		"user_status_code": "A",
		"date_of_birth": 14,
		"month_of_birth": 10,
		"year_of_birth": 1978,
		"created_at": 1355386501092,
		"updated_at": 1355388359982
	}'
```

* __GET (By User ID)__ _Request:_
```
	curl 'http://localhost:8400/demows/user/1'
```

* _Response:_
```
	'{
		"id": 1,
		"username": "johndoe",
		"password": "41a87d0faca541b691f11c6d51874f37b989f0cb1b0075cce599e94f82cbbdfc",
		"name_first": "John",
		"name_middle": "M",
		"name_last": "Doe",
		"user_status": "ACTIVE",
		"user_status_code": "A",
		"date_of_birth": 14,
		"month_of_birth": 10,
		"year_of_birth": 1978,
		"created_at": 1355386501092,
		"updated_at": 1355388359982
	}'
```

* __GET (By UserName)__ _Request:_
```
	curl 'http://localhost:8400/demows/user/username/johndoe'
```

* _Response:_
```
	'{
		"id": 1,
		"username": "johndoe",
		"password": "41a87d0faca541b691f11c6d51874f37b989f0cb1b0075cce599e94f82cbbdfc",
		"name_first": "John",
		"name_middle": "M",
		"name_last": "Doe",
		"user_status": "ACTIVE",
		"user_status_code": "A",
		"date_of_birth": 14,
		"month_of_birth": 10,
		"year_of_birth": 1978,
		"created_at": 1355386501092,
		"updated_at": 1355388359982
	}'
```

* __DELETE__ _Request:_
```
	curl -i -H "Content-Type: application/json" -X DELETE -d \
	'{
		"id":"1",
		"username":"johndoe",
		"password":"ǝopuɥoɾ",
		"name_first":"John",
		"name_middle":"M",
		"name_last":"Doe",
		"date_of_birth":14,
		"month_of_birth":10,
		"year_of_birth":1978
	}' 'http://localhost:8400/demows/user/1'
```

* _Response:_ _[Notice that the user gets marked as 'DELETED' and is not removed from the database]_
```
	'{
		"id": 1,
		"username": "johndoe",
		"password": "41a87d0faca541b691f11c6d51874f37b989f0cb1b0075cce599e94f82cbbdfc",
		"name_first": "John",
		"name_middle": "M",
		"name_last": "Doe",
		"user_status": "DELETED",
		"user_status_code": "D",
		"date_of_birth": 14,
		"month_of_birth": 10,
		"year_of_birth": 1978,
		"created_at": 1355386501092,
		"updated_at": 1355388912852
	}'
```

#### Sample test CURL calls (http://localhost:8400/demows/purchase - this uses MongoDB for persistence)
* __POST__ _Request:_
```
    curl -i -H "Content-Type: application/json" -X POST -d \
    '{
        "billing_address": {
            "first_name" : "Travis",
            "city" : "San Franciso",
            "postal_code" : "94000",
            "street_2" : "Street 2",
            "last_name" : "John",
            "street_1" : "Street 1",
            "country_code" : "US",
            "phone_number" : "415-415-1000",
            "name" : "Travis John",
            "state" : "CA"
        },
        "shipping_address": {
            "first_name" : "Johnny",
            "city" : "San Antonio",
            "postal_code" : "32000",
            "street_2" : "Street 2",
            "last_name" : "Cash",
            "street_1" : "Street 1",
            "country_code" : "US",
            "phone_number" : "420-420-1000",
            "name" : "Johnny Cash",
            "state" : "TX"
        },
        "billing_card": {
            "card_type" : "AMERICAN_EXPRESS",
            "card_number" : "kIXI51g+t88DJjaNguPMEQ==",
            "security_code" : "1004",
            "expiration_month" : 3,
            "expiration_year" : 2020,
            "encryption_type" : "sha512"
        },
        "user_ip_address": "127.127.127.127",
        "email": "test@test.com",
        "invoice_number": "INVOICE123",
        "client_id": "CLIENT124",
        "user_id": "PERSON123",
        "order_number": "WON123",
        "create_date": "MAR-21-2013",
        "transaction": {
            "currency_code" : "USD",
            "transaction_amount" : "1099.99"
        }
    }' 'http://localhost:8400/demows/purchase'
```

* _Response:_
```
	'{
       "id" : "5159d6d9456668495a2de972",
       "order_number" : "WON123",
       "create_date" : "MAR-21-2013",
       "user_ip_address" : "127.127.127.127",
       "transaction" : {
         "currency_code" : "USD",
         "transaction_amount" : "1099.99"
       },
       "invoice_number" : "INVOICE123",
       "user_id" : "PERSON123",
       "billing_address" : {
         "first_name" : "Travis",
         "city" : "San Franciso",
         "postal_code" : "94000",
         "street_3" : null,
         "street_2" : "Street 2",
         "last_name" : "John",
         "street_1" : "Street 1",
         "country_code" : "US",
         "phone_number" : "415-415-1000",
         "name" : "Travis John",
         "state" : "CA"
       },
       "shipping_address" : {
         "first_name" : "Johnny",
         "city" : "San Antonio",
         "postal_code" : "32000",
         "street_3" : null,
         "street_2" : "Street 2",
         "last_name" : "Cash",
         "street_1" : "Street 1",
         "country_code" : "US",
         "phone_number" : "420-420-1000",
         "name" : "Johnny Cash",
         "state" : "TX"
       },
       "client_id" : "CLIENT124",
       "billing_card" : {
         "card_type" : "AMERICAN_EXPRESS",
         "card_number" : "kIXI51g+t88DJjaNguPMEQ==",
         "security_code" : "1004",
         "expiration_month" : "3",
         "expiration_year" : "2020",
         "encryption_type" : "sha512"
       },
       "email" : "test@test.com"
     }'
```
