package challenge_one.ForumHub.controller;


import challenge_one.ForumHub.usuario.DadosRegistroUsuario;
import challenge_one.ForumHub.usuario.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    /**
     * Endpoint para registrar um novo usuário.
     * @param dados Dados de registro do usuário.
     * @return Resposta com o status e os dados do usuário registrado.
     */
    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody @Valid DadosRegistroUsuario dados) {
        try {
            return ResponseEntity.ok(usuarioService.registrar(dados));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
