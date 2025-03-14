# Using Hadoop Client Library in Java + Keytab Without Installing krb5 on Client

```
lh-java-hdfs/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/example/
│   │   │   │   ├── KerberosLogin.java
│   │   │   │   ├── HadoopClientApp.java
│   ├── resources/
│   │   ├── core-site.xml
│   │   ├── jaas.conf
│   │   ├── krb5.conf
│── pom.xml
│── README.md
```

---

## Build and Run the Java Application**
📌 **Build the project with Maven**

```bash
mvn clean package
```

📌 **Run the Java application (no need for `krb5`)**

```bash
java -Djava.security.auth.login.config=/etc/security/jaas.conf      -Djava.security.krb5.conf=/etc/security/krb5.conf      -jar target/hadoop-client-app-1.0-SNAPSHOT.jar
```

✅ **Java will authenticate with Kerberos and access HDFS without installing `krb5`! 🎯**

---

## **🔥 Summary**
| **Step** | **Description** | **File(s)** |
|----------|---------------|--------------|
| ✅ Configure Hadoop Client | Enable Keytab-based authentication | `core-site.xml` |
| ✅ Setup Java Kerberos Authentication | Allow Java to use Keytab directly | `jaas.conf` |
| ✅ Configure Kerberos Realm | Define KDC settings | `krb5.conf` |
| ✅ Implement Kerberos Authentication in Java | Use `LoginContext` for authentication | `KerberosLogin.java` |
| ✅ Access HDFS via Hadoop Client Library | Read files from HDFS | `HadoopClientApp.java` |
| ✅ Add Maven Dependencies | Include Hadoop Client Library | `pom.xml` |
| ✅ Build and Run Java App | Compile and execute the project | `mvn clean package && java -jar` |
