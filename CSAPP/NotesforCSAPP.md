## Notes for CSAPP


### Compilation System for Programs
- Preprocessing Phase
The preprocessor (cpp) modifies the original C program according to directives that begin with the # character.
For example, `#include <stdio.h` command tells the preprocessor to read the contents of the system header file stdio.h and insert it directly into the program text.
The result is another C program with the *.i* suffix.

- Compilation phase.
The compiler translates the text file `hello.i` into `hello.s` which contains an assembly-language program.
Assembly language is useful because it provides a common output language for different compilers for different high-level languages.

- Assembly phase
Next, the assembler (as) translates `hello.s` into machine-language instructions, packages them in a form known as a relocatable object and stores the result in the object file `hello.o`.
`hello.o` is a binary file whose bytes encode machine lang instructions rather than characters

- Linking phase
The printf function resides in a separate precompiled object file called `printf.o`, which must somehow be merged with our hello.o program. The linker (ld) handles this merging. The result is the hello file, which is an *executable object file* (or simply executable) that is ready to be loaded.

### Run the executable
To run the executable on a Unix system, we type its name to an application program known as a shell:
```
unix> ./hello
```

The shell is a command-line interpreter that prints a prompt, wait for you to type a command line, and then performs the command.