package br.com.zupacademy.rodrigo.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private EstabelecimentoResponse estabelecimento;
    private CartaoResponse cartao;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toModel(){
        return  new Transacao(id, valor, efetivadaEm,estabelecimento.toModel(), cartao.toModel());
    }
}
