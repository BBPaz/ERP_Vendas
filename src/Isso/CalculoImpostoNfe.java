package Isso;

import Defaut.Icms;

public class CalculoImpostoNfe {

    float valor_icms;
    float valor_ipi;
    float outras_despesas;
    float valor_nfe;
    String estado;
    // calc ipi utilizando um valor padrao de 12 para todos osprodutos
    public void calcIpi(){
        ProdutoPedido pd = new ProdutoPedido();
        valor_ipi = (pd.getValor_total() * 12)/100;  
    }
    // calculo de base icms
    public void calcBaseIcms() {
        double resultado = 0.0;
        ProdutoPedido pd = new ProdutoPedido();
        resultado = pd.getValor_total();
    }
    // calc de icms utilizando defaut 
    public void calcValorIcms() {
        ProdutoPedido pd = new ProdutoPedido();
        switch (estado) {
            case "ac":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "al":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "am":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "ap":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;

            case "ba":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "ce":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "df":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "es":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "go":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "ma":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "mt":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "ms":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "mg":
                valor_icms = (pd.getValor_total() * 12) / 100;
                break;
            case "pa":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "pb":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "pr":
                valor_icms = (pd.getValor_total() * 12) / 100;
                break;
            case "pe":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "pi":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "rn":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "rs":
                valor_icms = (pd.getValor_total() * 12) / 100;
                break;
            case "rj":
                valor_icms = (pd.getValor_total() * 12) / 100;
                break;
            case "ro":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "rr":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "sp":
                valor_icms = (pd.getValor_total() * 0) / 100;
                break;
            case "se":
                valor_icms = (pd.getValor_total() * 18) / 100;
                break;
            case "to":
                valor_icms = (pd.getValor_total() * 7) / 100;
                break;
            case "im":
                valor_icms = (pd.getValor_total() * 4) / 100;
                break;
            default:
                break;
        }
    }

}
