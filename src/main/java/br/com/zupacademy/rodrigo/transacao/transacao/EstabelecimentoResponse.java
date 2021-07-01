package br.com.zupacademy.rodrigo.transacao.transacao;

public class EstabelecimentoResponse {

    private String nome;
    private String cidade;
    private String endereco;

    public  EstabelecimentoResponse(){}

    public  EstabelecimentoResponse(Estabelecimento estabelecimento){
        this.nome = estabelecimento.getNome();
        this.cidade =estabelecimento.getCidade();
        this.endereco =estabelecimento.getEndereco();
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toModel(){
        return  new Estabelecimento(nome, cidade, endereco);
    }
}
