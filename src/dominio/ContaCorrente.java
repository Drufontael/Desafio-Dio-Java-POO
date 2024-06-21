package dominio;

class ContaCorrente extends ContaBancaria{
    private static int SEQUENCIA_CC=10000;


    public ContaCorrente(Correntista correntista) {
        super(correntista);
        this.numero=++SEQUENCIA_CC;
    }

    @Override
    public String toString() {
        return "\nContaCorrente\n" +
                "Agencia: " + agencia +
                " N°: " + numero +
                "\nCorrentista:" + correntista.getNome()+"\n";
    }
}
