package task2;

import task2.entity.Flower;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StAXParser {
    String fileName = "src\\task2\\flower.xml";
    public  List<Flower> getAll() {
        List<Flower> flowerList = new ArrayList<>();
        try {
            Flower flower = null;
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("name")) {
                        flower = new Flower();
                        xmlEvent = reader.nextEvent();
                        flower.setName(xmlEvent.asCharacters().getData());

                    } else if (startElement.getName().getLocalPart().equals("soil")) {
                        xmlEvent = reader.nextEvent();
                        assert flower != null;
                        flower.setSoil(xmlEvent.asCharacters().getData());

                    } else if (startElement.getName().getLocalPart().equals("origin")) {
                        xmlEvent = reader.nextEvent();
                        assert flower != null;
                        flower.setOrigin(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("stem_color")) {
                        xmlEvent = reader.nextEvent();
                        assert flower != null;
                        flower.setStem_color(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("leaf_color")) {
                        xmlEvent = reader.nextEvent();
                        assert flower != null;
                        flower.setLeaf_color(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("size")) {
                        xmlEvent = reader.nextEvent();
                        assert flower != null;
                        flower.setSize(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("temperature_celsius")) {
                        xmlEvent = reader.nextEvent();
                        assert flower != null;
                        flower.setTemperature_celsius(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("lighting")) {
                        xmlEvent = reader.nextEvent();
                        assert flower != null;
                        flower.setLighting(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("watering_milliliters")) {
                        xmlEvent = reader.nextEvent();
                        assert flower != null;
                        flower.setWatering_milliliters(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("flower")) {
                        flowerList.add(flower);

                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException exc) {
            exc.printStackTrace();
        }

        return flowerList;
    }


}



