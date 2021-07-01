package br.com.zupacademy.rodrigo.transacao.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> listar(@PathVariable  String id){
        Sort sort =Sort.by(Sort.Direction.DESC, "efetivadaEm");
        PageRequest pageRequest = PageRequest.of(0,10,sort);
        Page<Transacao> transacoes = this.transacaoRepository.findByCartaoId(id,pageRequest);

        if(transacoes.getNumberOfElements() == 0){
            return ResponseEntity.notFound().build();
        }

        Page<TransacaoResponse> transacaoResponses = transacoes.map(e -> new TransacaoResponse(e));
        return ResponseEntity.ok().body(transacaoResponses);
    }
}
