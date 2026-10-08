package lab2;

/**
 * @author Matheus Sampaio Lacerda de Almeida
 */
public class RegistroTempoOnline {
    private final String nomeDisciplina;
    private int tempoOnlineUsado;
    private final int tempoOnlineEsperado;

    public RegistroTempoOnline(String nomeDisciplina) { // Construtor de 3 variaveis, recebendo um argumento e retornando 2 outros 2 com pedido no comando
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineUsado = 0;
        this.tempoOnlineEsperado = 120;
    }

    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) { // Contrutor de 3 variaveis,agora recebendo 2 argumentos, também como pedido no comando
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineUsado = 0;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    public void adicionaTempoOnline(int tempoOnline) {
        this.tempoOnlineUsado += tempoOnline;
    }

    public boolean atingiuMetaTempoOnline() {
        return this.tempoOnlineUsado >= this.tempoOnlineEsperado;
    }
    
    @Override
    public String toString() {
        return nomeDisciplina + " " + tempoOnlineUsado + "/" + tempoOnlineEsperado;
    }
}
