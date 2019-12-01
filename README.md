# pucmg-tccpos
Repositório para postagem da POC desenvolvida no TCC da pós graduação em Arquitetura de Software Distruibuído pela PUC - MG com o tema Sistema de Controle de Vendas com a Modalidade de Entrega Dropshipping.

Para execução do serviço "vendasweb" é preciso criar o arquivo .env conforme o arquivo .env.exemple, preenchendo os campos com as informações solicitadas.
Feito isso é necessário instalar as dependências (npm i) e depois iniciar a aplicação (npm start).

Para execução do serviço "controlevendas" é preciso criar um banco de dados (MySQL) com o nome pucmg_tcc.
Feito isso é necessário alterar o  arquivo de properties da aplicação com as informações do banco de dados e da AWS (SNS e SQS) e iniciar a aplicação (mvn spring-boot:run).
Também pode-se buildar o projeto com o maven (mvn clean install) e executar o jar gerado.
PS: No projeto também existe um arquivo json com exemplo de menssagem para realizar o cadastro de produtos.

Para execução do serviço "spring-admin" basta alterar o arquivo de properties da aplicação com as informações de e-mail (origem e destino) e iniciar a aplicação (mvn spring-boot:run).
Também pode-se buildar o projeto com o maven (mvn clean install) e executar o jar gerado.
