package lt.codeacademy;

import lt.codeacademy.data.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Budget {
    private final List<Irasas> irasas;


    public Budget() {
        irasas = new ArrayList<>();

    }

    public void addIEntry(Irasas irasas) {
        this.irasas.add(irasas);
    }



    public List<Income> getIncome() {
        List<Income> incomes = new ArrayList<>();
        for (Irasas i : irasas) {
            if(i instanceof Income income) {
                irasas.add(income);
            }
        }

        return incomes;
    }

    public List<Cost> getCost(CostCategory category, LocalDate localDate) {
        List<Cost> costs = new ArrayList<>();
        for (Irasas i : irasas) {
            if(i instanceof Income income) {
                irasas.add(income);
            }
        }
        return costs;
    }

    public double balansas() {
        double incomeSum = 0;
        double costSum = 0;

        for(Income in : incomes) {
            incomeSum += in.getSum().doubleValue();
        }

        for(Cost c: costs) {
            costSum += c.getSum().doubleValue();
        }

        return incomeSum + costSum;
    }

    public void removeIncome(int index) {
        Iterator<Income>  iterator = incomes.iterator();
        while (iterator.hasNext()) {
            Income income = iterator.next();
            if(income.getIndex() == index) {
                iterator.remove();
                break;
            }
        }
    }

    public void removeCost(int index) {
        Iterator<Cost>  iterator = costs.iterator();
        while (iterator.hasNext()) {
            Cost cost = iterator.next();
            if(cost.getIndex() == index) {
                iterator.remove();
                break;
            }
        }
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public List<Cost> getCosts() {
        return costs;
    }
}
