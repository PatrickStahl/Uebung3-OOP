public class Flughafen 
{
    public static void main(String[] args) 
    {
        Airport airportTest = new Airport(2);

        //ich war bis jetzt zu faul für eine benutztereingabe (btw bin mir gar nicht //
        //sicher ob man das überhaupt machen soll), weswegen man das hier machen wuss//

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
        
        airportTest.removeFlight(318);

        Flight flug3 = new Flight();
        flug3.flightNumber=361;
        flug3.location="America";
        flug3.gate="56";
        flug3.time="11:55";
        flug3.inOut= false;
        airportTest.addNewFlight(flug3);

        

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
    private int [] NumberArray;
    private String [] LocationArray;
    private String [] GateArray;
    private String [] TimeArray;
    private boolean [] InOutArray;
    private int Anzahl;

    public Airport (int maxFlights)
    {
        NumberArray = new int[maxFlights];
        LocationArray = new String[maxFlights];
        GateArray = new String[maxFlights];
        TimeArray = new String[maxFlights];
        InOutArray = new boolean[maxFlights];
        Anzahl = -1;
    }

    public void addNewFlight (Flight flight)
    {
        //existiert, damit Programm sieht, ob im Array noch Platz ist
        Anzahl++; 
        for(int i = 0; i<NumberArray.length; i++)
        {
            if (NumberArray[i] == flight.flightNumber)
            {
                System.out.println("Flug existiert bereits");
                return;
            }
        }

        if(Anzahl>NumberArray.length-1)
        {
            System.out.println("Maximale Anzahl an Flügen überschritten!");
            return;
        }
        else
        {
            System.out.println("Flug " + flight.flightNumber+ " hinzugefügt!");
            NumberArray[Anzahl] = flight.flightNumber;
            LocationArray[Anzahl] = flight.location;
            GateArray[Anzahl] = flight.gate;
            TimeArray[Anzahl] = flight.time;
            InOutArray[Anzahl] = flight.inOut;
        
        }
    }

    public void removeFlight (int flightNumber)
    {
        for (int i=0; i<NumberArray.length;i++)
        {
            //passende Nummer gefunden
            if(NumberArray[i]==flightNumber) 
            {
                System.out.println("Flug " + flightNumber+ " entfernt!");
                //alle Flüge werden eins vorgezogen, der letzte Flug existiert nun zweimal
                for(int j = i; j<NumberArray.length-1;j++) 
                {
                    NumberArray[j]=NumberArray[j+1];
                    LocationArray[j]=LocationArray[j+1];
                    GateArray[j]=GateArray[j+1];
                    TimeArray[j]=TimeArray[j+1];
                    InOutArray[j]=InOutArray[j+1];
                }
            }
        }
        //letzter Flug aus altem Array wird auf 0 gesetzt, da alle eins aufgerückt sind
        NumberArray[Anzahl]=0;
        LocationArray[Anzahl]="-";
        GateArray[Anzahl]="-";
        TimeArray[Anzahl]="-";
        InOutArray[Anzahl]=false;
        //Da Flug entfernt wurde ist im Array wieder ein Platz mehr frei
        Anzahl--; 
    }
    
    //ich bin mir nicht sicher, ob eingehend true oder falsch sein soll
    public void listDepaturesOnScreen() //ausgehend
    {
        System.out.println("");
        System.out.println("Ausgehende Fluege:");
        for(int i = 0; i<NumberArray.length;i++)
        {
            if((NumberArray[i]!=0) && (InOutArray[i]==false))
            {
                System.out.println("Flugnummer: "  + NumberArray[i]);
                System.out.println("Zielort: " + LocationArray[i]);
                System.out.println("Gate: " + GateArray[i]);
                System.out.println("Ankunftszeit: " + TimeArray[i]);
                System.out.println("");
            }
        }
    }
    
    public void listArrivalsOnScreen() //eingehend
    {
        System.out.println("");
        System.out.println("Eingehende Fluege:");
        for(int i = 0; i<NumberArray.length;i++)
        {
            if((NumberArray[i]!=0) && (InOutArray[i]==true))
            {
                System.out.println("Flugnummer: "  + NumberArray[i]);
                System.out.println("Abflugsort: " + LocationArray[i]);
                System.out.println("Gate: " + GateArray[i]);
                System.out.println("Abflugszeit: " + TimeArray[i]);
                System.out.println("");
            }
        }
    }
}