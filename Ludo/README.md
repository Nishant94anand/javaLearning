# 🎲 Configurable Ludo Game — Java CLI

A fully customizable command-line Ludo game built in Java as a Low Level Design (LLD) practice project.

Unlike classic Ludo, this implementation allows you to configure almost every aspect of the game — enabling you to create your own rule variations while still supporting traditional gameplay.

---

## 🚀 Features

* Fully configurable board, players, coins, and dice
* Circular turn system using Circular Doubly Linked List
* Move handling using Deque (FIFO queue)
* Capture mechanics with safe zones
* Intelligent move validation
* Dynamic leaderboard with elimination
* Fun and quirky CLI interaction

---

## 📦 Project Structure

nishant.ludo/

* Ludo.java            → Entry point
* Game.java            → Game orchestration (configuration + play loop)
* Board.java           → Board state and capture logic
* Player.java          → Player behavior and move selection
* Coin.java            → Coin state and movement logic
* Die.java             → Dice logic
* PlayerDLLNode.java   → Node for circular player rotation
* PlayerDLLHelper.java → DLL utilities

---

## ▶️ How to Run

Prerequisite: Java 8+

Compile:
javac nishant/ludo/*.java

Run:
java nishant.ludo.Ludo

---

## ⚙️ Game Configuration

### Board

* Total Size → Total cells on board
* Journey Size → Cells to cover before safe lane
* Safe Lane Length → Range: 0–10
* Safe Spots → Any number of safe cells

---

### Players

* Number of Players → Minimum 2, must divide board size
* Coins per Player → Range: 1–10
* Color → Must be unique
* Name → User input

---

### Die

* Max Number → Upper bound of die
* Special Number → Grants extra roll

---

## 🎮 Gameplay Rules

### Turn Flow

1. Player rolls the die
2. Score is added to queue
3. Special number → extra roll
4. 3 consecutive special numbers → all 3 cancelled + extra roll
5. Moves processed in FIFO order (no skipping allowed)

---

### Movement Rules

* Only eligible coins can move
* Coin inside home requires special number
* Movement cannot overshoot destination
* Safe lane handled separately

---

### Capture Rules

* Landing on opponent → capture
* Captured coin goes back to home
* No capture on safe spots
* Capture gives extra roll

---

### Winning Logic

* All coins complete → player wins
* Player removed from turn rotation
* Added to leaderboard
* Game ends when only one player remains

---

## 🧠 Design Highlights

### Circular Doubly Linked List

Used for player rotation:

* Supports round-robin turn system
* Enables O(1) removal when a player wins

---

### Deque for Move Scores

Used to maintain move order:

* FIFO processing
* Supports chained rolls
* Handles capture bonus
* Handles triple-special cancellation

---

### Dual Mapping (Board State)

locationToCoinMap → position → coin
coinToLocationMap → coin → position

* Enables constant-time updates and lookups
* Keeps board state consistent

---

### Object-Oriented Design

* Game → Controls flow
* Board → Maintains state
* Player → Handles decisions
* Coin → Handles movement
* Die → Generates random values

---

## 🎭 Game Personality

This project uses fun and informal CLI messages instead of strict system prompts.

Examples:

* "Come on!! Common sense use karo!!"
* "Really?? Beyond the board??"
* "ooops!! 3 specials… sab gaya!"

---

## ⚠️ Important Notes

This is a learning-focused project:

* Multiple Scanner instances are used intentionally
* No mid-game exit or restart feature
* Some tight coupling exists for simplicity

---

## 🧪 Sample Gameplay

Refer to:
ludo_cli_mockup.txt

---

## 🎯 Classic Ludo Configuration

Use these values to play classic Ludo:

* Board Size → 52
* Journey Size → 50
* Safe Lane Length → 6
* Safe Spots → 0, 8, 13, 21, 26, 34, 39, 47
* Coins → 4
* Players → 4
* Die Max → 6
* Special Number → 6

---

## 🚀 Future Improvements

* GUI version (JavaFX / Web)
* AI players
* Save and load game state
* Undo functionality
* Multiplayer support

---

## 👨‍💻 Author

Nishant Anand

---

## ⭐ Final Thought

This is not just a game.
This is a design playground disguised as Ludo.
