package oficina8pt;

public class Notas {

    private String nome;
    private double media;

    public Notas(String nome, double media) {
        this.nome = nome;
        this.media = media;
    }

    // Getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getMedia() { return media; }
    public void setMedia(double media) { this.media = media; }

    public String getStatus() {
        if (media < 6) return "Reprovado";
        else
            return "Aprovado";
    }

    @Override
    public String toString() {
        return nome + " - Média: " + String.format("%.2f", media) + " (" + getStatus() + ")";
    }
}