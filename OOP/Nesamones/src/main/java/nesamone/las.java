package nesamone;

public class las {
       /* private Integer getId(Scanner scanner) {
        Integer id;

        for (int i = 0; i < MAX_RETRY; i++) {
            try {
                System.out.println("Iveskite prisijungimo id:");
                id = scanner.nextInt();
                if (!students.containsKey(id)) {
                    System.out.println("Toks vartotojas neegzistuoja");
                    login(scanner);
                }
                return id;
            }catch (InputMismatchException e){
                System.out.println("Bloga ivestis, pakartokite");
            }
        }
        return null;
    }

    public void login(Scanner scanner) {
        Integer id = getId(scanner);
        if (id == null){
            System.out.println("Prisijungimas nesekminga");
        }
        System.out.println("Iveskite slaptazodi:");
        String password = scanner.nextLine();

        Student student = students.get(id);

        if (!student.getAccountPassword().equals(DigestUtils.sha512Hex(password))) {
            System.out.println("Neteisingas slaptazodis");
            return;
        }

        System.out.println("Sveikiname  prisijungus");
    }*/
}
