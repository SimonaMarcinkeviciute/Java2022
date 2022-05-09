package lt.codeacademy.lessons.twentySixth.pilimorfizmas.task1;

import java.util.Random;

public class NelyginisSkaicius extends Skaicius{
    public NelyginisSkaicius(int maxGenNumb, int minInterval, int maxInterval) {
        super(maxGenNumb, minInterval, maxInterval);
    }

    @Override
    public void generuok() {
        Random random = new Random();
        int count = 0;
        while(count < maxGenNumb) {
            int randNumb = random.nextInt(minInterval, maxInterval + 1);
            if(randNumb % 2 !=0) {
                numbers.add(randNumb);
                count++;
            }
        }
    }
}
