public class Descanso {
    private int horasDeDescanso;
    private int numerosDeSemanas;
    public Descanso(int horasDeDescanso, int numerosDeSemanas) {
        this.horasDeDescanso = horasDeDescanso;
        this.numerosDeSemanas = numerosDeSemanas;
    }

    public void defineHorasDescanso(int horasDeDescanso) {
        this.horasDeDescanso = horasDeDescanso;
    }

    public void defineNumeroSemanas(int numerosDeSemanas) {
        this.numerosDeSemanas = numerosDeSemanas;
    }

    public String getStatusGeral() {
        if (horasDeDescanso/numerosDeSemanas >= 26) {
            return "Você está descansando bem!";
        } else {
            return "Você precisa descansar mais!";
        }
    }
}

