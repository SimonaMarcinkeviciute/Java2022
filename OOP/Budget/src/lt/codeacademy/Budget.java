package lt.codeacademy;

import lt.codeacademy.data.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Budget {
    private final List<Entry> entries;

    public Budget() {
        entries = new ArrayList<>();
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public List<Income> getIncomes() {
        List<Income> incomes = new ArrayList<>();
        for (Entry entry : entries) {
            if (entry instanceof Income income) {
                incomes.add(income);
            }
        }

        return incomes;
    }

    public List<Cost> getCosts() {
        List<Cost> costs = new ArrayList<>();
        for (Entry entry : entries) {
            if (entry instanceof Cost cost) {
                costs.add(cost);
            }
        }

        return costs;
    }

    public Income getIncome(IncomeCategory category, LocalDate localDate) {
        for (Entry entry : entries) {
            if (entry instanceof Income income
                    && category.equals(income.getIncomeCategory())
                    && localDate.isEqual(income.getDate().toLocalDate())) {
                return income;
            }
        }

        return null;
    }

    public Cost getCost(CostCategory costCategory, LocalDate localDate) {
        for (Entry entry : entries) {
            if (entry instanceof Cost cost
                    && costCategory.equals(cost.getCostCategory())
                    && cost.getDate().toLocalDate().isEqual(localDate)) {
                return cost;
            }
        }

        return null;
    }

    public double balansas() {
        double incomeSum = 0;
        double costSum = 0;

        for (Entry entry : entries) {
            if (entry instanceof Income) {
                incomeSum += entry.getSum().doubleValue();
            }

            if (entry instanceof Cost) {
                costSum += entry.getSum().doubleValue();
            }
        }

        return incomeSum - costSum;
    }

    public void removeIncome(int index) {
        Iterator<Entry> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry instanceof Income income && income.getIndex() == index) {
                iterator.remove();
                break;
            }
        }
    }

    public void removeCost(int index) {
        Iterator<Entry> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry instanceof Cost cost && cost.getIndex() == index) {
                iterator.remove();
                break;
            }
        }
    }

    public Income findIncome(int id) {
        for (Entry entry : entries) {
            if (entry instanceof Income income && income.getIndex() == id) {
                return income;
            }
        }

        return null;
    }
}
