package lab2;

import java.util.Arrays;
/** 
 * Classe criada para implementar uma disciplina, cada disciplina tem um nome, as horas de estudo atribuidas a ela,
 * as notas que o aluno tirou nas provas dessa disciplina e a media final dela.
 * @author Matheus Sampaio Lacerda de Almeida
 */
public class Disciplina {
    private static final int QTD_NOTAS = 4; // quantidade de notas que serão registradas, sendo sempre 4.
    private static final double MEDIA_FINAL = 7.0; // media final que o aluno precisa para ser aprovado na disciplina.

    private final String nomeDisciplina; // nome da disciplina que será implementada.
    private int horasDeEstudo; // horas que o estudante estudou determinada disciplina, começando sempre igual a 0.
    private final double[] notas; // array que armazena as notas tiradas pelo aluno nas 4 provas da disciplina.
    private int[] pesos;

    /** Construtor do objeto disciplina, que determina 3 variaveis.
    * @param nomeDisciplina o nome da disciplina, em string.
    * @param horasDeEstudo as horas de estudo do aluno, inicialmente igual a 0.
    * @param notas array que armazena as notas do aluno, com 4 posições.
    */
    public Disciplina(String nomeDisciplina) { 
        this.nomeDisciplina = nomeDisciplina;
        this.horasDeEstudo = 0;
        this.notas = new double[QTD_NOTAS];
    }

    /**
     * Constrói uma disciplina com um número específico de notas. Com todas as notas tendo o mesmo peso.
     * @param nome o nome da disciplina.
     * @param numeroNotas a quantidade de notas da disciplina.
     */
    public Disciplina(String nome, int numeroNotas) {
        this.nomeDisciplina = nome;
        this.notas = new double[numeroNotas];
        this.pesos = null;
    }

    public void cadastraHoras(int horas) { //adiciona horas no tempo de estudo do aluno.
        this.horasDeEstudo += horas;
    }
    
    /**
     * Constrói uma disciplina com um número específico de notas e pesos para
     * cada uma delas. Se o array de pesos não for passado, todas as notas terão o
     * mesmo peso.
     *
     * @param nome        o nome da disciplina.
     * @param numeroNotas a quantidade de notas da disciplina.
     * @param pesos       os pesos de cada nota (mesmo tamanho que
     *                    numeroNotas), ou null para pesos iguais.
     */
    public Disciplina(String nomeDisciplina, int numeroNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[numeroNotas];
 
        if (pesos == null) {
            this.pesos = new int[numeroNotas];
            Arrays.fill(this.pesos, 1);
        } else {
            this.pesos = Arrays.copyOf(pesos, pesos.length);
        }
    
    }

    public void cadastraNota(int nota, double valorNota) { //cadastra a nota que o aluno tirou em uma das 4 provas realizadas, podendo serem alteradas depois.
        this.notas[nota - 1] = valorNota; // Atribui uma nota ao Array notas
    }

    public boolean aprovado() { //retorna "true" se o aluno for aprovado com media >= 7 ou "false" se tiver media menor que 7.
        return calculaMedia() >= MEDIA_FINAL;
    }
    
    private double calculaMedia() { //atributo responsavel por calcular a media final do aluno.
        double soma = 0;
        int somaPesos = 0;
 
        for (int i = 0; i < this.notas.length; i++) {
            soma += this.notas[i] * this.pesos[i];
            somaPesos += this.pesos[i];
        }
 
        return soma / somaPesos;
    }


    @Override
    public String toString() { //retorna a representação escrita do objeto Disciplina
        return this.nomeDisciplina + " " + this.horasDeEstudo + " "
                + calculaMedia() + " " + Arrays.toString(this.notas);
    }
}
