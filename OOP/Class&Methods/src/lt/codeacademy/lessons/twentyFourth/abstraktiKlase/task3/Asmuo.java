package lt.codeacademy.lessons.twentyFourth.abstraktiKlase.task3;

import java.util.Objects;

public abstract class Asmuo {

    private final String vardas;

    public Asmuo(String vardas) {
        this.vardas = vardas;
    }


    public boolean array(Asmuo[] asmenys) {

        boolean isUnique = true;

        for (int i = 0; i < asmenys.length - 1; i++) {
            for (int j = i + 1; j < asmenys.length; j++) {
                if (asmenys[i].equals(asmenys[j])) {
                    isUnique = false;
                }
            }
        }

        return isUnique;
    }
// override situos metodus, kad patikrinti ar tai yra unikalus metodai, sukurus tos pacios klases du metodus su tuo paciu kintamuoju,su siais
    //metodais galima atpazinti kad du objektai viendi
    // jei nebutu sito metodo tada butu unikalus
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asmuo asmuo = (Asmuo) o;
        return vardas.equals(asmuo.vardas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vardas);
    }
}