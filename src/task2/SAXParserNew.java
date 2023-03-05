package task2;
import task2.entity.Flower;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class SAXParserNew extends DefaultHandler {
    private String currentQName;
    private List<Flower> flowers;

    private Flower currentFlower;

    public SAXParserNew() {

        flowers = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentQName = qName;

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String value = new String(ch, start, length);

        switch (currentQName) {
            case "flower" :
                currentFlower = new Flower();
                break;
            case "name" :
                currentFlower.setName(value);
                break;
            case "soil" :
                currentFlower.setSoil(value);
                break;
            case "origin" :
                currentFlower.setOrigin(value);
                break;
            case "stem_color" :
                currentFlower.setStem_color(value);
                break;
            case "leaf_color" :
                currentFlower.setLeaf_color(value);
                break;
            case "size" :
                String str1 = "";
                for (int i = 0; i < length; i++) {
                    str1 += ch[start + i];
                }
                currentFlower.setSize(Integer.parseInt(str1));
            case "temperature_celsius" :
                String str2 = "";
                for (int i = 0; i < length; i++) {
                    str2 += ch[start + i];
                }
                currentFlower.setTemperature_celsius(Integer.parseInt(str2));
                break;
            case "lighting" :
                currentFlower.setLighting(value);
                break;
            case "watering_milliliters" :
                String str3 = "";
                for (int i = 0; i < length; i++) {
                    str3 += ch[start + i];
                }
                currentFlower.setWatering_milliliters(Integer.parseInt(str3));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentQName = "";
        if (qName.equals("flower")) {
            flowers.add(currentFlower);
        }
    }

    public List<Flower> getAll() {
        return flowers;
    }

    @Override
    public void endDocument() throws SAXException {
        currentFlower = null;
    }

}
