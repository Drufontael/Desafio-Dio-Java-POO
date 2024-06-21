package dominio.enums;

public enum TipoTransacao {
    SAQUE("Saque",Fluxo.SAIDA),
    DEPOSITO("Depósito",Fluxo.ENTRADA),
    TRANSFERENCIA_ENTRADA("Transferência (+)",Fluxo.ENTRADA),
    TRANSFERENCIA_SAIDA("Transferência (-)",Fluxo.SAIDA),
    RENDIMENTO("Rendimento Liquido",Fluxo.ENTRADA),
    TAXA("Taxa administrativa",Fluxo.SAIDA);

    private String descricao;
    private Fluxo fluxo;

    TipoTransacao(String descricao,Fluxo fluxo) {
        this.descricao = descricao;
        this.fluxo=fluxo;
    }



    public String getDescricao() {
        return descricao;
    }

    public Fluxo getFluxo() {
        return fluxo;
    }
}
