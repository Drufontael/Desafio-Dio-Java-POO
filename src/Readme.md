# Sistema de Contas Bancárias

Este repositório foi criado para cumprir um desafio de projeto da DIO (Digital Innovation One), uma empresa de cursos online. O desafio consiste no desenvolvimento de um sistema de contas bancárias utilizando os pilares da Programação Orientada a Objetos (POO).

## Descrição do Projeto

O sistema de contas bancárias desenvolvido possui três entidades principais que fazem parte do domínio do negócio:

1. **Banco**: O Banco possui várias contas bancárias e é responsável por gerenciar as operações de entrada e saída de dados. É a única entidade que enxerga as demais (Correntista e ContaBancaria).

2. **Correntista**: O Correntista é o cliente do banco. Cada Correntista pode ter uma conta de cada tipo (ContaCorrente e ContaPoupança).

3. **ContaBancaria**: A classe ContaBancaria é a classe base para duas sub-classes: ContaCorrente e ContaPoupança. Cada conta bancária está associada a um Correntista.

### Funcionalidades

As operações disponíveis no sistema são:

- **Saque**: Permite ao correntista sacar dinheiro de sua conta.
- **Depósito**: Permite ao correntista depositar dinheiro em sua conta.
- **Transferência**: Permite ao correntista transferir dinheiro de uma conta para outra.
- **Consultar Extrato**: Permite ao correntista consultar o extrato de sua conta, visualizando as transações realizadas.

### Tecnologias Utilizadas

- **Programação Orientada a Objetos (POO)**: O sistema foi desenvolvido utilizando os princípios da POO, como encapsulamento, herança e polimorfismo.
- **Coleções e Streams**: Foram utilizados recursos de Collections e Streams para manipulação e processamento de dados.

## Estrutura do Projeto

A estrutura do projeto é a seguinte:

```
└── src
    ├── TesteBanco.java
    ├── dominio
    │   ├── Banco.java
    │   ├── ContaBancaria.java
    │   ├── ContaCorrente.java
    │   ├── ContaPoupanca.java
    │   ├── Correntista.java
    │   ├── Transacao.java
    │   └── enums
    │       ├── Fluxo.java
    │       ├── TipoConta.java
    │       └── TipoTransacao.java
    └── exception
        └── IrregularTransacaoException.java
```

- **src/TesteBanco.java**: Classe principal para execução do sistema.
- **src/dominio/Banco.java**: Classe que representa o banco e gerencia as operações e contas.
- **src/dominio/ContaBancaria.java**: Classe base para as contas bancárias.
- **src/dominio/ContaCorrente.java**: Sub-classe de ContaBancaria que representa uma conta corrente.
- **src/dominio/ContaPoupanca.java**: Sub-classe de ContaBancaria que representa uma conta poupança.
- **src/dominio/Correntista.java**: Classe que representa o cliente do banco.
- **src/dominio/Transacao.java**: Classe que representa uma transação bancária.
- **src/dominio/enums/Fluxo.java**: Enumeração que define os fluxos de transação.
- **src/dominio/enums/TipoConta.java**: Enumeração que define os tipos de conta (Corrente e Poupança).
- **src/dominio/enums/TipoTransacao.java**: Enumeração que define os tipos de transação (Saque, Depósito, Transferência).
- **src/exception/IrregularTransacaoException.java**: Classe de exceção para tratar transações irregulares.

## Como Executar

Para executar o projeto, siga os seguintes passos:

1. Clone o repositório para sua máquina local.
   ```bash
   git clone https://github.com/Drufontael/Desafio-Dio-Java-POO
   ```

2. Navegue até o diretório do projeto.
   ```bash
   cd Desafio-Dio-Java-POO/src
   ```

3. Compile o projeto.
   ```bash
   javac dominio/*.java dominio/enums/*.java exception/*.java TesteBanco.java
   ```

4. Execute o projeto.
   ```bash
   java TesteBanco
   ```

## Contribuição

Contribuições são bem-vindas! Se você deseja contribuir com este projeto, por favor, abra uma issue ou envie um pull request.



---

Desenvolvido como parte de um desafio de projeto da DIO.