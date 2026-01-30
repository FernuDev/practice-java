<div align="center">

# Java Learning Path

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Ready-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![License](https://img.shields.io/badge/License-GPL%203.0-blue?style=for-the-badge)

**A structured guide to learning Java from fundamentals to professional architecture patterns**

[Fundamentals](#fundamentals) | [Data Structures](#data-structures--algorithms) | [Architecture](#hexagonal-architecture) | [Getting Started](#getting-started)

</div>

---

## Overview

This repository serves as a progressive learning path for Java development, organized into three main modules:

```
java-learning-path/
├── fundamentals/      # Core Java syntax and concepts
├── dsa/               # Data Structures and Algorithms
└── architecture/      # Software Architecture Patterns
```

---

## Learning Modules

### Fundamentals

> **Path:** [`fundamentals/`](./fundamentals)

Core Java concepts including variables, types, control flow, and OOP principles.

| Topic | Status |
|-------|--------|
| Hello World | Done |
| Variables and Types | Done |

---

### Data Structures & Algorithms

> **Path:** [`dsa/`](./dsa)

Implementation of classic data structures from scratch, without using Java Collections.

| Data Structure | Description | Complexity |
|----------------|-------------|------------|
| [Linked List](./dsa/src/datastructures/linkedlist) | Singly linked nodes | O(n) search |
| [Doubly Linked List](./dsa/src/datastructures/doublylinkedlist) | Bidirectional traversal | O(n) search |
| [Stack](./dsa/src/datastructures/stack) | LIFO structure | O(1) push/pop |
| [Queue](./dsa/src/datastructures/queue) | FIFO structure | O(1) enqueue/dequeue |
| [Binary Search Tree](./dsa/src/datastructures/binaryseachtree) | Ordered tree structure | O(log n) average |

<details>
<summary><strong>Big O Notation Reference</strong></summary>

| Notation | Name | Example |
|----------|------|---------|
| O(1) | Constant | Array access |
| O(log n) | Logarithmic | Binary search |
| O(n) | Linear | Linear search |
| O(n log n) | Linearithmic | Merge sort |
| O(n²) | Quadratic | Bubble sort |

</details>

---

### Hexagonal Architecture

> **Path:** [`architecture/todo-app/`](./architecture/todo-app)

A production-ready REST API demonstrating clean architecture principles.

```
┌────────────────────────────────────────────────────────────────┐
│                        INFRASTRUCTURE                          │
│                                                                │
│   ┌──────────────┐      Adapters       ┌──────────────────┐   │
│   │  Controller  │ ◄─── (Driving) ───► │  External APIs   │   │
│   │    (REST)    │                     │  (HTTP Client)   │   │
│   └──────┬───────┘                     └────────┬─────────┘   │
│          │                                      │             │
│          ▼                                      ▼             │
│   ┌────────────────────────────────────────────────────┐      │
│   │                   APPLICATION                       │      │
│   │                                                     │      │
│   │    TaskService    Use Cases    Business Logic      │      │
│   │                                                     │      │
│   └────────────────────────┬───────────────────────────┘      │
│                            │                                   │
│                            ▼                                   │
│   ┌────────────────────────────────────────────────────┐      │
│   │                      DOMAIN                         │      │
│   │                                                     │      │
│   │     Models          Ports          Rules           │      │
│   │   (Task.java)    (Interfaces)   (Pure Java)        │      │
│   │                                                     │      │
│   └────────────────────────────────────────────────────┘      │
│                            ▲                                   │
│                            │                                   │
│   ┌──────────────┐      Adapters       ┌──────────────────┐   │
│   │  Repository  │ ◄─── (Driven) ────► │    Database      │   │
│   │    (JPA)     │                     │  (PostgreSQL)    │   │
│   └──────────────┘                     └──────────────────┘   │
│                                                                │
└────────────────────────────────────────────────────────────────┘
```

#### API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/tasks` | Create task |
| `GET` | `/api/tasks` | List all tasks |
| `GET` | `/api/tasks/{id}` | Get task by ID |
| `PUT` | `/api/tasks/{id}` | Update task |
| `DELETE` | `/api/tasks/{id}` | Delete task |
| `PATCH` | `/api/tasks/{id}/complete` | Mark as completed |
| `GET` | `/api/tasks/{id}/info` | Get external info |

#### Tech Stack

| Layer | Technology |
|-------|------------|
| Framework | Spring Boot 4.0 |
| Persistence | Spring Data JPA |
| Database | PostgreSQL 15 |
| Container | Docker + Docker Compose |

---

## Getting Started

### Prerequisites

- Java 17+
- Docker (optional, for todo-app)

### Run the Todo App

```bash
# Clone the repository
git clone https://github.com/your-username/practice-java.git
cd practice-java/architecture/todo-app

# Start with Docker
docker-compose up --build

# Or run locally (requires PostgreSQL)
./mvnw spring-boot:run
```

### Test the API

```bash
# Create a task
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title": "Learn Java", "description": "Complete this guide"}'

# List all tasks
curl http://localhost:8080/api/tasks
```

---

## Project Structure

```
practice-java/
│
├── fundamentals/                    # Module 1: Java Basics
│   └── src/
│       ├── HolaMundo.java
│       └── Variables.java
│
├── dsa/                             # Module 2: Data Structures
│   └── src/
│       ├── datastructures/
│       │   ├── linkedlist/
│       │   ├── doublylinkedlist/
│       │   ├── stack/
│       │   ├── queue/
│       │   └── binaryseachtree/
│       └── misc/
│           └── big_o/
│
└── architecture/                    # Module 3: Architecture
    └── todo-app/
        └── src/main/java/com/hexagonal/todo/
            ├── domain/              # Business logic (no dependencies)
            │   ├── models/
            │   └── ports/
            ├── application/         # Use cases
            │   ├── services/
            │   └── usecases/
            └── infrastructure/      # External adapters
                ├── controllers/
                ├── repositories/
                └── adapters/
```

---

