
package entidades;


import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.ParseConversionEvent;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GeradorNf {
    
    

public static void  main(String [] args){

    
try{
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    
    Document documentoXML = documentBuilder.newDocument();
    
    Element root = documentoXML.createElement("ide");
    documentoXML.appendChild(root);
    
    Element dados = documentoXML.createElement("dados");
    Attr nome = documentoXML.createAttribute("nome");
    nome.setValue("Igor pauduro");
    
    dados.setAttributeNode(nome);
    root.appendChild(dados);
    
    Element idade = documentoXML.createElement("idade");
    idade.appendChild(documentoXML.createTextNode("texte"));
    dados.appendChild(idade);
    
    
    
    
    TransformerFactory trans = TransformerFactory.newInstance();
        
            Transformer transformer = trans.newTransformer();
   
    
    DOMSource DocumentoFonte = new DOMSource (documentoXML);
    StreamResult documento = new StreamResult(new File("C:\\temp\\dados.xml"));    

    transformer.transform(DocumentoFonte, documento);
            
    
}catch (ParserConfigurationException ex){
    Logger.getLogger(GeradorNf.class.getName()).log(Level.SEVERE, null, ex);
    
}   catch (TransformerConfigurationException ex) {
        Logger.getLogger(GeradorNf.class.getName()).log(Level.SEVERE, null, ex);
    } catch (TransformerException ex) {
        Logger.getLogger(GeradorNf.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    

}
