class Aluno implements Comparable<Aluno> {
    private String rgm;
    private String nome;

    public Aluno(String rgm, String nome) {
        this.rgm = rgm;
        this.nome = nome;
    }

    public String getRgm() {
        return rgm;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int compareTo(Aluno outro) {
        return this.rgm.compareTo(outro.rgm);
    }

    @Override
    public String toString() {
        return "RGM: " + rgm + ", Nome: " + nome;
    }
}
