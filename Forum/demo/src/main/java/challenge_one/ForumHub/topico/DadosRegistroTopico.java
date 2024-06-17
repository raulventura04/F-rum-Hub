package challenge_one.ForumHub.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensagem) {
}