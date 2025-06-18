# 🎬 ScreenMatch - Catálogo de Filmes e Séries em Java com Spring Boot

Este projeto é um catálogo de filmes e séries desenvolvido em Java, utilizando o framework Spring Boot. Ele foca na aplicação de conceitos de Programação Orientada a Objetos (POO), consumo de APIs externas, manipulação e persistência de dados em banco de dados, e interação via console.

-----

## 📌 Sobre o Projeto

O **ScreenMatch** foi desenvolvido como parte de um curso de Java da Alura, com o objetivo de praticar e consolidar conhecimentos em:

  * **Criação de classes e objetos**: Modelagem de entidades como `Serie` e `Episodio`.
  * **Herança, interfaces e polimorfismo**: Utilização de interfaces para conversão de dados.
  * **Manipulação de listas e coleções**: Gerenciamento de listas de séries e episódios.
  * **Consumo de APIs externas**: Integração com a **OMDb API** para buscar dados de filmes e séries, e **MyMemory API** para tradução de sinopses.
  * **Tratamento de exceções**: Lidar com erros durante o consumo de APIs e conversão de dados.
  * **Serialização e desserialização de dados (JSON)**: Utilização de Jackson para mapear JSON para objetos Java.
  * **Persistência de dados**: Uso do Spring Data JPA para interagir com um banco de dados (provavelmente H2 ou PostgreSQL, configurável via `application.properties`).
  * **Consultas avançadas**: Implementação de consultas personalizadas com `@Query` para filtros e rankings.
  * **Enumerações**: Categorização de séries por gênero.

-----

## 🚀 Tecnologias Utilizadas

<div>
 <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white">
 <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white">
 <img src="https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
 <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white">
 <img src="https://img.shields.io/badge/H2_Database-2DB2DD?style=for-the-badge&logo=h2&logoColor=white">
</div>

-----

## 🧱 Estrutura do Projeto

```
📁 Screen-Match---Projeto-em-Java/
├── 📁 .idea/                      (Arquivos de configuração da IDE)
├── 📁 .mvn/                       (Arquivos do Maven Wrapper)
├── 📁 src/
│   └── 📁 main/
│       └── 📁 java/
│           └── 📁 br/
│               └── 📁 com/
│                   └── 📁 alura/
│                       └── 📁 screenmatch/
│                           ├── 📁 model/                (Classes de modelo de dados e records para DTOs)
│                           ├── 📁 principal/            (Classe Principal com o menu de interação)
│                           ├── 📁 repository/           (Interfaces de repositório Spring Data JPA)
│                           ├── 📁 service/              (Classes de serviço e lógica de negócio, como ConsumoAPI, ConverteDados, ConsultaMyMemory)
│                           └── 📄 ScreenmatchApplication.java (Classe principal da aplicação Spring Boot)
│       └── 📁 resources/
│           └── 📄 application.properties (Configurações do banco de dados e APIs)
├── 📄 .gitignore
├── 📄 ScreenMatch.iml             (Arquivo de módulo da IDE)
├── 📄 pom.xml                     (Configurações de dependências Maven)
└── 📄 README.md
```

-----

## ⚙️ Como Usar

Para executar este projeto em sua máquina local, siga os passos abaixo:

1.  **Pré-requisitos**:

      * Java 17 ou superior.
      * Maven.
      * Uma IDE (IntelliJ IDEA, Eclipse, VS Code com plugins Java).
      * (Opcional) PostgreSQL ou outro banco de dados relacional. Se não usar, o Spring Boot configurará um H2 em memória por padrão.

2.  **Clone o repositório:**

    ```bash
    git clone https://github.com/AbnerVital/ScreenMatch---Spring.git
    ```

3.  **Navegue até o diretório do projeto:**

    ```bash
    cd ScreenMatch---Spring
    ```

4.  **Configuração da API Key**:

      * Obtenha uma chave gratuita na [OMDb API](http://www.omdbapi.com/apikey.aspx).

      * Obtenha uma chave gratuita na [MyMemory API](https://www.google.com/search?q=https://mymemory.translated.net/api.php%3Fmt%3Dtrue).

      * Abra o arquivo `src/main/resources/application.properties` (ou crie-o se não existir) e adicione suas chaves:

        ```properties
        # Exemplo de configuração do banco de dados (ajuste conforme necessário)
        # spring.datasource.url=jdbc:postgresql://localhost:5432/screenmatch_db
        # spring.datasource.username=seu_usuario
        # spring.datasource.password=sua_senha
        # spring.jpa.hibernate.ddl-auto=update

        # Se você tiver a chave da OMDb ou MyMemory como variável de ambiente ou propriedade:
        # omdb.api.key=SUA_CHAVE_OMDB
        # mymemory.api.key=SUA_CHAVE_MYMEMORY
        ```

        *Obs: No código fornecido, a API Key da OMDb está hardcoded na classe `Principal`. Para um projeto real, é recomendável movê-la para `application.properties` e injetá-la.*
        *A API Key da MyMemory é gerenciada internamente pela `ConsultaMyMemory` e não requer uma propriedade explícita no `application.properties` com base no código fornecido.*

5.  **Compile e execute o projeto:**

      * **Via IDE (Recomendado)**:

        1.  Abra o projeto na sua IDE (ex: IntelliJ IDEA -\> `File` -\> `Open` -\> selecione a pasta do projeto).
        2.  Aguarde a IDE resolver as dependências do Maven.
        3.  Execute a classe `ScreenmatchApplication.java`.

      * **Via Terminal (com Maven)**:

        ```bash
        mvn spring-boot:run
        ```

6.  **Interação**:

      * Após a execução, um menu será exibido no console, permitindo que você interaja com o catálogo de séries. Siga as opções do menu para buscar séries, episódios e explorar os dados.

-----

## 📈 Melhorias Futuras

  * Implementar interface gráfica com **JavaFX** ou **Swing** (ou até mesmo uma interface web com **Spring Web/Thymeleaf/React/Angular**).
  * Adicionar funcionalidade de login e autenticação de usuários.
  * Integrar com banco de dados para persistência de dados (já parcialmente implementado com Spring Data JPA, mas expandir funcionalidades).
  * Desenvolver testes unitários para as principais funcionalidades (classes de modelo, serviços e repositórios).
  * Melhorar a experiência do usuário com validações de entrada mais robustas.
  * Implementar paginação para resultados de busca.

-----

## 👨‍💻 Autor

| [<img src="https://avatars.githubusercontent.com/u/102125924?v=4" width=115><br><sub>Abner Vital</sub>](https://github.com/AbnerVital) |
| :------------------------------------------------------------------------------------------------------------------------------------: |

-----

## 📫 Contato

  * **LinkedIn**: [@Abner Vital](https://www.linkedin.com/in/abner-vital-233730141/)
  * **GitHub**: [@AbnerVital](https://github.com/AbnerVital)

-----

> Desenvolvido durante os estudos na [Alura](https://www.alura.com.br/)

-----
