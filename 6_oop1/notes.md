### Editor

Use `ctrl + .` inside class body to obtain useful helpers like

- generate constructor
- generate setters/getters
- etc.

### Reference vs Object vs Instance vs Class

- **Class** - blueprint, using blueprint we can build as many objects as we like.
- **Instance/Object** - each object built using _class_.
- **Reference** - physical address of _object_.

### This vs Super

- **this** - used to call the _current class_ members (variables and methods)
- **super** - used to access/call _parent class_ members (variables and methods)
- `this(...)` - calls overloaded constructor from _current class_.
- `super(...)` - calls constructor from _parent class_. By default java puts empty `super()` if we don't add it. Even abstract classes have constructors, because when instantiating some subclass, `super()` will be called as well.

### Constructor chaining

One constructor should be considered as main (the one with most/all parameters) and should call `super(...)`. Rest of the constructors should call this with own parameters modifications.

### Method Overloading

- Static and instance method can be overloaded.
- Usually happens inside a single class, but method can be treated as overloaded if subclass overloaded parent class method. That's because subclass inherits one version of method and can create own overloaded versions.
- Compiler decides which method will be called based on name, return type, parameters (often refereed as **Compile Time Polymorphism**, however overloading has nothing to do with polymorphism at all).
- musts:
  - same name
  - different parameters
- may(s):
  - different return type
  - different access modifiers
  - throw different exceptions

### Method Overriding

- Known as **Runtime Polymorphism** because the method that is going to be called is decided at runtime by JVM.
- musts:

  - same signature (name, parameters)
  - return type must be same or can be a subclass of the return type in parent class

    ```
    class A;
    class B extends A;

    class FactoryA {
      public A get() {...}
    }

    class FactoryB extends Factory A {
      @override
      public B get() {...}
    }

    // B is subclass of A
    // FactoryB is subclass of FactoryA
    ```

  - cannot have lower access modifier (only higher like from private to public)
  - only instance methods can be overrider (static cannot)
  - cannot override constructors and private methods (only protected and public)
  - final method cannot be overridden

### Static

- Use static method if method is not using any instance variables.
- Static variable can be referenced normally in static methods and by using `ClassName.property` in instance methods.
