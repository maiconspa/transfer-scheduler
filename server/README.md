# Sistema de Agendamento de Transferências Financeiras
Este é um sistema desenvolvido em Spring Boot para agendamento de transferências financeiras.

## Decisões Arquiteturais
> O sistema foi construído seguindo uma arquitetura baseada em modelo MVC (Model-View-Controller), onde:

* **Model**: Representa as entidades de negócio, como Transfer e Account.
* **View**: Não implementada neste projeto, pois se trata de uma API RESTful, mas poderia ser adicionada no futuro para uma interface de usuário.
* **Controller**: Responsável por receber as requisições HTTP e chamar os serviços apropriados para processá-las.
* **Service**: Contém a lógica de negócio da aplicação, como cálculo de taxa de transferência e agendamento de transferências.
* **Repository**: Interfaces que estendem JpaRepository para acesso ao banco de dados, permitindo operações CRUD (Create, Read, Update, Delete) nas entidades.

## Versões de Linguagem e Ferramentas Utilizadas
* **Java 11**: Utilizamos o Java 11 para aproveitar os recursos mais recentes da linguagem e garantir compatibilidade e suporte a longo prazo.
* S**pring Boot 2.5.x**: Framework para desenvolvimento de aplicativos Java, utilizado para criar facilmente aplicativos Spring autônomos, com incorporação de servidores, configuração simplificada e monitoramento de produção.
* **H2 Database**: Banco de dados em memória para armazenamento dos dados do sistema durante o desenvolvimento e teste.
* **Maven**: Gerenciador de dependências utilizado para configurar e construir o projeto.
* **Lombok**: Biblioteca que facilita a criação de classes Java, eliminando a necessidade de escrever métodos getter, setter e outros métodos boilerplate.

## Instruções para Subida do Projeto

1. Certifique-se de ter o **Java 11** instalado em sua máquina. Você pode verificar digitando `java -version` no terminal.
1. **Clone** o repositório do projeto para o seu ambiente de desenvolvimento.
1. Abra o projeto em sua IDE de preferência (recomemndável IntelliJ IDEA).
1. Configure as **dependências** do projeto.
1. Execute a classe principal `TransferSchedulerApplication.java` ou a rotina `spring-boot:run` para **iniciar** o aplicativo Spring Boot.
1. O aplicativo estará **acessível em** http://localhost:8080.