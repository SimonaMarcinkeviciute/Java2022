package lt.codeacademy.lessons.twentySixth.castinimas.task3;

import java.util.HashMap;

public class DuomenuBaze implements Saugykla{
    private final HashMap<Integer, Info> infoObjects;

    public DuomenuBaze() {
        infoObjects = new HashMap<>();
    }

    @Override
    public void saveInfo(Info info) {
        infoObjects.put(info.getId(), info);
        System.out.println("Issaugota duomenu bazeje");

    }

    @Override
    public Info findInfo(int id) {
        System.out.println("Rasta duomenu bazeje pagal id");

        return infoObjects.get(id);
    }

    @Override
    public Info findInfo(String word) {
        for (Info info: infoObjects.values()) {
            if(info.isInText(word)) {
                System.out.println("Rasta duomenu bazeje pagal zodi");
                return info;
            }

        }
        return null;
    }
}
