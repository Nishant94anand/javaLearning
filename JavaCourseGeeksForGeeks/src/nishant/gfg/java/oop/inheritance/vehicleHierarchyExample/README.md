# Vehicle Inheritance Example

This example demonstrates inheritance concepts in Java using a vehicle hierarchy.

---

## 🚀 Concepts Covered

- Single Inheritance
- Multilevel Inheritance
- Hierarchical Inheritance
- Method Overriding
- Code Reusability
- Encapsulation

---

## 🧩 Design Overview

### Base Class
`Vehicle`
- Common state: isStarted
- Common behavior: start(), switchOff()

---

### Derived Classes

#### Car
- Adds driving capability

#### ElectricCar
- Extends Car
- Overrides behavior (silent operation)

#### Bike
- Independent subclass of Vehicle
- Demonstrates hierarchical inheritance

---

## 🔄 Inheritance Types Demonstrated

### ✔ Single Inheritance
Car → Vehicle

### ✔ Multilevel Inheritance
ElectricCar → Car → Vehicle

### ✔ Hierarchical Inheritance
Car, Bike → Vehicle

---

## ⚡ Key Highlights

- Common functionality reused via base class
- Specialized behavior via overriding
- Real-world vehicle modeling

---

## 🧠 Interview Takeaway

> Inheritance allows code reuse and hierarchical modeling,
> while method overriding enables behavior customization.

---

## 🏁 Conclusion

This example shows how inheritance helps in building scalable
and maintainable object-oriented systems.