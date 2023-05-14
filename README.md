# Contact Management System

The contact management system is a tool that allows you to organize and keep track of your contacts. With this system, you can create, update, delete, and search for contacts. The system provides basic authentication security to ensure that only authorized users can access and modify the contacts.

## APIs
To use the system, you can make HTTP requests to the API endpoints using HTTP client. The available endpoints include:

- **`GET /contacts/search`**: retrieve a list of contacts filtered by first name, last name, or email. Searching can be done on the basis of first name starting with, last name starting with, or email ID equal to the result, or any combination of these can be filtered accordingly.
- **`POST /contacts/create`**: create a new contact
- **`POST /contacts/create/batch`**: create multiple contacts in batch
- **`PUT /contacts/update`**: update an existing contact by first name and last name
- **`DELETE /contacts/delete`**: delete an existing contact by first name and last name

To search for contacts, you can use the GET /contacts/search endpoint and provide query parameters to filter the results based on criteria such as first name, last name, or email.
E.g : `/contacts/search?firstName="r"&lastName="z"` will result in contacts starting with firstname 'r' and lastname 'z'.

To create a new contact, you can use the POST /contacts/create endpoint and provide the required fields such as first name, last name, email, and phone number in the request body.

To create multiple contacts in batch, you can use the POST /contacts/create/batch endpoint and provide a list of contact details in the request body.

To update an existing contact, you can use the PUT /contacts/update endpoint and provide the first name and last name of the contact to update, along with the updated contact details in the request body.

To delete an existing contact, you can use the DELETE /contacts/delete endpoint and provide the first name and last name of the contact to delete.

## Security
All endpoints require authentication using Basic Auth, where only admin is allowed access. To access the API, you must provide a username and password. For now, you can use the following credentials:

**username: `user`**

**password: `lousing360`**

## Documentation
The API documentation is implemented using OpenAPI docs and can be accessed at the following URL after running the program: http://localhost:8080/swagger-ui/index.html#/. The OpenAPI docs provide a detailed description of each endpoint and its parameters, along with example requests and responses.