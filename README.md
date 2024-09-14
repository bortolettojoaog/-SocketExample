# 🌟 Welcome to SocketExample!

This is a simple project that demonstrates the use of UDP and TCP sockets in Java.

## 🌐 Language:

-   [Read in English](#-getting-started)

## 🚀 Getting Started:

### 📋 Prerequisites:

Make sure you have [Git](https://git-scm.com/) and [Java](https://www.oracle.com/java/technologies/javase-downloads.html) installed on your machine.

### 📂 Cloning the Repository:

```bash
git clone https://github.com/bortolettojoaog/SocketExample.git

cd SocketExample
```

### 🔧 Building the Project:

```bash
mvn clean install
```

### ▶️ Running the UDP:

```bash
##Client:
java -cp target/SocketExample-1.0-SNAPSHOT.jar udp.UDPclient

##Server:
java -cp target/SocketExample-1.0-SNAPSHOT.jar udp.UDPserver
```

### ▶️ Running the TCP:

```bash
##Client:
java -cp target/SocketExample-1.0-SNAPSHOT.jar tcp.TCPclient

##Server:
java -cp target/SocketExample-1.0-SNAPSHOT.jar tcp.TCPserver
```

### 📖 How to Use:

1. Start the server (UDP or TCP) using the commands above.
2. Start the client (UDP or TCP) using the commands above.
3. Follow the prompts in the client to send messages to the server.
4. Observe the server's responses in the console.

### 🤝 Contributing:

1. Fork the project.
2. Create a branch for your feature (`git checkout -b feature/new-feature`).
3. Commit your changes (`git commit -m 'feat: add new feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Open a Pull Request.

### 🌟 Best Practices:

It is important to use Git Flow to manage your branches:

-   `feature` for new features
-   `bugfix` for bug fixes
-   `hotfix` for urgent fixes

Also, use Conventional Commits to standardize your commit messages:

-   `feat` for new features
-   `fix` for bug fixes
-   `chore` for maintenance tasks
-   `style` for style changes (formatting, etc.)
-   `docs` for documentation

### 🛠️ Technologies Used:

-   [Java](https://www.oracle.com/java/)
-   [Maven](https://maven.apache.org/)

### 📄 License:

This project is licensed under the MIT License. See the [LICENSE](./LICENSE) file for more details.

---

<p align="center">Made with ❤️ by João Guilherme Bortoletto 👋</p>

<p align="center">
    <a href="https://www.linkedin.com/in/bortolettojoaog/">See my LinkedIn</a>
</p>
