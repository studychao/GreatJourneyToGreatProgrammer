#Tips&Notes for HTML

## PUT & POST
- If URL objects are named explicitly, use *PUT*;If you let the server decide, then POST.
- PUT is idempotent, if you put an object twice, it has no effect.
- You can update/create a resource with PUT with the same URL
- With POST you can have 2 requests coming in the same time making modifications to a URL.

### Example

POST:
Used to modify and update a resource
```
Post /questions/<existing_question> HTTP/1.1
Host: www.example.com/
```
Note the following is wrong.
```
POST /questions/<new_question> HTTP/1.1
Host: www.example.com/
```
If the URL is not yet created, you should not be using POST to create it while specifying the name.This should result
in a 'resource not found'

PUT:

Used to create a resource, or overwrite it. While you specify the resources new URL.

For a new resource:
```
PUT /questions/<new_question> HTTP/1.1
Host: www.example.com/
```
To overwrite an existing resource:
```
PUT /questions/<existing_question> HTTP/1.1
Host: www.example.com/
```

## GET
GET requests are the most common and widely used methods in APIs and websites. Simply put, the GET method is used to retreive data from a server at the specified resource. 