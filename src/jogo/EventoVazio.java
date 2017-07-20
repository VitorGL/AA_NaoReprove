package jogo;

import java.util.Collection;

public class EventoVazio extends Evento{
    public EventoVazio(String descricao, Collection<Escolha> escolhas) {
        super(descricao, escolhas);
    }

    @Override
    public void aplicarHistoria(Personagem personagem) {
    }
}