# Java Design Patterns

Goal of this project is to provide example implementations for all popular and important design patterns in Java.
It is created and developed by **java guild** in [vm.pl](https://vm.pl/).

## Table of content

- [Design patterns](#design-patterns)
    - [Creational](#creational)
        - [Singleton](#singleton)
    - [Structural](#structural)
        - [Adapter](#adapter)
    - [Behavioral](#behavioral)
        - [Strategy](#strategy)

## Design patterns

### Creational

#### Singleton

A Singleton only allows for a single instantiation, but many instances of the same object. The Singleton restricts clients from creating multiple objects, after
the first object created, it will return instances of itself.

[Singleton example](https://github.com/vmpl/java-design-patterns/tree/develop/src/main/java/pl/vm/javaguild/designpatterns/pattern/creational/singleton)

### Structural

#### Adapter

The adapter pattern convert the interface of a class into another interface clients expect. Adapter lets classes work together that couldn’t otherwise because
of incompatible interfaces.

[Adapter example](https://github.com/vmpl/java-design-patterns/tree/develop/src/main/java/pl/vm/javaguild/designpatterns/pattern/structural/adapter)

### Behavioral

#### Strategy

Strategy pattern is also known as Policy Pattern. We define multiple algorithms and let client application pass the algorithm to be used as a parameter.

[Strategy example](https://github.com/vmpl/java-design-patterns/tree/develop/src/main/java/pl/vm/javaguild/designpatterns/pattern/behavioral/strategy)