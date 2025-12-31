# --- STAGE 1(første image): Build app ---

FROM maven:3.9.9-eclipse-temurin-21 AS build
#---  Dette betyder at der startes et Docker image. Imageen indeholder Linux, Java 21o g Maven 3.9.9---
#---   AS build giver trinet et navn og vi kalder det build  ---
#---   OVERORDNET Jeg bruger et Maven-image til at bygge Java-applikationen ---

WORKDIR /app
#---  Her oprettes der mappen /app(app kunne  lige så godt hedde andet) inde i containeren   ---
#---   Herfra køres de næste kommandoer inde i mappen app   ---
#---  OVERORDNET  WORKDIR sætter den mappe(app), vi arbejder i inde i containeren.  ---


COPY pom.xml .
#--- Her kopieres pom.xml fra mit projekt    ---
#---   Den kopieres ind i /app ind i containeren  ---
#---  pom.xml beskriver nemlig de forskellige afhængigheder programmet har   ---
#---   Vi kopierer pom.xml først for at udnytte Docker build cache.  ---

RUN mvn dependency:go-offline
#---  Her kører vi en kommando inde i containeren   ---
#---    Der downloades alle Maven dependencies(spring boot, mySQLdriver osv) ---
#---  De gemmes derefter i containerenes cache(betyder Docker gemmer resultatet af et trin) hvis input ikke ændres springes trinnet over   --
#---   gp-offline betyder download alt nu så jeg ikke behøver internet senere  ----

#---   Hvis de 2 første trin ikke var der ville hvergang man lavet ny java kode ville Docker tro alt er nyt og Maven ville downloade alt igen fx(det er langsomt)  ---

COPY src ./src
#---  Her kopieres der java-kildekoden ( src: er java koden, den ændres hvergang der en fejl elelr rettelse.  )   ---
#---   Det gøres her fordi dependencies ændres sjælendt, og kode ændres ofte, så det gøre build hurtigere  ---
#---  Det gør cache bedre, fordi Docker skal igennem færre trin , det giver hurtugere builds end hvis den var før forrige step   ---


RUN mvn package -DskipTests
#---  mvn package Her bygges .jar filen(alt kode libaries osv)    ---
#---  -DskipTests test springes over(Docker build bruges til at pakke appen, ikke til at se om der fejl i koden) ---
#---  Test køres i CI og ikke i Docker build   ---






# --- STAGE 2 (andet image): Run app ---
FROM eclipse-temurin:21-jre
# --- (From) starter et nyt image, som indeholder java, dOCKER SIGER DEN VIL BYGGE VIDERE PÅ NOGET DER ALLEREDE FINDES---
# --- (eclipse-temurin) NAVNET PÅ ET FÆRDIGT Docker image, som imdeholder java---
# ---(21-jre) 21 betyder java version 21 og jre betyder Java runtime enviorment, sim betyder java kan køre programmer, det til at køre ikke udvikle som jdk ---
# --- OVERORDNET Her starter vi et nyt runtime-image med Java 21, som kun bruges til at køre den færdige .jar-fil, ikke til at bygge applikationen. ---


WORKDIR /app
# --- Her laves der igen en mappe vi kalder /app og den den pakkes ind i en container  ---


COPY --from=build /app/target/*.jar app.jar

# ---(COPY --from=build ) Her siges der tag en fil og kopier fra det tideligere build-stage ---
# --- (/app/target/*.jar app.jar) dette er stien inde i build-containeren ---
# --- (/target) er der maven lægger sit resultate, det er dens output mappe  ---
# --- (*.jar) betyder “den .jar-fil der findes---
# ---(app.jar) navnet vi giver filen i runtime-containeren ---
# --- ---


ENTRYPOINT ["java", "-jar", "app.jar"]
# ---ENTRYPOINT svarer på helt præcist hvilket program der skal starte når comtaineren start ---
# ---ENTRYPOINT uden det starter container, der sker intet og containeren stopper igen ---
# --- ["java", "-jar", "app.jar"] betyder start java, kør .jar-filen og start backend-applikation---


# ---Når man så kører containeren med docker run mit-image ---
# --- Docker starter containeren ---
# -- Docker kører ENTRYPOINT kommandoen  ----
# -- Java-applikationen start ----
# --  Containeren kører så længe appen kører (fejl i kode, forkert db-connection akn gøre appen ik kører ----