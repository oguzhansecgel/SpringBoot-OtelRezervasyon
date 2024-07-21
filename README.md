# SpringBoot-OtelRezervasyon
Bu proje, otel rezervasyonlarını yönetmek için geliştirilmiş bir Spring Boot uygulamasıdır. Aşağıda, projeyi nasıl klonlayacağınız, çalıştıracağınız ve kullanacağınız adım adım açıklanmıştır.

## Gereksinimler

- Java 17+
- Maven 3.8+
- Git
- PostgreSQL
- Docker Desktop

## Kurulum

### 1. Adım: Projeyi Klonlayın

```bash
git clone https://github.com/oguzhansecgel/SpringBoot-OtelRezervasyon.git

```
### 2. Adım: Proje Dizine Geçiş Yapın

```bash
cd SpringBoot-OtelRezervasyon
```

### 3. Adım: Bağımlılıkları İndirin ve Projeyi Derleyin

```bash
mvn clean install
```

### 4. Adım: Uygulamayı Başlatın

```bash
mvn spring-boot:run
```

## Docker Kurulum 
```
FROM maven:3.8.3-openjdk-17 as build
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests


FROM openjdk:17-jdk
COPY --from=build /app/target/OtelRezervasyon-0.0.1-SNAPSHOT.jar /app/OtelRezervasyon.jar
# EXPOSE 8082
CMD java -jar /app/OtelRezervasyon.jar
```


### Uygulama çalıştıktan sonra, API uç noktalarına erişebilirsiniz. Örneğin:
-Otelleri listelemek için: GET /hotels
-Yeni bir otel eklemek için: POST /hotels
-Belirli bir oteli görmek için: GET /hotels/{id}
-Belirli bir oteli güncellemek için: PUT /hotels/{id}
-Belirli bir oteli silmek için: DELETE /hotels/{id}


