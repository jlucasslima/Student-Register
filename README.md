# Sistema de Cadastro de Alunos

Um sistema em **Java** com interface gráfica para gerenciamento e cadastro de estudantes. Este projeto foi desenvolvido aplicando conceitos sólidos de **Programação Orientada a Objetos (POO)**, incluindo herança, polimorfismo e interfaces.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![BlueJ](https://img.shields.io/badge/BlueJ-3C8CC7?style=for-the-badge&logo=java&logoColor=white)

---

## Funcionalidades

O sistema conta com um menu interativo (`JOptionPane`) que permite:

- **Inserir Aluno:** Cadastro com Nome, Idade, RA e Curso.
- **Remover Aluno:** Exclusão de alunos da lista a partir do nome.
- **Listar Alunos:** Exibição de todos os alunos cadastrados no sistema.
- **Formatação Bibliográfica:** Conversão automática de nomes para o formato de citação (ex: *Ze da Silva Pereira Antunes* ➔ *ANTUNES, Ze da Silva Pereira*).
- **Controle de Capacidade:** O sistema respeita o limite de alunos definido pelo usuário no início da execução.

---

## Tecnologias Utilizadas

- **Linguagem:** Java (JDK)
- **Interface Gráfica:** Java Swing (`JOptionPane`)
- **Ambiente de Desenvolvimento:** BlueJ

---

## Arquitetura do Projeto

O projeto foi construído pensando em modularidade e boas práticas. As principais classes e interfaces são:

* `Pessoa` / `Aluno`: Classes de modelo utilizando herança para representar os dados do estudante.
* `Texto` / `NomePessoa`: Classes responsáveis pelo tratamento e formatação de strings (como a geração do nome bibliográfico).
* `IArmazenador`: Interface que define o contrato de armazenamento de dados.
* `ArmazenadorArray`: Implementação concreta da interface `IArmazenador`, gerenciando os alunos em um vetor em memória.
* `CadastroAlunos`: Classe controladora que faz a ponte entre a interface e os dados.
* `IMenu` / `MenuGrafico`: Interface e implementação da camada de visualização (UI) usando janelas pop-up.
* `App`: Classe principal que inicializa o sistema.

---

## Como Executar (no BlueJ)

1. Abra o projeto no **BlueJ**.
2. Clique no botão **"Compilar"** para garantir que todas as dependências estão corretas.
3. Clique com o botão direito na classe `App`.
4. Selecione `void main(String[] args)`.
5. Insira a quantidade máxima de alunos e interaja com o menu gráfico!

---
*Desenvolvido como projeto de estudo em Ciência da Computação.*
