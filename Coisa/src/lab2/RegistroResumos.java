package lab2;


/** Classe que registra resumos com uma quantidade fixa(numeroDeResumos), sendo esses resumos identificados pelos seus    
 * temas, e quando são colocados resumos até o limite do array, o primeiro resumo sera colocado pelo próximo.
 * 
 * @author Matheus Sampaio Lacerda de Almeida
 */
public class RegistroResumos {
    // atributo que armazena os resumos em um array da minha classe Resumo.
    private final Resumo[] resumos;

    // quantidade de resumos cadastrados.
    private int quantidade;

    // posição onde o próximo resumo será armazenado. Volta para o início quando chega ao fim do array.
    private int proximaPosicao;

    // representação de um resumo de estudo. os resumos possuem um tema e um conteúdo.
    public class Resumo {
        // tema do resumo, usado para identificá-lo no registro.
        private final  String tema;

        // conteúdo do resumo, com o texto sobre o tema.
        private final String conteudo;

        /**
         * cria um resumo a partir de seu tema e conteúdo.
         *
         * @param tema     o tema do resumo
         * @param conteudo o conteúdo do resumo
         */
        public Resumo(String tema, String conteudo) {
            this.tema = tema;
            this.conteudo = conteudo;
        }

        /**
         * retorna o tema do resumo.
         *
         * @return o tema do resumo.
         */
        public String getTema(){
            return this.tema;
        }

        /**
         * retorna o conteúdo do resumo.
         *
         * @return o conteúdo do resumo.
         */
        public String getConteudo(){
            return conteudo;
        }

        /**
         * retorna a String que representa o resumo. Sendo essa representação no formato "tema: conteudo".
         *
         * @return a representação em String de um resumo.
         */
        @Override
        public String toString(){
            return this.tema + ": " + this.conteudo;
        }
    }

    /**
     * constrói um registro de resumos com a capacidade informada. Começando sempre sem nenhuma resumo cadastrado.
     *
     * @param numeroDeResumos a capacidade máxima de resumos do registro
     */
    public RegistroResumos(int numeroDeResumos){
        this.resumos = new Resumo[numeroDeResumos];
        this.quantidade = 0;
        this.proximaPosicao = 0;
    }

    /**
     * adiciona um resumo ao registro. Se já existir um resumo com o mesmo tema,
     * não altera nada. Se o registro estiver cheio, o resumo mais antigo é
     * substituido pelo novo.
     *
     * @param tema     o tema do resumo
     * @param conteudo o conteúdo do resumo
     */
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

    /**
     * retorna as representações em String de todos os resumos cadastrados. Sendo essa representação no formato 
     * tema: conteudo".
     *
     * @return um array com a representação em String de todos os resumos registrados.
     */
    public String[] pegaResumos() {
        String[] resultado = new String[quantidade];

        for (int i = 0; i < quantidade; i++) {
            resultado[i] = resumos[i].toString();
        }

        return resultado;
    }

    /**
     * retorna uma String com a quantidade de resumos cadastrados e a lista de
     * seus temas. Sendo essa representação no formato "- x resumo(s) cadastrado(s)"
     * e na proxima linha,a listagem dos temas desses resumos, no formato  "- tema1 | tema2 | ...".
     *
     * @return a representação em String dos resumos cadastrados.
     */
    public String imprimeResumos(){
        String imprimeresumo = "";
        for (int i = 0; i < quantidade - 1; i++) {
            imprimeresumo += resumos[i].getTema() + " | ";
        }
        imprimeresumo += resumos[quantidade-1].getTema();
        return "- "+quantidade + " resumo(s) cadastrado(s)"+ "\n" +
                "- " + imprimeresumo;
    }

    /**
     * verifica se existe um resumo no registro com determinado tema.
     *
     * @param tema o tema a ser procurado
     * @return true se existe um resumo com o tema informado, false caso
     *         contrário.
     */
    public boolean temResumo(String tema) {
        for (Resumo t : this.resumos) {
            if (t != null && t.getTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }

    /**
     * retorna a quantidade de resumos cadastrados no registro.
     *
     * @return a quantidade de resumos cadastrados.
     */
    public int conta(){
        return quantidade;
    }

    /**
     * procura nos conteudo dos resumos a chave de busca, retornando em um array os temas que possuem essa chave.
     *
     * @param chaveDeBusca o texto procurado nos conteudos dos resumos.
     * @return um array que retorna em string os temas que os seus conteúdos possuem a chave de busca.
     */
    public String[] busca(String chaveDeBusca){
        int total = 0;
        for (int i = 0; i < quantidade; i++) {
            if (resumos[i].getConteudo().toLowerCase().contains(chaveDeBusca.toLowerCase())) {
                total++;
            }
        }

        String[] resultado = new String[total];
        int posicao = 0;
        for (int i = 0; i < quantidade; i++) {
            if (resumos[i].getConteudo().toLowerCase().contains(chaveDeBusca.toLowerCase())) {
                resultado[posicao] = resumos[i].getTema();
                posicao++;
            }
        }

        return resultado;
    }

}

