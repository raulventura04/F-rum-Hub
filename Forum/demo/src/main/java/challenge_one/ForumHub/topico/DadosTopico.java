package challenge_one.ForumHub.topico;

public record DadosTopico(Long id, String titulo, String mensagem, Long autorId) {
    public DadosTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getAutor().getId());
    }
}