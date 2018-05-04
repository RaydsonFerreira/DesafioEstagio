package locacar;

import java.util.ArrayList;

/**
 *
 * @author raydson
 */
public class Carro {
    private String nome;
    /*Lista de String com as datas em que o carra está emprestado*/
    private ArrayList<String> duracaoAluguel;

    public Carro(String nome) {
        this.nome = nome;
        this.duracaoAluguel = new ArrayList<>();
    }
    
    public void alugar(ArrayList<String> datas){
        for(String data : datas){
            this.duracaoAluguel.add(data);
        }
    }

    public String getNome() {
        return nome;
    }

    public ArrayList getDuracaoAluguel() {
        return duracaoAluguel;
    }
}
