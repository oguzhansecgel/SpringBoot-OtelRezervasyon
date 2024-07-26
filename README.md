# SpringBoot-OtelRezervasyon
Bu proje, otel rezervasyonlarını yönetmek için geliştirilmiş bir Spring Boot uygulamasıdır. Aşağıda, projeyi nasıl klonlayacağınız, çalıştıracağınız ve kullanacağınız adım adım açıklanmıştır.

## Gereksinimler

- Java 17+
- Maven 3.8+
- Git
- PostgreSQL
- Docker Desktop
-------------------------------------------------------------------------------------
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
-------------------------------------------------------------------------------------
### Uygulama çalıştıktan sonra, API uç noktalarına erişebilirsiniz. Örneğin:
#### Otel Api
- Otelleri listelemek için: `GET api/v1/hotel/getAll`
- Yeni bir otel eklemek için: `POST api/v1/hotel/create`
- Belirli bir oteli görmek için: `GET api/v1/hotel/getById/{id}`
- Belirli bir oteli güncellemek için: `PUT api/v1/hotel/update/{id}`
- Belirli bir oteli silmek için: `DELETE api/v1/hotel/deleteHotel/{id}`
- Otellerin odalarını görmek için: `GET api/v1/hotel/withRoom/{hotelId}`
- Otellerin özelliklerini görmek için: `GET api/v1/hotel/withHotelFeatures/{hotelId}`

-------------------------------------------------------------------------------------
#### Rezervasyon Api
- Rezervasyon oluşturmak için : `CREATE api/v1/reservation/createReservation`
- Rezervasyon güncellemek için : `UPDATE api/v1/reservation/updateReservation/{id}` 
- Rezervasyon listelemek için : `GET api/v1/reservation/getAll`
- Rezervasyon silmek için : `DELETE api/v1/reservation/deleteReservation/{id}`

-------------------------------------------------------------------------------------
#### Her türlü geri bildirim ve katkıya açığım !
