# Java Design Patterns

Goal of this project is to provide example implementations for all popular and important design patterns in Java.
It is created and developed by **java guild** in [vm.pl](https://vm.pl/).

## Table of content

- [Design patterns](#design-patterns)
    - [Creational](#creational)
        - [Simple Factory](#simple-factory)
        - [Builder](#builder)
        - [Prototype](#prototype)
        - [Singleton](#singleton)
    - [Structural](#structural)
        - [Composite](#composite)
        - [Bridge](#bridge)
    - [Behavioral](#behavioral)
      - [Memento](#memento)

## Design patterns

### Creational

**Creational** design patterns are a category of design patterns that deal with object creation mechanisms, trying to create objects in a manner suitable to the
situation. These design patterns provide a way to create objects while hiding the creation logic, rather than instantiating objects directly using new operator.
This gives program more flexibility in deciding which objects need to be created for a given use case.

#### Simple factory

The **Simple Factory** design pattern is a design pattern that is used to create objects without specifying the exact class
of object that will be created. This is
done by creating a factory class that has a method for creating objects, and the class of object that is created is
determined by the input to this method.

[Simple factory enhanced documentation](src/main/java/pl/vm/javaguild/designpatterns/pattern/creational/singleton/SINGLETON.md)

[Simple factory source code of gift store](https://github.com/vmpl/java-design-patterns/tree/develop/src/main/java/pl/vm/javaguild/designpatterns/pattern/creational/simplefactory)

#### Builder

The **Builder** is a design pattern designed to provide a flexible solution to various object creation problems in object-oriented programming. The intent of
the builder design pattern is to separate the construction of a complex object from its representation. It is one of the Gang of Four design patterns.

[Builder enhanced documentation](./src/main/java/pl/vm/javaguild/designpatterns/pattern/creational/builder/README.md)

[Builder source code ](https://github.com/vmpl/java-design-patterns/tree/develop/src/main/java/pl/vm/javaguild/designpatterns/pattern/creational/builder)

#### Prototype

The **Prototype** is a creational design pattern that allows you to create new objects by cloning existing
ones. The idea is to create a prototype object and then create new objects by copying this prototype and then modifying
it as necessary. This can be useful in situations where creating new objects from scratch is expensive, time-consuming,
or difficult. This allows you to create new objects that are similar to existing ones, but with slight variations.

[Prototype enhanced documentation](./src/main/java/pl/vm/javaguild/designpatterns/pattern/creational/prototype/PROTOTYPE.md)

[Prototype source code of free agent market](https://github.com/vmpl/java-design-patterns/tree/develop/src/main/java/pl/vm/javaguild/designpatterns/pattern/creational/prototype)

#### Singleton

In Java, the **Singleton** is a design pattern that restricts the instantiation of a class to one object and provides global access to that instance throughout
the application.
It ensures that a class has only one instance and provides a single point of access to that instance.

[Singleton enhanced documentation](./src/main/java/pl/vm/javaguild/designpatterns/pattern/creational/singleton/SINGLETON.md)

[Singleton source code](https://github.com/vmpl/java-design-patterns/tree/develop/src/main/java/pl/vm/javaguild/designpatterns/pattern/creational/singleton)

### Structural

**Structural** are a category of design patterns that focus on how objects and classes are composed to form larger structures.
They simplify the structure by identifying the relationships among classes and objects. This makes it easier to scale and maintain the system as it grows.

#### Composite

The **Composite** is a structural design pattern that helps you compose objects into tree structures to represent part-whole hierarchies.
In this pattern, individual objects (leaves) and compositions of objects (composites) are treated uniformly.
This means that client code can interact with a single object and a composition of objects through the same interface.
The pattern ensures that the client code can treat complex and simple objects the same way, and this allows you to build more flexible and extensible systems.

[Composite enhanced documentation](./src/main/java/pl/vm/javaguild/designpatterns/pattern/structural/composite/COMPOSITE.md)

[Composite source code](https://github.com/vmpl/java-design-patterns/tree/develop/src/main/java/pl/vm/javaguild/designpatterns/pattern/structural/composite)

#### Bridge

The **Bridge** is a structural design pattern that separates an abstraction from its implementation, allowing the two to vary independently. It
decouples the abstraction from the implementation, enabling both to change independently.

This pattern promotes loose coupling by enabling the separation of the abstract and concrete aspects of a system, increasing flexibility and maintainability. It
also allows for multiple implementations of the same abstraction, simplifying component-based software development.

[Bridge enhanced documentation](./src/main/java/pl/vm/javaguild/designpatterns/pattern/structural/bridge/BRIDGE.md)

[Bridge source code](https://github.com/vmpl/java-design-patterns/tree/develop/src/main/java/pl/vm/javaguild/designpatterns/pattern/structural/bridge)

### Behavioral

**Behavioral** design patterns are concerned with the communication and behavior of objects and classes within software systems. They provide solutions for
common
communication patterns and design problems, promoting flexibility, modularity, and maintainability.

#### Memento

**Memento** is a behavioral design pattern that provides a way to capture and restore the internal state of an object without violating its encapsulation. It is
used to preserve a snapshot of the object's state at a specific point in time, called a memento. This allows the object to be restored to its previous state if
needed.

[Memento source code](https://github.com/vmpl/java-design-patterns/tree/develop/src/main/java/pl/vm/javaguild/designpatterns/pattern/behavioral/memento)