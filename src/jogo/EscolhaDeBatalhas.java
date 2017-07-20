package jogo;


public class EscolhaDeBatalhas extends Escolha {
	public EscolhaDeBatalhas(String descricao, Evento evento, Inimigo inimigo, Jogador jogador) {
		super(descricao, evento);
		
		this.inimigo = inimigo;
		this.executarEscolha(jogador);
	}
	
	@Override
	public void executarEscolha(Personagem personagem) {
		personagem.batalha(this.inimigo);
	}
	
	private Inimigo inimigo;
}
