package lt.codeacademy.lessons.twentyNinth.exeptionExercises.task4;

import java.util.Random;

public class NetworkConnector {
    public void send(Email email) throws NoNetwirkExeption {

        Random rand = new Random();
        int n = rand.nextInt(10);
        try {
            int i = 1 / n;
            email.setBusena(Busena.ISSIUSTAS);
        } catch (ArithmeticException e) {
            email.setBusena(Busena.KARTOJAMAS_SIUNTIMAS);
            throw new NoNetwirkExeption("ERROR: nutruko rysys");
        }    }


    }

