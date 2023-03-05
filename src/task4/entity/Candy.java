package task4.entity;

public class Candy {
    private String id;
    private String name;
    private String producer;
    private String sort;
    private String packaging;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public Candy() {
    }

    public Candy(String id, String name, String sort, String packaging) {
        this.id = id;
        this.name = name;
        this.sort = sort;
        this.packaging = packaging;
    }
}
