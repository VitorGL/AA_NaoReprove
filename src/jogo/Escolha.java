package jogo;


public abstract class Escolha {
    public Escolha(String descricao, Evento evento) {
        this.evento = evento;
        this.descricao = descricao;
    }

    public String getDescription() {
        return numero + ": "+ this.descricao;
    }

    public void definirNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
    }

    public Evento getEvento() {
        return this.evento;
    }

    public abstract void executarEscolha(Personagem personagem);

    private String descricao;
    private Evento evento;
    private int numero;
}