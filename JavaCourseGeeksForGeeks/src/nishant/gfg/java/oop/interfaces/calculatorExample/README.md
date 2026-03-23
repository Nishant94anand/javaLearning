# Calculator using Java Interfaces

This example demonstrates how Java interfaces can be used to achieve
abstraction, code reuse, and multiple inheritance of behavior.

---

## 🚀 Concepts Covered

- Abstraction using Interfaces
- Multiple Inheritance via Interfaces
- Default Methods in Interfaces
- Code Reusability
- Clean Separation of Responsibilities

---

## 🧠 Key Idea

Each mathematical operation (Add, Subtract, Multiply, Divide) is defined
as a separate interface.

These interfaces provide default implementations, allowing a class to
reuse behavior without explicitly implementing every method.

---

## 🧩 Design Overview

### Interfaces

- `MathAddable` → provides addition logic
- `MathSubtractable` → provides subtraction logic
- `MathMultipliable` → provides multiplication logic
- `MathDividable` → provides division logic

Each interface:
- Defines a specific capability
- Uses `default` methods to provide implementation

---

### Implementation Class

- `MathCalculator`

This class:
- Implements all operation interfaces
- Inherits default implementations
- Overrides division logic to add validation (divide-by-zero check)

---

### Execution Class

- `Calculations`

This class:
- Acts as entry point (`main` method)
- Demonstrates usage of calculator operations

---

## 🔧 Example Flow

1. Create calculator instance
2. Call individual operations:
   - add()
   - subtract()
   - multiply()
   - divide()
3. Execute all operations together using `performAllOperations()`

---

## ⚡ Key Highlights

- No method implementation required in class (thanks to default methods)
- Multiple behaviors combined into a single class
- Safe override of default method (division)

---

## 🧠 Interview Takeaway

> Java supports multiple inheritance of behavior through interfaces,
> and default methods allow sharing implementation without breaking
> existing classes.

---

## 📌 Notes

- Default methods help extend interfaces without impacting existing implementations
- Interfaces define behavior; classes control execution and validation

---

## 🏁 Conclusion

This example shows how interfaces can go beyond contracts and act as
behavior providers, enabling clean, modular, and extensible designs.