//Comentário Inicial: Muito bom o código, não tenho muito a acrescentar, comentários apenas pelo pedido da questão

package lab2;

/** Classe criada para identificar se um aluno está descansado ou não, com base na pré-definição de que um
 * aluno só esta descansado se tiver 26 horas de descanso semanais
 */

public class Descanso {
    private int horasDeDescanso;
    private int numerosDeSemanas;
    public Descanso() { // Construtor de 2 variaveis
        this.horasDeDescanso = 0;
        this.numerosDeSemanas = 0;
    }

    //Atributo criado para definir as horas de descanso tidos por um determinado aluno em uma quantidade de semanas x
    public void defineHorasDescanso(int horasDeDescanso) { // Bem nomeado
        this.horasDeDescanso = horasDeDescanso;
    }
    //Atributo criado para definir o numero de semanas que foram contabilizadas as horas de descanso do aluno
    public void defineNumeroSemanas(int numerosDeSemanas) {
        this.numerosDeSemanas = numerosDeSemanas;
    }
    // Metodo que retorna o estado do aluno, sendo "descansado" ou "cansado" saídas válidas
    public String getStatusGeral() {
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

