package task2.entity;

public class Flower implements Comparable <Flower> {
    private String name;
    private String soil;
    private String origin;
    private String stem_color;
    private String leaf_color;
    private int size;
    private int temperature_celsius;
    private String lighting;
    private int watering_milliliters;
    private String multiplying;

    public Flower() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getStem_color() {
        return stem_color;
    }

    public void setStem_color(String stem_color) {
        this.stem_color = stem_color;
    }

    public String getLeaf_color() {
        return leaf_color;
    }

    public void setLeaf_color(String leaf_color) {
        this.leaf_color = leaf_color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTemperature_celsius() {
        return temperature_celsius;
    }

    public void setTemperature_celsius(int temperature_celsius) {
        this.temperature_celsius = temperature_celsius;
    }

    public String getLighting() {
        return lighting;
    }

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    public int getWatering_milliliters() {
        return watering_milliliters;
    }

    public void setWatering_milliliters(int watering_milliliters) {
        this.watering_milliliters = watering_milliliters;
    }

    public String getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", soil='" + soil + '\'' +
                ", origin='" + origin + '\'' +
                ", stem_color='" + stem_color + '\'' +
                ", leaf_color='" + leaf_color + '\'' +
                ", size=" + size +
                ", temperature_celsius=" + temperature_celsius +
                ", lighting=" + lighting +
                ", watering_milliliters=" + watering_milliliters +
                ", multiplying='" + multiplying + '\'' +
                '}';
    }

    @Override
    public int compareTo(Flower o) {

        if (this.name != null) {
            if (this.temperature_celsius != o.getTemperature_celsius()) {
                return this.temperature_celsius - o.getTemperature_celsius();
            }
            return this.name.compareTo(o.getName());
        }
        return 1;
    }


}

