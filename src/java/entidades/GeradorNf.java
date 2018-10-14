
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
NotaFiscal nf = new NotaFiscal();
CentroCusto ct = new CentroCusto();
    
try{
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    // criando o docmu XML
    Document documentoXML = documentBuilder.newDocument();
    
    // criando Node principal
    Element root = documentoXML.createElement("NFe");
    documentoXML.appendChild(root);
    
    Element ide = documentoXML.createElement("ide");
    //Attr nome = documentoXML.createAttribute("nome");
    //nome.setValue("Igor pauduro");
    //ide.setAttributeNode(nome);
    root.appendChild(ide);
    
    // tag estado
    Element cUF = documentoXML.createElement("cUF");
    cUF.appendChild(documentoXML.createTextNode(nf.getEstado()));
    ide.appendChild(cUF);
    
    //tag cNF
    Element cNF = documentoXML.createElement("cNF");
    cNF.appendChild(documentoXML.createTextNode("valor teste"));
    ide.appendChild(cNF);
    
    //tag natureza e operacao
    Element natOp = documentoXML.createElement("natOP");
    natOp.appendChild(documentoXML.createTextNode("Venda"));
    ide.appendChild(natOp);
    
    //tag indPag
    Element indPag = documentoXML.createElement("indPag");
    indPag.appendChild(documentoXML.createTextNode("0"));
    ide.appendChild(indPag);
    
    //tag mod
    
    Element mod = documentoXML.createElement("mod");
    mod.appendChild(documentoXML.createTextNode("mod"));
    ide.appendChild(mod);
    
    // tag serie
    
        Element serie = documentoXML.createElement("serie");
    serie.appendChild(documentoXML.createTextNode("serie"));
    ide.appendChild(serie);
    
    // tag nNF
    Element nNF = documentoXML.createElement("nNF");
    nNF.appendChild(documentoXML.createTextNode(nf.getNumero()));
    ide.appendChild(nNF);
    
    //dEmiss
    Element dEmiss = documentoXML.createElement("dEmiss");
    dEmiss.appendChild(documentoXML.createTextNode(nf.getData_emissao()));
    ide.appendChild(dEmiss);
    
    //dSaiEnt
      Element dSaiEnt = documentoXML.createElement("dSaiEnt");
    dSaiEnt.appendChild(documentoXML.createTextNode(nf.getData_emissao()));
    ide.appendChild(dSaiEnt);
    
    
    //tpNF
      Element tpNF = documentoXML.createElement("tpNF");
    tpNF.appendChild(documentoXML.createTextNode("1"));
    ide.appendChild(tpNF);
    
    // node emitente
    Element emit = documentoXML.createElement("emit");
    root.appendChild(emit);
    
    //CNPJ
    Element CNPJ = documentoXML.createElement("CNPJ");
    CNPJ.appendChild(documentoXML.createTextNode(ct.getCNPJ1()));
    emit.appendChild(CNPJ);
    
    //xNome
    Element xNome = documentoXML.createElement("xNome");
    xNome.appendChild(documentoXML.createTextNode(ct.getrSocial()));
    emit.appendChild(xNome);
    
    //xFant
        Element xFant = documentoXML.createElement("xFant");
    xFant.appendChild(documentoXML.createTextNode(ct.getFantasia()));
    emit.appendChild(xFant);
    
    Element IE = documentoXML.createElement("IE");
    IE.appendChild(documentoXML.createTextNode(ct.getIe()));
    emit.appendChild(IE);
    
    //enderEmit
    Element enderEmit = documentoXML.createElement("enderEmit");
    emit.appendChild(enderEmit);
    
    //Lgr
    Element xLgr = documentoXML.createElement("xLgr");
    xLgr.appendChild(documentoXML.createTextNode(ct.getLongradouro()));
    enderEmit.appendChild(xLgr);
    
    //nro
     Element nro = documentoXML.createElement("nro");
    nro.appendChild(documentoXML.createTextNode(String.valueOf(ct.getNro())));
    enderEmit.appendChild(nro);
    
    //bairro
     Element bairro = documentoXML.createElement("bairro");
    bairro.appendChild(documentoXML.createTextNode(ct.getBairro()));
    enderEmit.appendChild(bairro);
   
    //xMuni
     Element xMuni = documentoXML.createElement("xMuni");
    xMuni.appendChild(documentoXML.createTextNode(ct.getMunicipio()));
    enderEmit.appendChild(xMuni);
    
    //UF
     Element UF = documentoXML.createElement("UF");
    UF.appendChild(documentoXML.createTextNode(ct.getUf()));
    enderEmit.appendChild(UF);
    
    //cep
     Element cep = documentoXML.createElement("CEP");
    cep.appendChild(documentoXML.createTextNode(ct.getCep()));
    enderEmit.appendChild(cep);
    
    //pais
    Element xPais = documentoXML.createElement("xPais");
    xPais.appendChild(documentoXML.createTextNode("Brasil"));
    enderEmit.appendChild(xPais);
    
    //fone
    Element fone = documentoXML.createElement("fone");
    fone.appendChild(documentoXML.createTextNode("948601713"));
    enderEmit.appendChild(fone);
    
    
    
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
