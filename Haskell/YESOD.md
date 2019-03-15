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
Case statements let you safely match, letting the compiler warn you if you missed a case.
```
$case foo
    $of Left bar
        <p>It was left: #{bar}
    $of Right baz
        <p>It was right: #{baz}
```

