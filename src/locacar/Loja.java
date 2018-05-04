package locacar;

import java.util.ArrayList;

/**
 * @author raydson
 */
public class Loja {
    private String nome;
    /*Lista com todos os carros da locadora*/
    private ArrayList<Carro> carro;
    /*Tipo de carro que a loja aluga*/
    private char tipoDeCarro;
    /*Taxa no Meio da Semana*/
    private double taxaMDSNormal;
    /*Taxa no Fim da Semana*/
    private double taxaFDSNormal;
    /*Taxa no Meio da Semana com cartão fidelidade*/
    private double taxaMDSVip;
    /*Taxa no Fim da Semana com cartão fidelidade*/
    private double taxaFDSVip;
    
    public Loja(String nome, char tipoDeCarro, double taxaMDSNormal, double taxaFDSNormal, double taxaMDSVip, double taxaFDSVip) {
        this.nome = nome;
        this.tipoDeCarro = tipoDeCarro;
        this.taxaMDSNormal = taxaMDSNormal;
        this.taxaFDSNormal = taxaFDSNormal;
        this.taxaMDSVip = taxaMDSVip;
        this.taxaFDSVip = taxaFDSVip;
        this.carro = new ArrayList<>();
    }
    
    public void addCarro(Carro carro){
        this.carro.add(carro);
    }
    
    /*Metodo para fazer aluguel de um carro*/
    public String alugar(ArrayList<String> datas){
        ArrayList<String> data = new ArrayList<>();
        boolean alugado = false;
        
        /*Percorre lista dos carros e as datas que estão emprestados
        Para não gerar conflito de empréstimo*/
        for(Carro C : carro){
            data = C.getDuracaoAluguel();
            for(String dataAux : data){
                for(String datasAux : datas){
                    if(dataAux.contains(datasAux)){
                        alugado = true;
                    }
                }
            }
            if(!alugado){
                C.alugar(datas);
                return C.getNome() + ": " + nome;
            }
            alugado = false;
        }
        return "carros indisponíveis";
    }

    public double getTaxaMDSNormal() {
        return taxaMDSNormal;
    }

    public double getTaxaFDSNormal() {
        return taxaFDSNormal;
    }

    public double getTaxaMDSVip() {
        return taxaMDSVip;
    }

    public double getTaxaFDSVip() {
        return taxaFDSVip;
    }
}
