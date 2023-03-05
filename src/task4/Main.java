package task4;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import task4.entity.Candy;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
public class Main {
    public static void main(String[] args)  {
         String fileName = "src\\task4\\candies.xml";
        List<Candy> candyLists = getCollection(fileName);
        System.out.println("Колекція Candy из xml-файла: ");
        for (Candy c : candyLists)  {
            System.out.println("\t" + c.getId() +  " | " + c.getName()
                    + " | " + c.getSort() + " | " + c.getPackaging()+  " | " + c.getProducer());
        }
    }
    private static  List<Candy> getCollection(String fileName) {
        List<Candy> candyList = new ArrayList<>();
        try {
            Candy candy = null;
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                        if (startElement.getName().getLocalPart().equals("Candy")) {
                         candy = new Candy();
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                           candy.setId((idAttr.getValue()));
                        }
                    } else if (startElement.getName().getLocalPart().equals("name")) {
                        xmlEvent = reader.nextEvent();
                            assert candy != null;
                            candy.setName(xmlEvent.asCharacters().getData());


                    } else if (startElement.getName().getLocalPart().equals("producer")) {
                        xmlEvent = reader.nextEvent();
                            assert candy != null;
                            candy.setProducer(xmlEvent.asCharacters().getData());

                    } else if (startElement.getName().getLocalPart().equals("sort")) {
                        xmlEvent = reader.nextEvent();
                            assert candy != null;
                            candy.setSort(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("packaging")) {
                        xmlEvent = reader.nextEvent();
                            assert candy != null;
                            candy.setPackaging(xmlEvent.asCharacters().getData());
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("Candy")) {
                        candyList.add(candy);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException exc) {
            exc.printStackTrace();
        }
        return candyList;
    }

}


