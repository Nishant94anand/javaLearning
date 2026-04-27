# Notification System — Java OOP Practice Project

## Overview

This is a simple Java-based Notification System built to practice core Object-Oriented Programming concepts including:

* Constructors
* Packages and Access Modifiers
* Abstraction
* Polymorphism

The system supports multiple notification channels such as Email, SMS, and Push Notifications.

---

## Project Structure

nishant.gfg.java.oop.notification

* base/

  * Notification.java (Abstract base class)

* channels/

  * EmailNotification.java
  * SMSNotification.java
  * PushNotification.java

* service/

  * NotificationService.java

* app/

  * Main.java (Entry point)

---

## Key Concepts Demonstrated

### 1. Constructors

Each notification type has its own constructor to initialize specific fields:

* EmailNotification → emailId, message
* SMSNotification → mobileNumber, message
* PushNotification → deviceId, message

Base class constructor is invoked using super().

---

### 2. Packages and Access Modifiers

The project is divided into multiple packages:

* base → abstraction
* channels → implementations
* service → orchestration
* app → entry point

Protected access modifier is used in the base class so that subclasses in different packages can access shared fields.

---

### 3. Polymorphism

The Notification reference is used to hold different types of objects:

Notification n = new EmailNotification(...);

At runtime, the correct send() method is executed based on object type.

---

### 4. Abstraction

The Notification class defines an abstract method send() which must be implemented by all subclasses.

---

## How It Works

1. Main class creates different notification objects
2. Each object is passed to NotificationService
3. Service calls send() method
4. Correct implementation executes based on runtime type

---

## Sample Flow

* Create EmailNotification
* Create SMSNotification
* Create PushNotification
* Pass all to NotificationService
* Each sends notification using its own logic

---

## Learning Outcome

This project helps in understanding:

* How constructors work with inheritance
* How packages organize code
* How access modifiers control visibility
* How polymorphism enables flexible design

---

## Future Enhancements

* Add Notification Priority
* Add Retry Mechanism
* Add Logging
* Add Notification Queue
* Add Email/SMS validation

---

## Author

Nishant Anand

---

## Final Note

This is a beginner-friendly but conceptually strong project designed to build a solid foundation in Java OOP.