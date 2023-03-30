# Java Design Patterns

Goal of this project is to provide example implementations for all popular and important design patterns in Java.
It is created and developed by **java guild** in [vm.pl](https://vm.pl/).

## Table of content

- [Design patterns](#design-patterns)
    - [Creational](#creational)
        - [Simple Factory](#singleton)

## Design patterns

### Creational

Creational design patterns are a category of design patterns that deal with object creation mechanisms, trying to create objects in a manner suitable to the
situation. These design patterns provide a way to create objects while hiding the creation logic, rather than instantiating objects directly using new operator.
This gives program more flexibility in deciding which objects need to be created for a given use case.

#### Simple factory

The simple factory design pattern is a design pattern that is used to create objects without specifying the exact class of object that will be created. This is
done by creating a factory class that has a method for creating objects, and the class of object that is created is determined by the input to this method.

[Simple factory enhanced documentation](src/main/java/pl/vm/javaguild/designpatterns/pattern/creational/singleton/SINGLETON.md)

[Simple factory source code of gift store](https://github.com/vmpl/java-design-patterns/tree/develop/src/main/java/pl/vm/javaguild/designpatterns/pattern/creational/simplefactory)