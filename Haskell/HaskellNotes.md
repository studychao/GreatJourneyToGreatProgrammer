Haskell Notes

This is the start point that I need to be a self-discipline person.I will start from today to fight against all the shady part of my body.
It doesn't mean I don't love myself.I love it more than you think but I want to help it to become better.
Loveya.Bye.

## ByteString 

### Builder



## Monoid
A monoid has two things: a 'unit' value, which we call *mempty*, and an append operation that combines values, called *mappend*.
It's defined as 
```
class Monoid a where
    mempty  :: a
    mappend :: a -> a -> a

    -- This is here because some types might have a more efficient definition for it.
    mconcat :: [a] -> a
    mconcat = foldr mappend mempty
```

(<>) => used to refer to mappend
```
infixr 6 (<>)

(<>) :: Monoid a => a -> a -> a
(<>) = mappend
```
> What is infixr?
>infixr 6 (<>)
>(<>) :: Monoid a => a -> a -> a
>(<>) = mappend