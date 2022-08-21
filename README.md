# Iouring_Biller_SpringBoot
1.Login-Api
The API gets in the username and Password of a username.Then the api performs authentication and returns a cookie
Format:localhost:8080/login?name=<username>&password=<password>
2. Add Product API
The API gets the details as a JSON in request body and posts it.
Format: http://localhost:8080/add-product
3. Search Product API
(i)By Product code:
Gets product_code and returns the product details
e.g:http://localhost:8080/search?code=<product_code>
(ii)By Product Name:
Gets product_name and returns the product details
Format:localhost:8080/search?name=<product_name>
4. Billing API
The api gets either product_code or product_name and quantity and returns the Total amount with tax details
Format:http://localhost:8080/bill?code=<product_code>&quantity=<?>
