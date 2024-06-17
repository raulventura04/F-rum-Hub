package challenge_one.ForumHub.controller;

import challenge_one.ForumHub.topico.DadosAtualizacaoTopico;
import challenge_one.ForumHub.topico.DadosRegistroTopico;
import challenge_one.ForumHub.topico.DadosTopico;
import challenge_one.ForumHub.topico.TopicoService;
import challenge_one.ForumHub.usuario.Usuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor
public class TopicoController {
    private final TopicoService topicoService;

    /**
     * Endpoint para registrar um novo tópico.
     * @param dados Dados do tópico a ser registrado.
     * @param usuario Usuário autenticado que está criando o tópico.
     * @return Resposta com os dados do novo tópico registrado.
     */
    @PostMapping
    public ResponseEntity<DadosTopico> registrar(@RequestBody @Valid DadosRegistroTopico dados, @AuthenticationPrincipal Usuario usuario) {
        DadosTopico novoTopico = topicoService.registrar(dados, usuario);
        return ResponseEntity.ok(novoTopico);
    }

    /**
     * Endpoint para listar todos os tópicos com paginação.
     * @param paginacao Informações de paginação.
     * @return Página com a lista de tópicos.
     */
    @GetMapping
    public ResponseEntity<Page<DadosTopico>> listar(Pageable paginacao) {
        Page<DadosTopico> topicos = topicoService.listar(paginacao);
        return ResponseEntity.ok(topicos);
    }

    /**
     * Endpoint para obter detalhes de um tópico específico.
     * @param id ID do tópico.
     * @return Dados detalhados do tópico.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DadosTopico> detalhar(@PathVariable Long id) {
        DadosTopico topico = topicoService.detalhar(id);
        return ResponseEntity.ok(topico);
    }

    /**
     * Endpoint para atualizar um tópico existente.
     * @param id ID do tópico a ser atualizado.
     * @param dados Dados atualizados do tópico.
     * @return Dados do tópico atualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<DadosTopico> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        DadosTopico topicoAtualizado = topicoService.atualizar(id, dados);
        return ResponseEntity.ok(topicoAtualizado);
    }

    /**
     * Endpoint para excluir um tópico.
     * @param id ID do tópico a ser excluído.
     * @return Resposta sem conteúdo.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        topicoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
