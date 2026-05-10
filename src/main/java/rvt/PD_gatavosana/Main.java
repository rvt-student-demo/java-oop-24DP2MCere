package rvt.PD_gatavosana;

// Abstrakta klase
abstract class Animal {

    // Parasta metode
    String elpot() {
        return "Elpoßana";
    }

    // Abstrakta metode (bez implementācijas)
    abstract String izdodSkanu();
}

// Klase, kas manto abstrakto klasi
class Dog extends Animal {

    // Obligāti jāimplementē abstraktā metode
    String izdodSkanu() {
        return "Gaf gafgaf";
    }
}

public class Main {

    public static void main(String[] args) {
        Dog Mike = new Dog();
        System.out.println(Mike.elpot());         // no abstraktās klases
        System.out.println(Mike.izdodSkanu());  // no Suns klases
    }
}
