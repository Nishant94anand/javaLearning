# Discount Engine Example

This example demonstrates key Java interface concepts in a real-world scenario.

## Concepts Covered

- Functional Interfaces (Java 8+)
- Lambda Expressions
- Strategy Design Pattern
- Interface Constants (`public static final`)
- Clean separation of business logic

## Key Idea

Instead of hardcoding discount logic, we use a functional interface (`PricingStrategy`)
to dynamically inject behavior at runtime.

## Highlights

- Different pricing strategies (Festive, Premium, Super Premium)
- Discount capping using `MAX_DISCOUNT`
- Tax applied using shared constants
- Clean and extensible design

## Takeaway

This pattern allows:
- Flexible business rules
- Easy extension without modifying existing code
- Clean and maintainable architecture