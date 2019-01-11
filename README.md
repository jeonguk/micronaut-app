# micronaut-app & graalvm

## Running the Application

```
$ ./gradlew run
```

### GraalVM Docker build Run

```
$ ./gradlew assemble
```

```
$ docker build . -t complete
```

```
$ docker run -p 8080:8080 -t complete
```

### Check
```
$ time curl localhost:8080/conferences/random
```


## Test Case

```
./gradlew test
```

```
open build/reports/tests/test/index.html
```

