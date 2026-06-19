# Jogo da Forca em Java (Console)

## Objetivo

Este projeto tem como objetivo praticar alguns conceitos fundamentais da linguagem **Java** através do desenvolvimento de um jogo da forca em terminal.

Durante sua construção foram aplicados conceitos de programação orientada a objetos, manipulação de arquivos, estruturas de repetição, validação de entrada do usuário e organização de código em múltiplas classes.

O projeto também simula uma experiência de jogo mais completa, com feedback dinâmico, estatísticas e interface textual aprimorada.

------------------------------------------------------------------------

# Tecnologias e Conceitos Utilizados

## Java

Durante o desenvolvimento foram utilizados diversos conceitos fundamentais da linguagem:

-   Classes e objetos
-   Métodos e encapsulamento de lógica
-   Estruturas de repetição (`while`, `for`)
-   Estruturas condicionais (`if`, `switch`)
-   Manipulação de arrays (`char[]`)
-   Coleções (`Set`, `TreeSet`)
-   Entrada de dados com `Scanner`
-   Manipulação de strings
-   Validação de entrada do usuário

------------------------------------------------------------------------

## Programação Orientada a Objetos (POO)

O projeto foi organizado em múltiplas classes com responsabilidades separadas:

-   `JogoDaForca` → lógica principal do jogo
-   `GerenciadorPalavras` → leitura e seleção de palavras
-   `DesenhoForca` → renderização do boneco em ASCII
-   `Main` → ponto de entrada da aplicação

------------------------------------------------------------------------

## Manipulação de Arquivos

As palavras do jogo são carregadas dinamicamente a partir de um arquivo `.txt` utilizando a API de NIO do Java:

``` java
Files.readAllLines(Paths.get("resources/palavras.txt"));
```

------------------------------------------------------------------------

# Estrutura do Projeto

``` text
src/
├── Main.java
├── JogoDaForca.java
├── GerenciadorPalavras.java
├── DesenhoForca.java
└── resources/
    └── palavras.txt
```

------------------------------------------------------------------------

# Funcionalidades Básicas

-   Sorteio aleatório de palavras
-   Exibição da palavra oculta
-   Sistema de tentativas
-   Validação de entrada
-   Feedback dinâmico
-   Estatísticas finais
-   Controle de letras utilizadas

------------------------------------------------------------------------

# Melhorias futuras

-   Categorias de palavras
-   Dificuldade
-   Interface JavaFX
