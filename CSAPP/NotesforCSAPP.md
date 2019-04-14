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

### Processor
The central processing unit(CPU), or simply processor, is the engine that interprets (or executes) instructions that stored in main memory. At its core is a word-sized storage device(or register) called the program counter(PC). At any point in time, the PC points at (contains the address of ) some machine-language in main memory.

From the time the power is applied to the system, until the time that the power is shut off, the processor blindly and repeatedly performs the same basic task over and over again:1) It reads the instruction from memory pointed at by the program counter(PC) 2) interprets the bits in the instruction 3) performs some simple operation dictated by the instruction 4) update the PC to point to the next instruction (may not be contiguous in memory)

There are only a few of these simple op, and the revolve around main memory, the register file, and the arithmetic/logic unit (ALU). The register file is a small storage device that consists of a collection of word-sized registers, each with its own unique name. The ALU computes new data and address values. Here are some examples of the simple op that the CPU carry out.

Load : copy a byte/word: Main Memory -> Register.(overwriting the previous contents)
Store : copy a byte /word : Register -> Main Memory. (overwriting the previous contents)
Update : copy the contents of two registers to the ALU, whcih adds the two words together and stores the result in a register.
(overwriting the previous contents)
I/O Read: copy a byte/word :  I/O device -> Register
I/O Write : copy a byte/word : Register -> I/O device
Jump : Extract a word from the instruction itself and copy that word into the program counter (PC) (overwriting the previous contents)

```
Byte & Word
Byte: Today, a byte is almost always 8 bit. However, that wasn't always the case and there's no "standard" or something that dictates this. Since 8 bits is a convenient number to work with it became the de facto standard.

Word: The natural size with which a processor is handling data (the register size). The most common word sizes encountered today are 8, 16, 32 and 64 bits, but other sizes are possible. For examples, there were a few 36 bit machines, or even 12 bit machines.

The byte is the smallest addressable unit for a CPU. If you want to set/clear single bits, you first need to fetch the corresponding byte from memory, mess with the bits and then write the byte back to memory.

The word by contrast is biggest chunk of bits with which a processor can do processing (like addition and subtraction) at a time. That definition is a bit fuzzy, as some processor might have different word sizes for different tasks (integer vs. floating point processing for example). The word size is what the majority of operations work with
```