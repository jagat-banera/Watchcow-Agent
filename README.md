# Watchcow-Agent 🛰️

Watchcow Agent is a lightweight, configurable Java-based system monitoring agent designed to collect and stream infrastructure metrics such as CPU, memory, disk usage, and system load.

It is built with clean architecture principles and designed to integrate with a centralized monitoring ingestion service.

---

## 🚀 Features

- CPU usage monitoring
- Memory usage monitoring
- Disk usage monitoring
- System load average
- Configurable via `agent.properties`
- Structured JSON payload
- Scheduled execution (configurable interval)

---

## 🏗️ Architecture Overview

- _**Collectors Interface**_ - They are responsible for collection of system metrics like CPU Load , load Average , Disk Space and Memory Space.

- _**Assemblers**_ - Used as a wrapper class to wrap the Data Accumuated by Collecters. 

- 
