# LiterAluraONE

💻 **Desafio desenvolvido como parte do Programa de Estudos _Oracle Next Education_ — Alura**

## 🚀 Tecnologias utilizadas

- **Java JDK 17**  
- **Spring Boot 3.5.4**  
- **Jackson** — para consumir a API do Gutendex e converter os dados JSON  
- **PostgreSQL 17.5** — banco de dados usado para armazenar as informações obtidas  

## 🎯 Foco do desafio

Este projeto teve como objetivo **aprofundar conhecimentos** nas seguintes áreas:

- Uso de **funções Lambda** no Java  
- Criação e execução de consultas usando **JPQL**  
- Integração e manipulação de dados com **JDBC**  
- Consumo e manipulação de APIs externas  
- Uso e manipulação de **bibliotecas externas** no projeto  
- Conversão de dados JSON para entidades Java e persistência no banco de dados  
- Boas práticas no uso do **Spring Boot** e suas anotações  
- Criação de **Derived Queries** com Spring Data JPA para consultas personalizadas

## 📖 Funcionalidade do programa

Este programa realiza buscas de livros na API pública **Gutendex**, exibe as informações encontradas e as armazena para consultas posteriores.  
Também oferece um **menu interativo no terminal** com as seguintes opções:

1️⃣ **Buscar um livro pelo título**  
2️⃣ **Listar livros registrados**  
3️⃣ **Listar autores registrados**  
4️⃣ **Listar autores vivos em um determinado ano**  
5️⃣ **Listar livros em um determinado idioma** — entre eles espanhol, inglês, francês e português.

## 🛠️ Pré-requisitos

Antes de começar, você vai precisar ter instalado na sua máquina:

- **Java JDK 17**  
- **Spring Boot 3.x** (este projeto usa a versão **3.5.4**)  
- **Maven** (ou Gradle)  
- **PostgreSQL 17.5**  

## 📦 Como instalar e executar

1. **Clone o repositório**  
   ```bash
   git clone https://github.com/Axtes/LiterAluraONE.git
   cd LiterAluraONE
2. **Configure o banco de dados**

Crie um banco de dados no PostgreSQL (por exemplo, liter_alura_db).
Ajuste as configurações de conexão (URL, usuário e senha) no arquivo application.properties.

Após isso configurado, a aplicação rodará tranquilamente em sua máquina!
