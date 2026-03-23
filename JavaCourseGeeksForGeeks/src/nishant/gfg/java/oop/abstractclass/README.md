# Abstract Classes in Java - Examples

This module demonstrates different use cases of abstract classes in Java,
covering basic to advanced concepts.

---

## 🚀 Concepts Covered

- Abstract Classes
- Abstract Methods
- Concrete Methods
- Constructor Chaining
- Runtime Polymorphism
- Multi-Level Inheritance
- Inner Abstract Classes

---

## 🧩 Examples Included

### 1️⃣ Shape Example
- Abstract class defines a template (`Shape`)
- Subclasses (`Circle`, `Rectangle`) provide implementations
- Demonstrates polymorphism and constructor flow

---

### 2️⃣ Multi-Level Abstract Classes
- Abstract class extending another abstract class
- Partial implementation at intermediate level
- Final implementation at concrete class

---

### 3️⃣ Inner Abstract Class Example
- Abstract class inside another abstract class
- Inner class inheritance
- Demonstrates advanced OOP structure and relationships

---

## 🧠 Key Takeaways

- Abstract classes allow combining abstraction with shared behavior
- Constructors in abstract classes are invoked during subclass creation
- Partial implementation is possible across multiple levels
- Inner abstract classes enable complex hierarchical design

---

## ⚖️ Abstract Class vs Interface (Quick Insight)

| Feature | Abstract Class | Interface |
|--------|---------------|----------|
| State (variables) | ✔ | Limited (constants only) |
| Constructors | ✔ | ❌ |
| Multiple inheritance | ❌ | ✔ |
| Default implementation | ✔ | ✔ (Java 8+) |

---

## 🏁 Conclusion

Abstract classes are useful when:
- You want to define a base template
- Some behavior is common, some is specific
- You need shared state across subclasses

These examples demonstrate both basic and advanced usage patterns
of abstract classes in real-world scenarios.