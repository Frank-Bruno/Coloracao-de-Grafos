package application;

import java.util.*;
import java.util.LinkedList;

class Grafo
{
	int numVertices;
	LinkedList<Integer> listaAdjacencia[];
	int listaCores[];
	boolean corDisponivel[]; 
	
	Grafo(int nVertices) {
		numVertices = nVertices;
		listaAdjacencia = new LinkedList[nVertices];
		for (int i=0; i<nVertices; ++i)
			listaAdjacencia[i] = new LinkedList();
		
		listaCores = new int[numVertices];

		Arrays.fill(listaCores, -1);

		listaCores[0] = 0;
		
		corDisponivel = new boolean[numVertices];
		
		Arrays.fill(corDisponivel, true);
	}

	public void addAresta(int v1,int v2) {
		listaAdjacencia[v1].add(v2);
		listaAdjacencia[v2].add(v1);
	}

	public void coloreGrafo() {
		for (int u = 1; u < numVertices; u++) {
			Iterator<Integer> it = listaAdjacencia[u].iterator() ;
			while (it.hasNext()) {
				int i = it.next();
				if (listaCores[i] != -1)
					corDisponivel[listaCores[i]] = false;
			}

			int cd;
			for (cd = 0; cd < numVertices; cd++) {  
				if (corDisponivel[cd])
					break;
			}
			
			listaCores[u] = cd;
			
			Arrays.fill(corDisponivel, true);
		}
	}
	
	public void imprime() {
		for (int i = 0; i < numVertices; i++)
			System.out.println("Vertice " + i + " ---> Cor " + listaCores[i]);
	}
}
