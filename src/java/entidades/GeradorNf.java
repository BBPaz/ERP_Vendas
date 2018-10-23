
package entidades;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    SimpleDateFormat _date = new SimpleDateFormat("dd/MM/yyyy hh:mm");
Pedido pd = new Pedido();

Produto pdt = new Produto();
pdt.setId("124125");
pdt.setValor(1.2f);
pdt.setDescricao("Uma panela bem bonita.");
pdt.setNome("Panela bonita");
pdt.setTipo("Tipo 2");

Produto pdt2 = new Produto();
pdt2.setId("3");
pdt2.setValor(1.8f);
pdt2.setDescricao("Uma panela bem feia.");
pdt2.setNome("Panela feia");
pdt2.setTipo("Tipo 5");

ProdutoPedido pdp = new ProdutoPedido();
pdp.setProduto(pdt);
pdp.setPedido(pd);
pdp.setDevolvido(false);
pdp.setQtd(3);

ProdutoPedido pdp2 = new ProdutoPedido();
pdp2.setProduto(pdt2);
pdp2.setPedido(pd);
pdp2.setDevolvido(false);
pdp2.setQtd(3);

pd.getLista_produtos().add(pdp);
pd.getLista_produtos().add(pdp2);

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
//------------------------------------------------------------------------------    
    // tag estado
    Element cUF = documentoXML.createElement("cUF");
    cUF.appendChild(documentoXML.createTextNode(ct.getUf()));
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
    dEmiss.appendChild(documentoXML.createTextNode(_date.format(new Date())));
    ide.appendChild(dEmiss);
    
    //dSaiEnt
      Element dSaiEnt = documentoXML.createElement("dSaiEnt");
    dSaiEnt.appendChild(documentoXML.createTextNode(_date.format(new Date())));
    ide.appendChild(dSaiEnt);
    
    
    //tpNF fixo sempre sera um
      Element tpNF = documentoXML.createElement("tpNF");
    tpNF.appendChild(documentoXML.createTextNode("1"));
    ide.appendChild(tpNF);
//------------------------------------------------------------------------------        
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
//------------------------------------------------------------------------------        
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
//------------------------------------------------------------------------------        
    // node dest
    Element dest = documentoXML.createElement("dest");
    root.appendChild(dest);
    
    // cnpj/cpf pessoa
    Element CNPJD = documentoXML.createElement("CNPJ");
    CNPJD.appendChild(documentoXML.createTextNode("CNPJ CLIENTE"));
    dest.appendChild(CNPJD);
   
    Element xNomeD = documentoXML.createElement("xNome");
    xNomeD.appendChild(documentoXML.createTextNode("Nome destinatrio"));
    dest.appendChild(xNomeD);
//------------------------------------------------------------------------------        
    
    Element enderDest = documentoXML.createElement("enderDest");
    root.appendChild(enderDest);
    
    
    //Lgr
    Element xLgrD = documentoXML.createElement("xLgr");
    xLgrD.appendChild(documentoXML.createTextNode("Longradouro cliente"));
    enderDest.appendChild(xLgr);
    
    //nro
     Element nroD = documentoXML.createElement("nro");
    nroD.appendChild(documentoXML.createTextNode(String.valueOf("Numero destinatrio")));
    enderDest.appendChild(nroD);
    
    //bairro
     Element bairroD = documentoXML.createElement("bairro");
    bairroD.appendChild(documentoXML.createTextNode("bairro desti"));
    enderDest.appendChild(bairroD);
   
    //xMuni
     Element xMuniD = documentoXML.createElement("xMuni");
    xMuniD.appendChild(documentoXML.createTextNode("Municipio desti"));
    enderDest.appendChild(xMuniD);
    
    //UF
     Element UFD = documentoXML.createElement("UF");
    UFD.appendChild(documentoXML.createTextNode("UF desti"));
    enderDest.appendChild(UFD);
    
    //cep
     Element cepD = documentoXML.createElement("CEP");
    cepD.appendChild(documentoXML.createTextNode("000000"));
    enderDest.appendChild(cepD);
    
    //pais
    Element xPaisD = documentoXML.createElement("xPais");
    xPaisD.appendChild(documentoXML.createTextNode("Brasil"));
    enderDest.appendChild(xPaisD);
    
    //fone
    Element foneD = documentoXML.createElement("fone");
    foneD.appendChild(documentoXML.createTextNode("948601713"));
    enderDest.appendChild(foneD);
    
//------------------------------------------------------------------------------ 
    Element entrega = documentoXML.createElement("entrega");
    root.appendChild(entrega);
    
    Element CNPJE = documentoXML.createElement("CNPJ");
    CNPJE.appendChild(documentoXML.createTextNode("CNPJ CLIENTE"));
    entrega.appendChild(CNPJE);
    
    Element xLgrE = documentoXML.createElement("xLgr");
    xLgrE.appendChild(documentoXML.createTextNode("Longradouro cliente"));
    entrega.appendChild(xLgrE);
    
     Element nroE = documentoXML.createElement("nro");
    nroE.appendChild(documentoXML.createTextNode(String.valueOf("Numero destinatrio")));
    entrega.appendChild(nroE);
    
    Element xCpl = documentoXML.createElement("xCpl");
    xCpl.appendChild(documentoXML.createTextNode("COMPLEMENTO"));
    entrega.appendChild(xCpl);
    
       Element bairroE = documentoXML.createElement("bairro");
    bairroE.appendChild(documentoXML.createTextNode("bairro entrega"));
    entrega.appendChild(bairroE);
    
        //xMuni
     Element xMuniE = documentoXML.createElement("xMuni");
    xMuniE.appendChild(documentoXML.createTextNode("Municipio entrega"));
    entrega.appendChild(xMuniE);
    
    //UF
     Element UFE = documentoXML.createElement("UF");
    UFE.appendChild(documentoXML.createTextNode("UF entrega"));
    entrega.appendChild(UFE);
//------------------------------------------------------------------------------
if(pd.getLista_produtos().size()>0){
     for(ProdutoPedido p : pd.getLista_produtos()){
    Element det  = documentoXML.createElement("det");
    Attr nItem = documentoXML.createAttribute("nItem");
    nItem.setValue(String.valueOf(pd.getLista_produtos().size()));
    det.setAttributeNode(nItem );
    root.appendChild(det);
   
         Element prod = documentoXML.createElement("prod");
        det.appendChild(prod);

        Element cProd = documentoXML.createElement("cProd");
        cProd.appendChild(documentoXML.createTextNode(String.valueOf(p.getProduto().getId())));
        prod.appendChild(cProd);

        Element cEAN = documentoXML.createElement("cEAN");
        cEAN.appendChild(documentoXML.createTextNode(String.valueOf(p.getProduto().getId())));
        prod.appendChild(cEAN);

        Element xProd = documentoXML.createElement("xProd");
        xProd.appendChild(documentoXML.createTextNode(String.valueOf(p.getProduto().getNome())));
        prod.appendChild(xProd);

        if(nf.getEstado() == "SP"){
        
        Element CFOP = documentoXML.createElement("CFOP");
        CFOP.appendChild(documentoXML.createTextNode("5100"));
        prod.appendChild(CFOP);

        }else{
            Element CFOP = documentoXML.createElement("CFOP");
        CFOP.appendChild(documentoXML.createTextNode("6100"));
        prod.appendChild(CFOP);
    }
        Element uCom = documentoXML.createElement("uCom");
        uCom.appendChild(documentoXML.createTextNode("UN"));
        prod.appendChild(uCom);

        Element qCom = documentoXML.createElement("qCom");
        qCom.appendChild(documentoXML.createTextNode(String.valueOf(p.getQtd())));
        prod.appendChild(qCom);

        Element vUnCom = documentoXML.createElement("vUnCom");
        vUnCom.appendChild(documentoXML.createTextNode(String.valueOf(p.getProduto().getValor())));
        prod.appendChild(vUnCom);

        Element vProd = documentoXML.createElement("vProd");
        vProd.appendChild(documentoXML.createTextNode(String.valueOf(p.getProduto().getValor())));
        prod.appendChild(vProd);

        Element vEANTrib = documentoXML.createElement("vEANTrib");
        vEANTrib.appendChild(documentoXML.createTextNode(String.valueOf(p.getProduto().getId())));
        prod.appendChild(vEANTrib);
        

    /*Element prod = documentoXML.createElement("prod");
    det.appendChild(prod);
    
    Element cProd = documentoXML.createElement("cProd");
    cProd.appendChild(documentoXML.createTextNode("codigo do produto"));
    prod.appendChild(cProd);
    
    Element cEAN = documentoXML.createElement("cEAN");
    cEAN.appendChild(documentoXML.createTextNode("codigo EAN" ));
    prod.appendChild(cEAN);
    
    Element xProd = documentoXML.createElement("xProd");
    xProd.appendChild(documentoXML.createTextNode("Nome produto"));
    prod.appendChild(xProd);
    
    Element CFOP = documentoXML.createElement("CFOP");
    CFOP.appendChild(documentoXML.createTextNode("CFOP"));
    prod.appendChild(CFOP);
    
    Element uCom = documentoXML.createElement("uCom");
    uCom.appendChild(documentoXML.createTextNode("Unidade do produto"));
    prod.appendChild(uCom);
    
    Element qCom = documentoXML.createElement("qCom");
    qCom.appendChild(documentoXML.createTextNode("156456"));
    prod.appendChild(qCom);
    
    Element vUnCom = documentoXML.createElement("vUnCom");
    vUnCom.appendChild(documentoXML.createTextNode("qtde unide"));
    prod.appendChild(vUnCom);
    
    Element vProd = documentoXML.createElement("vProd");
    vProd.appendChild(documentoXML.createTextNode("valor produto"));
    prod.appendChild(vProd);
    
    Element vEANTrib = documentoXML.createElement("vEANTrib");
    vEANTrib.appendChild(documentoXML.createTextNode("Nao sri"));
    prod.appendChild(vEANTrib);
    
    Element uTrib = documentoXML.createElement("uTrib");
    uTrib.appendChild(documentoXML.createTextNode("Unidade"));
    prod.appendChild(uTrib);
    
    Element qTrib = documentoXML.createElement("qTrib");
    qTrib.appendChild(documentoXML.createTextNode("10000"));
    prod.appendChild(qTrib);
    
    Element vUnTrib = documentoXML.createElement("vUnTrib");
    vUnTrib.appendChild(documentoXML.createTextNode("1"));
    prod.appendChild(vUnTrib);
    */
    
    Element ICMS = documentoXML.createElement("ICMS");
    root.appendChild(ICMS);
    
    Element ICMS00 = documentoXML.createElement("ICMS00");
    ICMS.appendChild(ICMS00);
    
    // Origem sempre sera zero pois parte de producao propria
    Element orig = documentoXML.createElement("orig");
    orig.appendChild(documentoXML.createTextNode("0"));
    ICMS00.appendChild(orig);
    
    Element CST = documentoXML.createElement("CST");
    CST.appendChild(documentoXML.createTextNode("00"));
    ICMS00.appendChild(CST);
    
    Element modBC = documentoXML.createElement("modBC");
    modBC.appendChild(documentoXML.createTextNode("00"));
    ICMS00.appendChild(modBC);
    
    Element vBC = documentoXML.createElement("vBC");
    vBC.appendChild(documentoXML.createTextNode(String.valueOf(nf.getValor_total())));
    ICMS00.appendChild(vBC);
    
    Element pICMS = documentoXML.createElement("pICMS");
    pICMS.appendChild(documentoXML.createTextNode("00"));
    ICMS00.appendChild(pICMS);
    
    Element vICMS = documentoXML.createElement("vICMS");
    vICMS.appendChild(documentoXML.createTextNode("00"));
    ICMS00.appendChild(vICMS);
    
    Element PIS = documentoXML.createElement("PIS");
    root.appendChild(PIS);
    
    Element PISAliq = documentoXML.createElement("PISAliq");
    PIS.appendChild(PISAliq);
    
    
     // 01 tributado integralmente
    Element CSTAliq = documentoXML.createElement("CST");
    CSTAliq.appendChild(documentoXML.createTextNode("01"));
    PISAliq.appendChild(CSTAliq);
    
    Element vBCAliq = documentoXML.createElement("vBC");
    vBCAliq.appendChild(documentoXML.createTextNode("2121"));
    PISAliq.appendChild(vBCAliq);
   /* 
    Element pPisAliq = documentoXML.createElement("pPisAliq");
    pPisAliq.appendChild(documentoXML.createTextNode("2121"));
    PISAliq.appendChild(pPisAliq);
    
    Element vPisAliq = documentoXML.createElement("vPisAliq");
    vPisAliq.appendChild(documentoXML.createTextNode("2121"));
    PISAliq.appendChild(vPisAliq);
    */
    
    Element COFINS = documentoXML.createElement("COFINS");
    root.appendChild(COFINS);
    
    Element COFINSAliq = documentoXML.createElement("COFINSAliq");
    COFINS.appendChild(COFINSAliq);
    // 01 tributado integralmente
    Element CSTCofins = documentoXML.createElement("CST");
    CSTCofins.appendChild(documentoXML.createTextNode("01"));
    COFINSAliq.appendChild(CSTCofins);
    
   /* Element vBCConfins = documentoXML.createElement("vBC");
    vBCConfins.appendChild(documentoXML.createTextNode("2121"));
    COFINSAliq.appendChild(vBCConfins);
    
     Element pCOFINS= documentoXML.createElement("pCOFINS");
    pCOFINS.appendChild(documentoXML.createTextNode("2121"));
    COFINSAliq.appendChild(pCOFINS);
    
    Element vCOFINS= documentoXML.createElement("vCOFINS");
    vCOFINS.appendChild(documentoXML.createTextNode("2121"));
    COFINSAliq.appendChild(vCOFINS);
    */
        }
}
    
    Element total = documentoXML.createElement("total");
    root.appendChild(total);
    
    Element ICMSTotal = documentoXML.createElement("ICMSTot");
    total.appendChild(ICMSTotal);
    
    Element vBCTotal= documentoXML.createElement("vBC");
    vBCTotal.appendChild(documentoXML.createTextNode("Valor de base total"));
    ICMSTotal.appendChild(vBCTotal);
   
    Element vICMSTotal= documentoXML.createElement("vICMSTotal");
    vICMSTotal.appendChild(documentoXML.createTextNode("Valor"));
    ICMSTotal.appendChild(vICMSTotal);
    
    Element vBCST= documentoXML.createElement("vBCST");
    vBCST.appendChild(documentoXML.createTextNode("Valor"));
    ICMSTotal.appendChild(vBCST);
    
    // valor sempre sera 0
    Element vST= documentoXML.createElement("vST");
    vST.appendChild(documentoXML.createTextNode("0"));
    ICMSTotal.appendChild(vST);
    
    Element vProdTotal= documentoXML.createElement("vProd");
    vProdTotal.appendChild(documentoXML.createTextNode("0"));
    ICMSTotal.appendChild(vProdTotal);
    
    Element vFrete= documentoXML.createElement("vFrete");
    vFrete.appendChild(documentoXML.createTextNode("0"));
    ICMSTotal.appendChild(vFrete);
    
    Element vSeg = documentoXML.createElement("vSeg");
    vSeg.appendChild(documentoXML.createTextNode("0"));
    ICMSTotal.appendChild(vFrete);
    
    Element vDesc = documentoXML.createElement("vDesc");
    vDesc.appendChild(documentoXML.createTextNode("0"));
    ICMSTotal.appendChild(vDesc);
    
    Element vPIS = documentoXML.createElement("vPIS");
    vPIS.appendChild(documentoXML.createTextNode(String.valueOf(ct.getaPis())));
    ICMSTotal.appendChild(vPIS);
    
    Element vCOFINSTotal = documentoXML.createElement("vCOFINS");
    vCOFINSTotal.appendChild(documentoXML.createTextNode(String.valueOf(ct.getaCofins())));
    ICMSTotal.appendChild(vCOFINSTotal);
    
    Element vOutro = documentoXML.createElement("vOutro");
    vOutro.appendChild(documentoXML.createTextNode("0"));
    ICMSTotal.appendChild(vOutro);
    
    Element vNF = documentoXML.createElement("vNF");
    vNF.appendChild(documentoXML.createTextNode("0"));
    ICMSTotal.appendChild(vNF);
    
    
    
    
    
            
    
    
    
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    TransformerFactory trans = TransformerFactory.newInstance();
        
            Transformer transformer = trans.newTransformer();
   
    
    DOMSource DocumentoFonte = new DOMSource (documentoXML);
    StreamResult documento = new StreamResult(new File("t:\\dados" + nf.getNumero() +".xml"));    

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
