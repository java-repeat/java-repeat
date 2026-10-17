# java-repeat

Kotlin-style repetition for Java, with support for checked exceptions.

```java
import static io.github.repeat.Repeat.*;

// run an action n times (like Kotlin's repeat(3) { i -> ... })
repeat(3, i -> System.out.println("attempt " + i));

// build a read-only list of n elements (like Kotlin's List(5) { i -> ... })
List<Integer> squares = list(5, i -> i * i); // [0, 1, 4, 9, 16]

// checked exceptions propagate without wrapping
repeat(3, i -> Files.createFile(Paths.get("file-" + i))); // throws IOException
```

| Kotlin | java-repeat |
|---|---|
| `repeat(n) { i -> ... }` | `repeat(n, i -> ...)` |
| `List(n) { i -> ... }` | `list(n, i -> ...)` |

As in Kotlin, `repeat` with a zero or negative count does nothing, and `list` with a negative size throws `IllegalArgumentException`.

## Maven

This API will ship in the next release (0.0.10). 0.0.9 and earlier have the old `Repeat.of().times(n).repeat(...)` API.

```xml
<dependency>
  <groupId>io.github.java-repeat</groupId>
  <artifactId>repeat</artifactId>
  <version>0.0.10</version>
</dependency>
```
