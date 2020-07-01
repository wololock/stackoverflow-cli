# stackoverflow-cli

A simple and unofficial Stack Overflow CLI tool build with Java 11, Micronaut Framework, Picocli, and compiled to the native executable file with the GraalVM.


## Links and resources

* My YouTube video https://www.youtube.com/watch?v=Xdcg4Drg1hc
* SDKMAN! https://sdkman.io/
* Micronaut Picocli Integration Guide https://micronaut-projects.github.io/micronaut-picocli/latest/guide/
* Micronaut 2.0.0 Documentation https://docs.micronaut.io/latest/guide/index.html
* Picocli Quick Guide https://picocli.info/quick-guide.html
* Picocli Documentation https://picocli.info/
* GraalVM native-image documentation https://www.graalvm.org/docs/reference-manual/native-image/
* Stack Exchange API /search documentation https://api.stackexchange.com/docs/search
  

## Build the JAR file

```
./gradlew --no-daemon assemble
```

## Run command as a Java program

```
java -jar build/libs/stackoverflow-cli-*-all.jar -h  

Usage: stackoverflow-cli [-hvV] [COMMAND]
...
  -h, --help      Show this help message and exit.
  -v, --verbose   ...
  -V, --version   Print version information and exit.
Commands:
  search  Search questions matching criteria.
```

```
java -jar build/libs/stackoverflow-cli-*-all.jar search --verbose -t java -q "merge maps" 
✔ 1|3 Merge maps in java
      https://stackoverflow.com/questions/11010392/merge-maps-in-java
✔ 3|4 Merge maps and make values as array
      https://stackoverflow.com/questions/47632521/merge-maps-and-make-values-as-array
✔ 3|2 Java 8 Merge maps in iterator
      https://stackoverflow.com/questions/35685959/java-8-merge-maps-in-iterator
✔ 14|3 Merge maps with recursive nested maps in Groovy
      https://stackoverflow.com/questions/27475111/merge-maps-with-recursive-nested-maps-in-groovy
✔ 1|1 Merge maps from a list of maps java8
      https://stackoverflow.com/questions/60696792/merge-maps-from-a-list-of-maps-java8
✔ 4|1 Java 8 stream - Merge maps and calculate average of &quot;values&quot;
      https://stackoverflow.com/questions/47569933/java-8-stream-merge-maps-and-calculate-average-of-values
✔ 0|1 How to merge Maps in Java base on one of the key field?
      https://stackoverflow.com/questions/61986945/how-to-merge-maps-in-java-base-on-one-of-the-key-field
✔ 2|1 java 8 stream: grouping by and storing sum in new object, and merge maps
      https://stackoverflow.com/questions/42968013/java-8-stream-grouping-by-and-storing-sum-in-new-object-and-merge-maps

Items size: 8 | Quota max: 300 | Quota remaining: 299 | Has more: false
```

## Compile native binary file

```
$ sdk use java 20.1.0.r11-grl 

Using java version 20.1.0.r11-grl in this shell.

$ gu install native-image

$ native-image --no-server -cp build/libs/stackoverflow-cli-*-all.jar

[stackoverflow-cli:84444]    classlist:   5,115.40 ms,  0.94 GB
[stackoverflow-cli:84444]        (cap):     963.25 ms,  0.94 GB
[stackoverflow-cli:84444]        setup:   3,020.17 ms,  0.94 GB
WARNING GR-10238: VarHandle for static field is currently not fully supported. Static field private static volatile java.lang.System$Logger jdk.internal.event.EventHelper.securityLogger is not properly marked for Unsafe access!
[stackoverflow-cli:84444]     (clinit):   1,479.16 ms,  4.96 GB
[stackoverflow-cli:84444]   (typeflow):  32,740.44 ms,  4.96 GB
[stackoverflow-cli:84444]    (objects):  33,983.72 ms,  4.96 GB
[stackoverflow-cli:84444]   (features):   3,879.75 ms,  4.96 GB
[stackoverflow-cli:84444]     analysis:  75,962.00 ms,  4.96 GB
[stackoverflow-cli:84444]     universe:   2,248.75 ms,  4.96 GB
[stackoverflow-cli:84444]      (parse):   9,574.10 ms,  5.10 GB
[stackoverflow-cli:84444]     (inline):   6,848.65 ms,  5.28 GB
[stackoverflow-cli:84444]    (compile):  54,886.12 ms,  6.04 GB
[stackoverflow-cli:84444]      compile:  75,453.26 ms,  6.04 GB
[stackoverflow-cli:84444]        image:   6,473.31 ms,  6.05 GB
[stackoverflow-cli:84444]        write:   1,086.98 ms,  6.05 GB
[stackoverflow-cli:84444]      [total]: 169,717.49 ms,  6.05 GB

$ ./stackoverflow-cli search --verbose -t java -q "merge maps" 
✔ 1|3 Merge maps in java
      https://stackoverflow.com/questions/11010392/merge-maps-in-java
✔ 3|4 Merge maps and make values as array
      https://stackoverflow.com/questions/47632521/merge-maps-and-make-values-as-array
✔ 3|2 Java 8 Merge maps in iterator
      https://stackoverflow.com/questions/35685959/java-8-merge-maps-in-iterator
✔ 14|3 Merge maps with recursive nested maps in Groovy
      https://stackoverflow.com/questions/27475111/merge-maps-with-recursive-nested-maps-in-groovy
✔ 1|1 Merge maps from a list of maps java8
      https://stackoverflow.com/questions/60696792/merge-maps-from-a-list-of-maps-java8
✔ 4|1 Java 8 stream - Merge maps and calculate average of &quot;values&quot;
      https://stackoverflow.com/questions/47569933/java-8-stream-merge-maps-and-calculate-average-of-values
✔ 0|1 How to merge Maps in Java base on one of the key field?
      https://stackoverflow.com/questions/61986945/how-to-merge-maps-in-java-base-on-one-of-the-key-field
✔ 2|1 java 8 stream: grouping by and storing sum in new object, and merge maps
      https://stackoverflow.com/questions/42968013/java-8-stream-grouping-by-and-storing-sum-in-new-object-and-merge-maps

Items size: 8 | Quota max: 300 | Quota remaining: 298 | Has more: false
```
