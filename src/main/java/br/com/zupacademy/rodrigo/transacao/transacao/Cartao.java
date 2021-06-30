package br.com.zupacademy.rodrigo.transacao.transacao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @NotBlank
    private String email;

    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public Cartao(){

    }
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
