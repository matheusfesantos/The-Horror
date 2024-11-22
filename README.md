### The Horror - README

**The Horror** é um software criado para os fãs de filmes de terror, permitindo catalogar e organizar os seus títulos favoritos de forma prática e personalizada. Ele oferece uma interface simples e intuitiva para que você possa gerenciar sua coleção de filmes de terror e descobrir novas obras do gênero.

---

## 🎥 **Descrição do Projeto**

O projeto **The Horror** foi desenvolvido com o objetivo de fornecer aos usuários uma ferramenta para organizar e consultar seus filmes de terror favoritos. Com um foco em simplicidade e funcionalidade, o software permite adicionar informações sobre os filmes, como:

- Título  
- Diretor  
- Ano de lançamento

Este projeto foi idealizado como uma forma de aplicar conceitos de **desenvolvimento de software**, **design de interfaces** e organização de dados.

---

## 🛠️ **Tecnologias Utilizadas**

- **Java**: Para desenvolvimento da lógica e estrutura do software.  
- **JavaFX**: Para construção da interface gráfica interativa.    
- **CSS**: Para estilizar a interface com um visual que combina com o tema de terror.  

---

## 🚀 **Funcionalidades**

- **Adicionar Filmes**: Cadastre filmes com detalhes como título, ano, gênero e comentários.  
- **Editar e Remover Filmes**: Atualize informações ou remova filmes do catálogo.  
- **Pesquisa Avançada**: Encontre filmes rapidamente com filtros por gênero, ano ou avaliação.  
- **Interface Personalizável**: Visual inspirado no gênero terror, com tema escuro e design imersivo.  

---

## 📂 **Estrutura do Projeto**

```
The-Horror/
├── .gitignore
├── .idea/
│   ├── inspectionProfiles/
│   │   └── Project_Default.xml
│   ├── libraries/
│   │   ├── KotlinJavaRuntime.xml
│   │   └── lib.xml
│   ├── misc.xml
│   ├── modules.xml
│   ├── uiDesigner.xml
│   └── vcs.xml
├── Banco_de_Dados/
│   └── Info_Filmes.txt
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── horror/
│   │   │   │   │   ├── DadosFilmes.java
│   │   │   │   │   └── Telalnicial.java
│   │   ├── resources/
│   │   │   ├── Images/
│   │   │   │   └── Background.gif
│   │   │   └── Style/
│   │   │       └── Telalnicial.css
├── The_Horror.iml
└── README.md
```

### **Descrição dos Diretórios e Arquivos**

- **.gitignore**: Arquivo utilizado para listar os arquivos e pastas que devem ser ignorados pelo Git.
- **.idea/**: Arquivos de configuração do IntelliJ IDEA, utilizados pela IDE.
- **Banco_de_Dados/**: Pasta contendo o arquivo `Info_Filmes.txt`, onde os filmes cadastrados são armazenados em formato texto.
- **src/**: Diretório contendo o código fonte do projeto.
  - **main/java/com/horror/**: Contém a lógica do software, incluindo as classes `DadosFilmes.java` e `Telalnicial.java`.
  - **main/resources/**: Contém os recursos utilizados pela aplicação, como imagens e estilos.
    - **Images/**: Contém imagens usadas na interface do software, como o fundo (`Background.gif`).
    - **Style/**: Contém o arquivo de estilo (`Telalnicial.css`) que define o visual da interface.
- **The_Horror.iml**: Arquivo de configuração do IntelliJ IDEA para o projeto.
- **README.md**: Este arquivo, que contém informações sobre o projeto e como utilizá-lo.

---

## 🔧 **Como Usar**

1. Clone o repositório:  
   ```bash
   git clone https://github.com/matheusfesantos/The-Horror.git
   ```
2. Navegue até a pasta do projeto:  
   ```bash
   cd The-Horror
   ```
3. Compile e execute o projeto com sua IDE de preferência ou terminal:  
   ```bash
   javac -d bin src/**/*.java
   java -cp bin com.horror.catalog.Main
   ```
4. Comece a catalogar sua coleção de filmes de terror! 🎃  

---

## 🤝 **Contribuições**

Se você quiser contribuir com melhorias ou adicionar novas funcionalidades, siga os passos abaixo:  

1. Faça um *fork* do projeto.  
2. Crie uma *branch*:  
   ```bash
   git checkout -b feature/nova-feature
   ```
3. Realize as alterações e faça um *commit*:  
   ```bash
   git commit -m "Adiciona nova funcionalidade"
   ```
4. Envie para o seu *fork* e crie um *pull request*:  
   ```bash
   git push origin feature/nova-feature
   ```

---

## 📬 **Contato**

- **Desenvolvedor**: Matheus Ferreira  
- **GitHub**: [matheusfesantos](https://github.com/matheusfesantos)  
- **E-mail**: (adicione seu e-mail aqui, se preferir)  

---

Organize, explore e curta o mundo sombrio dos filmes de terror com **The Horror**! 💀
