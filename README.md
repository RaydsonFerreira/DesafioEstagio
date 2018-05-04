# DesafioEstagio

# Resolução

Para Resolução do problema foi utilizado Java 1.8, conforme solicitado no documento enviado. Foram utilizadas duas classes, uma chamada Loja, que representam as lojas filiais da locadora, e outra classe chamada Carro, que representam os carros pertencentes as lojas. Para entrada dos carros, foi criado um arquivo .txt que se encontra na pasta ‘dist’. Outros dados de entrada são feitos pelo teclado.

#Execução

O programa não utiliza interface gráfica, sendo somente utilizado o terminal para interação com o mesmo, o qual pode ser executado da seguinte maneira:

Faça um clone da aplicação em sua máquina;

Navegue até a pasta ‘dist’ através do terminal (Ex.: se você fez o clone na área de trabalho, abra o terminal, e navegue com o seguinte comando: cd Área\ de\ Trabalho//DesafioEstagio/dist);

Execute o comando: java -jar LocaCar.jar

ao iniciar o programa, digite 1 para alugar um carro e depois coloque na descrição conforme o padrão: 

< Tipo de Cliente >: < Quantidade de passageiros >: < Data1 >, < Data2 >, <  Data3 >,…

Tipo de Cliente: Normal ou Premium, o que caracteriza se um cliente possui ou não o cartão fidelidade;

Quantidade de passageiros: Quantos passageiros o carro deve comportar;

Data(s): Data(s) em que se utilizará o carro.

Como exemplo de entrada tem-se:

Normal: 3: 23Mar2009(Qua), 24Mar2009(Qui), 25Mar2009(Sex)

E como exemplo de saída:

Fiat 500: SouthCar

# Lógica

Como o problema foi descrito de uma forma ampla, foi pensado o seguinte como lógica:

1. Nenhum carro pose ser alugado na mesma data, portanto foi desenvolvida uma função para checagem na hora de alugar que faz uma verificação se o carro já está ou estará alugado naquela(s) data(s) informada(s). Sendo que quando um carro já está ocupado, o sistema retorna outro carro, ou se todos estiverem ocupados, é gerada uma mensagem escrita “carros indisponíveis”.  

2. Para verificar qual carro é melhor para um determinado número de passageiros, é feito um calculo, onde o valor da diária de cada carro e somada (diferenciando fim de semana com dia de semana, e cliente premium do normal). Verificando assim o melhor preço e a disponibilidade do aluguel do carro.

# Dúvidas

Toda e qualquer dúvida a respeito de execução ou de lógica do programa pode ser contada através do e-mail raydsonferreira@gmail.com com o seguinte assunto “Duvidas a respeito do DesafiodeEstágio”
