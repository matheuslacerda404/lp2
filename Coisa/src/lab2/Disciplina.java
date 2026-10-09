package lab2;

import java.util.Arrays;
/** 
 * Classe criada para implementar uma disciplina, cada disciplina tem um nome, as horas de estudo atribuidas a ela,
 * as notas que o aluno tirou nas provas dessa disciplina e a media final dela.
 * @author Matheus Sampaio Lacerda de Almeida
 */
public class Disciplina {
    private static final int QTD_NOTAS = 4;
    private static final double MEDIA_FINAL = 7.0;

    private final String nomeDisciplina; // nome da disciplina que será implementada.
    private int horasDeEstudo; // horas que o estudante estudou determinada disciplina, começando sempre igual a 0.
    private final double[] notas; // array que armazena as notas tiradas pelo aluno nas 4 provas da disciplina.

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

    public void cadastraHoras(int horas) { //adiciona horas no tempo de estudo do aluno.
        this.horasDeEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota) { //cadastra a nota que o aluno tirou em uma das 4 provas realizadas, podendo serem alteradas depois.
        if(nota < 1 || nota > QTD_NOTAS) {
             throw new IllegalArgumentException("Nota inválida: use 1, 2, 3 ou 4."); // Retorno para caso de entrada inválida
        }
        this.notas[nota - 1] = valorNota; // Atribui uma nota ao Array notas
    }

    public boolean aprovado() { //retorna "true" se o aluno for aprovado com media >= 7 ou "false" se tiver media menor que 7.
        return calculaMedia() >= MEDIA_FINAL;
    }
    
    private double calculaMedia() { //atributo responsavel por calcular a media final do aluno.
        double soma = 0;
        for (double n : notas) {
            soma += n;
        }
        return soma / QTD_NOTAS;
    }


    @Override
    public String toString() { //retorna a representação escrita do objeto Disciplina
        return this.nomeDisciplina + " " + this.horasDeEstudo + " "
                + calculaMedia() + " " + Arrays.toString(this.notas);
    }
}
