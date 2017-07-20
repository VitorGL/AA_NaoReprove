package jogo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Stream;



public class Engine {
	public static void main(String[] args) throws IOException {
        Livro livro = Engine.criarLivro();

        System.out.println(livro.mostrarLivroDaHistoria());

        Scanner in = new Scanner(System.in);

        do {
            System.out.println(livro.mostrarHistoria());


            for(Escolha escolha:livro.nextEvents()) {
                System.out.println(escolha.getDescription());
                
            }

            int i;
            do {
                i = in.nextInt();
            } while(!livro.proximoEvento(i));
        } while(!livro.isTheEnd());

        System.out.println(livro.mostrarHistoria());
    }
	
	public static String FazerDescricao(int x) throws IOException{
		String linha;
		BufferedReader leitor = new BufferedReader(new FileReader("arquivos/texto.txt"));
	
		for(int i = 1; i < x; i++) {
			leitor.readLine();
		}
		linha = leitor.readLine();
		
		return linha;
	}

    public static Livro criarLivro()  throws IOException{
    	Jogador jogador = new Jogador(180, 1);
    	//int vida = 100;
    	Inimigo p1;
    	Inimigo p2;
    	Inimigo pO;
    	Inimigo sono;
    	String descricaoEscolha;
		String descricaoEscolha2;
		String descricaoEvento;
        
        Collection escolhas = new ArrayList<Escolha>();
        
        descricaoEvento = FazerDescricao(43);
        Evento eventoFinalExclente = new EventoVazio(descricaoEvento, new ArrayList<Escolha>());
        // Dia p2 excelente
        
        descricaoEvento = FazerDescricao(24);
        Evento eventoFinalBom = new EventoVazio(descricaoEvento, new ArrayList<Escolha>());
        // Dia p2 bom
        
        descricaoEvento = FazerDescricao(23);
        Evento eventoFinalMediano = new EventoVazio(descricaoEvento, new ArrayList<Escolha>());
        // final mediano
        
        
        descricaoEvento = FazerDescricao(16);
        Evento eventoFinalRuim = new EventoVazio(descricaoEvento, new ArrayList<Escolha>());
        // Dia p2 / final ruim
        
        descricaoEvento = FazerDescricao(20);
		descricaoEscolha = FazerDescricao(21);
		descricaoEscolha2 = FazerDescricao(22);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaDiversao21 = new EscolhaDeBatalhas(descricaoEscolha, eventoFinalBom, p2 = new Inimigo(-50, 1), jogador);
        Escolha escolhaDiversao22 = new EscolhaDeBatalhas(descricaoEscolha2, eventoFinalMediano, p2 = new Inimigo(-20, 1), jogador);
        escolhas.add(escolhaDiversao21);
        escolhas.add(escolhaDiversao22);
        Evento eventoDiversao11 = new EventoVazio(descricaoEvento, escolhas); // Dia p2 bom
        
        
        descricaoEvento = FazerDescricao(17);
		descricaoEscolha = FazerDescricao(18);
		descricaoEscolha2 = FazerDescricao(19);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaDiversao19 = new EscolhaDeBatalhas(descricaoEscolha, eventoFinalMediano, p2 = new Inimigo(-20, 1), jogador);
        Escolha escolhaDiversao20 = new EscolhaDeBatalhas(descricaoEscolha2, eventoFinalRuim, p2 = new Inimigo(20, 1), jogador);
        escolhas.add(escolhaDiversao19);
        escolhas.add(escolhaDiversao20);
        Evento eventoDiversao10 = new EventoVazio(descricaoEvento, escolhas); // Dia p2 mediano
        
        descricaoEvento = FazerDescricao(13);
		descricaoEscolha = FazerDescricao(14);
		descricaoEscolha2 = FazerDescricao(15);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaDiversao17 = new EscolhaDeBatalhas(descricaoEscolha, eventoDiversao10, p2 = new Inimigo(20, 1), jogador);
        Escolha escolhaDiversao18 = new EscolhaDeBatalhas(descricaoEscolha2, eventoDiversao11, p2 = new Inimigo(-20, 1), jogador);
        escolhas.add(escolhaDiversao17);
        escolhas.add(escolhaDiversao18);
        Evento eventoDiversao9 = new EventoVazio(descricaoEvento, escolhas); //Dia da P1 bom
        
        
        descricaoEvento = FazerDescricao(10);
		descricaoEscolha = FazerDescricao(11);
		descricaoEscolha2 = FazerDescricao(12);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaDiversao15 = new EscolhaDeBatalhas(descricaoEscolha, eventoFinalRuim, p2 = new Inimigo(20, 1), jogador);
        Escolha escolhaDiversao16 = new EscolhaDeBatalhas(descricaoEscolha2, eventoDiversao10, p2 = new Inimigo(-20, 1), jogador);
        escolhas.add(escolhaDiversao15);
        escolhas.add(escolhaDiversao16);
        Evento eventoDiversao8 = new EventoVazio(descricaoEvento, escolhas); //Dia da P1 ruim
        
        
        descricaoEvento = FazerDescricao(7);
		descricaoEscolha = FazerDescricao(8);
		descricaoEscolha2 = FazerDescricao(9);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaDiversao13 = new EscolhaDeBatalhas(descricaoEscolha, eventoDiversao8, p1 = new Inimigo(40, 1), jogador);
        Escolha escolhaDiversao14 = new EscolhaDeBatalhas(descricaoEscolha2, eventoDiversao9, p1 = new Inimigo(20, 1), jogador);
        escolhas.add(escolhaDiversao13);
        escolhas.add(escolhaDiversao14);
        jogador = new Jogador(100, 10);
        Evento eventoDiversao7 = new EventoVazio(descricaoEvento, escolhas); // Batalha da P1
        
        
        /////////////////////////////////////////
        //////////  Eventos Estudar  ////////////
        
        descricaoEvento = FazerDescricao(40);
 		descricaoEscolha = FazerDescricao(41);
 		descricaoEscolha2 = FazerDescricao(42);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaEstudar11 = new EscolhaDeBatalhas(descricaoEscolha, eventoFinalExclente, p2 = new Inimigo(-80, 3), jogador);
        Escolha escolhaEstudar12 = new EscolhaDeBatalhas(descricaoEscolha2, eventoFinalMediano, p2 = new Inimigo(-20, 3), jogador);
        escolhas.add(escolhaEstudar11);
        escolhas.add(escolhaEstudar12);
        Evento eventoEstudar6 = new EventoVazio(descricaoEvento, escolhas); // Dia p2 bom
        
        
        descricaoEvento = FazerDescricao(37);
 		descricaoEscolha = FazerDescricao(38);
 		descricaoEscolha2 = FazerDescricao(39);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaEstudar9 = new EscolhaDeBatalhas(descricaoEscolha, eventoFinalMediano, p2 = new Inimigo(-20, 3), jogador);
        Escolha escolhaEstudar10 = new EscolhaDeBatalhas(descricaoEscolha2, eventoFinalMediano, p2 = new Inimigo(20, 3), jogador);
        escolhas.add(escolhaEstudar9);
        escolhas.add(escolhaEstudar10);
        Evento eventoEstudar5 = new EventoVazio(descricaoEvento, escolhas); // Dia p2 mediano
        
        descricaoEvento = FazerDescricao(34);
 		descricaoEscolha = FazerDescricao(35);
 		descricaoEscolha2 = FazerDescricao(36);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaEstudar7 = new EscolhaDeBatalhas(descricaoEscolha, eventoEstudar5, p2 = new Inimigo(20, 3), jogador);
        Escolha escolhaEstudar8 = new EscolhaDeBatalhas(descricaoEscolha2, eventoEstudar6, p2 = new Inimigo(-20, 3), jogador);
        escolhas.add(escolhaEstudar7);
        escolhas.add(escolhaEstudar8);
        Evento eventoEstudar4 = new EventoVazio(descricaoEvento, escolhas); //Dia da P1 alto
        
        
        descricaoEvento = FazerDescricao(31);
 		descricaoEscolha = FazerDescricao(32);
 		descricaoEscolha2 = FazerDescricao(33);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaEstudar5 = new EscolhaDeBatalhas(descricaoEscolha, eventoEstudar5, p2 = new Inimigo(20, 3), jogador);
        Escolha escolhaEstudaro6 = new EscolhaDeBatalhas(descricaoEscolha2, eventoEstudar6, p2 = new Inimigo(-20, 3), jogador);
        escolhas.add(escolhaEstudar5);
        escolhas.add(escolhaEstudaro6);
        Evento eventoEstudar3 = new EventoVazio(descricaoEvento, escolhas); //Dia da P1 mediano
        
        
        descricaoEvento = FazerDescricao(28);
 		descricaoEscolha = FazerDescricao(29);
 		descricaoEscolha2 = FazerDescricao(30);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaEstudar3 = new EscolhaDeBatalhas(descricaoEscolha, eventoEstudar3, p1 = new Inimigo(40, 3), jogador);
        Escolha escolhaEstudar4 = new EscolhaDeBatalhas(descricaoEscolha2, eventoEstudar4, p1 = new Inimigo(20, 3), jogador);
        escolhas.add(escolhaEstudar3);
        escolhas.add(escolhaEstudar4);
        Evento eventoEstudar2 = new EventoVazio(descricaoEvento, escolhas); // Batalha da P1
        
        descricaoEvento = FazerDescricao(25);
 		descricaoEscolha = FazerDescricao(26);
 		descricaoEscolha2 = FazerDescricao(27);
        escolhas = new ArrayList<Escolha>();	
        Escolha escolhaEstudar1 = new EscolhaDeBatalhas(descricaoEscolha, eventoDiversao7, sono = new Inimigo(30, 1), jogador);
        Escolha escolhaEstudar2 = new EscolhaVazia(descricaoEscolha2, eventoEstudar2);
        escolhas.add(escolhaEstudar1);
        escolhas.add(escolhaEstudar2);
        Evento estudarInicial = new EventoVazio(descricaoEvento + " " + jogador.getEnergia(), escolhas);
        
        /////////////////////////////////////////
        //////////  Eventos Diversão  //////////
        
        descricaoEvento = FazerDescricao(20);
		descricaoEscolha = FazerDescricao(21);
		descricaoEscolha2 = FazerDescricao(22);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaDiversao11 = new EscolhaDeBatalhas(descricaoEscolha, eventoFinalBom, p2 = new Inimigo(-50, 1), jogador);
        Escolha escolhaDiversao12 = new EscolhaDeBatalhas(descricaoEscolha2, eventoFinalMediano, p2 = new Inimigo(-20, 1), jogador);
        escolhas.add(escolhaDiversao11);
        escolhas.add(escolhaDiversao12);
        Evento eventoDiversao6 = new EventoVazio(descricaoEvento, escolhas); // Dia p2 bom
        
        
        descricaoEvento = FazerDescricao(17);
		descricaoEscolha = FazerDescricao(18);
		descricaoEscolha2 = FazerDescricao(19);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaDiversao9 = new EscolhaDeBatalhas(descricaoEscolha, eventoFinalMediano, p2 = new Inimigo(-20, 1), jogador);
        Escolha escolhaDiversao10 = new EscolhaDeBatalhas(descricaoEscolha2, eventoFinalRuim, p2 = new Inimigo(20, 1), jogador);
        escolhas.add(escolhaDiversao9);
        escolhas.add(escolhaDiversao10);
        Evento eventoDiversao5 = new EventoVazio(descricaoEvento, escolhas); // Dia p2 mediano
        
        descricaoEvento = FazerDescricao(13);
		descricaoEscolha = FazerDescricao(14);
		descricaoEscolha2 = FazerDescricao(15);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaDiversao7 = new EscolhaDeBatalhas(descricaoEscolha, eventoDiversao5, p2 = new Inimigo(20, 1), jogador);
        Escolha escolhaDiversao8 = new EscolhaDeBatalhas(descricaoEscolha2, eventoDiversao6, p2 = new Inimigo(-20, 1), jogador);
        escolhas.add(escolhaDiversao7);
        escolhas.add(escolhaDiversao8);
        Evento eventoDiversao4 = new EventoVazio(descricaoEvento + " energia: " + jogador.getEnergia(), escolhas); //Dia da P1 bom
        
        
        descricaoEvento = FazerDescricao(10);
		descricaoEscolha = FazerDescricao(11);
		descricaoEscolha2 = FazerDescricao(12);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaDiversao5 = new EscolhaDeBatalhas(descricaoEscolha, eventoFinalRuim, p2 = new Inimigo(100, 1), jogador);
        Escolha escolhaDiversao6 = new EscolhaDeBatalhas(descricaoEscolha2, eventoDiversao5, p2 = new Inimigo(-20, 1), jogador);
        escolhas.add(escolhaDiversao5);
        escolhas.add(escolhaDiversao6);
        Evento eventoDiversao3 = new EventoVazio(descricaoEvento + " energia: " + jogador.getEnergia(), escolhas); //Dia da P1 ruim
        
        
        descricaoEvento = FazerDescricao(7);
		descricaoEscolha = FazerDescricao(8);
		descricaoEscolha2 = FazerDescricao(9);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaDiversao3 = new EscolhaDeBatalhas(descricaoEscolha, eventoDiversao3, p1 = new Inimigo(40, 1), jogador);
        Escolha escolhaDiversao4 = new EscolhaDeBatalhas(descricaoEscolha2, eventoDiversao4, p1 = new Inimigo(20, 1), jogador);
        escolhas.add(escolhaDiversao3);
        escolhas.add(escolhaDiversao4);
        jogador = new Jogador(100, 10);
        Evento eventoDiversao2 = new EventoVazio(descricaoEvento + " energia: " + jogador.getEnergia(), escolhas); // Batalha da P1
        
        
        descricaoEvento = FazerDescricao(4);
		descricaoEscolha = FazerDescricao(5);
		descricaoEscolha2 = FazerDescricao(6);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaDiversao1 = new EscolhaDeBatalhas(descricaoEscolha, eventoDiversao2, sono = new Inimigo(30, 1), jogador);
        
        Escolha escolhaDiversao2 = new EscolhaVazia(descricaoEscolha2, eventoEstudar2);
        escolhas.add(escolhaDiversao1);
        escolhas.add(escolhaDiversao2);
        Evento diversaoInicial = new EventoVazio(descricaoEvento + " energia: " + jogador.getEnergia(), escolhas);
        
        
        descricaoEvento = FazerDescricao(1);
		descricaoEscolha = FazerDescricao(2);
		descricaoEscolha2 = FazerDescricao(3);
        escolhas = new ArrayList<Escolha>();
        Escolha escolhaDiversao = new EscolhaVazia(descricaoEscolha, diversaoInicial);
        Escolha escolhaEstudar = new EscolhaVazia(descricaoEscolha2, estudarInicial);
        escolhas.add(escolhaDiversao);
        escolhas.add(escolhaEstudar);

        Evento eventoInicial = new EventoVazio(descricaoEvento, escolhas);
        
        String descricaoLivro = FazerDescricao(44);
        Livro livro = new Livro(descricaoLivro, eventoInicial, jogador);

        return livro;
    }
}