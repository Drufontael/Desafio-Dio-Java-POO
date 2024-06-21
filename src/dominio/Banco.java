package dominio;

import dominio.enums.TipoConta;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private static Banco INSTACE;
    private static final String NOME = "Meu Banco";
    private final List<ContaBancaria> contas=new ArrayList<>();
    public static double RENDIMENTO_POUPANCA;
    public static ContaBancaria CONTA_ATUAL;

    private Banco() {
    }

    public static Banco iniciarBanco(){
        if(INSTACE==null) INSTACE=new Banco();
        return INSTACE;
    }

    private ContaBancaria criarConta(Correntista correntista, TipoConta tipoConta){
        switch (tipoConta){
            case CORRENTE -> {
                return new ContaCorrente(correntista);
            }
            case POUPANCA -> {
                return new ContaPoupanca(correntista);
            }
        }
        return null;
    }

    public void abrirConta(String nomeCorrentista, String cpfCorrentista,TipoConta tipoConta){
        Correntista correntista=verificaCorrentista(nomeCorrentista,cpfCorrentista);
        this.contas.add(criarConta(correntista,tipoConta));
    }

    private Correntista verificaCorrentista(String nomeCorrentista, String cpfCorrentista){
        for (ContaBancaria c:contas){
            if(c.getCorrentista().getCpf().equals(cpfCorrentista)){
                return c.getCorrentista();
            }
        }
        return new Correntista(nomeCorrentista,cpfCorrentista);
    }

    private List<ContaBancaria> listarContas(String cpf){
        return contas.stream().filter(c->c.getCorrentista().getCpf().equals(cpf)).toList();
    }

    public void visualizarContas(String cpf){
        List<ContaBancaria> lista=listarContas(cpf);
        if (lista.size()==0){
            System.out.println("Não existe conta para esse CPF");
        } else if(lista.size()==1){
            System.out.println(lista.get(0));
        }else {
            System.out.println(lista);
        }
    }

    private ContaBancaria localizarConta(int numeroConta){
        for (ContaBancaria contaBancaria:contas) {
            if(contaBancaria.numero==numeroConta) return contaBancaria;
        }
        return null;
    }

    public void iniciarSecao(int numeroConta){
        CONTA_ATUAL=localizarConta(numeroConta);
    }

    public void encerrarSecao(){
        CONTA_ATUAL=null;
    }

    private void aplicarRendimento(ContaBancaria conta){
        if(conta instanceof ContaPoupanca){
            ContaPoupanca poupanca=(ContaPoupanca) conta;
            poupanca.aplicarRendimento(RENDIMENTO_POUPANCA);
        }
    }

    public void atualizarRendimentos(){
        for(ContaBancaria conta:contas){
            aplicarRendimento(conta);
        }
    }

    public void listarCorrentistas(){
        contas.stream().map(ContaBancaria::getCorrentista).distinct().forEach(System.out::println);
    }

    public void depositar(double valor){
        CONTA_ATUAL.depositar(valor);
    }

    public void sacar(double valor){
        CONTA_ATUAL.sacar(valor);
    }

    public void transferir(double valor, int numeroConta){
        ContaBancaria destino=localizarConta(numeroConta);
        CONTA_ATUAL.transferir(valor,destino);
    }

    public void consultarSaldo(){
        System.out.printf("\nSeu saldo é de R$ %.2f",CONTA_ATUAL.getSaldo());
    }

    public void consultarExtrato(){
        CONTA_ATUAL.mostrarExtrato();
    }

}
