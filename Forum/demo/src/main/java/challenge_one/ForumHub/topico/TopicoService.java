package challenge_one.ForumHub.topico;


import challenge_one.ForumHub.exception.NotFoundException;
import challenge_one.ForumHub.exception.RegisterException;
import challenge_one.ForumHub.usuario.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicoService {
    private final TopicoRepository repository;

    public DadosTopico registrar(DadosRegistroTopico dados, Usuario usuario) {
        if (repository.findByTituloAndMensagem(dados.titulo(), dados.mensagem()).isPresent()) {
            throw new RegisterException("Tópico já está registrado");
        }
        Topico topico = new Topico(dados, usuario);
        return new DadosTopico(repository.save(topico));
    }

    public Page<DadosTopico> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosTopico::new);
    }

    public DadosTopico detalhar(Long id) {
        return new DadosTopico(buscarTopicoPorId(id));
    }

    public DadosTopico atualizar(Long id, DadosAtualizacaoTopico dados) {
        Topico topico = buscarTopicoPorId(id);
        topico.atualizarInformacoes(dados);
        return new DadosTopico(repository.save(topico));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    private Topico buscarTopicoPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Tópico não encontrado"));
    }
}
