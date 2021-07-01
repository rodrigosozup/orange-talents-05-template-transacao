package br.com.zupacademy.rodrigo.transacao.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {
    Page<Transacao> findByCartaoId(String id, Pageable pageRequest);
    //List<Transacao> findByCartaoId(String id, Pageable pageRequest);
    List<Transacao> findByCartaoId(String id);
}
