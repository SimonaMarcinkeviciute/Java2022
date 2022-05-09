package lt.codeacademy.lessons.twentyFirst.map;

//Interaktyvi programa:○[1] – įvesti studentą○[2] – gauti studentą pagal numerį○[3] – baigti programą•Jei pasirinktas
// [1], tada:○Paprašo įvesti duomenis:■Įveskite vardą/Įveskite pavardę/Įveskite studento nr./
// Įveskite universitetą○Programa duomenis išsaugo į HashMap■studento numeris -> Studentas○Programa toliau rodo
// pradinį pasirinkimų meniu•Jeipasirinktas [2]:○Paprašoma įvesti studento numerį, pagal kurį programa randa HashMap‘e
// studentą ir atspausdina jo vardą, pavardę ir universitetą○Programa toliau rodo pradinį pasirinkimų meniu

import java.util.HashMap;
import java.util.Scanner;

public class Studentas {
    private final String vardas;
    private final String pavarde;
    private final String universitetas;



    public Studentas(String vardas, String pavarde, String universitetas) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.universitetas = universitetas;
    }

    @Override
    public String toString() {
        return "Studentas (" +
                "vardas - " + vardas + '\'' +
                ", pavarde - " + pavarde + '\'' +
                ", universitetas - " + universitetas + '\'' +
                ')';
    }
}

