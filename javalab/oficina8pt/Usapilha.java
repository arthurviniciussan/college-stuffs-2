package oficina8pt;

import javax.swing.JOptionPane;

public class Usapilha {

    // Lê o tamanho da pilha até o usuário digitar um inteiro positivo
    public static int lerTamanho() {
        while (true) {
            String str = JOptionPane.showInputDialog(null, "Deseja iniciar uma pilha com qual tamanho ?");
            if (str == null) System.exit(0); // Cancelar
            try {
                int n = Integer.parseInt(str.trim());
                if (n > 0) return n;
            } catch (NumberFormatException e) {
                // cai na mensagem abaixo
            }
            JOptionPane.showMessageDialog(null, "Digite um número inteiro maior que zero!");
        }
    }

    // Lê a média (0 a 10). Retorna null se o usuário cancelar.
    public static Double lerMedia() {
        while (true) {
            String str = JOptionPane.showInputDialog(null, "Digite a média (0 a 10):");
            if (str == null) return null;
            try {
                double m = Double.parseDouble(str.trim().replace(',', '.'));
                if (m >= 0 && m <= 10) return m;
            } catch (NumberFormatException e) {
                // cai na mensagem abaixo
            }
            JOptionPane.showMessageDialog(null, "Média inválida! Use um valor entre 0 e 10.");
        }
    }

    public static void main(String[] args) {
        int n = lerTamanho();
        Pilha p1 = new Pilha(n);

        String menu = "*** Pilha Estática de Notas ***\n"
                + "1 push (empilhar aluno)\n"
                + "2 pop (desempilhar)\n"
                + "3 listar\n"
                + "4 ver topo\n"
                + "5 buscar aluno por nome\n"
                + "6 estatísticas da turma\n"
                + "7 destruir\n"
                + "8 sair\n"
                + "item:";

        while (true) {
            String item = JOptionPane.showInputDialog(null, menu);
            if (item == null) break; // Close Window

            switch (item.trim()) {
                case "1": {
                    if (p1.cheia()) {
                        JOptionPane.showMessageDialog(null, "Pilha Cheia!");
                        break;
                    }
                    String nome = JOptionPane.showInputDialog(null, "Digite o nome do aluno:");
                    if (nome == null || nome.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nome inválido!");
                        break;
                    }
                    Double media = lerMedia();
                    if (media == null) break;
                    p1.push(nome.trim(), media);
                    break;
                }
                case "2":
                    p1.pop();
                    break;
                case "3":
                    p1.print();
                    break;
                case "4":
                    p1.verTopo();
                    break;
                case "5": {
                    String busca = JOptionPane.showInputDialog(null, "Digite o nome do aluno a buscar:");
                    if (busca != null && !busca.trim().isEmpty()) p1.buscar(busca.trim());
                    break;
                }
                case "6":
                    p1.estatisticas();
                    break;
                case "7":
                    p1.destrutor(p1.topo);
                    break;
                case "8":
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        }
    }
}