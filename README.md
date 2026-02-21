# 🛑 Party DETECTOR
### Smart Dorm Noise Monitoring System

Party Patrol is an IoT-based monitoring system designed to detect excessive noise in student dormitories during quiet hours and automatically notify security staff via a real-time dashboard.

The system integrates hardware sensors, cloud-based backend services, and a web interface to improve student wellbeing and dormitory management.

---

## 📌 Problem

In student residences:

- Loud music after midnight disturbs residents
- Noise complaints are handled manually
- Security response is delayed
- No historical data is collected

There is no automated, scalable solution for monitoring and managing noise violations.

---

## 💡 Solution

Party Patrol provides an automated monitoring system that:

1. Detects excessive noise using sound sensors
2. Applies time-based rules (quiet hours)
3. Sends alerts via HTTP to a backend server
4. Stores violations in a database
5. Displays real-time alerts on a dashboard

---

## 🏗️ System Architecture


Sound Sensor
↓
ESP32 (C++)
↓ HTTP (JSON)
Spring Boot API (Java 21)
↓
Database (H2 / PostgreSQL)
↓
Web Dashboard (React)
↓
Security Staff


---

## ⚙️ Technology Stack

### Hardware
- ESP32 (WiFi-enabled microcontroller)
- Big Sound sensor module
- Optional LED indicators

### Backend
- Java 21
- Spring Boot 3.x
- Spring Data JPA
- H2 / PostgreSQL
- REST API

### Frontend
- React
- Vite
- TypeScript
- React Query

---

## ✨ Features

### Noise Detection
- Continuous sound sampling
- Configurable threshold
- Noise duration validation

### Quiet Hours Enforcement
- Weekdays (Mon–Fri)
- 00:00–07:00 time window
- NTP time synchronization

### Alert Management
- Automatic alert creation
- Persistent storage
- Acknowledge functionality

### Dashboard
- Live room monitoring
- Alert history
- Auto-refresh
- Status indicators

---

## 🔌 API Endpoints

### Create Alert (ESP32 → Server)

POST /api/alerts


```json
{
  "deviceId": "ESP32-01",
  "location": "Dorm A - Floor 2 Corridor",
  "noiseLevel": 780,
  "duration": 12
}
```

## Get Latest Alerts
```
GET /api/alerts/latest
Acknowledge Alert
POST /api/alerts/{id}/ack
Get Rooms
GET /api/rooms
```

## Running the Backend
## Requirements

Java 21

Maven

## Check installation:

java -version
mvn -version
Start Server
mvn spring-boot:run

## Server will run at:

http://localhost:8080
H2 Database Console
http://localhost:8080/h2

## JDBC URL:

jdbc:h2:mem:partydetector
🧪 Testing with Curl

## Create a test alert:

curl -X POST http://localhost:8080/api/alerts \
  -H "Content-Type: application/json" \
  -d '{"deviceId":"ESP32-01","location":"Dorm A - Floor 2 Corridor","noiseLevel":780,"duration":15}'

## Get alerts:
```
curl http://localhost:8080/api/alerts/latest
```

##📡 ESP32 Communication Flow

- Connects to WiFi

- Synchronizes time via NTP

 - Reads sound sensor values

- Applies rule validation

- Sends HTTP POST request

- Waits for server response

## 📊 Data Model
 - Room

- id

- name

- floor

- deviceId

- currentNoise

- lastUpdate

## Alert

- id

- deviceId

- location

- noiseLevel

- duration

- createdAt

- status (NEW / ACK)

##  Future Improvements

AI-based sound classification

SMS / Telegram notifications

User authentication

Multi-building support

Docker deployment

Advanced analytics

## 🏆 Hackathon Impact

Party Patrol demonstrates:

- IoT integration

- Cloud backend development

- RESTful architecture

- Hardware–software synergy

- Practical social impact

👩‍💻 Team

Developed as part of a hackathon project focused on improving student wellbeing and dormitory life through smart systems.

## TEAM MEMBERS 
- Daria Konstantinova
- Philipp Wiedemann 
- Bahar Ozdemir
