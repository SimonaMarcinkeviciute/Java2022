package lt.codeacademy.lessons.twentySixth.castinimas.task3;

import java.util.ArrayList;
import java.util.List;

public class RemoteDisc implements Saugykla{
    private final List<Info> infos;

    public RemoteDisc() {
        infos = new ArrayList<>();
    }

    @Override
    public void saveInfo(Info info) {
        infos.add(info);
        System.out.println("Info issaugojamas nutolusiame diske");
    }

    @Override
    public Info findInfo(int id) {
        for(Info info : infos) {
            if(info.getId() == id) {
                System.out.println("Rasta info pagal id nutolusiame diske");
                return info;
            }
        }
        return null;
    }

    @Override
    public Info findInfo(String word) {
        for(Info info : infos) {
            if(info.isInText(word));
            System.out.println("Rasta nutolusiame diske");
            return info;
        }
        return null;
    }
}
