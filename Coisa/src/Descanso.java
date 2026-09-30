public class Descanso {
    private int horasDeDescanso;
    private int numerosDeSemanas;
    public Descanso() {
        this.horasDeDescanso = 0;
        this.numerosDeSemanas = 0;
    }

    public void defineHorasDescanso(int horasDeDescanso) {
        this.horasDeDescanso = horasDeDescanso;
    }

    public void defineNumeroSemanas(int numerosDeSemanas) {
        this.numerosDeSemanas = numerosDeSemanas;
    }

    public String getStatusGeral() {
        if (horasDeDescanso/numerosDeSemanas <= 26 || numerosDeSemanas == 0 || horasDeDescanso == 0) {
            return "cansado";
        } else {
            return "descansado";
        }
    }
}

