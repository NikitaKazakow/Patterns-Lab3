package strategy.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import strategy.Strategy;
import strategy.dto.Student;
import strategy.dto.Subject;

import javax.xml.parsers.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

@RequiredArgsConstructor
public class SAXStrategy implements Strategy {

    private static final ArrayList<Student> students = new ArrayList<>();

    @NonNull
    private final String inputFilePath;

    @NonNull
    private final String outputFilePath;

    @Override
    public void checkAverage() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(new File(inputFilePath), handler);

            for (Student student : students) {
                double calculatedAverage = 0,
                        documentAverage = student.getAverage();
                int subjectCount = 0;
                for (Subject subject : student.getSubjects()) {
                    calculatedAverage += subject.getMark();
                    subjectCount++;
                }
                calculatedAverage /= subjectCount;
                if (calculatedAverage != documentAverage) {
                    student.setAverage(calculatedAverage);
                }
            }

            XMLOutputFactory xof = XMLOutputFactory.newInstance();
            XMLStreamWriter xsw = xof.createXMLStreamWriter(new FileWriter(outputFilePath));

            xsw.writeStartDocument();

            xsw.writeStartElement("students");
            for (Student student : students) {
                xsw.writeStartElement("student");
                xsw.writeAttribute("lastname", student.getLastName());
                for (Subject subject : student.getSubjects()) {
                    xsw.writeEmptyElement("subject");
                    xsw.writeAttribute("title", subject.getTitle());
                    xsw.writeAttribute("mark", Integer.toString(subject.getMark()));
                }
                xsw.writeStartElement("average");
                xsw.writeCharacters(Double.toString(student.getAverage()));
                xsw.writeEndElement();
                xsw.writeEndElement();
            }
            xsw.writeEndElement();
            xsw.writeEndDocument();

            xsw.flush();
            xsw.close();

            format(outputFilePath);

        } catch (ParserConfigurationException | SAXException | IOException | XMLStreamException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private void format(String file) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new InputStreamReader(new FileInputStream(file))));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        transformer.transform(new DOMSource(document), new StreamResult(new File(file)));
    }

    private static class XMLHandler extends DefaultHandler {

        private Student student;
        private String lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            switch (qName) {
                case "student" -> {
                    String lastName = attributes.getValue("lastname");
                    this.student = new Student(lastName);
                }
                case "subject" -> {
                    String title = attributes.getValue("title");
                    int mark = Integer.parseInt(attributes.getValue("mark"));
                    Subject subject = new Subject(title, mark);
                    this.student.addSubject(subject);
                }
                case "average" -> this.lastElementName = qName;
            }
        }


        @Override
        public void endElement(String uri, String localName, String qName) {
            if ("student".equals(qName)) {
                students.add(student);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("average"))
                    student.setAverage(Double.parseDouble(information));
            }
        }
    }
}
