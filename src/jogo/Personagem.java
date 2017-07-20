package jogo;

public class Personagem {

    public Personagem(int energia, int fix) {
        this.energia = energia;
        this.fix = fix;
    }

    public void batalha(Personagem inimigo) {
   
        this.receberDano(inimigo.getEnergia());
        inimigo.receberDano(this.getEnergia());
    }

    public boolean estaVivo() {
        if(this.energia > 0)
            return true;

        return false;
    }

    public void receberDano(int dano) {
    	if((dano - this.fix) > 0)
        	this.energia -= dano;
        if(this.energia <= 0)
        	setEnergia(0);
    	//this.energia -= dano;
    }
    
    public int getFix() {
        return this.fix;
    }

    public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	private int energia;
    private int fix;
}