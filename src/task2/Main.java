package task2;
import org.xml.sax.SAXException;
import task2.entity.Flower;
import task2.DOMParser;
import task2.SAXParserNew;
import task2.StAXParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XMLStreamException {

//------------------DOM Parser----------------------------
        DOMParser dom = new DOMParser();
        List<Flower> flowers = dom.getAll();
        System.out.println("All flowers: ");
        Collections.sort(flowers);
        for (Flower f : flowers) {
            System.out.println(f.toString());
        }
        //------------------SAX Parser---------------------------
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser parser = factory.newSAXParser();
//        SAXParserNew sax = new SAXParserNew();
//         File file = new File("src\\task2\\flower.xml");
//        if (file.exists()) {
//            parser.parse(file, sax);
//            List<Flower> flowers = sax.getAll();
//            System.out.println("All flowers: ");
//            Collections.sort(flowers);
//            for (Flower f : flowers) {
//               System.out.println(f.toString());
//            }
//        }
//--------------------StAX Parser--------------
//        StAXParser stax = new StAXParser();
//        List<Flower> flowers = stax.getAll();
//        System.out.println("All flowers: ");
//        Collections.sort(flowers);
//        for (Flower f : flowers) {
//            System.out.println(f.toString());
//        }

    }
}


