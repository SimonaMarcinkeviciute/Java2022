package lt.codeacademy;

import org.apache.commons.lang3.RandomStringUtils;


import java.util.HashMap;
import java.util.Map;

public class Bank {
    Map<Person, String> bankAccounts = new HashMap<>();

    public void createBankAcount(Person person, Currency currency) {
        //sukuria saskaita ir i deda i sarasa

        String bankAccount = currency + RandomStringUtils.randomNumeric(18);;
        System.out.println(bankAccount);

        bankAccounts.put(new Person())

    }
}
