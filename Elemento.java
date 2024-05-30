class Elemento<T extends Comparable<T>> {
    private T valor;
    private Elemento<T> esquerda;
    private Elemento<T> direita;

    public Elemento(T valor) {
        this.valor = valor;
        this.direita = null;
        this.esquerda= null; 
    }

    public T getValor() {
        return valor;
    }

    public Elemento<T> getEsquerda() {
        return esquerda;
    }

    public Elemento<T> getDireita() {
        return direita;
    }

    public void adicionar(T novoValor) {
        if (novoValor.compareTo(valor) < 0) {
            if (esquerda == null) {
                esquerda = new Elemento<>(novoValor);
            } else {
                esquerda.adicionar(novoValor);
            }
        } else {
            if (direita == null) {
                direita = new Elemento<>(novoValor);
            } else {
                direita.adicionar(novoValor);
            }
        }
    }

    public Elemento<T> pesquisar(T valor) {
        if (valor.equals(this.valor)) {
            return this;
        } else if (valor.compareTo(this.valor) < 0) {
            if (esquerda != null) {
                return esquerda.pesquisar(valor);
            }
        } else {
            if (direita != null) {
                return direita.pesquisar(valor);
            }
        }
        return null;
    }
}
