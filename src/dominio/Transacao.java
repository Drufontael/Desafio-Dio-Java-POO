package dominio;

import dominio.enums.TipoTransacao;

import java.time.LocalDate;

public class Transacao {
    private TipoTransacao tipoTransacao;
    private double valor;
    private LocalDate data;
    private ContaBancaria origem;
    private ContaBancaria destino;

    public Transacao() {
    }

    public Transacao(TipoTransacao tipoTransacao, double valor, LocalDate data) {
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.data = data;
    }

    public Transacao(TipoTransacao tipoTransacao, double valor, LocalDate data, ContaBancaria origem, ContaBancaria destino) {
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.data = data;
        this.origem = origem;
        this.destino = destino;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public ContaBancaria getOrigem() {
        return origem;
    }

    public ContaBancaria getDestino() {
        return destino;
    }

    @Override
    public String toString() {
        return tipoTransacao.getDescricao() + String.format("\tR$ %.2f",valor)+
                "\tdata: " + data +
                "\n";
    }
}
