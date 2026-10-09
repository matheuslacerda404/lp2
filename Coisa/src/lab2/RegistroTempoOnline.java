package lab2;

/**
 * Classe que registra o tempo online que um estudante dedica a uma
 * disciplina. Cada registro guarda o nome da disciplina, o tempo online já
 * utilizado e o tempo online esperado como meta(quando não informado no construtor é equivalente a 120 horas).
 *
 * @author Matheus Sampaio Lacerda de Almeida
 */
public class RegistroTempoOnline {
    // Nome da disciplina que o registro se refere.
    private final String nomeDisciplina;

    //Tempo online utilizado na disciplina. Começa sempre em 0.
    private int tempoOnlineUsado;

    //Tempo online esperado para a disciplina.
    private final int tempoOnlineEsperado;

    /**
     * Constrói um registro de tempo online a partir do nome da disciplina.
     * Todo registro começa com o tempo online usado igual a 0 e com o tempo
     * online esperado igual a 120.
     *
     * @param nomeDisciplina o nome da disciplina
     */
    public RegistroTempoOnline(String nomeDisciplina) { // Construtor de 3 variaveis, recebendo um argumento.
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineUsado = 0;
        this.tempoOnlineEsperado = 120;
    }

    /**
     * Constrói um registro de tempo online a partir do nome da disciplina e do
     * tempo online esperado. Todo registro começa com o tempo online usado
     * igual a 0.
     *
     * @param nomeDisciplina      o nome da disciplina
     * @param tempoOnlineEsperado o tempo online esperado para a disciplina
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) { // Contrutor de 3 variaveis,agora recebendo 2 argumentos
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineUsado = 0;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
     * Adiciona o tempo informado ao tempo online já utilizado na disciplina.
     *
     * @param tempoOnline o tempo online a ser adicionado
     */
    public void adicionaTempoOnline(int tempoOnline) {
        this.tempoOnlineUsado += tempoOnline;
    }

    /**
     * Verifica se a meta de tempo online foi atingida. A meta é atingida quando o tempo online usado é maior ou igual ao 
     * tempo online esperado.
     *
     * @return true se a meta foi atingida, false caso contrário.
     */
    public boolean atingiuMetaTempoOnline() {
        return this.tempoOnlineUsado >= this.tempoOnlineEsperado;
    }

    /**
     * Retorna a String que representa o registro. A representação segue o
     * formato "nomeDisciplina  tempoOnlineUsado/tempoOnlineEsperado".
     *
     * @return a representação em String de um registro de tempo online.
     */
    @Override
    public String toString() {
        return nomeDisciplina + " " + tempoOnlineUsado + "/" + tempoOnlineEsperado;
    }
}
