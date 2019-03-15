# YESOD


## Hamlet (HTML)

### Conditions
```
$if isAdmin
    <p>Welcome to the admin section.
$elseif isLoggedIn
    <p>You are not the administrator.
$else
    <p>I don't know who you are. Please log in so I can decide if you get access.
```

### Maybe
```
$maybe name <- maybeName
    <p>Your name is #{name}
$nothing
    <p>I don't know your name.
```

### Forall
```
$if null people
    <p>No people.
$else
    <ul>
        $forall person <- people
            <li>#{person}
```

### Case
`Case` statements let you safely match, letting the compiler warn you if you missed a case.
```
$case foo
    $of Left bar
        <p>It was left: #{bar}
    $of Right baz
        <p>It was right: #{baz}
```

### Doctype
we recommend $doctype 5 for modern web applications, which generates <!DOCTYPE html>.

```
$doctype 5
<html>
    <head>
        <title>Hamlet is Awesome
    <body>
        <p>All done.
````

## Lucius (CSS)
Lucius is one of two CSS templating languages in the Shakespeare family. 

Old
```
article code { background-color: grey; }
article p { text-indent: 2em; }
article a { text-decoration: none; }
```

With Lucius
```
article {
    code { background-color: grey; }
    p { text-indent: 2em; }
    a { text-decoration: none; }
    > h1 { color: green; }
}
```

And you can stop repeating urself
```
@textcolor: #ccc; /* just because we hate our users */
body { color: #{textcolor} }
a:link, a:visited { color: #{textcolor} }
```

## Cassius 
Cassius is a whitespace-sensitive alternative to Lucius. As mentioned in the synopsis, it uses the same processing engine as Lucius, but preprocesses all input to insert braces to enclose subblocks and semicolons to terminate lines. 
```
#banner
    border: 1px solid #{bannerColor}
    background-image: url(@{BannerImageR})
```

## Julius
In fact, some might even say it’s really just Javascript. Julius allows the three forms of interpolation we’ve mentioned so far,

## How to use these things?
### Quasiquotes
Quasiquotes allow you to embed arbitrary content within your Haskell, and for it to be converted into Haskell code at compile time.

`hamlet :: QuasiQuoter Source`

Hamlet quasi-quoter. May only be used to generate expressions.

Generated expression have type HtmlUrl url, for some url.

### External File
In this case, the template code is in a separate file which is referenced via Template Haskell.

##Render
render behind the hemlet is for reacting with @

##Widget

Widgets take a different approach. Instead of viewing an HTML document as a monolithic tree of tags, widgets see a number of distinct components in the page. In particular:

- The title setTitle
- External stylesheets
- External Javascript
- CSS declarations
- Javascript code
- Arbitrary <head> content  ToWidgetHead
- Arbitrary <body> content. ToWidgetBody


### Specific Widget
1. setTitle
Turns some HTML into the page title.

2. toWidgetMedia
Works the same as toWidget, but takes an additional parameter to indicate what kind of media this applies to. Useful for creating print stylesheets, for instance.

3. addStylesheet
Adds a reference, via a <link> tag, to an external stylesheet. Takes a type-safe URL.

4. addStylesheetRemote
Same as addStylesheet, but takes a normal URL. Useful for referring to files hosted on a CDN, like Google’s jQuery UI CSS files.

5. addScript
Adds a reference, via a <script> tag, to an external script. Takes a type-safe URL.

6. addScriptRemote
Same as addScript, but takes a normal URL. Useful for referring to files hosted on a CDN, like Google’s jQuery.

