public class Flughafen 
{
    public static void main(String[] args) 
    {
        Airport airportTest = new Airport(3);

        //ich war bis jetzt zu faul für eine Benutztereingabe (bzw bin mir gar nicht //
        //sicher ob man das überhaupt machen soll). Deswegen kann man das hier wie bei//
        //den drei Beispielen testen//

        Flight flug1 = new Flight();
        flug1.flightNumber=187;
        flug1.location="Tunesien";
        flug1.gate="87";
        flug1.time="15:37";
        flug1.inOut= true;
        airportTest.addNewFlight(flug1);


        Flight flug2 = new Flight();
        flug2.flightNumber=318;
        flug2.location="Malediven";
        flug2.gate="30";
        flug2.time="13:37";
        flug2.inOut= false;
        airportTest.addNewFlight(flug2);
        

        Flight flug3 = new Flight();
        flug3.flightNumber=361;
        flug3.location="America";
        flug3.gate="56";
        flug3.time="11:55";
        flug3.inOut= false;
        airportTest.addNewFlight(flug3);

        airportTest.removeFlight(187);

        airportTest.listDepaturesOnScreen();
        airportTest.listArrivalsOnScreen();
    
    }    
}

class Flight
{
    int flightNumber; // Flugnummer
    String location; // Abflugs-/Zielort
    String gate; // Gate
    String time; // Abflugs-/Ankunftszeit
    boolean inOut; // ein- oder abgehender Flug
}

class Airport
{
    private Flight[] Array;
    private int Anzahl;

    Airport (int maxFlights)
    {
        //erstellt Arrays in der angegebenen Größe
        Array = new Flight[maxFlights];
        for(int i = 0; i<Array.length;i++)
            {
                //weißt jedem Teil des Arrays ein leeres Flight object zu
                Array[i] = new Flight();
            }
        Anzahl = -1;
    }

    void addNewFlight (Flight flight)
    {
        //existiert, damit Programm sieht, ob im Array noch Platz ist
        Anzahl++;
        //doppelter Flug
        for(int i = 0; i<Array.length; i++)
        {
            if (Array[i].flightNumber == flight.flightNumber)
            {
                System.out.println("Flug existiert bereits");
                return;
            }
        }

        //zu viele Flüge
        if(Anzahl>Array.length-1)
        {
            System.out.println("Maximale Anzahl an Flügen überschritten!");
            return;
        }
        else
        {
            System.out.println("Flug " + flight.flightNumber+ " hinzugefügt!");
            //Dem nächsten freien Arrayplatz (sieht man an Anzahl) wird der eingegebene Flug zugewiesen
            this.Array[Anzahl] = flight;
        }
    }

    void removeFlight (int flightNumber)
    {
        for (int i=0; i<Array.length;i++)
        {
            //passende Nummer gefunden
            if(Array[i].flightNumber==flightNumber) 
            {
                System.out.println("Flug " + flightNumber+ " entfernt!");
                //alle Flüge werden eins vorgezogen, der letzte Flug existiert nun zweimal
                for(int j = i; j<Array.length-1;j++) 
                {
                    Array[j] = Array[j+1];
                }
                //Der letzte (doppelte) Wert wird mit einem leeren object Flight ersetzt, was später wieder belegt werden kann
                Array[Anzahl] = new Flight();
            }
        }
        //Da Flug entfernt wurde ist im Array wieder ein Platz mehr frei
        Anzahl--; 
    }
    
    
    void listDepaturesOnScreen() //ausgehend
    {
        System.out.println("");
        System.out.println("Ausgehende Fluege:");
        for(int i = 0; i<Array.length;i++)
        {
            if((this.Array[i].flightNumber!=0) && (this.Array[i].inOut==false))
            {
                System.out.println("Flugnummer: " + Array[i].flightNumber);
                System.out.println("Zielort: " + Array[i].location);
                System.out.println("Gate: " + Array[i].gate);
                System.out.println("Ankunftszeit: " + Array[i].time);
                System.out.println("");
            }
        }
    }
    
    void listArrivalsOnScreen() //eingehend
    {
        System.out.println("");
        System.out.println("Eingehende Fluege:");
        for(int i = 0; i<Array.length;i++)
        {
            if((Array[i].flightNumber!=0) && (Array[i].inOut==true))
            {
                System.out.println("Flugnummer: " + Array[i].flightNumber);
                System.out.println("Abflugsort: " + Array[i].location);
                System.out.println("Gate: " + Array[i].gate);
                System.out.println("Abflugszeit: " + Array[i].time);
                System.out.println("");
            }
        }
    }
}