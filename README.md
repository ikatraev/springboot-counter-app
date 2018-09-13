# SpringBoot Counter App

Test application for [Maven Docker Plugin](https://github.com/fabric8io/docker-maven-plugin)

## image `external` configuration Issue

### Description
If `external` configuration added for an image description the [Maven Docker Plugin](https://github.com/fabric8io/docker-maven-plugin) drops/does not recognize the assembly `incline` description anymore

### How to reproduce
To reproduce the issue run the following maven command with the maven profile that adds `external` description:
```bash
mvn clean install -P docker-build-with-external
```
The build fails

The build does not fail with the following maven profile
```bash
mvn clean install -P docker-build
```

### The cause
The plugin ignores `assembly`->`inline` description if `external` configuration present, even with `override` option 

## References
* [Maven Docker Plugin](https://github.com/fabric8io/docker-maven-plugin)
* [Issue 1082](https://github.com/fabric8io/docker-maven-plugin/issues/1082)