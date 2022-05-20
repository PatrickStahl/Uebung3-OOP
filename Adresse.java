
/* Das habe ich noch nicht gemacht*/ 


public class Adresse
{

    private String straße = "Ernst-Thälmann-Str";
    private String plz = "98724";
    private String ort = "Piesau";

    public String getStraße()
    {
        return straße;
    }
    public String getPlz()
    {
        return plz;
    }
    public String getOrt()
    {
        return ort;
    }

    public static void main(String[] args)
    {
        
    }
}

class Hörsaal
{
    int plätze;
    int Vorlesung [];

    int getPlätze()
    {
        return plätze;
    }
    void getAdresse()
    {
        Adresse AdresseHörsaal = new Adresse();
        // String Postleitzahl = test.plz;
        // return Postleitzahl;
        AdresseHörsaal.getPlz();
        AdresseHörsaal.getStraße();
        AdresseHörsaal.getOrt();

    }
}

class SeminarRaum
{

}

class Labor
{
    int plätze;
}


