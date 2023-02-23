# Java Design Patterns

Goal of this project is to provide example implementations for all popular and important design patterns in Java.
It is created and developed by **java guild** in [vm.pl](https://vm.pl/).

## Table of content

- [Design patterns](#design-patterns)
    - [Creational](#creational)
        - [Simple Factory](#simple-factory)
        - [Prototype](#prototype)

## Design patterns

### Creational

Creational design patterns are a category of design patterns that deal with object creation mechanisms, trying to create objects in a manner suitable to the
situation. These design patterns provide a way to create objects while hiding the creation logic, rather than instantiating objects directly using new operator.
This gives program more flexibility in deciding which objects need to be created for a given use case.

#### Simple factory

The simple factory design pattern is a design pattern that is used to create objects without specifying the exact class
of object that will be created. This is
done by creating a factory class that has a method for creating objects, and the class of object that is created is
determined by the input to this method.

[Simple factory enhanced documentation](./src/main/java/pl/vm/javaguild/designpatterns/pattern/creational/simplefactory/SIMPLE_FACTORY.md)

[Simple factory source code of gift store](https://github.com/vmpl/java-design-patterns/tree/develop/src/main/java/pl/vm/javaguild/designpatterns/pattern/creational/simplefactory)

#### Prototype

The Prototype Design Pattern is a creational design pattern that allows you to create new objects by cloning existing
ones. The idea is to create a prototype object and then create new objects by copying this prototype and then modifying
it as necessary. This can be useful in situations where creating new objects from scratch is expensive, time-consuming,
or difficult. This allows you to create new objects that are similar to existing ones, but with slight variations.

[Prototype enhanced documentation](./src/main/java/pl/vm/javaguild/designpatterns/pattern/creational/prototype/PROTOTYPE.md)

[Prototype source code of free agent market](https://github.com/vmpl/java-design-patterns/tree/develop/src/main/java/pl/vm/javaguild/designpatterns/pattern/creational/prototype)