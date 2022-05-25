public class UniAdresse
{
    public static void main(String[] args)
    {
        
    }
}

class Adresse
{

    private String straße;
    private String plz;
    private String ort;

    Adresse (String straße, String plz, String ort)
    {
        this.straße = straße;
        this.plz = plz;
        this.ort = ort;
    }
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
}

class Hörsaal
{
    private int plätze;
    private Vorlesung[] vorlesungen;
    private int size;

    Hörsaal(int plz, Adresse adr, Vorlesung[] vlg)
    {
        this.plätze = plz;
        String StraßeHörsaal;
        String PlzHörsaal;
        String OrtHörsaal;
        adr = new Adresse("", "", "");
        vlg = new Vorlesung[size];
    }

    int getPlätze()
    {
        return plätze;
    }
    Adresse getAdresse()
    {
        Adresse adr = new Adresse("", "", "");
        String StraßeHörsaal = adr.getStraße();
        String PlzHörsaal = adr.getPlz();
        String OrtHörsaal = adr.getOrt();
        Adresse adrOutput = new Adresse(StraßeHörsaal, PlzHörsaal, OrtHörsaal);
        return adrOutput;
    }
    Vorlesung[] getVorlesungen()
    {
        Vorlesung HörsaalVorlesung = new Vorlesung();
        HörsaalVorlesung.vorlesungen = vorlesungen;
        return HörsaalVorlesung.vorlesungen;
    }
}

class SeminarRaum
{
    private int plätze;
    private Übung[] übungen;
    private int size;

    SeminarRaum(int plz, Adresse adr, Übung[] übg)
    {
        this.plätze = plz;
        String StraßeSeminarRaum;
        String PlzSeminarRaum;
        String OrtSeminarRaum;
        adr = new Adresse("", "", "");
        übg = new Übung[size];
    }

    int getPlätze()
    {
        return plätze;
    }
    Adresse getAdresse()
    {
        Adresse adr = new Adresse("", "", "");
        String StraßeSeminarRaum = adr.getStraße();
        String PlzSeminarRaum = adr.getPlz();
        String OrtSeminarRaum = adr.getOrt();
        Adresse adrOutput = new Adresse(StraßeSeminarRaum, PlzSeminarRaum, OrtSeminarRaum);
        return adrOutput;
    }
    Übung[] getÜbungen()
    {
        Übung SeminarRaumÜbung = new Übung();
        SeminarRaumÜbung.übungen = übungen;
        return SeminarRaumÜbung.übungen;
    }
}

class Labor
{
    private int plätze;
    private Praktikum[] praktika;
    private int size;

    Labor(int plz, Adresse adr, Praktikum[] prk)
    {
        this.plätze = plz;
        String StraßeLabor;
        String PlzLabor;
        String OrtLabor;
        adr = new Adresse("", "", "");
        prk = new Praktikum[size];
    }

    int getPlätze()
    {
        return plätze;
    }
    Adresse getAdresse()
    {
        Adresse adr = new Adresse("", "", "");
        String StraßeLabor = adr.getStraße();
        String PlzLabor = adr.getPlz();
        String OrtLabor = adr.getOrt();
        Adresse adrOutput = new Adresse(StraßeLabor, PlzLabor, OrtLabor);
        return adrOutput;
    }
    Praktikum[] getPraktika()
    {
        Praktikum LaborPraktikum = new Praktikum();
        LaborPraktikum.praktika = praktika;
        return LaborPraktikum.praktika;
    }
}

class Vorlesung
{
    //Hab ich nur reingeschrieben, um keine Fehlermeldung zu bekommen
    public Vorlesung[] vorlesungen;
    public int size;
    public int getSize() 
    {
        return size;
    }
}
class Übung
{
    public Übung[] übungen;
    public int size;
    public int getSize()
    {
        return size;
    } 
    //Code
}
class Praktikum
{
    public Praktikum[] praktika;
    public int size;
    public int getSize()
    {
        return size;
    } 
    //Code
}
