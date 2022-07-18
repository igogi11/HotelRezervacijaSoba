package Hotel;

import Hotel.Sobe.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Hotel {
    private String naziv;
    private ArrayList<Duplex> listaDuplex;
    private ArrayList<Apartman> listaApartmana;
    private ArrayList<Garsonjera> listaGarsonjera;
    private ArrayList<Radnik> listaRadnika;
    private ArrayList<Rezervacija> listaRezervacija;
    private ArrayList<Gost> listaGostiju;
    private int brojSoba;
    private int racun;
    private int brGarsonjera;
    private int brApartmana;
    private int brDuplex;

    public Hotel(String naziv,int brojSoba,String nazivDatRadnici,String nazivDatRezervacije,String nazivDatGostiju) {
        this.naziv=naziv;
        this.brojSoba=brojSoba;
        this.brGarsonjera=brojSoba/3+4;
        this.brApartmana=brojSoba/3+3;
        this.brDuplex=brojSoba/3-7;
        listaRadnika=Radnik.ucitajRadnike(nazivDatRadnici);
        listaGostiju=Gost.ucitajGoste(nazivDatGostiju);
        listaRezervacija=Rezervacija.ucitajRezervacije(nazivDatRezervacije);
        listaDuplex=Duplex.ucitajDuplex("json/Sobe/Duplex.json");
        listaApartmana=Apartman.ucitajApartman("json/Sobe/Apartman.json");
        listaGarsonjera=Garsonjera.ucitajGarsonjera("json/Sobe/Garsonjera.json");
        for(Rezervacija r :listaRezervacija){
            racun+=r.getCenaRezervacije();
            if(r.getSoba().getNaziv()=="Garsonjera")
                brGarsonjera--;
            else if(r.getSoba().getNaziv()=="Apartman")
                brApartmana--;
            else
                brDuplex--;
        }
    }
    @Override
    public String toString() {
        return "Hotel: "+ naziv + ", ima: " + listaRadnika.size() + " Radnika, Broj rezervisanih soba: " + listaRezervacija.size() +"("+brojSoba+")"+ ", Racun hotela: "+racun;
    }
    public void ispisiRezervacije(){
        for(Rezervacija r:listaRezervacija){
            System.out.println(r.toString());
        }
    }
    public void listaRadnika(){
        for(Radnik r:listaRadnika){
            System.out.println(r.toString());
        }
    }
    public void listaRezervacija(){
        for(Rezervacija r:listaRezervacija){
            System.out.println(r.toString());
        }
    }
    public void preostaleSobe(){
        System.out.println("\n\n---Preostale sobe u hotelu---\n\n"+"Grasonjera: "+brGarsonjera+"\nApartman: "+brApartmana+"\nDuplex: "+brDuplex+"\n\n");
    }
    public void izborSobaHotel(){
        System.out.println("\n\t---Izbor soba iz hotela---\n\t--Duplex--\n");
        for(Duplex d:listaDuplex){
            System.out.println(d.toString());
        }
        System.out.println("\t--Apartmani--\n");
        for(Apartman a:listaApartmana){
            System.out.println(a.toString());
        }
        System.out.println("\t--Garsonjere--\n");
        for(Garsonjera g:listaGarsonjera){
            System.out.println(g.toString());
        }
    }
    public void listaGostiju(){
        for(Gost g:listaGostiju){
            System.out.println(g.toString());
        }
    }
    public void dodajNovuRezervaciju(int idSobe,int idGosta,int brDana){
        for(Garsonjera g:listaGarsonjera)
            if(g.getId()==idSobe)
                for(Gost gost:listaGostiju)
                    if(gost.getIdCard()==idGosta) {
                        if(brGarsonjera!=0) {
                            listaRezervacija.add(new Rezervacija(g, gost, brDana));
                            brGarsonjera--;
                        }
                        else
                            System.out.println("\nNema vise slobodnih garsonjera!\nMorate izabrati drugu sobu\n");
                    }
        for(Duplex g:listaDuplex)
            if(g.getId()==idSobe)
                for(Gost gost:listaGostiju)
                    if(gost.getIdCard()==idGosta) {
                        if(brDuplex!=0) {
                            listaRezervacija.add(new Rezervacija(g, gost, brDana));
                            brDuplex--;
                        }
                        else
                            System.out.println("\nNema vise slobodnih duplexa!\nMorate izabrati drugu sobu\n");
                    }
        for(Apartman g:listaApartmana)
            if(g.getId()==idSobe)
                for(Gost gost:listaGostiju)
                    if(gost.getIdCard()==idGosta){
                        if(brApartmana!=0) {
                            listaRezervacija.add(new Rezervacija(g, gost, brDana));
                            brApartmana--;
                        }
                        else
                            System.out.println("\nNema vise slobodnih garsonjera!\nMorate izabrati drugu sobu\n");
                    }
    }
    public void izbrisiRezervaciju(int idRezervacije) {
        for (Iterator<Rezervacija> iterator = listaRezervacija.iterator(); iterator.hasNext(); ) {
            Rezervacija rezervacija = iterator.next();
            if (rezervacija.getId() == idRezervacije) {
                iterator.remove();
                System.out.println("\n\nUkupan racun ove rezervacije je: "+rezervacija.getCenaRezervacije());
                if(rezervacija.getSoba().getNaziv().equalsIgnoreCase("Garsonjera"))
                    brGarsonjera++;
                else if(rezervacija.getSoba().getNaziv().equalsIgnoreCase("Apartman"))
                    brApartmana++;
                else
                    brDuplex++;

            }
        }
    }
    public void zapamtiSve(){
        Rezervacija.updateJSON(listaRezervacija);
    }


    public String getNaziv() {
        return naziv;
    }

    public ArrayList<Radnik> getListaRadnika() {
        return listaRadnika;
    }

    public ArrayList<Rezervacija> getListaRezervacija() {
        return listaRezervacija;
    }

    public ArrayList<Gost> getListaGostiju() {
        return listaGostiju;
    }

    public int getBrojSoba() {
        return brojSoba;
    }

    public int getRacun() {
        return racun;
    }

    public int getBrGarsonjera() {
        return brGarsonjera;
    }

    public int getBrApartmana() {
        return brApartmana;
    }

    public int getBrDuplex() {
        return brDuplex;
    }
}
