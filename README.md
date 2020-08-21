## Quarkus Maven Archetype

Maven Archetype Plugin to create a Quarkus project with postgresql + minio + some abstract classes.

### How to: 
```
git clone git@github.com:ict-group/quarkus-archetype.git
cd quarkus-archetype
mvn install
cd ..
mvn archetype:generate \
                       -DarchetypeGroupId=it.ictgroup \
                       -DarchetypeArtifactId=quarkus-archetype
                       -DarchetypeVersion=1.6.1.Final
                       -DgroupId=io.ictgroup
                       -DartifactId=first-sample
                       -Dversion=1.0-SNAPSHOT
```
