# jpa-sandbox

## Mapping @OneToMany

https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/

## Unidirectional

Relationship is defined in one direction only. (one of the 2 classes)

## bidirectional

A bidirectional relationship, on the other hand, would involve foreign keys and references in both tables, creating a
link in both directions.

## 2 options

- a unidirectional @OneToMany association
- a bidirectional @OneToMany association

### Unidirectional @OneToMany (no joincolumn)

```java

@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
private List<PostComment> comments = new ArrayList<>();
```

Generates a third table like a @ManyToMany -> Not efficient

### Unidirectional @OneToMany (with joincolumn)

```java

@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
@JoinColumn(name = "post_id")
private List<PostComment> comments = new ArrayList<>();
```

Better but still not the most efficient way

### Bidirectional @OneToMany

The best way to map a @OneToMany association is to rely on the @ManyToOne side to propagate all entity state changes:



### Extra comments
Therefore, in reality, @OneToMany is practical only when many means few. Maybe @OneToFew would have been a more suggestive name for this annotation.

Therefore, most of the time, the @ManyToOne annotation on the child side is everything you need. But then, how do you get the child entities associated with a Post entity?