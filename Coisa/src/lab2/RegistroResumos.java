package lab2;


/** Armazena e gerencia resumos de temas e conteudos variados.
 * @author Matheus Sampaio Lacerda de Almeida
 */
public class RegistroResumos {
    private Resumo[] resumos;
    private int quantidade;
    private int proximaPosicao;

    public class Resumo {
        private String tema;
        private String conteudo;

        public Resumo(String tema, String conteudo) {
            this.tema = tema;
            this.conteudo = conteudo;
        }

        public String getTema(){
            return this.tema;
        }
        public String getConteudo(){
            return conteudo;
        }

        public String toString(){
            return this.tema + ": " + this.conteudo;
        }
    }

    public RegistroResumos(int numeroDeResumos){
        this.resumos = new Resumo[numeroDeResumos];
        this.quantidade = 0;
        this.proximaPosicao = 0;
    }

    public void adiciona(String tema, String conteudo){
        for(Resumo t: this.resumos) {
            if (t != null && t.getTema().equals(tema)) {
                return;
            }
        }

        resumos[proximaPosicao] = new Resumo(tema, conteudo);
        proximaPosicao = (proximaPosicao + 1) % resumos.length;

        if (quantidade < resumos.length) {
            quantidade++;
        }
    }

    public String[] pegaResumos() {
        String[] resultado = new String[quantidade];

        for (int i = 0; i < quantidade; i++) {
            resultado[i] = resumos[i].toString();
        }

        return resultado;
    }

    public String imprimeResumos(){
        String imprimeresumo = "";
        for (int i = 0; i < quantidade - 1; i++) {
            imprimeresumo += resumos[i].getTema() + " | ";
        }
        imprimeresumo += resumos[quantidade-1].getTema();
        return "- "+quantidade + " resumo(s) cadastrado(s)"+ "\n" +
                "- " + imprimeresumo;
    }
    
    public boolean temResumo(String tema) {
        for (Resumo t : this.resumos) {
            if (t != null && t.getTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }
    public int conta(){
        return quantidade;
    }

    public String[] busca(String chaveDeBusca){

    }
}
