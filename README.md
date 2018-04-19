# test-near-earth-objects
A Near Earth Object Web Service POC.

NeoWs (Near Earth Object Web Service) is a RESTful web service for near earth Asteroid information. With NeoWs a user can: search for Asteroids based on their closest approach date to Earth, lookup a specific Asteroid with its NASA JPL small body id, as well as browse the overall data-set.

Data-set: All the data is from the NASA JPL Asteroid team (http://neo.jpl.nasa.gov/).

In this I use our API Key : VYnTDDfLv4n3QsJpar1tRbXIC8l1LSI160QMPcbT

The period used is from the date you enter to 7 days after. It's the limitation of the API
The default date is "today"

Running the application:
To run the executable goto project folder and run "start-application.bat"

Building code source:
This application is maven one. Builde it with your IDE (Netbeans, IntelliJ or Eclipse.
If you have maven installed on your machine build it with your external maven tool.


To test this application as bellow:

- At first usage I request the web server within a browser with this request :
   https://api.nasa.gov/neo/rest/v1/feed?start_date=2018-04-19&end_date=2018-04-19&api_key=VYnTDDfLv4n3QsJpar1tRbXIC8l1LSI160QMPcbT
   it return a json that I stor in file called "test.json" stored under classpath folder.
- Each time I run the application or I run the application test, it read the file stored in class path, parse it as java List called localObjects.
  then I send a request to the server with the same date "2018-04-19" the result is parsed in another java List called remoteList
- after tha, I compare the results.
- I implement an "equals" methode for each object to compare objects and children of the object.
- I compare the size of these java lists too.


The code can be shared via Google Drive, sent via Skype.
I plan to push it to Github.

Thanks!
