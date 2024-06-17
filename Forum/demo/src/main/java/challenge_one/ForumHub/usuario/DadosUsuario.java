package challenge_one.ForumHub.usuario;

public record DadosUsuario(Long id, String nome, String email) {
    public DadosUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}
