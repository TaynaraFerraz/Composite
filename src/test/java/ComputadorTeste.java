import org.example.Arquivo;
import org.example.Computador;
import org.example.Pasta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ComputadorTeste {

    @Test
    void deveRetornarEstruturaComputador() {
        Pasta documentos = new Pasta("Documentos");
        Arquivo curriculo = new Arquivo("curriculo.pdf", 250);
        Arquivo trabalho = new Arquivo("trabalho.docx", 480);
        documentos.addItem(curriculo);
        documentos.addItem(trabalho);

        Pasta faculdade = new Pasta("Faculdade");
        Arquivo planilha = new Arquivo("notas.xlsx", 90);
        faculdade.addItem(planilha);

        Pasta imagens = new Pasta("Imagens");
        Arquivo foto = new Arquivo("foto.png", 1200);
        imagens.addItem(foto);

        Pasta raiz = new Pasta("Meus Arquivos");
        raiz.addItem(documentos);
        raiz.addItem(faculdade);
        raiz.addItem(imagens);

        Computador computador = new Computador();
        computador.setRaiz(raiz);

        assertEquals("Pasta: Meus Arquivos\n" +
                "Pasta: Documentos\n" +
                "Arquivo: curriculo.pdf - tamanho: 250 KB\n" +
                "Arquivo: trabalho.docx - tamanho: 480 KB\n" +
                "Pasta: Faculdade\n" +
                "Arquivo: notas.xlsx - tamanho: 90 KB\n" +
                "Pasta: Imagens\n" +
                "Arquivo: foto.png - tamanho: 1200 KB\n", computador.getEstrutura());
    }

    @Test
    void deveRetornarEstruturaComPastaVazia() {
        Pasta vazia = new Pasta("Downloads");

        Pasta raiz = new Pasta("Meus Arquivos");
        raiz.addItem(vazia);

        Computador computador = new Computador();
        computador.setRaiz(raiz);

        assertEquals("Pasta: Meus Arquivos\n" +
                "Pasta: Downloads\n", computador.getEstrutura());
    }

    @Test
    void deveRetornarEstruturaComArquivoComoRaiz() {
        Arquivo arquivo = new Arquivo("readme.txt", 5);

        Computador computador = new Computador();
        computador.setRaiz(arquivo);

        assertEquals("Arquivo: readme.txt - tamanho: 5 KB\n", computador.getEstrutura());
    }

    @Test
    void deveRetornarEstruturaComPastasAninhadas() {
        Pasta nivel3 = new Pasta("Nivel 3");
        nivel3.addItem(new Arquivo("fundo.txt", 1));

        Pasta nivel2 = new Pasta("Nivel 2");
        nivel2.addItem(nivel3);

        Pasta nivel1 = new Pasta("Nivel 1");
        nivel1.addItem(nivel2);

        Computador computador = new Computador();
        computador.setRaiz(nivel1);

        assertEquals("Pasta: Nivel 1\n" +
                "Pasta: Nivel 2\n" +
                "Pasta: Nivel 3\n" +
                "Arquivo: fundo.txt - tamanho: 1 KB\n", computador.getEstrutura());
    }

    @Test
    void deveRetornarExcecaoComputadorSemRaiz() {
        try {
            Computador computador = new Computador();
            computador.getEstrutura();
            fail();
        }
        catch (NullPointerException e) {
            assertEquals("Computador sem diretório raiz", e.getMessage());
        }
    }
}
