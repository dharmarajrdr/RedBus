# RedBus – Low Level Design Requirements

## 1. Overview
RedBus is an online bus ticket booking platform that allows users to search buses, view seat availability in real time, reserve seats, make payments, and receive confirmed tickets.  
This document lists **core LLD-level requirements** that translate directly into classes, services, state machines, and APIs.

---

## 2. Top 5 Functional Requirements (LLD Focused)

### 2.1 Real-Time Seat Availability & Locking
- System must show **near real-time seat availability** per bus, route, and date.
- When a user selects seats, those seats must be **temporarily locked** for a fixed TTL (e.g., 5 minutes).
- Seat locking must prevent **double booking** under concurrent requests.
- Lock must be released automatically on:
    - Payment failure
    - Timeout expiration
    - User cancellation
- Requires:
    - SeatState (`AVAILABLE`, `LOCKED`, `BOOKED`)
    - Lock ownership (user/session based)
    - TTL-based eviction

---

### 2.2 Bus Search & Route Scheduling
- Users must be able to search buses based on:
    - Source
    - Destination
    - Date of journey
- Search results must include:
    - Operator details
    - Departure/arrival times
    - Fare
    - Seat availability count
- System must support **multiple schedules** per bus per day.
- Requires:
    - Route, Schedule, Bus, Operator entities
    - Efficient indexing on (source, destination, date)

---

### 2.3 Booking Lifecycle Management
- Booking must follow a **well-defined state machine**:
    - `INITIATED → SEATS_LOCKED → PAYMENT_PENDING → CONFIRMED / FAILED`
- Each state transition must be **idempotent**.
- Booking record must be created **before payment** to track retries.
- Partial failures must not corrupt seat state.
- Requires:
    - Booking entity with state transitions
    - Transaction boundary definitions

---

### 2.4 Payment Processing & Confirmation
- System must integrate with one or more payment gateways.
- Payment callbacks/webhooks must be:
    - Idempotent
    - Verifiable (signature validation)
- Booking confirmation must occur **only after payment success**.
- Seat state must move from `LOCKED → BOOKED` atomically.
- Requires:
    - PaymentAttempt entity
    - Callback handler with retry safety
    - Atomic booking finalization logic

---

### 2.5 Ticket Generation & Notification
- On successful booking:
    - Generate a unique Ticket ID / PNR
    - Persist ticket and passenger details
- System must send:
    - SMS / Email confirmation
    - Downloadable ticket (PDF / QR)
- Ticket must be retrievable anytime using:
    - Booking ID
    - PNR
- Requires:
    - Ticket entity
    - Notification service abstraction

---

## 3. Non-Functional Requirements (LLD-Relevant)

- **Concurrency Handling**: Must support high contention on popular routes.
- **Consistency**: Strong consistency required for seat booking.
- **Latency**:
    - Seat lock operation < 200ms
    - Booking confirmation < 2s
- **Fault Tolerance**:
    - Payment callback retries
    - Seat lock recovery on crashes
- **Idempotency**:
    - Payment confirmation
    - Booking state transitions

---

## 4. Out of Scope

- User reviews and ratings
- Offers, coupons, loyalty programs
- Dynamic pricing algorithms
- Admin dashboards
- Analytics & reporting

---

## 5. Assumptions & Constraints

- Peak traffic during weekends and holidays
- A bus can have 30–60 seats
- Lock TTL is configurable (default: 5 minutes)
- Single booking = single bus journey
- Strong consistency preferred over availability for seat booking