package lt.codeacademy.lessons.twentySixth.pilimorfizmas.task1;

import java.util.ArrayList;
import java.util.List;

public abstract class Skaicius {
    protected List<Integer> numbers;
    protected final int maxGenNumb;
    protected final int minInterval;
    protected final int maxInterval;


    public Skaicius(int maxGenNumb, int minInterval, int maxInterval) {
        this.numbers = numbers;
        this.maxGenNumb = maxGenNumb;
        this.minInterval = minInterval;
        this.maxInterval = maxInterval;
    }

    public abstract void generuok();

    public int sum() {
        int sum = 0;
        for(Integer numb : numbers) {
            sum += numb;
        }

        return sum;
    }
}
