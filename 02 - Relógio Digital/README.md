# Relógio Digital com JavaFX

## Objetivo

Este projeto tem como objetivo praticar o desenvolvimento de aplicações desktop utilizando **JavaFX**, criando um relógio digital capaz de exibir a hora atual do sistema em tempo real.

Durante sua implementação foram explorados conceitos relacionados à manipulação de datas e horários, atualização automática da interface gráfica e utilização de componentes visuais do JavaFX.

---

# Tecnologias e Conceitos Utilizados

## Java

Durante o desenvolvimento foram utilizados diversos conceitos da linguagem Java:

- Classes e objetos
- Herança (`extends Application`)
- Métodos
- Programação Orientada a Objetos
- Manipulação de datas e horários
- Expressões Lambda
- Encapsulamento de lógica em métodos

---

## JavaFX

A interface gráfica foi construída utilizando componentes do JavaFX:

- `Application`
- `Stage`
- `Scene`
- `Label`

Também foram utilizados gerenciadores de layout para posicionamento dos elementos na tela.

---

# Manipulação de Data e Hora

Para obter a data e hora atual do sistema foi utilizada a API moderna de datas do Java:

```java
LocalDateTime.now();
```

Exemplo de retorno:

```text
2026-06-11T01:05:08
```

---

## Formatação da Hora

A classe `DateTimeFormatter` foi utilizada para transformar a data e hora em um formato amigável para o usuário.

Exemplo:

```java
DateTimeFormatter.ofPattern("HH:mm:ss");
```

Resultado:

```text
14:35:27
```

---

# Atualização Automática da Interface

Uma das principais características do projeto é a atualização automática do relógio sem necessidade de interação do usuário.

Para isso foram utilizados:

- `Timeline`
- `KeyFrame`
- `Duration`

---

## Timeline

O `Timeline` permite executar uma ação repetidamente em intervalos definidos.

Neste projeto ele é responsável por atualizar o horário exibido na tela.

---

## KeyFrame

O `KeyFrame` define qual ação será executada em cada intervalo de tempo.

Exemplo:

```java
new KeyFrame(
    Duration.seconds(1),
    e -> atualizarRelogio()
);
```

---

## Duration

A classe `Duration` define o intervalo entre as atualizações.

Neste projeto foi utilizado:

```java
Duration.seconds(1)
```

permitindo que o relógio seja atualizado a cada segundo.

---

# Funcionalidades

- Exibição da hora atual do sistema
- Atualização automática em tempo real
- Exibição de horas, minutos e segundos
- Interface gráfica utilizando JavaFX
- Formatação personalizada da hora

---

# Estrutura Utilizada Neste Projeto

Por se tratar de um projeto de estudos, toda a aplicação foi implementada em um único arquivo Java.

Estrutura atual:

```text
RelogioDigital.java
```

Essa abordagem facilita a visualização dos conceitos fundamentais envolvidos no funcionamento do JavaFX e da API de datas do Java.

---

# Como Isso Seria Feito em um Projeto Profissional?

Em aplicações profissionais a organização costuma ser diferente.

A lógica da aplicação, a interface gráfica e os recursos visuais normalmente são separados em arquivos específicos para facilitar manutenção, escalabilidade e testes. Apesar de que nesse caso em especifico, por ser uma ferramenta simples, não há a necessidade disso.

Exemplo:

```text
src
├── main
│   ├── java
│   │   ├── Main.java
│   │   ├── controller
│   │   │   └── RelogioController.java
│   │   ├── service
│   │   │   └── RelogioService.java
│   │   └── model (se necessário)
│   │       └── ...
│   │
│   └── resources
│       └── relogio.fxml
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

# Maven e Gradle

Neste projeto o JavaFX foi utilizado de forma simples para fins educacionais.

Em ambientes profissionais é comum utilizar ferramentas de automação e gerenciamento de dependências como:

- Maven
- Gradle

Essas ferramentas permitem:

- Gerenciamento automático de bibliotecas
- Controle de versões das dependências
- Automatização de builds
- Execução de testes
- Empacotamento da aplicação
- Integração contínua (CI/CD)

---

# Conhecimentos Praticados

Este projeto permitiu praticar:

- Desenvolvimento de interfaces gráficas com JavaFX
- Manipulação de data e hora com a API moderna do Java
- Formatação de datas utilizando `DateTimeFormatter`
- Atualização periódica da interface utilizando `Timeline`
- Eventos e expressões Lambda
- Organização de layouts
- Programação Orientada a Objetos