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

