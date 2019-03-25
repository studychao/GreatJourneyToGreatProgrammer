# Web Security

TLS??

## Rules
Rule 1 : All data coming from the client is assumed to be malicious until you have properly validated it.

## sessions and cookies
HTTP is stateless.
you send a request, you get a response, the connection ends.
If you send another, http won't know if it comes from same person.

## Cookies
Browsers implement cookies to get state between requests
If a response contains a COOKIE header then all further requests to the same server will include this header.

*Never* include a password or other secret data in a cookie.
*Never* try and authticate people by checking if their name appears in the cookie.Anyone can mannually set user=admin in their cookie.

`Set-Cookie: id = 14d58f7a... ; HttpOnly: Secure;`

HttpOnly : this cookie is not accessible to JS
Secure : this cookie will only be sent for TLS encrypted requests

## Session Hijacking
Session Hijacking is breaking into someone's account by stealing a copy of their session data.
You can make this harder by
- not using predictable session tokens
- using TLS encryption
- expiring inactive session

### Session tokens
`Using java.util.UUID.randomUUID()`

## JWT
JASON WEB TOKEN

## CSRF
CSRF : cross-site request forgery
You click a link on one site that causes an action to log in
CSRF defences
- Check the Referrer and Origin HTTP headers
- If necessary, use per-request CSRF security tokens
- Re-authenticate before critical operations
- For an API,you can add and require custom "X-" headers

## SOP
SOP = Same Origin Policy
Browsers only allow JavaScript requests to the same origin(protocol,host,port) as the source of the script

So a script on forum.example.com cannot launch requests to Bank.example.com

## CORS
CORS : Cross Origin Resource Sharing 
Then you should set the following header in your responses:
Access-Control-Allow-Origin: *

Instead of * , you can whitlist particular domains that are allowed - details at
`https://www.w3.org/TR/cors/`

## TLS
### Idea1
Encrypt ur traffic with a key so that anyone listening in can't understand
Problem: the attacker could be o the path to the real server

###Ideal2
- browsers have root certificates from CAs built in 
- servers buy certificates from CAs

## Password storage
Hashing Password.  
In theory, you should pick a random salt for each user and store hash (salt, password). That way it doesn't show up if users share passwords.

For Java,use `ScryptUtil`
Use a library - don't use you own model unless you got a PHD in this field.

## SQL Injection
A SQL injection vulnerability exists when an application combines user-supplied data with SQL code in a single string. The whole string is parsed as SQL on the server. If the user-supplied data is supposed to be a single-quoted string, then a single quote in the data ends the string prematurely and lets you write almost any SQL query.
