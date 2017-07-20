package jogo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Livro {

    public Livro(String descricao, Evento eventoInicial, Jogador jogador) {
        this.eventoInicial = eventoInicial;
        this.descricao = descricao;
        this.jogador = jogador;

        this.reiniciarHistoria();
    }

    public void reiniciarHistoria() {
        this.eventoAtual = this.eventoInicial;
    }

    public String mostrarHistoria() {
        return this.eventoAtual.history();
    }

    public boolean isTheEnd() {
        return this.eventoAtual.isEndEvent();
    }

    public String mostrarLivroDaHistoria(){
        return this.descricao;
    }

    public boolean proximoEvento(int numero) {
        Escolha escolha = this.selecionarEscolha(numero);

        if(escolha != null) {
            escolha.executarEscolha(jogador);

            if(jogador.estaVivo()) {
                this.eventoAtual = escolha.getEvento();
                this.eventoAtual.aplicarHistoria(jogador);
            }
            else {
                Evento gameOver = new EventoVazio("Game Over", new ArrayList<Escolha>());
                this.eventoAtual = gameOver;
            }

            return true;
        }

        return false;
    }

    public Escolha selecionarEscolha(int numero) {
        return this.eventoAtual.encontrarEscolha(numero);
    }

    public Collection<Escolha> nextEvents() {
        return this.eventoAtual.nextEvents();
    }

    private Evento eventoAtual;
    private Evento eventoInicial;
    private String descricao;
    private Jogador jogador;
}