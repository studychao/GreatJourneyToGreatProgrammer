# Notes for CSAPP
## Some abbreviation
1. CPU : Central Processing Unit
2. ALU: Arithmetic/Logic Unit
3. PC : Program Counter
4. USE: Universal Serial Bus
5. DRAM : Dynamic Random Access Memory

## Compilation System for Programs
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

## Run the executable
To run the executable on a Unix system, we type its name to an application program known as a shell:
```
unix> ./hello
```

The shell is a command-line interpreter that prints a prompt, wait for you to type a command line, and then performs the command.

## Hardware Organization of a System

### Buses
Running throught the system is a collection of electrical conduits called buses that carry bytes of information back and forth between the components.
Buses transfer *words*
*words* size varies on different systems.

### I/O Devices
The executable hello program resides on the disk.
Each I/O is connected to the I/O bus by either a controller or an adapter.
Controller : chip sets in the device itself/ on the system's main printed circuit board
Adapter : a card that plugs into a slot on the motherboard.

### Main Memory
The main memory is a *temporary* storage device that holds both a program and the data it manipulates while the processor is executing the program.
Main memory consists of a collection of Dynamic Random Access Memory(*DRAM*) chips.
Logically, memory is organized as a linear array of bytes each with its own unique address starting at zero.