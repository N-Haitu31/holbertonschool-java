# holbertonschool-java

Two back-end Java projects, built one after the other with the same rules: JDK 21, `javac` and `java` only, no build tool and no external library.

| Project | Folder | Goal |
|---------|--------|------|
| Java Basics | [`basics/`](basics/) | Learn the language through small programs: compiling and running, types, strings, control flow, arrays, methods, access modifiers, `static`, and reading input |
| Java OOP | [`oop/`](oop/) | Learn object-oriented programming by building, step by step, the core of a property management application |

Java OOP follows Java Basics: it reuses what the first project taught (methods, arrays, strings, `private`, `static`, `this`) and builds on it.

## Repository layout

```
holbertonschool-java/
├── basics/     Java Basics: tasks 0 to 12, one folder per task
│   ├── tests/  provided tests and grader
│   └── README.md
├── oop/        Java OOP: tasks 0 to 13, one folder per task
│   ├── tests/  provided tests and grader
│   └── README.md
└── README.md
```

Each project is independent. It has its own `tests/` folder, its own `.gitignore` (which ignores the `*.class` files) and its own `README.md`, which describes its tasks in detail:

- [Java Basics README](basics/README.md)
- [Java OOP README](oop/README.md)

## Requirements

- JDK 21 (LTS)
- `javac` and `java` available in the terminal

Check with:

```bash
javac -version
java -version
```

## Compile, run and test

All commands are run from the root of **a project** (`basics/` or `oop/`), the folder that contains `tests/`, not from the root of this repository.

```bash
cd oop
javac -Xlint:all 0-property/*.java      # compile every class of a task, with no warning
java -cp 0-property PropertyDemo        # run a class of this task
java tests/Task00Test.java              # run the test of this task
java tests/Grader.java                  # run every test of the project and get the score
```

The same commands work in `basics/`, with the folder and class names of its own tasks.

The test files are run directly by `java`, they do not need to be compiled. The grader does not compile anything: a task that scores 0 with a `.class not found` message has simply not been compiled yet.

## Conventions

Both projects follow the same rules:

- Java 21, compiled with `javac -Xlint:all` and no warning
- Oracle code style: 4-space indentation, opening brace on the same line, `PascalCase` for classes, `camelCase` for methods and variables, `UPPER_SNAKE_CASE` for constants
- No `var`, and no `package` declaration
- A file name matches the name of its public class
- No `.class` file committed
- Every file ends with a new line
- The `tests/` folders are provided and are never modified
