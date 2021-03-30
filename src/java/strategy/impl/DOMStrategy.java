package strategy.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import strategy.Strategy;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
public class DOMStrategy implements Strategy {

    @NonNull
    private final String filePath;

    @NonNull
    private final String outputFilePath;

    private void correctAverage(Node averageNode, double newValue){
        Element averageElement = (Element)averageNode;
        averageElement.setTextContent(Double.toString(newValue));
    }

    private double readAverage(NodeList averageList){
        int len = averageList.getLength();
        if (len != 1)
            return -1;
        double result = -1;
        for (int k = 0; k < len; k++) {
            Node averageNode = averageList.item(k);
            if (averageNode.getNodeType() != Node.ELEMENT_NODE)
                continue;
            Element averageElement = (Element)averageNode;
            result = Double.parseDouble(averageElement.getTextContent());
        }
        return result;
    }

    private double calculateAverage(NodeList subjectList) {
        int len = subjectList.getLength();
        if(len == 0)
            return -1;
        double result = 0;
        int counter = 0;
        for (int j = 0; j < len; j++) {
            Node subjectNode = subjectList.item(j);
            if(subjectNode.getNodeType() != Node.ELEMENT_NODE)
                continue;
            Element subjectElement = (Element)subjectNode;
            result += Double.parseDouble(subjectElement.getAttribute("mark"));
            counter++;
        }
        if (counter != 0)
            return result / counter;
        else
            return -1;
    }

    private void saveChanges(Document document, String fileName) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        transformer.transform(new DOMSource(document), new StreamResult(new File(outputFilePath)));
    }

    @Override
    public void checkAverage() {
        double docAverage, calcAverage;
        try {
            File file = new File(filePath);

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builderFactory.setValidating(true);

            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();

            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();

            Element root = document.getDocumentElement();
            NodeList studentList = root.getElementsByTagName("student");

            for (int i = 0; i < studentList.getLength(); i++) {
                Node studentNode = studentList.item(i);

                if(studentNode.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element)studentNode;

                    calcAverage = calculateAverage(element.getElementsByTagName("subject"));
                    docAverage = readAverage(element.getElementsByTagName("average"));

                    if (calcAverage < 0)
                        calcAverage = 0;

                    if (docAverage != calcAverage || docAverage < 0) {
                        Node averageNode = element.getElementsByTagName("average").item(0);
                        correctAverage(averageNode, calcAverage);
                    }
                }
            }

            saveChanges(document, outputFilePath);

        } catch (ParserConfigurationException | IOException | TransformerException | SAXException e) {
            e.printStackTrace();
        }
    }
}
