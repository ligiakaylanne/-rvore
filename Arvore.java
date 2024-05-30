public class Arvore<T extends Comparable<T>> {
    private Elemento<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public Arvore(T valor) {
        this.raiz = new Elemento<>(valor);
    }

    public Elemento<T> getRaiz() {
        return raiz;
    }

    public void adicionar(T valor) {
        raiz = adicionarRecursivo(raiz, valor);
    }

    private Elemento<T> adicionarRecursivo(Elemento<T> atual, T valor) {
        if (atual == null) {
            return new Elemento<>(valor);
        }

        if (valor.compareTo(atual.getValor()) < 0) {
            atual.setEsquerda(adicionarRecursivo(atual.getEsquerda(), valor));
        } else if (valor.compareTo(atual.getValor()) > 0) {
            atual.setDireita(adicionarRecursivo(atual.getDireita(), valor));
        }

        return atual;
    }

    public void remover(T valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private Elemento<T> removerRecursivo(Elemento<T> atual, T valor) {
        if (atual == null) {
            return null;
        }

        if (valor.equals(atual.getValor())) {
            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                return null;
            }

            if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }

            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            }

            T menorValor = encontrarMenorValor(atual.getDireita());
            atual.setValor(menorValor);
            atual.setDireita(removerRecursivo(atual.getDireita(), menorValor));
            return atual;
        }

        if (valor.compareTo(atual.getValor()) < 0) {
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), valor));
        } else {
            atual.setDireita(removerRecursivo(atual.getDireita(), valor));
        }

        return atual;
    }

    private T encontrarMenorValor(Elemento<T> raiz) {
        return raiz.getEsquerda() == null ? raiz.getValor() : encontrarMenorValor(raiz.getEsquerda());
    }

    public Elemento<T> pesquisar(T valor) {
        return pesquisarRecursivo(raiz, valor);
    }

    private Elemento<T> pesquisarRecursivo(Elemento<T> atual, T valor) {
        if (atual == null || valor.equals(atual.getValor())) {
            return atual;
        }

        if (valor.compareTo(atual.getValor()) < 0) {
            return pesquisarRecursivo(atual.getEsquerda(), valor);
        } else {
            return pesquisarRecursivo(atual.getDireita(), valor);
        }
    }

    public void esvaziar() {
        raiz = null;
    }

    public void exibir(Elemento<T> atual, String tipo) {
        if (atual != null) {
            switch (tipo) {
                case "preordem":
                    System.out.println(atual.getValor());
                    exibir(atual.getEsquerda(), tipo);
                    exibir(atual.getDireita(), tipo);
                    break;
                case "inordem":
                    exibir(atual.getEsquerda(), tipo);
                    System.out.println(atual.getValor());
                    exibir(atual.getDireita(), tipo);
                    break;
                case "posordem":
                    exibir(atual.getEsquerda(), tipo);
                    exibir(atual.getDireita(), tipo);
                    System.out.println(atual.getValor());
                    break;
            }
        }
    }
}

class Elemento<T> {
    private T valor;
    private Elemento<T> esquerda;
    private Elemento<T> direita;

    public Elemento(T valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Elemento<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Elemento<T> esquerda) {
        this.esquerda = esquerda;
    }

    public Elemento<T> getDireita() {
        return direita;
    }

    public void setDireita(Elemento<T> direita) {
        this.direita = direita;
    }
}
