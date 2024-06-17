package challenge_one.ForumHub.usuario;



import challenge_one.ForumHub.exception.RegisterException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public DadosUsuario registrar(DadosRegistroUsuario dados) {
        if (repository.findByEmail(dados.email()).isPresent()) {
            throw new RegisterException("Email já está em uso");
        }

        Usuario usuario = new Usuario(dados, encoder.encode(dados.password()));
        return new DadosUsuario(repository.save(usuario));
    }
}
