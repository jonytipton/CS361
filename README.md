# Project 1: (Deterministic Finite Automata)

* Authors:  Johnathon Begg, Jonathan Tipton
* Class:    CS361 Section-001
* Semester: Spring 2020

## Overview

This Java application simulates a DFA (Deterministic Finite Automata).

## Compiling and Using

To compile this project, first navigate to the src folder then:

Compile dfa package:
```
$ javac fa/dfa/*.java
```

Compile fa package:
```
$ javac fa/*.java
```

Run the project (from src directory):
```
$ java fa.dfa.DFADriver /path/to/input.txt
```
input.txt can be any of the provided test files located under the tests directory,
or a new DFA can be created using the following format in a new .txt file:
* 1st line contains the names of the final state, i.e., elements of F. The names are separated by white space. Can be empty if there are no final states.
* 2nd line contains the name of the start state, i.e., q0
* 3rd line contains the rest of the DFA’s states, i.e., those states that are not F or q0. It can be empty if all states have been specified in the previous two lines.
* The 4th lines lists the transitions. Transitions are separated by white space. 
Three symbols compose a transition s0s1s2, where:
** The first symbol s0 is the name of the "from" state
** The second symbol s1 is the symbol from the alphabet, i.e., s1 ∈ Σ
** The third symbol s2 is the name of the "to" state
*Starting from line 5, each line contains a string for which we need to determine whether it is in the language of the DFA. The strings are over the DFA's alphabet and we use 'e' symbol to represent the empty string ε


