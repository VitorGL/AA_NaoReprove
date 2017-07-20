package jogo;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Evento {
    public Evento(String descricao, Collection<Escolha> escolhas) {
        this.descricao = descricao;
        this.escolhas = new ArrayList<>();

        int i = 0;
        for(Escolha escolha:escolhas) {
            escolha.definirNumero(i);
            this.escolhas.add(escolha);
            i++;
        }

    }

    public String history() {
        return this.descricao;
    }

    public boolean isEndEvent() {
        if(this.escolhas.isEmpty()) return true;

        return false;
    }

    public Collection<Escolha> nextEvents() {
        return this.escolhas;
    }

    public Escolha encontrarEscolha(int numero) {
        for(Escolha escolha:this.escolhas) {
            if(escolha.getNumero() == numero)
            	return escolha;
        }

        return null;
    }

    public abstract void aplicarHistoria(Personagem personagem);

    private String descricao;
    private Collection<Escolha> escolhas;
}