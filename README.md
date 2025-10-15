# qa-final-project-java

# Ce face proiectul

La fiecare push/apasare din GitHub Actions proiectul:
1. Rulează testele definite in pseudocod în fisierul ApiTest.txt din calea src/test/java/com/toninutescu/tests/ cu mvn test
2. Construiește imaginea Docker
3. Incarca imaginea în Docker-Hub pe baza credentialelor definite (username si token): docker push toninutescu/qa-project-java:tagname


# Cum se rulează testele local (comanda mvn test)
Se asigura ca exista Java 17/temurin si Maven, conform fisierului ci.yml si porneste in radacina proiectului comanda mvn test
Astfel se simuleaza rularea testelor definite in src\test\java\com\toninutescu\tests

# Cum se construiește și se rulează imaginea Docker

Construirea imaginii Docker se face prin:
docker build -t qa-project-java:latest

Rularea imaginii Docker se face prin:
docker run --rm qa-project-java:latest

# Badge de status
[![CI Pipeline for QA Project](https://github.com/toninutescu/qa-final-project-java/actions/workflows/ci.yml/badge.svg)](https://github.com/toninutescu/qa-final-project-java/actions/workflows/ci.yml)