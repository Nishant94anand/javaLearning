# Bank Account Inheritance Example

This example demonstrates core Object-Oriented Programming concepts in Java using a banking system.

---

## 🚀 Concepts Covered

- Inheritance (Single Level)
- Abstract Classes
- Method Overriding
- Runtime Polymorphism
- Encapsulation of business logic

---

## 🧩 Design Overview

### 🔹 Abstract Base Class : BankAccount

- Contains common properties:
  - accountNumber
  - balance
- Provides shared methods:
  - deposit()
  - withdraw()
  - showBalance()
- Defines abstract method:
  - calculateInterest()

---

### 🔹 Concrete Implementations

#### SavingsAccount
- Provides interest calculation
- Uses static interest rate

#### CurrentAccount
- Overrides interest logic
- No interest applied

---

## 🔄 Runtime Polymorphism

```java
BankAccount acc = new SavingsAccount();
acc.calculateInterest();