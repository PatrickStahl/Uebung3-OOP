//Funktioniert bis jetzt nur mit Flugnummern, den Rest muss ich noch ergänzen
//die Theorie dahinter passt aber so

public class Flughafen 
{
    public static void main(String[] args) 
    {
        Airport airportTest = new Airport(3);
        Flight flug1 = new Flight();
        flug1.flightNumber=187;
        
        Flight flug2 = new Flight();
        flug2.flightNumber=420;

        Flight flug3 = new Flight();
        flug3.flightNumber=318;
        
        airportTest.addNewFlight(flug1);
        airportTest.addNewFlight(flug2);
        airportTest.addNewFlight(flug3);
        airportTest.removeFlight(flug3.flightNumber);
        
        airportTest.listDepaturesOnScreen();
    
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
    private int Anzahl;

    public Airport (int maxFlights)
    {
        NumberArray = new int[maxFlights];
        //hier noch location, gate, ... Arrays ergänzen
        Anzahl = -1;
    }

    public void addNewFlight (Flight flight)
    {
        Anzahl++;
        for(int i = 0; i<NumberArray.length; i++)
        {
            if (NumberArray[i] == flight.flightNumber)
            {
                System.out.println("Fehler!");
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
            NumberArray[Anzahl] = flight.flightNumber;
        
        }
    }

    public void removeFlight (int flightNumber)
    {
        for (int i=0; i<NumberArray.length;i++)
        {
            if(NumberArray[i]==flightNumber)
            {
                NumberArray[i]=0;
            }
        }
    }
    //funktioniert logischerweise noch nicht für in und out weil ich das noch nicht gemacht hab
    public void listDepaturesOnScreen() 
    {
        for(int i = 0; i<NumberArray.length;i++)
        {
            if(NumberArray[i]!=0)
            {
                System.out.println("Flug " + (i+1) + ":");
                System.out.println("Flugnummer: "  + NumberArray[i]);
            }
        }
    }
}
