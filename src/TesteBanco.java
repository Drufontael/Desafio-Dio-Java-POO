import dominio.Banco;
import dominio.enums.TipoConta;

public class TesteBanco {
    static Banco BANCO=Banco.iniciarBanco();

    public static void main(String[] args) {
        inicializarDados();

        //Lista contas do correntista com CPF 121
        BANCO.visualizarContas("121");

        //Iniciar sessão na conta 20005
        BANCO.iniciarSecao(20005);

        //Deposito inicial
        BANCO.depositar(10000.0);

        //Transferir para conta 10003
        BANCO.transferir(3000,10003);

        //Sacar
        BANCO.sacar(427.0);

        //Definir rendimento da poupança - aqui deveria ser buscada uma fonte externa
        Banco.RENDIMENTO_POUPANCA=1.12;

        //Atualizando Rendimentos
        BANCO.atualizarRendimentos();

        //Verificando saldo
        BANCO.consultarSaldo();

        //Visualizando movimentação
        BANCO.consultarExtrato();

        //Trocar correntista e fazer mais movimentações
        BANCO.iniciarSecao(10003);
        BANCO.depositar(5200.0);
        BANCO.sacar(2124);
        BANCO.transferir(2450,20001);
        BANCO.depositar(1420);
        BANCO.consultarExtrato();

        BANCO.iniciarSecao(20001);
        BANCO.consultarExtrato();








    }
    public static void inicializarDados(){

        //Criando contas
        BANCO.abrirConta("Marcelo","123", TipoConta.CORRENTE);
        BANCO.abrirConta("Maria","124", TipoConta.POUPANCA);
        BANCO.abrirConta("Carlos","125", TipoConta.CORRENTE);
        BANCO.abrirConta("Joana","126", TipoConta.POUPANCA);
        BANCO.abrirConta("Paula","127", TipoConta.CORRENTE);
        BANCO.abrirConta("Edu","128", TipoConta.POUPANCA);
        BANCO.abrirConta("Pedro","129", TipoConta.CORRENTE);
        BANCO.abrirConta("Luiza","120", TipoConta.POUPANCA);
        BANCO.abrirConta("Andre","121", TipoConta.CORRENTE);
        BANCO.abrirConta("Andre","121", TipoConta.POUPANCA);

        //Mostrar correntistas
        BANCO.listarCorrentistas();

    }
}
