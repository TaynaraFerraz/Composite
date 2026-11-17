package org.example;

public class Computador {

    private Item raiz;

    public void setRaiz(Item raiz) {
        this.raiz = raiz;
    }

    public String getEstrutura() {
        if (this.raiz == null) {
            throw new NullPointerException("Computador sem diretório raiz");
        }
        return this.raiz.getDetalhes();
    }
}
