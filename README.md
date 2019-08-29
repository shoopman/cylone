# Introduction

Cyclone is a light-weight library to convert pojos.

# Usage

## Introduce to your project

Gradle build.gradle

```gradle
    compile("net.meku.cylone:cylone:1.0-SNAPSHOT")
```

Maven pom.xml 

```xml

	<dependency>
		<groupId>net.meku.cylone</groupId>
		<artifactId>cylone</artifactId>
		<version>1.0-SNAPSHOT</version>
	</dependency>
        
```

## Convert your pojos

First, create your own converters.

```java

public class AttachmentConverter extends BeanCopyPojoConverter<Attachment, AttachmentView> {
    
    protected void afterBeanCopy(AttachmentView source, Attachment target) {
        // do something
    }
}

```

Now you can convert your pojos.

```java

    AttachmentConverter converter = new AttachmentConverter();
    Attachment model = converter.toPojo(view);
    List<Attachment> models = converter.toList(views);

```

Use *SimpleConverter* if you only have simple properties to pass between pojos.

```java

    SimpleConverter<Article, ArticleView> converter = new SimpleConverter<>();
    Article model = new Article();
    converter.toPojo(view, model);

```