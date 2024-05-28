# Design patterns

## Creational patterns
1. Factory Method


### Factory Method
- A design pattern that defers object creation to subclasses and relies on a factory method to create objects
- Typically, has a:
    - 1 Abstract class that depends on an object whose type is decided at runtime
    - 1 Interface whose instance the Abstract class uses
    - N extensions of the Abstract class, each overriding the factory method to return one type of the interface
    - N implementations of the Interface
- E.g.
    - Factory to create objects of different modes (Road transport, Water transport, etc.)
    - Factory to create pizza varieties (NY Pizza, Chicago pizza, etc.)
