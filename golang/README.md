
# golang



## golang-java

```
make (darwin/windows/linux)

ls  build/*/* | grep -v "\.h" | xargs -i cp {} golang-java/src/main/resources/

cd golang-java

mvn package

java -jar target/golang-java-1.0-SNAPSHOT.jar

```

## golang-python

```
make (darwin/windows/linux)

ls  build/*/* | grep -v "\.h" | xargs -i cp {} golang-python/lib/

cd golang-python

python hello.py

```

## golang-php

Todo

### Reference:

1. https://github.com/vladimirvivien/go-cshared-examples
