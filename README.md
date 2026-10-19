<p align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="assets/logo/wordmark-white.svg">
    <img src="assets/logo/wordmark.svg" alt="java-repeat" width="360">
  </picture>
</p>

# java-repeat

Kotlin-style repetition for Java, with support for checked exceptions.

```java
import static io.github.repeat.Repeat.*;

// run an action n times (like Kotlin's repeat(3) { i -> ... })
repeat(3, i -> System.out.println("attempt " + i));

// checked exceptions propagate without wrapping
repeat(3, i -> Files.createFile(Paths.get("file-" + i))); // throws IOException
```

| Kotlin | java-repeat |
|---|---|
| `repeat(n) { i -> ... }` | `repeat(n, i -> ...)` |

As in Kotlin, a zero or negative count does nothing.

## Maven

This API will ship in the next release (1.0.0). 0.0.9 and earlier have the old `Repeat.of().times(n).repeat(...)` API.

```xml
<dependency>
  <groupId>io.github.java-repeat</groupId>
  <artifactId>repeat</artifactId>
  <version>1.0.0</version>
</dependency>
```
