<p align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="assets/logo/wordmark-white.svg">
    <img src="assets/logo/wordmark.svg" alt="java-repeat" width="360">
  </picture>
</p>

# java-repeat

[![Maven Central](https://img.shields.io/maven-central/v/io.github.java-repeat/repeat)](https://central.sonatype.com/artifact/io.github.java-repeat/repeat)
[![Javadoc](https://javadoc.io/badge2/io.github.java-repeat/repeat/javadoc.svg)](https://javadoc.io/doc/io.github.java-repeat/repeat)
[![Build](https://github.com/java-repeat/java-repeat/actions/workflows/build.yml/badge.svg?branch=develop)](https://github.com/java-repeat/java-repeat/actions/workflows/build.yml)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=java-repeat_java-repeat&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=java-repeat_java-repeat)

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

## Install

Java 8 or later. No runtime dependencies.

Maven:

```xml
<dependency>
  <groupId>io.github.java-repeat</groupId>
  <artifactId>repeat</artifactId>
  <version>1.0.1</version>
</dependency>
```

Gradle:

```kotlin
implementation("io.github.java-repeat:repeat:1.0.1")
```

Coming from 0.0.9 or earlier (`Repeat.of().times(n).repeat(...)`)? See [Migrating from 0.x](https://java-repeat.github.io/guides/migrating-from-0x/).

## Documentation

- [Docs](https://java-repeat.github.io): getting started, guides and the API reference
- [Javadoc](https://javadoc.io/doc/io.github.java-repeat/repeat)
- [Releases](https://github.com/java-repeat/java-repeat/releases)

## Release notes skill

Release notes are written by the `/release-notes` skill in [`.claude/skills/release-notes`](.claude/skills/release-notes). The release workflow runs it with the Claude GitHub Action after each release and publishes the result as the GitHub release. You can also run it yourself in Claude Code, for example `/release-notes repeat-1.0.1`.

### Running the skill evals

The skill's eval cases are in [`evals/evals.json`](.claude/skills/release-notes/evals/evals.json). Run them with Anthropic's [skill-creator](https://github.com/anthropics/claude-plugins-official/tree/main/plugins/skill-creator) plugin:

1. Start Claude Code in the repository root. skill-creator is enabled in [`.claude/settings.json`](.claude/settings.json); accept the install prompt the first time, or run `/plugin install skill-creator@claude-plugins-official`.
2. Evaluate the skill:

   ```text
   /skill-creator eval release-notes
   ```

   To measure an edit, compare against the version on `develop`, for example `/skill-creator eval release-notes, comparing against the skill on origin/develop`.
3. skill-creator runs each eval in a fresh subagent, grades every expectation, and opens a review page with the outputs and a benchmark (pass rate, time, tokens). Results go to `.claude/skills/release-notes-workspace/`, which is gitignored.

The evals use the real release tags, so fetch them first (`git fetch --tags`). When the skill gets something wrong in a real release, add a case to `evals/evals.json`.
