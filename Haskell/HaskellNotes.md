Haskell Notes

This is the start point that I need to be a self-discipline person.I will start from today to fight against all the shady part of my body.
It doesn't mean I don't love myself.I love it more than you think but I want to help it to become better.
Loveya.Bye.

## ByteString 

### Builder
Builders are used to efficiently construct sequences of bytes from smaller parts. Typically, such a construction is part of the implementation of an encoding, i.e., a function for converting Haskell values to sequences of bytes. 




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
>There are three kinds of fixity, non-, left- and right-associativity (infix, infixl, and infixr, respectively), and ten precedence levels, 0 to 9 inclusive (level 0 binds least tightly, and level 9 binds most tightly).

The following laws must hold:
```
a <> (b <> c) = (a <> b) <> c
mempty <> a = a
a <> mempty = a
```
The main thing to understand about a series of values merged by `(<>)` is that the order that they are evaluated doesn't matter. However, often the order of the arguments does matter -- `a <> b` is not necessarily the same thing as `b <> a`.

### List as Example

List concatenation is an associative operation, and adding an empty list to either side just results in the same list. It's a monoid!
```
instance Monoid [a] where
    mempty  = []
    mappend = (++)
```
Let's test that this makes sense as a monoid:
```
main = do
    let a = [1,1,2]
        b = [3,5]
        c = [8,13]

    putStrLn "These are equal:"
    print $  a ++ (b  ++ c)
    print $ (a ++  b) ++ c
    putStrLn "\nThese leave 'a' alone:"
    print $ a ++ []
    print $ [] ++ a
```
Yup! It satisfies the laws we want. Let's try using the monoid instance on String (which uses the list monoid):

import Data.Monoid

main = do 
    putStrLn "These are equal:"
    print $ "Hello there!" <>  mempty <> " Monoids are"  <> " neat!" <> mempty
    print $ "Hello there!" <> (mempty <> " Monoids are") <> " neat!" <> mempty

## SemiGroup
A semigroup is a set S together with a binary operation " · " (that is, a functionthat satisfies the associative property:

For all  a,b,c 属于 S, the equation (a·b)·c = a·(b·c) holds.
More succinctly, a semigroup is an associative magma.

## Quasiquote

The QuasiQuoter type, a value q of this type can be used in the syntax `[q| ... string to parse ...|]`. In fact, for convenience, a QuasiQuoter actually defines multiple quasiquoters to be used in different splice contexts; if you are only interested in defining a quasiquoter to be used for expressions, you would define a QuasiQuoter with only quoteExp, and leave the other fields stubbed out with errors.


