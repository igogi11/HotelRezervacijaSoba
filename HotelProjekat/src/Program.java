import Hotel.Hotel;

import java.util.Scanner;

public class Program {1
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Sloboda",30,"json/Radnici.json","json/Rezervacije.json","json/Gosti.json");
        int opcija,izborSobe,izborGosta,brojDana,izborRezervacija;
        while(true){
            opcija=meni(hotel);
            switch (opcija){
                case 1:
                    System.out.println(hotel.toString());
                    hotel.izborSobaHotel();
                    break;
                case 2:
                    hotel.listaRadnika();
                    break;
                case 3:
                    hotel.listaRezervacija();
                    break;
                case 4:
                    hotel.preostaleSobe();
                    break;
                case 5:
                    izborSobe =izborSobe(hotel);
                    izborGosta=izborGosta(hotel);
                    brojDana=brojDana();
                    hotel.dodajNovuRezervaciju(izborSobe,izborGosta,brojDana);
                    break;
                case 6:
                    izborRezervacija=izborRezervacije(hotel);
                    hotel.izbrisiRezervaciju(izborRezervacija);
                    break;
                case 7:
                    izlaz(hotel);
                    break;
            }
        }
    }
    public static int meni(Hotel hotel){
        int opcija;
        Scanner scan= new Scanner(System.in);
        System.out.println("---Dobrodosli u Hotel "+hotel.getNaziv()+" ---\n");
        System.out.println("Izaberi opciju:\n1.Informacije o hotelu\n2.Zaposleni u hotelu\n3.Rezervacije\n4.Broj preostalih soba u hotelu\n5.Dodaj rezervaciju\n6.Stampaj racun\n7.Izlaz\n");
        do{
            System.out.print("Izaberite opciju: ");
            opcija =scan.nextInt();
        }while(opcija>7||opcija<1);
        return opcija;
    }
    public static int izborSobe(Hotel hotel){
        Scanner scan=new Scanner(System.in);
        hotel.izborSobaHotel();
        System.out.print("\nIzaberite koju sobu zelite: ");
        int opcija = scan.nextInt();
        return opcija;
    }
    public static int izborGosta(Hotel hotel){
        Scanner scan=new Scanner(System.in);
        hotel.listaGostiju();
        System.out.print("\nIzaberite gosta kojem dodeljujete sobu: ");
        int opcija = scan.nextInt();
        return opcija;
    }
    public static int brojDana(){
        Scanner scan = new Scanner(System.in);
        System.out.print("\nUnesite koliko dana gost ostaje u sobi: ");
        int opcija = scan.nextInt();
        return opcija;
    }
    public static int izborRezervacije(Hotel hotel){
        Scanner scan = new Scanner(System.in);
        hotel.ispisiRezervacije();
        System.out.print("\nIzaberite za koju rezervaciju zelite da odstampate racun: ");
        int opcija =scan.nextInt();
        return opcija;
    }
    public static void izlaz(Hotel hotel){
        hotel.zapamtiSve();
        System.out.println("\n\n----------Izlaz----------");
        System.exit(0);
    }
}
