public class RegistroResumos {

    private String[] temas;
    private String[] conteudos;
    private int quantidade;
    private int proximaPosicao;

    public RegistroResumos(int numeroDeResumos){
        this.temas = new String[numeroDeResumos];
        this.conteudos = new String[numeroDeResumos];
        this.quantidade = 0;
        this.proximaPosicao = 0;
    }

    public void adicionaResumo(String tema, String conteudo){
        for(int i = 0; i < quantidade; i++) {
            if (temas[i].equals(tema)) {
                conteudos[i] = conteudo;
                return;
            }
        }

        temas[proximaPosicao] = tema;
        conteudos[proximaPosicao] = conteudo;
        proximaPosicao = (proximaPosicao + 1) % temas.lenght;

        if (quantidade < temas.lenght) {
            quantidade++;
        }
    }

    public String[] pegaResumos() {
        String[] resumos = new String[quantidade];
        for (int = i; i < quantidade; i++) {
            resumos[i] = temas[i] + ": " + conteudos[i];
        }
        return resumos;
    }

    public String imprimeResumos(){
        StringBuilder sb = new StringBuilder();
        sb.append(quantidade).append(" resumo(s) cadastrado(s)\n");
        for (int i = 0; i < quantidade; i++) {
            sb.append(temas[i]);
            if (i < quantidade - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
    
    public int contaResumos(){
        return quantidade;
    }
}
