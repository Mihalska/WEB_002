package task2.entity;


import java.util.ArrayList;
import java.util.List;

public class Flowers {
    List<Flower> flowerList = new ArrayList<>();
    public void add(Flower flower){
        this.flowerList.add(flower);
    }

    @Override
    public String toString() {
        return "Flowers{" +
                "flowerList=" + flowerList +
                '}';
    }
}
