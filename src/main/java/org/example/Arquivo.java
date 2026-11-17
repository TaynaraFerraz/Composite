package org.example;

public class Arquivo extends Item {

    private int tamanhoKb;

    public Arquivo(String nome, int tamanhoKb) {
        super(nome);
        this.tamanhoKb = tamanhoKb;
    }

    public int getTamanhoKb() {
        return tamanhoKb;
    }

    public void setTamanhoKb(int tamanhoKb) {
        this.tamanhoKb = tamanhoKb;
    }

    public String getDetalhes() {
        return "Arquivo: " + this.getNome() + " - tamanho: " + this.tamanhoKb + " KB\n";
    }

}
