//Comentário Inicial: Muito bom o código, não tenho muito a acrescentar, comentários apenas pelo pedido da questão

package lab2;

public class Descanso {
    private int horasDeDescanso;
    private int numerosDeSemanas;
    public Descanso() { // Construtor de 2 variaveis
        this.horasDeDescanso = 0;
        this.numerosDeSemanas = 0;
    }

    public void defineHorasDescanso(int horasDeDescanso) { // Bem nomeado
        this.horasDeDescanso = horasDeDescanso;
    }

    public void defineNumeroSemanas(int numerosDeSemanas) {
        this.numerosDeSemanas = numerosDeSemanas;
    }

    public String getStatusGeral() { // Metodo que retorna o estado do aluno, sendo "descansado" ou "cansado" saídas válidas
        if (numerosDeSemanas == 0) {
            return "cansado";
        }
        if (horasDeDescanso/numerosDeSemanas >= 26) {
            return "descansado";
        } else {
            return "cansado";
        }
    }
}

