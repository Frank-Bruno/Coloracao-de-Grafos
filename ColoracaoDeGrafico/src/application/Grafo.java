package application;

import java.util.*;
import java.util.LinkedList;

// Classe para a criacao de um grafo nao direcionado
class Grafo
{
	int numVertices; // Numero de vertices
	LinkedList<Integer> listaAdjacencia[]; //Lista de adjacencia
	int listaCores[];
	boolean corDisponivel[]; 
	
	// Construtor
	Grafo(int nVertices) {
		numVertices = nVertices;
		listaAdjacencia = new LinkedList[nVertices];
		for (int i=0; i<nVertices; ++i)
			listaAdjacencia[i] = new LinkedList();
		
		// Inicialia uma lista para armazenar as cores de cada vertice
		listaCores = new int[numVertices];
		
		// Inicializa todos os vertices sem cores (-1)
		Arrays.fill(listaCores, -1);
		
		// Atrubui a cor 0 ao primeiro vertice
		listaCores[0] = 0;
		
		// Cria uma lista para armazenar as cores disponiveis
		corDisponivel = new boolean[numVertices];
		
		// Inicializa a lista com todas as cores estando disponiveis
		Arrays.fill(corDisponivel, true);
	}
	// Metodo para adicionar uma aresta nao direcionada, ligando dois vertices no grafo 
	public void addAresta(int v1,int v2) {
		listaAdjacencia[v1].add(v2);
		listaAdjacencia[v2].add(v1);
	}
	// Atribui cores para os vertices, inicializando em 0
	public void coloreGrafo() {
		// Atribui cores a todos os vertices restantes
		for (int u = 1; u < numVertices; u++) {
			// Analisa os vertices adjacentes e verifica as cores disponiveis
			Iterator<Integer> it = listaAdjacencia[u].iterator() ;
			while (it.hasNext()) {
				int i = it.next();
				if (listaCores[i] != -1)
					corDisponivel[listaCores[i]] = false;
			}
			// Seleciona a primeira cor disponivel
			int cd;
			for (cd = 0; cd < numVertices; cd++) {  
				// Interrompe o laço se corDiponivel[cd] for verdadeiro   
				if (corDisponivel[cd])
					break;
			}
			// Atribui ao vertice a cor selecionada
			listaCores[u] = cd;
			
			// Reinicia os valores disponiveis
			Arrays.fill(corDisponivel, true);
		}
	}
	
	public void imprime() {
		// Imprime os resultados
		for (int i = 0; i < numVertices; i++)
			System.out.println("Vertice " + i + " ---> Cor " + listaCores[i]);
	}
}
