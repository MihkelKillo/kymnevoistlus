Lihtne REST API kümnevõistluse punktide arvutamiseks.


Jookustamiseks valik kas IDE enda tööriistad, käsurealt 'mvn clean package' ja 'java -jar target/kymnevoistlus-0.1.0.jar' või Dockeriga käivitamine.

Dockeri jaoks käsud:

docker build -t kymnevoistlus .

docker run --rm -p 8080:8080 -t kymnevoistlus


UI käivitamiseks avada brauseris index.html.