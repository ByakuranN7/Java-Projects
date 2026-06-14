# Calculadora de IMC com JavaFX

## Objetivo

Este projeto tem como objetivo praticar o desenvolvimento de aplicações utilizando **JavaFX**, aplicando conceitos fundamentais da linguagem Java e da Programação Orientada a Objetos.

A aplicação permite que o usuário informe seu peso e altura, calcule seu **Índice de Massa Corporal (IMC)** e visualize a classificação correspondente de acordo com os valores de referência.

---

## Tecnologias e Conceitos Utilizados

### Java

Durante o desenvolvimento foram utilizados diversos conceitos da linguagem Java:

* Classes e objetos
* Métodos de instância
* Herança (`extends Application`)
* Encapsulamento da lógica em métodos
* Manipulação de Strings
* Conversão de tipos (`String` → `double`)
* Estruturas condicionais (`if`, `else if`, `else`)
* Tratamento de exceções (`try-catch`)
* Expressões Lambda
* Formatação de texto com `String.format()`

---

### JavaFX

A interface gráfica foi construída utilizando componentes do JavaFX:

* `Application`
* `Stage`
* `Scene`
* `Label`
* `TextField`
* `Button`

Também foram utilizados diferentes gerenciadores de layout:

* `HBox`
* `VBox`
* `BorderPane`

Além disso, foram explorados conceitos como:

* Posicionamento de componentes
* Alinhamento de elementos
* Espaçamento interno (`Insets`)
* Estilização com CSS inline (`setStyle`)
* Manipulação de eventos com `setOnAction`

---

## Funcionalidades

* Entrada de peso em quilogramas
* Entrada de altura em metros
* Cálculo automático do IMC
* Classificação do resultado
* Validação de valores negativos ou iguais a zero
* Tratamento de entradas inválidas
* Exibição dos resultados diretamente na interface gráfica

---

## Fórmula Utilizada

O cálculo do IMC é realizado através da fórmula:

```text
IMC = peso / (altura²)
```

Exemplo:

```text
Peso: 75 kg
Altura: 1,80 m

IMC = 75 / (1,80 × 1,80)
IMC = 23,15
```

---

## Classificação do IMC

| IMC            | Classificação           |
| -------------- | ----------------------- |
| Menor que 17   | Muito abaixo do peso    |
| 17 até 18,49   | Abaixo do peso          |
| 18,5 até 24,99 | Peso normal             |
| 25 até 29,99   | Acima do peso           |
| 30 até 34,99   | Obesidade I             |
| 35 até 39,99   | Obesidade II (severa)   |
| 40 ou mais     | Obesidade III (mórbida) |

---

## Estrutura Utilizada Neste Projeto

Por se tratar de um projeto de estudos, toda a aplicação foi implementada em um único arquivo Java.

Isso facilita a visualização dos conceitos fundamentais do JavaFX e da interação entre interface gráfica e lógica da aplicação.

Estrutura atual:

```text
CalculadoraIMC.java
```

---

## Como Isso Seria Feito em um Projeto Profissional?

Em aplicações reais normalmente a organização é diferente.

A interface gráfica, os controladores e as regras de negócio costumam ser separados em arquivos distintos, seguindo princípios de responsabilidade única e manutenção facilitada.

Um exemplo de estrutura seria:

```text
src
├── main
│   ├── java
│   │   ├── Main.java
│   │   ├── controller
│   │   │   └── CalculadoraController.java
│   │   ├── service
│   │   │   └── IMCService.java
│   │   └── model (se necessário)
│   │       └── ...
│   │
│   └── resources
│       └── calculadora.fxml
```

### Responsabilidades

| Componente | Responsabilidade |
|------------|------------------|
| Main | Inicializar a aplicação e carregar a interface |
| Controller | Receber eventos da interface e coordenar a lógica da aplicação |
| Service | Implementar as regras de negócio |
| Model | Representar e armazenar os dados da aplicação |
| FXML | Definir a estrutura visual da interface gráfica |

---

## Maven e Gradle

Neste projeto o JavaFX foi utilizado de forma simples para fins educacionais.

Em ambientes profissionais é comum utilizar ferramentas de automação e gerenciamento de dependências como:

* Maven
* Gradle

Essas ferramentas permitem:

* Gerenciamento automático de bibliotecas
* Controle de versões das dependências
* Automatização do processo de build
* Execução de testes
* Empacotamento da aplicação
* Integração contínua (CI/CD)

---

## Próximos Passos de Aprendizado

Algumas evoluções naturais deste projeto seriam:

* Separação da lógica em classes específicas
* Introdução ao padrão MVC
* Utilização de Controllers
* Utilização de arquivos FXML
* Uso do Scene Builder
* Aplicação de CSS externo
* Criação de testes automatizados

---

## Resumo

Este projeto foi desenvolvido como prática dos conceitos fundamentais do JavaFX e da linguagem Java.

Durante sua implementação foram explorados conceitos relacionados a:

* Programação Orientada a Objetos
* Interfaces gráficas
* Layouts
* Eventos
* Tratamento de exceções
* Validação de dados
* Organização visual de componentes

Além de cumprir sua função como calculadora de IMC, o projeto serve como base para estudos futuros envolvendo arquiteturas mais robustas, FXML, Scene Builder, Maven/Gradle e aplicações desktop desenvolvidas profissionalmente.