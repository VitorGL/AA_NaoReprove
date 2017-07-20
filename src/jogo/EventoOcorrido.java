package jogo;

import java.util.Collection;

public class EventoOcorrido extends Evento {
	
	public EventoOcorrido(String descricao, Collection<Escolha> escolhas) {
		super(descricao, escolhas);
	}

	public void aplicarHistoria(Personagem personagem) {
		
	}
}
