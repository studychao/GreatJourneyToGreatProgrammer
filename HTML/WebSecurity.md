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