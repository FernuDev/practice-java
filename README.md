# Java Practice Repository

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0-green?style=flat-square&logo=springboot)
![License](https://img.shields.io/badge/License-GPL%20v3-blue?style=flat-square)

A collection of Java projects for learning and practicing core concepts, data structures, algorithms, and software architecture patterns.

---

## Projects

| Project | Description | Status |
|---------|-------------|--------|
| [`architecture/todo-app`](./architecture/todo-app) | REST API with Hexagonal Architecture | Complete |
| [`dsa`](./dsa) | Data Structures and Algorithms | In Progress |
| [`fundamentals`](./fundamentals) | Java Core Fundamentals | In Progress |

---

## Architecture - Todo App

A Spring Boot application demonstrating **Hexagonal Architecture** (Ports & Adapters).

```
domain/          Core business logic (no external dependencies)
application/     Use cases and orchestration
infrastructure/  Adapters, controllers, repositories
```

### Quick Start

```bash
cd architecture/todo-app
docker-compose up --build
```

### API Endpoints

```
POST   /api/tasks           Create task
GET    /api/tasks           List all tasks
GET    /api/tasks/{id}      Get task by ID
PUT    /api/tasks/{id}      Update task
DELETE /api/tasks/{id}      Delete task
PATCH  /api/tasks/{id}/complete   Mark as completed
```

---

## Data Structures & Algorithms

Implementations from scratch for learning purposes.

| Structure | Location |
|-----------|----------|
| Linked List | [`dsa/src/datastructures/linkedlist`](./dsa/src/datastructures/linkedlist) |
| Doubly Linked List | [`dsa/src/datastructures/doublylinkedlist`](./dsa/src/datastructures/doublylinkedlist) |
| Stack | [`dsa/src/datastructures/stack`](./dsa/src/datastructures/stack) |
| Queue | [`dsa/src/datastructures/queue`](./dsa/src/datastructures/queue) |
| Binary Search Tree | [`dsa/src/datastructures/binaryseachtree`](./dsa/src/datastructures/binaryseachtree) |

---

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](./LICENSE) file for details.
