# micronaut-app & graalvm

## Running the Application

```
$ ./gradlew run
```

### GraalVM Docker Run

```
$ ./gradlew assemble
```

```
$ docker build . -t complete
```

```
docker run -p 8080:8080 -t complete
```

```
$ time curl localhost:8080/conferences/random
```

## Test

```
./gradlew test
```

```
open build/reports/tests/test/index.html
```

