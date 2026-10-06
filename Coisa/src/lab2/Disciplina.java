//Comentário Inicial: Muito bom o código, não tenho muito a acrescentar, comentários apenas pelo pedido da questão

package lab2;

import java.util.Arrays;
public class Disciplina {
    private static final int QTD_NOTAS = 4;
    private static final double MEDIA_FINAL = 7.0;

    private final String nomeDisciplina;
    private int horasDeEstudo;
    private final double[] notas;

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasDeEstudo = 0;
        this.notas = new double[QTD_NOTAS];
    }

    public void cadastraHoras(int horas) {
        this.horasDeEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota) {
        if(nota < 1 || nota > QTD_NOTAS) {
             throw new IllegalArgumentException("Nota inválida: use 1, 2, 3 ou 4."); // Retorno para caso de entrada inválida
        }
        this.notas[nota - 1] = valorNota; // Atribui uma nota ao Array notas
    }

    public boolean aprovado() {
        return calculaMedia() >= MEDIA_FINAL;
    }
    
    private double calculaMedia() {
        double soma = 0;
        for (double n : notas) {
            soma += n;
        }
        return soma / QTD_NOTAS;
    }


    @Override
    public String toString() {
        return this.nomeDisciplina + " " + this.horasDeEstudo + " "
                + calculaMedia() + " " + Arrays.toString(this.notas);
    }
}
