
# golang



## golang-java

```
make all

ls  build/*/* | grep -v "\.h" | xargs -i cp {} golang-java/src/main/resources/

cd golang-java

mvn package

java -jar target/golang-java-1.0-SNAPSHOT.jar

```


### Reference:

1. https://blog.dogan.io/2015/08/15/java-jni-jnr-go/
