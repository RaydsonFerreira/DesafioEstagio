package locacar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author raydson
 */
public class LocaCar {

    public static void main(String[] args) {

        /*Declaração das lojas como especificado no problema*/
        Loja southCar = new Loja("SouthCar", 'C', 210.00, 200.00, 150.00, 90.00);
        Loja westCar = new Loja("WestCar", 'E', 530.00, 200.00, 150.00, 90.00);
        Loja northCar = new Loja("NorthCar", 'S', 630.00, 600.00, 580.00, 590.00);
        
        /**
         * Leitura do arquivo que contém alguns carros e inserção dos mesmos
         * nas respectivas lojas
         */
        try{
            BufferedReader carros = new BufferedReader(new FileReader("carros.txt"));
            String nomeCarro, tipoCarro;
            Carro carro;
            String linha = carros.readLine();
            while(linha!=null){
                
                nomeCarro = linha.split(", ")[0];
                tipoCarro = linha.split(", ")[1];
                carro = new Carro(nomeCarro);
                
                if(tipoCarro.equals("S")){
                    northCar.addCarro(carro);
                }
                
                else if(tipoCarro.equals("C")){
                    southCar.addCarro(carro);
                }
                
                else if(tipoCarro.equals("E")){
                    westCar.addCarro(carro);
                }
                
                linha = carros.readLine();
            }
        }
        catch(Exception e){
            System.out.println("Erro ao ler o arquivo :: " + e);  
        }
        
        System.out.println();
        System.out.println("****** LocaCar, alugue seu carro aqui! ******");
        System.out.println("Digite 1 para alugar um carro, ou 0 para sair");
        
        Scanner entrada;
        entrada = new Scanner(System.in);
        int i = entrada.nextInt();
        
        while(i!=0){
            System.out.print("Descrição: ");
            String pedido = entrada.nextLine();
            pedido = entrada.nextLine();

            String tipoCliente, datasAlocacao[];
            int qntPassageiros;
            ArrayList<String> datas = new ArrayList<>();

            tipoCliente = pedido.split(": ")[0];
            qntPassageiros = Integer.parseInt(pedido.split(": ")[1]);
            datasAlocacao = (pedido.split(": ")[2]).split(", ");
            for(String d : datasAlocacao){
                datas.add(d);
            }

            if(qntPassageiros < 1 && qntPassageiros > 7){
                System.out.println("Carros indisponíveis");
            }

            else{
                double precoNorth = 0.0, precoSouth = 0.0, precoWest = 0.0;

                for(String d : datas){
                    if(tipoCliente.contains("Normal")){
                        if(d.contains("sab") || d.contains("dom")){
                            precoNorth += northCar.getTaxaFDSNormal();
                            precoSouth += southCar.getTaxaFDSNormal();
                            precoWest += westCar.getTaxaFDSNormal();
                        }
                        else{
                            precoNorth += northCar.getTaxaMDSNormal();
                            precoSouth += southCar.getTaxaMDSNormal();
                            precoWest += westCar.getTaxaMDSNormal();
                        }
                    }

                    else if(tipoCliente.contains("Premium")){
                        if(d.contains("sab") || d.contains("dom")){
                            precoNorth += northCar.getTaxaFDSVip();
                            precoSouth += southCar.getTaxaFDSVip();
                            precoWest += westCar.getTaxaFDSVip();
                        }
                        else{
                            precoNorth += northCar.getTaxaMDSVip();
                            precoSouth += southCar.getTaxaMDSVip();
                            precoWest += westCar.getTaxaMDSVip();
                        }
                    }
                }
                
                /*Nessa Parte do código são feitas verificações para checar
                qual carro é o mais viavel considerando preço e número de
                passageiros*/
                String resultadoEmprestimo;
                
                if(qntPassageiros > 4){
                    System.out.println(northCar.alugar(datas));
                }

                else if(qntPassageiros > 2){
                    
                    if(precoNorth > precoSouth){
                        resultadoEmprestimo = southCar.alugar(datas);
                        
                        if(resultadoEmprestimo.equals("carros indisponíveis"))
                            System.out.println(northCar.alugar(datas));
                        
                        else
                            System.out.println(resultadoEmprestimo);
                    }

                    else{
                        resultadoEmprestimo = northCar.alugar(datas);
                        
                        if(resultadoEmprestimo.equals("carros indisponíveis"))
                            System.out.println(southCar.alugar(datas));
                        
                        else    
                            System.out.println(resultadoEmprestimo);
                    }
                }

                else{
                    
                    if(precoNorth > precoSouth && precoSouth > precoWest){
                        resultadoEmprestimo = westCar.alugar(datas);
                        
                        if(resultadoEmprestimo.equals("carros indisponíveis")){
                            resultadoEmprestimo = southCar.alugar(datas);
                            
                            if(resultadoEmprestimo.equals("carros indisponíveis"))
                                System.out.println(northCar.alugar(datas));
                            
                            else
                                System.out.println(resultadoEmprestimo);
                        }
                        
                        else
                            System.out.println(resultadoEmprestimo);
                    }
                    
                    else if(precoNorth < precoSouth && precoSouth < precoWest){
                        resultadoEmprestimo = northCar.alugar(datas);
                        
                        if(resultadoEmprestimo.equals("carros indisponíveis")){
                            resultadoEmprestimo = southCar.alugar(datas);
                            
                            if(resultadoEmprestimo.equals("carros indisponíveis"))
                                System.out.println(westCar.alugar(datas));
                            
                            else
                                System.out.println(resultadoEmprestimo);
                        }
                        
                        else
                            System.out.println(resultadoEmprestimo);
                    }
                    
                    else{
                        resultadoEmprestimo = southCar.alugar(datas);
                        
                        if(resultadoEmprestimo.equals("carros indisponíveis")){
                            resultadoEmprestimo = westCar.alugar(datas);
                            
                            if(resultadoEmprestimo.equals("carros indisponíveis"))
                                System.out.println(northCar.alugar(datas));
                            
                            else
                                System.out.println(resultadoEmprestimo);
                        }
                        
                        else
                            System.out.println(resultadoEmprestimo);
                    }
                }
            }
            
        System.out.println();
        System.out.println("Se deseja continuar alugando digite 1, para sair digite 0");    
        i = entrada.nextInt();
        }
    }    
}
