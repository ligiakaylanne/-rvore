import java.util.ArrayList;
import java.util.List;

class Arvore<T extends Comparable<T>> {
    private Elemento<T> raiz;

    public Elemento<T> getRaiz() {
        return raiz;
    }

    public void adicionar(T valor) {
        if (raiz == null) {
            raiz = new Elemento<>(valor);
        } else {
            raiz.adicionar(valor);
        }
    }

    public void remover(T valor, Elemento<T> elemento) {
        // Implementação da remoção
    }

    public Elemento<T> pesquisar(T valor) {
        if (raiz != null) {
            return raiz.pesquisar(valor);
        }
        return null;
    }

    public void esvaziar() {
        raiz = null;
    }

    public void exibir(Elemento<T> elemento, String tipo) {
        List<T> elementos = new ArrayList<>();
        switch (tipo) {
            case "inordem":
                inOrdem(elemento, elementos);
                break;
            case "preordem":
                preOrdem(elemento, elementos);
                break;
            case "posordem":
                posOrdem(elemento, elementos);
                break;
            default:
                System.out.println("Tipo de exibição inválido.");
                return;
        }
        for (T e : elementos) {
            System.out.println(e);
        }
    }

    private void inOrdem(Elemento<T> elemento, List<T> elementos) {
        if (elemento != null) {
            inOrdem(elemento.getEsquerda(), elementos);
            elementos.add(elemento.getValor());
            inOrdem(elemento.getDireita(), elementos);
        }
    }

    private void preOrdem(Elemento<T> elemento, List<T> elementos) {
        if (elemento != null) {
            elementos.add(elemento.getValor());
            preOrdem(elemento.getEsquerda(), elementos);
            preOrdem(elemento.getDireita(), elementos);
        }
    }

    private void posOrdem(Elemento<T> elemento, List<T> elementos) {
        if (elemento != null) {
            posOrdem(elemento.getEsquerda(), elementos);
            posOrdem(elemento.getDireita(), elementos);
            elementos.add(elemento.getValor());
        }
    }
}
