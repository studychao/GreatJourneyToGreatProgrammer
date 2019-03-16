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


## Functors
Functor has only one typeclass method,namely fmap

`fmap :: ( a -> b) -> f a -> f b`
` fmap f g = f.g; `
It says: give me a function that takes an a and returns a b and a box with an a inside it and I'll give you a give with a b inside it.

If we want to make a type constructor an instance of Functor, it has to have a kind of`* -> *` , which means that it has to take exactly one concrete type as a type parameter.
For example, Maybe can be made an instance because it takes one type parameter to produce a concrete type, like Maybe Int or Maybe String

If a type constructor takes two parameters, like `Either`, we have to partially apply the type constructor until it only takes one type parameter. So we can't write `instance Functor Either where`, but we can write `instance Functor (Either a) where` and then if we imagine that fmap is only for Either a, it would have a type declaration of `fmap :: (b -> c) -> Either a b -> Either a c`. As you can see, the `Either a` part is fixed, because `Either a` takes only one type parameter, whereas just Either takes two so `fmap :: (b -> c) -> Either b -> Either c` wouldn't really make sense.



## Monad


`(<*>) :: (Applicative f) => f (a -> b) -> f a -> f b`

example:
```
a = Just (*2)
b = Just 4
a <*> b
>>>Just 8
```
`(<$>) :: Functor f => (a -> b) -> f a -> f b`

Monads are a natural extension of applicative functors and with them we're concerned with this: if you have a value with a context, m a, how do you apply to it a function that takes a normal a and returns a value with a context? That is , how do you apply a function of type a -> m b to a value of type m a? So essentially, we will want this function:

`(>>=) :: (Monad m) => m a -> (a -> m b) -> m b `


## Type Constructor && Data Constructor

### Star
[] is a type constructor
```
:info []
data [] a = [] | a : [a] -- Defined 
```

[] is a type constructor taking one type argument a and returning the type [] a, which is also permitted to be written as [a].

[] is a data constructor which essentially means "empty list." This data constructor takes no value arguments.

### Data Constructors
```
data Colour = Red | Green | Blue
```
Colour is a type, and Green is a constructor that contains a value of type Colour.
Similarly, Red and Blue are both constructors that construct values of type Colour.

```
data Colour = RGB Int Int Int
```
We still have just the type Colour, but RGB is not a value – it's a function taking three Ints and returning a value! RGB has the type
```
RGB :: Int -> Int -> Int -> Colour
```
RGB is a data constructor that is a function taking some values as its arguments, and then uses those to construct a new value. If you have done any object-oriented programming, you should recognise this. In OOP, constructors also take some values as arguments and return a new value!

A data constructor either contains a value like a variable would, or takes other values as its argument and creates a new value. 

### Intermission 

If you want to construct a binary tree to store Strings, you could imagine doing something like
```
data SBTree = Leaf String
            | Branch String SBTree SBTree
```
What we see here is a type SBTree that contains two data constructors. In other words, there are two functions (namely Leaf and Branch) that will construct values of the SBTree type. If you're not familiar with how binary trees work, just hang in there. You don't actually need to know how binary trees work, only that this one stores Strings in some way


### Type constructors
```
data BTree a = Leaf a
             | Branch a (BTree a) (BTree a)
             ```

Now we introduce a type variable a as a parameter to the type constructor. In this declaration, BTree has become a function. It takes a type as its argument and it returns a new type.

 a type constructor function which you need to feed a type to be able to be assigned to a value