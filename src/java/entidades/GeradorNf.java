        package entidades;

import Dao.NotaProdutosDao;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
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
import org.xml.sax.SAXException;

public class GeradorNf {/*

    public static void main(String[] args) {
        NotaProdutosDao n1 = new NotaProdutosDao();

        GerarNfeProdutos();
        gerarNFServico();

    }

    public static void GerarNfeProdutos() {
        NotaFiscal nf = new NotaFiscal();
        CentroCusto ct = new CentroCusto();
        PessoaJuridica cj = new PessoaJuridica();
        PessoaFisica cf = new PessoaFisica();
        Cliente cl = new Cliente();
        Endereco ed = new Endereco();
        ProdutoNota pn = new ProdutoNota();


try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            // criando o docmu XML
            Document documentoXML = documentBuilder.newDocument();

            Element root = documentoXML.createElement("NFe");
            documentoXML.appendChild(root);
            Element ide = documentoXML.createElement("ide");
            root.appendChild(ide);
//------------------------------------------------------------------------------    
//estado
            Element cUF = documentoXML.createElement("cUF");
            cUF.appendChild(documentoXML.createTextNode(ct.getUf()));
            ide.appendChild(cUF);
            NotaFiscal n1 = new NotaFiscal();
//tag natureza e operacao
            Element natOp = documentoXML.createElement("natOP");
            natOp.appendChild(documentoXML.createTextNode("Venda"));
            ide.appendChild(natOp);

//tag indPag tipo pagamento
            Element indPag = documentoXML.createElement("indPag");
            indPag.appendChild(documentoXML.createTextNode("outros"));
            ide.appendChild(indPag);

//Numero nota fiscal
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

//tpNF fixo sempre sera 1
            Element tpNF = documentoXML.createElement("tpNF");
            tpNF.appendChild(documentoXML.createTextNode("1"));
            ide.appendChild(tpNF);
//------------------------------------------------------------------------------        
// node emitente
            Element emit = documentoXML.createElement("emit");
            root.appendChild(emit);

//CNPJ
            Element CNPJ = documentoXML.createElement("CNPJ");
            CNPJ.appendChild(documentoXML.createTextNode(ct.getCnpj()));
            emit.appendChild(CNPJ);

//xNome
            Element xNome = documentoXML.createElement("xNome");
            xNome.appendChild(documentoXML.createTextNode(ct.getRazao_social()));
            emit.appendChild(xNome);

//xFant
            Element xFant = documentoXML.createElement("xFant");
            xFant.appendChild(documentoXML.createTextNode(ct.getFantasia()));
            emit.appendChild(xFant);

//Ie
            Element IE = documentoXML.createElement("IE");
            IE.appendChild(documentoXML.createTextNode(ct.getInscricao_estadual()));
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

//fone
            Element fone = documentoXML.createElement("fone");
            fone.appendChild(documentoXML.createTextNode(ct.getTelefone()));
            enderEmit.appendChild(fone);
//------------------------------------------------------------------------------        
// node dest
            Element dest = documentoXML.createElement("dest");
            root.appendChild(dest);

// cnpj/cpf pessoa

if(cl instanceof PessoaJuridica){
    
            Element CNPJD = documentoXML.createElement("CNPJ");
            CNPJD.appendChild(documentoXML.createTextNode(cj.getCnpj()));
             dest.appendChild(CNPJD);
             
             
            Element xNomeD = documentoXML.createElement("xNome");
            xNomeD.appendChild(documentoXML.createTextNode(cj.getRazao_social()));
            dest.appendChild(xNomeD);

}else if (cl instanceof PessoaFisica){ 
     Element CPFD = documentoXML.createElement("CPF");
            CPFD.appendChild(documentoXML.createTextNode(cf.getCpf()));
             dest.appendChild(CPFD);
             
            Element xNomeD = documentoXML.createElement("xNome");
            xNomeD.appendChild(documentoXML.createTextNode(cf.getNome()));
            dest.appendChild(xNomeD);
}
//------------------------------------------------------------------------------        

            Element enderDest = documentoXML.createElement("enderDest");
            root.appendChild(enderDest);

//Lgr
            Element xLgrD = documentoXML.createElement("xLgr");
            xLgrD.appendChild(documentoXML.createTextNode(ed.getRua()));
            enderDest.appendChild(xLgr);

//nro
            Element nroD = documentoXML.createElement("nro");
            nroD.appendChild(documentoXML.createTextNode(String.valueOf(ed.getNumero())));
            enderDest.appendChild(nroD);

            //bairro
            Element bairroD = documentoXML.createElement("bairro");
            bairroD.appendChild(documentoXML.createTextNode(ed.getBairro()));
            enderDest.appendChild(bairroD);

//UF
            Element UFD = documentoXML.createElement("UF");
            UFD.appendChild(documentoXML.createTextNode(ed.getUf()));
            enderDest.appendChild(UFD);

//cep
            Element cepD = documentoXML.createElement("CEP");
            cepD.appendChild(documentoXML.createTextNode(ed.getCep()));
            enderDest.appendChild(cepD);

//fone
if(cl instanceof PessoaFisica){
            Element foneD = documentoXML.createElement("fone");
            foneD.appendChild(documentoXML.createTextNode(cf.getTelefone()));
            enderDest.appendChild(foneD);

}else if (cl instanceof PessoaJuridica){
     Element foneD = documentoXML.createElement("fone");
            foneD.appendChild(documentoXML.createTextNode(cj.getTelefone()));
            enderDest.appendChild(foneD);
}
//------------------------------------------------------------------------------ 
            Element entrega = documentoXML.createElement("entrega");
            root.appendChild(entrega);

            Element CNPJE = documentoXML.createElement("CNPJ");
            CNPJE.appendChild(documentoXML.createTextNode("CNPJ CLIENTE"));
            entrega.appendChild(CNPJE);

            Element xLgrE = documentoXML.createElement("xLgr");
            xLgrE.appendChild(documentoXML.createTextNode(ed.getRua()));
            entrega.appendChild(xLgrE);

            Element nroE = documentoXML.createElement("nro");
            nroE.appendChild(documentoXML.createTextNode(String.valueOf(ed.getNumero())));
            entrega.appendChild(nroE);

            Element xCpl = documentoXML.createElement("xCpl");
            xCpl.appendChild(documentoXML.createTextNode(ed.getCep()));
            entrega.appendChild(xCpl);

            Element bairroE = documentoXML.createElement("bairro");
            bairroE.appendChild(documentoXML.createTextNode(ed.getBairro()));
            entrega.appendChild(bairroE);
//UF
            Element UFE = documentoXML.createElement("UF");
            UFE.appendChild(documentoXML.createTextNode(cl.getEndereco().getUf()));
            entrega.appendChild(UFE);
//------------------------------------------------------------------------------
            if (pd.getLista_produtos().size() > 0) {
                for (ProdutoPedido p : pd.getLista_produtos()) {
                    Element det = documentoXML.createElement("det");
                    Attr nItem = documentoXML.createAttribute("nItem");
                    nItem.setValue(String.valueOf(pd.getLista_produtos().size()));
                    det.setAttributeNode(nItem);
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

                    if (nf.getEstado() == "SP") {

                        Element CFOP = documentoXML.createElement("CFOP");
                        CFOP.appendChild(documentoXML.createTextNode("5100"));
                        prod.appendChild(CFOP);

                    } else {
                        Element CFOP = documentoXML.createElement("CFOP");
                        CFOP.appendChild(documentoXML.createTextNode("6100"));
                        prod.appendChild(CFOP);
                    }
                    Element uCom = documentoXML.createElement("uCom");
                    uCom.appendChild(documentoXML.createTextNode("UN"));
                    prod.appendChild(uCom);

                    Element vUnCom = documentoXML.createElement("vUnCom");
                    vUnCom.appendChild(documentoXML.createTextNode(String.valueOf(p.getProduto().getValor())));
                    prod.appendChild(vUnCom);

                    Element vProd = documentoXML.createElement("vProd");
                    vProd.appendChild(documentoXML.createTextNode(String.valueOf(p.getProduto().getValor())));
                    prod.appendChild(vProd);
//---------------------------------
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

                    Element vBC = documentoXML.createElement("vBC");
                    vBC.appendChild(documentoXML.createTextNode(String.valueOf(pn.getValor_total())));
                    ICMS00.appendChild(vBC);          
//---------------------------------
                }
            }

            Element total = documentoXML.createElement("total");
            root.appendChild(total);

            Element ICMSTotal = documentoXML.createElement("ICMSTot");
            total.appendChild(ICMSTotal);

            Element vBCTotal = documentoXML.createElement("vBC");
            vBCTotal.appendChild(documentoXML.createTextNode(String.valueOf(nf.getValor_total())));
            ICMSTotal.appendChild(vBCTotal);
            
            Element AliqIcms = documentoXML.createElement("aliqIcms");
            AliqIcms.appendChild(documentoXML.createTextNode("18"));
            ICMSTotal.appendChild(AliqIcms);

            Element vICMSTotal = documentoXML.createElement("vICMSTotal");
            vICMSTotal.appendChild(documentoXML.createTextNode(String.valueOf(nf.getValor_total()/18)));
            ICMSTotal.appendChild(vICMSTotal);

            Element vProdTotal = documentoXML.createElement("vProd");
            vProdTotal.appendChild(documentoXML.createTextNode(String.valueOf(nf.getValor_total())));
            ICMSTotal.appendChild(vProdTotal);

            Element vFrete = documentoXML.createElement("vFrete");
            vFrete.appendChild(documentoXML.createTextNode("0"));
            ICMSTotal.appendChild(vFrete);

            Element vOutro = documentoXML.createElement("vOutro");
            vOutro.appendChild(documentoXML.createTextNode("0"));
            ICMSTotal.appendChild(vOutro);

            Element vNF = documentoXML.createElement("vNF");
            vNF.appendChild(documentoXML.createTextNode(String.valueOf(nf.getValor_total())));
            ICMSTotal.appendChild(vNF);

            TransformerFactory trans = TransformerFactory.newInstance();

            Transformer transformer = trans.newTransformer();

            DOMSource DocumentoFonte = new DOMSource(documentoXML);
            StreamResult documento = new StreamResult(new File("c:\\temp\\NFe" + nf.getNumero() + ".xml"));

            transformer.transform(DocumentoFonte, documento);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GeradorNf.class.getName()).log(Level.SEVERE, null, ex);

        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(GeradorNf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(GeradorNf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gerarNFServico() {
        Cliente cl = new Cliente();
        PessoaFisica cf = new PessoaFisica();
        PessoaJuridica cj = new PessoaJuridica();
        Servico s = new Servico();
        Endereco end = new Endereco();
        NfSaida ns = new NfSaida();
        CentroCusto cc = new CentroCusto();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("NFeS");
            doc.appendChild(root);

            Element ide = doc.createElement("ide");
            root.appendChild(ide);

            Element CPFCNPJ = doc.createElement("CPFCPNJRemetente");
            ide.appendChild(CPFCNPJ);


            Element CNPJRemetente = doc.createElement("CNPJ");
            CNPJRemetente.appendChild(doc.createTextNode(cc.getCnpj()));
            CPFCNPJ.appendChild(CNPJRemetente);
            
            
            Element dtInicio = doc.createElement("dtInicio");
            dtInicio.appendChild(doc.createTextNode(ns.getData_emissao()));
            ide.appendChild(dtInicio);

            Element dtFim = doc.createElement("dtFim");
            dtFim.appendChild(doc.createTextNode(ns.getData_emissao()));
            ide.appendChild(dtFim);
            //----------
            Element ValorTotalServicos = doc.createElement("ValorTotalServicos");
            ValorTotalServicos.appendChild(doc.createTextNode(String.valueOf(ns.getValor_total())));
            ide.appendChild(ValorTotalServicos);

            Element ValorTotalDeducoes = doc.createElement("ValorTotalDeducoes");
            ValorTotalDeducoes.appendChild(doc.createTextNode("0"));
            ide.appendChild(ValorTotalDeducoes);

            Element ChaveRPS = doc.createElement("ChaveRPS");
            ide.appendChild(ChaveRPS);

            Element InscricaoPrestador = doc.createElement("InscricaoPrestador");
            InscricaoPrestador.appendChild(doc.createTextNode(cc.getMunicipio()));
            ide.appendChild(InscricaoPrestador);

            Element NumeroRPS = doc.createElement("NumeroRPS");
            NumeroRPS.appendChild(doc.createTextNode("Numero do RPS"));

            Element TipoRPS = doc.createElement("TipoRPS");
            ide.appendChild(TipoRPS);

            Element DataEmissao = doc.createElement("DataEmissao");
            DataEmissao.appendChild(doc.createTextNode("DATA EMISSAO"));
            ide.appendChild(DataEmissao);

            Element TributacaoRPS = doc.createElement("TributacaoRPS");
            TributacaoRPS.appendChild(doc.createTextNode("True"));
            ide.appendChild(TributacaoRPS);

            Element ValorServicos = doc.createElement("ValorServicos");
            ValorServicos.appendChild(doc.createTextNode(String.valueOf(ns.getValor_total())));
            ide.appendChild(ValorServicos);

            Element ValorDeducoes = doc.createElement("ValorDeducoes");
            ValorDeducoes.appendChild(doc.createTextNode("0"));
            ide.appendChild(ValorDeducoes);

            Element ValorPIS = doc.createElement("ValorPIS");
            ValorPIS.appendChild(doc.createTextNode("0"));
            ide.appendChild(ValorPIS);

            Element ValorCOFINS = doc.createElement("ValorCOFIN");
            ValorCOFINS.appendChild(doc.createTextNode("0"));
            ide.appendChild(ValorCOFINS);

            Element ValorINSS = doc.createElement("ValorINSS");
            ValorINSS.appendChild(doc.createTextNode("0"));
            ide.appendChild(ValorINSS);

            Element ValorIR = doc.createElement("ValorIR");
            ValorPIS.appendChild(doc.createTextNode("0"));
            ide.appendChild(ValorIR);

            Element ValorCSLL = doc.createElement("ValorCSLL");
            ValorCSLL.appendChild(doc.createTextNode("0"));
            ide.appendChild(ValorCSLL);

            if (pd.getLista_servicos().size() > 0) {
                for (ServicoPedido sp : pd.getLista_servicos()) {

                    Element DescricaoServico = doc.createElement("DescricaoServico");
                    DescricaoServico.appendChild(doc.createTextNode(sp.getServico().getDescricao()));
                    ide.appendChild(DescricaoServico);
                }
            }
            Element ISSRetido = doc.createElement("ISSRetido");
            ISSRetido.appendChild(doc.createTextNode("True"));
            ide.appendChild(ISSRetido);

            Element CPFCNPJTomador = doc.createElement("CPFCPNJTomador");
            ide.appendChild(CPFCNPJTomador);

            if (cl instanceof PessoaFisica){
            
            Element CPFTomador = doc.createElement("CPF");
            CPFTomador.appendChild(doc.createTextNode(cf.getCpf()));
            CPFCNPJTomador.appendChild(CPFTomador);
            
            
            Element RazaoSocialTomador = doc.createElement("RazaoSocialTomador");
            RazaoSocialTomador.appendChild(doc.createTextNode(cf.getNome()));
            ide.appendChild(RazaoSocialTomador);

            }else if (cl instanceof PessoaJuridica){
            Element CNPJTomador = doc.createElement("CNPJ");
            CNPJTomador.appendChild(doc.createTextNode(cj.getCnpj()));
            CPFCNPJTomador.appendChild(CNPJTomador);
            
            Element RazaoSocialTomador = doc.createElement("RazaoSocialTomador");
            RazaoSocialTomador.appendChild(doc.createTextNode(cj.getRazao_social()));
            ide.appendChild(RazaoSocialTomador);
        }
            Element EnderecoTomador = doc.createElement("EnderecoTomador");
            ide.appendChild(EnderecoTomador);

            Element TipoLongradouro = doc.createElement("TipoLongradouro");
            TipoLongradouro.appendChild(doc.createTextNode(end.getRua()));
            EnderecoTomador.appendChild(TipoLongradouro);

            Element NumeroEndereco = doc.createElement("NumeroEndereco");
            NumeroEndereco.appendChild(doc.createTextNode(end.getNumero()));
            EnderecoTomador.appendChild(NumeroEndereco);

            Element BairroTomador = doc.createElement("Bairro");
            BairroTomador.appendChild(doc.createTextNode(end.getBairro()));
            EnderecoTomador.appendChild(BairroTomador);

            Element CidadaeTomador = doc.createElement("Cidadae");
            CidadaeTomador.appendChild(doc.createTextNode(end.getCidade()));
            EnderecoTomador.appendChild(CidadaeTomador);

            Element UFTomador = doc.createElement("UF");
            UFTomador.appendChild(doc.createTextNode(end.getUf()));
            EnderecoTomador.appendChild(UFTomador);

            Element CEPTomador = doc.createElement("CEP");
            CEPTomador.appendChild(doc.createTextNode(end.getCep()));
            EnderecoTomador.appendChild(CEPTomador);

            //Tags
            TransformerFactory trans = TransformerFactory.newInstance();
            Transformer transformer = trans.newTransformer();
            DOMSource DocumentoFonte = new DOMSource(doc);
            StreamResult documento = new StreamResult(new File("c:\\temp\\dados.xml"));
            transformer.transform(DocumentoFonte, documento);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GeradorNf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(GeradorNf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(GeradorNf.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
*/}
