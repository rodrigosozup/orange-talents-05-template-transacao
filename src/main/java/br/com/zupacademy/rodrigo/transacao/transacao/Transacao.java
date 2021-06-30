package br.com.zupacademy.rodrigo.transacao.transacao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
public class Transacao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @NotNull
    @Positive
    private BigDecimal valor;
    @NotNull
    private LocalDateTime efetivadaEm;
    @OneToOne(cascade = CascadeType.ALL)
    private Estabelecimento estabelecimento;
    @OneToOne(cascade = CascadeType.ALL)
    private Cartao cartao;

    public Transacao(String id, BigDecimal valor,LocalDateTime efetivadaEm, Estabelecimento estabelecimento, Cartao cartao) {
        this.id = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    public Transacao(){

    }
    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }
}
