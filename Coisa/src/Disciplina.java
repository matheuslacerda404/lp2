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
             throw new IllegalArgumentException("Nota inválida: use 1, 2, 3 ou 4.");
        }
        this.notas[nota - 1] = valorNota;
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
