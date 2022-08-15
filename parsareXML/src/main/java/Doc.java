import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;


public class Doc {
    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<Book>();
        DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder dbdoc = db.newDocumentBuilder();
            Document doc = dbdoc.parse("biblioteca.xml");
            NodeList booklist = doc.getElementsByTagName("Carti");

            final float pretReferinta = (float) 10.00;
            LocalDate dataReferinta = LocalDate.of(2005, 1, 1);

            for (int i = 0; i < booklist.getLength(); i++) {
                Element book = (Element) booklist.item(i);
                if (book == null) continue;
                Node pretNode = book.getElementsByTagName("Pret").item(0);
                Node dataPublicareNode = book.getElementsByTagName("DataPublicare").item(0);

                if (pretNode == null || dataPublicareNode == null)
                    continue;
                float pretParsat;
                try {
                    pretParsat = Float.parseFloat(pretNode.getTextContent());
                } catch (NumberFormatException ignore) {
                    System.out.println("Valoarea pretului " + pretNode.getTextContent() + " nu este numerica");
                    continue;
                }

                LocalDate dataParsata;
                try {
                    dataParsata = LocalDate.parse(dataPublicareNode.getTextContent());
                } catch (DateTimeParseException ignore) {
                    System.out.println("Valoarea datei " + pretNode.getTextContent() + " nu respecta formatul");
                    continue;
                }


                if (pretParsat >= pretReferinta && dataParsata.isAfter(dataReferinta)) {
                    Node numeAutorNode = book.getElementsByTagName("numeAutor").item(0);
                    Node numeCarteNode = book.getElementsByTagName("numeCarte").item(0);
                    Node categorieNode = book.getElementsByTagName("Categorie").item(0);
                    Node descriereNode = book.getElementsByTagName("Descriere").item(0);

                    if (numeAutorNode == null || numeCarteNode == null || categorieNode == null || descriereNode == null)
                        continue;


                    Book newBook = new Book(numeAutorNode.getTextContent(), numeCarteNode.getTextContent(),
                            categorieNode.getTextContent(), pretParsat, dataParsata, descriereNode.getTextContent());
                    books.add(newBook);

                }

            }

        } catch (ParserConfigurationException | SAXException | IOException e) {

            e.printStackTrace();

        }




       for(Book newBook:books){
               System.out.println(newBook);
               }




                }}
