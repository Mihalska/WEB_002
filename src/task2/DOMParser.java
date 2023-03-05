package task2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import task2.entity.Flower;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMParser {
    private Document document;

    public DOMParser() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);

        DocumentBuilder db = dbf.newDocumentBuilder();

        document = db.parse("src\\task2\\flower.xml");
    }

    public List<Flower> getAll() {
        List<Flower> flowers = new ArrayList<>();

        Element root = document.getDocumentElement();


        NodeList list = root.getElementsByTagName("flower");

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            Flower flower = new Flower();
            String name = root.getElementsByTagName("name").item(i).getFirstChild().getTextContent();
            String soil = root.getElementsByTagName("soil").item(i).getFirstChild().getTextContent();
            String origin = root.getElementsByTagName("origin").item(i).getFirstChild().getTextContent();
            String stem_color = root.getElementsByTagName("stem_color").item(i).getFirstChild().getTextContent();
            String leaf_color = root.getElementsByTagName("leaf_color").item(i).getFirstChild().getTextContent();
            int size = Integer.parseInt(root.getElementsByTagName("size").item(i).getFirstChild().getTextContent());
            int watering_milliliters = Integer.parseInt(root.getElementsByTagName("watering_milliliters").item(i).getFirstChild().getTextContent());
            int temperature_celsius = Integer.parseInt(root.getElementsByTagName("temperature_celsius").item(i).getFirstChild().getTextContent());
            String lighting = root.getElementsByTagName("lighting").item(i).getFirstChild().getTextContent();
            String multiplying = root.getElementsByTagName("multiplying").item(i).getFirstChild().getTextContent();
            flower.setName(name);
            flower.setSoil(soil);
            flower.setOrigin(origin);
            flower.setStem_color(stem_color);
            flower.setLeaf_color(leaf_color);
            flower.setSize(size);
            flower.setWatering_milliliters(watering_milliliters);
            flower.setTemperature_celsius(temperature_celsius);
            flower.setLighting(lighting);
            flower.setMultiplying(multiplying);
            flowers.add(flower);


        }

        return flowers;
    }

}
