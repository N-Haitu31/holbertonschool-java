# Java OOP

An introduction to object-oriented programming in Java. Step by step, the project builds the core of a property management application: properties (apartments, houses, commercial spaces), their address and energy class, their owners and tenants, a portfolio, and the leases signed through an agency.

Every task adds one notion to the same code base. By the end, the four pillars of OOP (encapsulation, inheritance, polymorphism and abstraction) have been used on a concrete case.

Only the standard library is used. There is no Maven, no Gradle and no external library: just the JDK, a terminal and an editor.

## Requirements

- JDK 21 (LTS)
- `javac` and `java` available in the terminal

Check with:

```bash
javac -version
java -version
```

## Project layout

Each task has its own folder, and each folder is **self-contained**: it holds every class of the application at that stage, including the ones written in the previous tasks. The files listed below are the ones that appear in each task.

```
oop/
├── 0-property/        Property.java, PropertyDemo.java
├── 1-encapsulation/   (Property.java improved)
├── 2-object-methods/  (Property.java improved)
├── 3-record/          + Address.java
├── 4-enum/            + EnergyClass.java
├── 5-inheritance/     + Apartment.java, House.java
├── 6-polymorphism/    + PolymorphismDemo.java
├── 7-abstract/        + CommercialSpace.java
├── 8-interfaces/      + Insurable.java
├── 9-composition/     + Contact.java, Owner.java, Tenant.java
├── 10-collections/    + Portfolio.java
├── 11-generics/       + Identifiable.java, Registry.java
├── 12-sorting/        + PropertyComparators.java
├── 13-exceptions/     + Lease.java, Agency.java,
│                        PropertyUnavailableException.java,
│                        InvalidLeaseException.java
├── tests/             provided tests (Task00Test.java ... and Grader.java)
├── .gitignore
└── README.md
```

To start a task, the source files of the previous one are copied into the new folder, then modified. This keeps the tests of each task describing that task, and makes it easy to compare two versions of the same class.

## Compile and run

All commands are run from the root of the project (the folder that contains `tests/`). A task contains several classes, so the whole folder is compiled at once:

```bash
javac -Xlint:all 0-property/*.java     # compiles every class of the task, with no warning
java -cp 0-property PropertyDemo       # runs the class PropertyDemo located in 0-property/
```

Example with the polymorphism demo:

```bash
javac -Xlint:all 6-polymorphism/*.java
java -cp 6-polymorphism PolymorphismDemo
```

```
Property P-001: 880 EUR/month
Apartment P-002: 1040 EUR/month
House P-003: 2060 EUR/month
Total: 3980 EUR/month
```

The `.class` files are written next to their sources and are ignored by Git (`.gitignore` contains `*.class`).

## Tests

Compile a task, then run its test. The test file is run directly, it does not need to be compiled:

```bash
javac 4-enum/*.java
java tests/Task04Test.java
```

To run several tests at once and get the score:

```bash
java tests/Grader.java            # every task, summary and failing tests
java tests/Grader.java -v         # details of all the tests
java tests/Grader.java 3 4        # only tasks 3 and 4
```

The grader does not compile anything: a task that scores 0 with a `.class not found` message has simply not been compiled yet.

## Tasks

| # | Folder | Main files | What it covers |
|---|--------|------------|----------------|
| 0 | `0-property` | `Property.java`, `PropertyDemo.java` | Class, object, constructor, `this`, getters |
| 1 | `1-encapsulation` | `Property.java` | `private` and `final` fields, invariants, validation, setters, `IllegalArgumentException` |
| 2 | `2-object-methods` | `Property.java` | `toString`, `equals`, `hashCode`, `==` vs `equals` |
| 3 | `3-record` | `Address.java` | `record`, compact constructor, immutable objects, composition |
| 4 | `4-enum` | `EnergyClass.java` | `enum` with fields, constructor and methods |
| 5 | `5-inheritance` | `Apartment.java`, `House.java` | `extends`, `super(...)`, order of constructors |
| 6 | `6-polymorphism` | `PolymorphismDemo.java` | Overriding, `super.method()`, polymorphism, `final` method |
| 7 | `7-abstract` | `Property.java`, `CommercialSpace.java` | Abstract class and abstract methods, `protected` |
| 8 | `8-interfaces` | `Insurable.java` | Interface, `default` method, `Comparable<Property>` |
| 9 | `9-composition` | `Contact.java`, `Owner.java`, `Tenant.java` | "Is a" vs "has a", delegation, `IllegalStateException` |
| 10 | `10-collections` | `Portfolio.java` | `List` and `ArrayList`, defensive copy |
| 11 | `11-generics` | `Identifiable.java`, `Registry.java` | Generic class, bounded type `<T extends ...>`, `Map` |
| 12 | `12-sorting` | `PropertyComparators.java` | `Comparator`, lambdas, `comparing`, `thenComparing` |
| 13 | `13-exceptions` | `Lease.java`, `Agency.java`, `PropertyUnavailableException.java`, `InvalidLeaseException.java` | Custom checked and unchecked exceptions, `throw` and `throws` |

## The four pillars of OOP

- **Encapsulation** (task 1): fields are private, and the constructor and the setters enforce the rules of each object.
- **Inheritance** (task 5): `Apartment` and `House` extend `Property` and only add what is specific to them.
- **Polymorphism** (task 6): `getMonthlyCharges()` runs the method of the real type of the object, not the type of the variable.
- **Abstraction** (tasks 7 and 8): `Property` is abstract and cannot be instantiated, and `Insurable` is a contract that several classes can promise to respect.

## Conventions

- Java 21, compiled with `javac -Xlint:all` and no warning
- Oracle code style: 4-space indentation, opening brace on the same line, `PascalCase` for classes, `camelCase` for methods and variables, `UPPER_SNAKE_CASE` for constants
- No `var`, and no `package` declaration
- A file name matches the name of its public class
- Instance fields are private, and every overriding method has `@Override`
- Amounts are whole euros stored in an `int`
- Every file ends with a new line
