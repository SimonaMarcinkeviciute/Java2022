package lt.codeacademy.lessons.twentyEigth.exceptions.tryCach.Task1;

import java.util.Random;

public class Airplane {

    public void expandChasis() {
        Random random = new Random();
        int number = random.nextInt(10);


        try {
            int result = 10 / number;
            if (result == 5) {
                vaziuokle();
            }
            System.out.println("Success: Vaziuokle issiskleide");
        } catch (VaziuoklesIsskleidimoKlaida e) {
            System.out.printf("%s %s \n",e.getMessage(), e.getPriezastis());
        } catch (ArithmeticException e) {
            System.out.println("Error: Vaziuoklei issiskeisti nepavyko");
        } finally {
            System.out.println("INFO: lektuvas skrenda");
            System.out.println("----------------------");
        }
    }

    public void vaziuokle() throws VaziuoklesIsskleidimoKlaida {
        Random random = new Random();
        int number = random.nextInt(10);

        switch (number) {
            case 0 -> throw new VaziuoklesIsskleidimoKlaida("Nezinomo svarbumo klaida:","Neatsidare durys");
            case 1 -> throw new LaikinaKlaida("Laikina klaida:","Nenusileido ratas");
            case 2 -> throw new SvarbiKlaida("Svarbi klaida:","Negavo leidimo leistis");
            case 4 -> throw new VaziuoklesIsskleidimoKlaida("Nezinomo svarbumo klaida:","nr 4");
            case 5 -> throw new LaikinaKlaida("Laikina klaida:","nr 5");
            case 6 -> throw new SvarbiKlaida("Svarbi klaida:","nr 6");
            case 7 -> throw new VaziuoklesIsskleidimoKlaida("Nezinomo svarbumo klaida:","nr 7");
            case 8 -> throw new LaikinaKlaida("Laikina klaida:","nr 8");
            case 9 -> throw new SvarbiKlaida("Svarbi klaida:","nr 9");
        }
    }
}
