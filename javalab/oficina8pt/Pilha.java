package oficina8pt;

import javax.swing.JOptionPane;

public class Pilha {

    /* ATRIBUTOS DO MODELO Pilha.java */
    public Notas pil[];         // vetor de objetos Notas
    public int topo;            // posição do topo
    public int max;             // tamanho limite
    public int tamanho = 0;     // tamanho preenchido

    // Construtor: recebe o tamanho máximo da pilha
    public Pilha(int max) {
        this.max = max;
        this.topo = -1;
        pil = new Notas[max];
    }

    // Empilhar
    public void push(String nome, double media) {
        if (cheia()) {
            JOptionPane.showMessageDialog(null, "Pilha Cheia!");
            return;
        }
        topo++;
        pil[topo] = new Notas(nome, media);
        tamanho++;
        JOptionPane.showMessageDialog(null, "Dados empilhados!");
    }

    // Desempilhar
    public void pop() {
        if (vazia()) {
            JOptionPane.showMessageDialog(null, "Pilha já está vazia!");
            return;
        }
        Notas removida = pil[topo];
        pil[topo] = null;
        topo--;
        tamanho--;
        JOptionPane.showMessageDialog(null, "Desempilhado:\n" + removida);
    }

    // Mostrar somente o elemento do topo
    public void verTopo() {
        if (vazia()) {
            JOptionPane.showMessageDialog(null, "Pilha vazia!");
            return;
        }
        JOptionPane.showMessageDialog(null, "Topo da pilha:\n" + pil[topo]);
    }

    // Listar do topo até a base
    public void print() {
        if (vazia()) {
            JOptionPane.showMessageDialog(null, "Pilha vazia!");
            return;
        }
        String saida = "*** Pilha (" + tamanho + "/" + max + ") ***";
        for (int i = topo; i >= 0; i--) {
            saida += "\n" + i + " - " + pil[i];
        }
        JOptionPane.showMessageDialog(null, saida);
    }

    // Busca linear por nome, do topo até a base
    public void buscar(String nome) {
        if (vazia()) {
            JOptionPane.showMessageDialog(null, "Pilha vazia!");
            return;
        }
        for (int i = topo; i >= 0; i--) {
            if (pil[i].getNome().equalsIgnoreCase(nome)) {
                JOptionPane.showMessageDialog(null, "Aluno encontrado na posição " + i + ":\n" + pil[i]);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Aluno \"" + nome + "\" não encontrado!");
    }

    public void estatisticas() {
        if (vazia()) {
            JOptionPane.showMessageDialog(null, "Pilha vazia!");
            return;
        }
        double soma = 0;
        int aprovados = 0, reprovados = 0;
        Notas maior = pil[0];
        Notas menor = pil[0];

        for (int i = 0; i <= topo; i++) {
            soma += pil[i].getMedia();
            if (pil[i].getMedia() > maior.getMedia()) maior = pil[i];
            if (pil[i].getMedia() < menor.getMedia()) menor = pil[i];
            if (pil[i].getStatus().equals("Aprovado")) aprovados++;
            else
                reprovados++;
        }

        String saida = "*** Estatísticas ***";
        saida += "\nAlunos na pilha: " + tamanho;
        saida += "\nMédia da turma: " + String.format("%.2f", soma / tamanho);
        saida += "\nMaior média: " + maior;
        saida += "\nMenor média: " + menor;
        saida += "\nAprovados: " + aprovados;
        saida += "\nReprovados: " + reprovados;
        JOptionPane.showMessageDialog(null, saida);
    }

    // Destrutor recursivo
    public void destrutor(int topo) {
        if (topo == -1) { // condição de parada recursivo
            this.topo = -1;
            this.tamanho = 0;
            JOptionPane.showMessageDialog(null, "Pilha destruída...!");
            return;
        }
        pil[topo] = null;
        destrutor(topo - 1);
    }

    public boolean vazia() {
        if (topo == -1) return true;
        else
            return false;
    }

    public boolean cheia() {
        if (tamanho == max) return true;
        else
            return false;
    }
}