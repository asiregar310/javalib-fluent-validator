# fluent-validator

fluent api for making validation code become more readable.

example:

```java
// to validate string value that must have a value and minimal length is 5.
SomeObject obj = new SomeObject();

Validator validator = Validator.create()
    .propertyOf(obj.getProperty1(), "Property #1").mustNotNullOrEmpty()
    .propertyOf(obj.getProperty1(), "Property #1").minLength(5)
    .validate();

if (!validator.isValid())
    System.out.println("invalid: " + validator.getMessages());
else
    System.out.println("valid");
```
