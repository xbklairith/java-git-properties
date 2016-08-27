# java-git-properties
Store git state on properties file

###Maven

Make `.properties` in resources directory

```
# git.properties
git.tags=${git.tags}
git.branch=${git.branch}
git.dirty=${git.dirty}
git.remote.origin.url=${git.remote.origin.url}
git.commit.id=${git.commit.id}
git.commit.id.abbrev=${git.commit.id.abbrev}
git.commit.id.describe=${git.commit.id.describe}
git.commit.id.describe-short=${git.commit.id.describe-short}
git.commit.user.name=${git.commit.user.name}
git.commit.message.full=${git.commit.message.full}
git.commit.message.short=${git.commit.message.short}
git.commit.time=${git.commit.time}
git.closest.tag.name=${git.closest.tag.name}
git.closest.tag.commit.count=${git.closest.tag.commit.count}
git.build.user.name=${git.build.user.name}
git.build.time=${git.build.time}
git.build.host=${git.build.host}
git.build.version=${git.build.version}
```



Add `git-commit-id-plugin`

```xml
<plugins>
...
 <plugin>
	<groupId>pl.project13.maven</groupId>
	<artifactId>git-commit-id-plugin</artifactId>
	<version>2.1.15</version>
	<executions>
		<execution>
			<goals>
				<goal>revision</goal>
			</goals>
		</execution>
	</executions>
	<configuration>
		<verbose>false</verbose>
		<prefix>git</prefix>
		<dotGitDirectory>${project.basedir}/.git</dotGitDirectory>
	</configuration>
 </plugin>
 ... 

```

let's maven know resource files

```xml
<build>
  <resources>
  ....
    <resource>
		<directory>src/main/resources</directory>
		<filtering>true</filtering>
		<includes>
			<include>**/*.properties</include>
			<include>**/*.xml</include>
		</includes>
	</resource
	....
```
During building the project maven will replace `${...}` with current git environments





###try-it
run `mvn spring-boot:run` 
browse `http://localhost:8080` to see the git properties


