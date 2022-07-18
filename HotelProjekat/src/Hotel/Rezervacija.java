package Hotel;

import Hotel.Sobe.Apartman;
import Hotel.Sobe.Duplex;
import Hotel.Sobe.Garsonjera;
import Hotel.Sobe.Soba;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Rezervacija implements Update{
    private int id;
    private Soba soba;
    private Gost gost;
    private int brojDana;
    private int cenaRezervacije;
    private static int redniBroj=1;

    public Rezervacija(Garsonjera soba, Gost gost, int brojDana) {
        this.id=redniBroj;
        this.soba = soba;
        this.gost = gost;
        this.brojDana = brojDana;
        this.cenaRezervacije = soba.getCena()*brojDana;
        redniBroj++;
    }
    public Rezervacija(Apartman soba, Gost gost, int brojDana) {
        this.id=redniBroj;
        this.soba = soba;
        this.gost = gost;
        this.brojDana = brojDana;
        this.cenaRezervacije = soba.getCena()*brojDana;
        redniBroj++;
    }
    public Rezervacija(Duplex soba, Gost gost, int brojDana) {
        this.id=redniBroj;
        this.soba = soba;
        this.gost = gost;
        this.brojDana = brojDana;
        this.cenaRezervacije = soba.getCena()*brojDana;
        redniBroj++;
    }
    @Override
    public String toString() {
        return "Rezervacija "+ id + " Gost: "+ gost.getIme()+" "+gost.getPrezime() + ", Soba: " + soba.getNaziv() + "\tBroj nocenja: "+brojDana+", Cena rezervacije ukupno: " + cenaRezervacije;
    }
    public static ArrayList<Rezervacija> ucitajRezervacije(String dat){
        ArrayList<Rezervacija> ucitaneRezervacije = new ArrayList<>();
        try{
            JSONArray jsonLista=(JSONArray) new JSONParser().parse(new FileReader(dat));
            for(Object object : jsonLista){
                JSONObject json =(JSONObject) object;

                int brojDana = Integer.parseInt(json.get("brojDana").toString());
                String jmbg = json.get("jmbg").toString();
                String ime =json.get("ime").toString();
                String prezime = json.get("prezime").toString();
                int godine = Integer.parseInt(json.get("god").toString());
                String pol=json.get("pol").toString();
                String brTelefona=json.get("brojTelefona").toString();
                String naziv =json.get("nazivSobe").toString();
                int id = Integer.parseInt(json.get("id").toString());
                double kvadratura = Double.parseDouble(json.get("kvadratura").toString());
                int brojSoba=Integer.parseInt(json.get("brojSoba").toString());
                int brojKreveta=Integer.parseInt(json.get("brojKreveta").toString());
                int cena=Integer.parseInt(json.get("cena").toString());

                if(naziv.equalsIgnoreCase("Garsonjera"))
                    ucitaneRezervacije.add(new Rezervacija(new Garsonjera(id,kvadratura,brojSoba,brojKreveta,cena),new Gost(jmbg,ime,prezime,godine,pol,brTelefona),brojDana));
                else if(naziv.equalsIgnoreCase("Apartman"))
                    ucitaneRezervacije.add(new Rezervacija(new Apartman(id,kvadratura,brojSoba,brojKreveta,cena),new Gost(jmbg,ime,prezime,godine,pol,brTelefona),brojDana));
                else if(naziv.equalsIgnoreCase("Duplex"))
                    ucitaneRezervacije.add(new Rezervacija(new Duplex(id,kvadratura,brojSoba,brojKreveta,cena),new Gost(jmbg,ime,prezime,godine,pol,brTelefona),brojDana));
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return ucitaneRezervacije;
    }
    public static void updateJSON(ArrayList<Rezervacija> listaRe) {
        JSONArray jsonLista=new JSONArray();
        PrintWriter pw=null;
        for(Rezervacija r:listaRe){
            JSONObject object = new JSONObject();
            object.put("brojDana",r.brojDana);
            object.put("jmbg",r.getGost().getJmbg());
            object.put("ime",r.getGost().getIme());
            object.put("prezime",r.getGost().getPrezime());
            object.put("god",r.getGost().getGodine());
            object.put("pol",r.getGost().getPol());
            object.put("brojTelefona",r.getGost().getBrojTelefona());
            object.put("nazivSobe",r.getSoba().getNaziv());
            object.put("id",r.getSoba().getId());
            object.put("kvadratura",r.getSoba().getKvadratura());
            object.put("brojSoba",r.getSoba().getBrojSoba());
            object.put("brojKreveta",r.getSoba().getBrojKreveta());
            object.put("cena",r.getSoba().getCena());
            jsonLista.add(object);
        }
        try{
            pw=new PrintWriter("json/Rezervacije.json");
            pw.write(jsonLista.toJSONString());
        }catch (FileNotFoundException ex){
            System.out.println("Greska prilikom upisa!\n"+ex.getMessage());
        }finally {
            if(pw!=null)
                pw.close();
        }
    }

    public int getId() {
        return id;
    }

    public Soba getSoba() {
        return soba;
    }

    public Gost getGost() {
        return gost;
    }

    public int getBrojDana() {
        return brojDana;
    }

    public int getCenaRezervacije() {
        return cenaRezervacije;
    }
}
