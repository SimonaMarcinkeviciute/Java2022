package lt.codeacademy.lessons.eighth.array;

public class ArrayExample {

    public static void main(String[] args) {

        //masyvo inicializavimas ir reiksmiu priskirims

        int[] mass = new int[10];

        mass[1] = 15;
        mass[0] = 10;

        System.out.println(mass.length);
        System.out.println(mass[5]);
        System.out.println(mass[0]);
        System.out.println(mass[1]);

        // kitas budas inicializuoti masyva ir priskirti
        //reiksmes is karto

        int[] secondMas = {55, 4, 5, 9, 56, 6};

        System.out.println(secondMas[3]);

        //dvimaciai masyvai, inicializuojam, pirma reiksme
        //stulpeiai, antra eilutes



        int[][]matrix = new int[10][5];
        matrix[5][1] = 55;

        System.out.println(matrix[5][1]);

        String[][] stringMstrix = {
                {"As","tu"},
                {"Mes", "jie"}
        };

        System.out.println(stringMstrix[1][1]);

        //masyvo kopijavimas

       // System.arraycopy(senasMasyvas, 2/*nuo kelinto kopijuosim*/, naujasMasyvas, 0, 8);// nuo kelinto irasineti it kie elementu paimtis
        //System.out.println(new String(naujasMasyvas);
    }
}
