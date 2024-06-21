package dominio;

import dominio.enums.TipoTransacao;

import java.time.LocalDate;

class ContaPoupanca extends ContaBancaria{

    private static int SEQUENCIA_CP=20000;
    private double rendimento;


    public ContaPoupanca(Correntista correntista) {
        super(correntista);
        this.numero=++SEQUENCIA_CP;
        this.rendimento=0;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public void aplicarRendimento(double rendimento){
        setRendimento(rendimento);
        double rendimentoLiquido=super.getSaldo()*(1+rendimento/100)-super.getSaldo();
        super.depositar(rendimentoLiquido,true);
        super.getTransacoes().add(new Transacao(TipoTransacao.RENDIMENTO,rendimentoLiquido, LocalDate.now()));
    }

    @Override
    public String toString() {
        return "\nContaPoupança\n" +
                "Agencia: " + agencia +
                " N°: " + numero +
                "\nCorrentista:" + correntista.getNome()+"\n";
    }
}
