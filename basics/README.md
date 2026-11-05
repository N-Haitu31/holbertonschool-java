# Java Basics

A set of small Java programs written to learn the language: compiling and running, types, strings, control flow, arrays, methods, access modifiers, `static`, and reading input. Each task lives in its own folder.

Only the standard library is used. There is no Maven, no Gradle and no external library.

## Requirements

- JDK 21 (LTS)
- `javac` and `java` available in the terminal

Check with:

```bash
javac -version
java -version
```

## Project layout

Each task has its own folder, because a Java file must be named after its public class (`Hello.java` for `public class Hello`), and a class name cannot start with a digit.

```
basics/
├── 0-hello/          Hello.java
├── 1-args/           Greeter.java
├── 2-variables/      Variables.java
├── 3-strings/        Strings.java
├── 4-string-traps/   StringTraps.java
├── 5-conditions/     Conditions.java
├── 6-loops/          Loops.java
├── 7-arrays/         ArrayTools.java
├── 8-methods/        MathUtils.java
├── 9-by-value/       ByValue.java
├── 10-access/        Counter.java, Scope.java
├── 11-static/        Ticket.java, StaticDemo.java
├── 12-input/         Interactive.java
├── tests/            provided tests (Task00Test.java ... and Grader.java)
├── .gitignore
└── README.md
```

## Compile and run

All commands are run from the root of the project (the folder that contains `tests/`).

```bash
javac -Xlint:all 0-hello/Hello.java    # produces 0-hello/Hello.class, with no warning
java -cp 0-hello Hello                 # runs the class Hello located in 0-hello/
```

For a folder with several files, compile them together:

```bash
javac -Xlint:all 10-access/*.java
java -cp 10-access Scope
```

The `.class` files are ignored by Git (`.gitignore` contains `*.class`).

## Tests

Compile a task, then run its test:

```bash
javac 6-loops/Loops.java
java tests/Task06Test.java
```

To run every test and get the score:

```bash
java tests/Grader.java
```

## Tasks

| # | Folder | File(s) | What it covers |
|---|--------|---------|----------------|
| 0 | `0-hello` | `Hello.java` | Compile and run a first program |
| 1 | `1-args` | `Greeter.java` | Command-line arguments (`args`) |
| 2 | `2-variables` | `Variables.java` | Primitive types, overflow, precision, casts, `printf` |
| 3 | `3-strings` | `Strings.java` | `String` methods, immutability |
| 4 | `4-string-traps` | `StringTraps.java` | `==` vs `equals`, `null`, `StringBuilder` |
| 5 | `5-conditions` | `Conditions.java` | `if / else if`, `switch`, switch expressions, `&&` and `\|\|` |
| 6 | `6-loops` | `Loops.java` | `for`, `while`, `do-while`, nested loops |
| 7 | `7-arrays` | `ArrayTools.java` | One- and two-dimensional arrays |
| 8 | `8-methods` | `MathUtils.java` | Overloading, varargs, recursion |
| 9 | `9-by-value` | `ByValue.java` | Pass by value (primitives and references) |
| 10 | `10-access` | `Counter.java`, `Scope.java` | Access modifiers, `this`, variable scope |
| 11 | `11-static` | `Ticket.java`, `StaticDemo.java` | `static` members, `final`, `String.format` |
| 12 | `12-input` | `Interactive.java` | `Scanner`, `try / catch`, `System.err`, exit code |

## Conventions

- Java 21, compiled with `javac -Xlint:all` and no warning
- Oracle code style: 4-space indentation, opening brace on the same line, `PascalCase` for classes, `camelCase` for methods and variables, `UPPER_SNAKE_CASE` for constants
- No `var`
- `System.exit` is only used in the tasks that need an exit code
- Every file ends with a new line
