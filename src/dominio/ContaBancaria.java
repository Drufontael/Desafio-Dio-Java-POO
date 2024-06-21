package dominio;

import dominio.enums.TipoTransacao;
import exception.IrregularTransacaoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class ContaBancaria {

    protected static final int AGENCIA_DIGITAL=1;

    protected int agencia;
    protected int numero;
    protected Correntista correntista;
    private  double saldo;
    private List<Transacao> transacoes=new ArrayList<>();

    public ContaBancaria(Correntista correntista){
        this.saldo=0;
        this.agencia=AGENCIA_DIGITAL;
        this.correntista=correntista;
    }





    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public Correntista getCorrentista() {
        return correntista;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void sacar(double saque) throws IrregularTransacaoException{
        sacar(saque,false);
    }
    protected void sacar(double saque,boolean eTransferencia) throws IrregularTransacaoException{
        if(saque>this.saldo) throw new IrregularTransacaoException("Saldo insuficiente");
        this.saldo-=saque;
        if(!eTransferencia) transacoes.add(new Transacao(TipoTransacao.SAQUE,saque, LocalDate.now()));
    }

    public void depositar(double deposito){
        depositar(deposito,false);
    }
    protected void depositar(double deposito,boolean eTransferencia){
        this.saldo+=deposito;
        if(!eTransferencia) transacoes.add(new Transacao(TipoTransacao.DEPOSITO,deposito, LocalDate.now()));
    }

    public void transferir (Double valor, ContaBancaria contaDestino) throws IrregularTransacaoException{
        sacar(valor,true);
        transacoes.add(new Transacao(TipoTransacao.TRANSFERENCIA_SAIDA,valor,LocalDate.now(),this,contaDestino));
        contaDestino.depositar(valor,true);
        contaDestino.getTransacoes().add(new Transacao(TipoTransacao.TRANSFERENCIA_ENTRADA,valor,LocalDate.now(),this,contaDestino));

    }

    public void mostrarExtrato(){
        System.out.println("\n"+this);
        getTransacoes().forEach(System.out::println);
        System.out.printf("\nSaldo: R$ %.2f",getSaldo());
    }

    //public void mostrarExtrato()


    @Override
    public String toString() {
        return "ContaBancaria{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", correntista=" + correntista.getNome() +
                '}';
    }
}
