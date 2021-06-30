package br.com.zupacademy.rodrigo.transacao.transacao.listener;

import br.com.zupacademy.rodrigo.transacao.transacao.Transacao;
import br.com.zupacademy.rodrigo.transacao.transacao.TransacaoRepository;
import br.com.zupacademy.rodrigo.transacao.transacao.TransacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class TransacaoListener {

    @Autowired
    private TransacaoRepository transacaoRepository;
    /*@Bean
    JsonMessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }*/

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoResponse transacaoResponse) {
        Transacao transacao = transacaoResponse.toModel();
        transacaoRepository.save(transacao);
    }

}
