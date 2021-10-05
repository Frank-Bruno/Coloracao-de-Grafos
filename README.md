Alunos/Students:

- Eduardo Morais Ribeiro – EduardoRibeiroIX
- Frank Bruno Ferreira Boa Morte – Frank Bruno
- Jean Dean Monteiro Pereira – JD3an
- João da Cruz de Natividade e Silva Neto – Joaosnet

# Coloração de Grafos

Os grafos são estruturas matemáticas compostas por vértices conectados por arestas. E dentro dessa estrutura, há o problema de colorir grafos, atribuindo cores a certos elementos de um grafo, sujeitos a determinadas restrições. Com isso, a coloração de vértices é o problema de coloração de grafos mais comum.
O problema é que, para cores, é necessário encontrar uma maneira de colorir os vértices de um grafo, de forma que dois vértices adjacentes não sejam coloridos com a mesma cor. Portanto, uma coloração nada mais é que uma numeração dos vértices. Podemos dizer também que uma coloração é uma partição do conjunto de vértices: cada bloco da partição corresponde a uma cor.
Uma coloração de um grafo é válida se as duas pontas de cada aresta têm cores diferentes. Buscar colorações válidas com diversas cores é fácil. Porém, encontrar colorações válidas com um pequeno número de cores torna o problema bem mais difícil. Com isso, surge o problema da coloração mínima de vértices, onde um grafo *G* busca uma coloração válida com o menor número de cores possível.

### Aplicações do problema

### O algoritmo

### Entradas e Saídas


```java
Grafo grafo = new Grafo(5);
grafo.addAresta(0, 1);
grafo.addAresta(0, 2);
grafo.addAresta(1, 2);
grafo.addAresta(1, 3);
grafo.addAresta(2, 3);
grafo.addAresta(3, 4)
```

```java
Vertice 0 ---> Cor 0
Vertice 1 ---> Cor 1
Vertice 2 ---> Cor 2
Vertice 3 ---> Cor 0
Vertice 4 ---> Cor 1
```


### Análise do algoritmo e limitações


```java
//Grafo 1
Grafo grafo = new Grafo(5);
grafo.addAresta(0, 1);
grafo.addAresta(0, 2);
grafo.addAresta(1, 2);
grafo.addAresta(1, 3);
grafo.addAresta(2, 3);
grafo.addAresta(3, 4)

//Grafo 2
Grafo grafo = new Grafo(5);
grafo.addAresta(0, 1);
grafo.addAresta(0, 2);
grafo.addAresta(1, 2);
grafo.addAresta(1, 4);
grafo.addAresta(2, 4);
grafo.addAresta(4, 3)

//Saida do Grafo 1
Vertice 0 ---> Cor 0
Vertice 1 ---> Cor 1
Vertice 2 ---> Cor 2
Vertice 3 ---> Cor 0
Vertice 4 ---> Cor 1

//Saida do Grafo 2
Vertice 0 ---> Cor 0
Vertice 1 ---> Cor 1
Vertice 2 ---> Cor 2
Vertice 3 ---> Cor 0
Vertice 4 ---> Cor 3
```


### Referências
