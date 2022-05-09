package lt.codeacademy.lessons.twentySixth.pilimorfizmas.task1;

import java.util.Random;

public class NeigiamiSkaiciai extends Skaicius{
    public NeigiamiSkaiciai(int maxGenNumb, int minInterval, int maxInterval) {
        super(maxGenNumb, minInterval, maxInterval);
    }

    @Override
    public void generuok() {
        Random random = new Random();
        for(int i = 0; i < maxGenNumb; i++) {
            int randNumb = random.nextInt(minInterval, maxInterval + 1) * -1;
            numbers.add(randNumb);
        }
    }
}
