package lt.codeacademy.lessons.sixteen.StringBuilder;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Tekstas");

        sb.reverse();
        // apvercia stringa
        System.out.println(sb);
        // jei reikia prisilyginti stringui
        String t = sb.toString();

        // galima prideti reiksmiu
        StringBuilder sb2 = new StringBuilder("Labas vakaras Jonai");

        if(true) {
            sb2.append("!!!!!");
        }

        System.out.println(sb2);

        // ilgis
        System.out.println(sb2.length());

        // grazina indeksa, kur stovi
        sb2.indexOf("a");
        // nuo pabaigos
        sb2.lastIndexOf("b");

        // jei paversti i string
        String eilute = sb.toString();

        // susplitint teksta. galima vesti dvi reiksmes nuo kiek iki kiek
        // po substring grazina stringa, ir negalima naudoti metodo substring
        sb.substring(6);

        // galima istrinti simbolius, turi tureti pradzia ir pabaiga
        sb2.delete(3,6);

        // parodys raide pagal skaiciu
        sb2.charAt(5);

        // galima ideti
        sb2.insert(6, "rytas");

        // galima pakeisti nuo iki.
        sb2.replace(3, 6, "ai");


    }
}
