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

Esse problema pode ser encontrado de diversas formas no cotidiano, representando problemas por meio da coloração de grafos. Dois exemplos são mencionados a seguir:

- Atribuição de frequências em redes móveis: As frequências atribuídas a todas as torres de telecomunicações em uma mesma localidade devem ser diferentes. Sabendo disso, como deve-se atribuir frequências com essa condição? Qual é o número mínimo de frequências necessárias para serem atribuídas as torres?  Estas questões também fazem parte do problema de coloração de grafos, onde cada torre de telecomunicação pode representar um vértice e uma aresta entre duas torres representa que elas estão no intervalo uma da outra.

- Elaborando um cronograma: Imagine que você queira fazer um cronograma de provas para uma universidade. Temos uma lista de várias disciplinas e alunos matriculados em cada uma das disciplinas. Diversas disciplinas teriam alunos em comum. Como iríamos marcar as provas para que não fossem agendados duas provas com um aluno em comum? Quantos intervalos de tempo mínimos são necessários para marcar todas as provas? Este problema pode ser representado como um grafo, onde cada vértice é um aluno e uma aresta entre dois vértices representa a existência de um aluno em comum. Com isso, pode-se entender que é um problema de coloração de grafo, onde o número mínimo de intervalos de tempo é igual ao número mínimo de cores necessárias para representar um grafo *G*.

### O algoritmo

Não existe um algoritmo eficiente disponível para colorir um gráfico com um número mínimo de cores, pois o problema faz parte da categoria de problemas NP-Completo. Ainda assim, existem algoritmos que buscam aproximar-se da solução para resolver o problema. Sendo assim, o nosso algoritmo possui elementos de Algoritmos Gulosos (*Algoritmo Greedy*) básicos para atribuir cores. Essa solução pode fornecer um uso de cores mínimas, mas permite um limite superior no número de cores. O algoritmo básico nunca usa mais do que *d* + 1 cores, onde *d* é o grau máximo de um vértice no grafo fornecido. O algoritmo funciona da seguinte maneira:

1. O primeiro vértice é pintado com a primeira cor.

1. A mesma ação é repetida para para os vértices *V* - 1 restantes.

1. Considere o vértice escolhido atualmente e pinte-o com a cor de menor número que não foi usada em nenhum vértice colorido adjacente a ele. Se todas as cores usadas anteriormente aparecerem nos vértices adjacentes ao vértice *V*, atribua uma nova cor a ele.


### Entradas e Saídas

Entrada: No arquivo *Main.java*, são inseridos 5 vértices, e o algoritmo escolhe um número mínimo de cores.

```java
Grafo grafo = new Grafo(5);
grafo.addAresta(0, 1);
grafo.addAresta(0, 2);
grafo.addAresta(1, 2);
grafo.addAresta(1, 3);
grafo.addAresta(2, 3);
grafo.addAresta(3, 4);
```

Saída: A saída imprime as cores para cada vértice.
```java
Vertice 0 ---> Cor 0
Vertice 1 ---> Cor 1
Vertice 2 ---> Cor 2
Vertice 3 ---> Cor 0
Vertice 4 ---> Cor 1
```

### Análise do algoritmo e limitações

O algoritmo nem sempre utiliza um número mínimo de cores. Além disso, o número de cores usadas em algum momento pode depender da ordem em que os vértices são inseridos. Por exemplo, considere os dois grafos a seguir. Observe que no grafo 2 os vértices 3 e 4 estão trocados.

```java
//Grafo 1
Grafo grafo = new Grafo(5);
grafo.addAresta(0, 1);
grafo.addAresta(0, 2);
grafo.addAresta(1, 2);
grafo.addAresta(1, 3);
grafo.addAresta(2, 3);
grafo.addAresta(3, 4);

//Grafo 2
Grafo grafo = new Grafo(5);
grafo.addAresta(0, 1);
grafo.addAresta(0, 2);
grafo.addAresta(1, 2);
grafo.addAresta(1, 4);
grafo.addAresta(2, 4);
grafo.addAresta(4, 3);

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
Se inserirmos os vértices 0, 1, 2, 3, 4, como a inserção do grafo 1, podemos colorir os grafos usando 3 cores. Mas se considerarmos os vértices 0, 1, 2, 3, 4, inserindo-os como no grafo 2, precisamos de 4 cores. Portanto, a ordem em que os vértices são inseridos é importante. Uma alternativa diferente para encontrar uma solução que funcione melhor do que este básico algoritmo é o Algoritmo Welsh-Powell, que considera os vértices em ordem decrescente de graus.

### Referências

- DÉHARBE, David. **Algoritmos gulosos,** Universidade Federal do Rio Grande do Norte. Disponível em: http://daviddeharbe.github.io/downloads/lectures/2015.2/dim0806/aula29.pdf. Acesso em 03 out. 2021.
- FEOFILOFF, Paulo.  Algoritmos para grafos: **Coloração de vértices.** Instituto de Matemática e Estatística da USP, 2019. Disponível em: https://www.ime.usp.br/~pf/algoritmos_para_grafos/aulas/vertex-coloring.html#sec:greedy. Acesso em: 02 out. 2021.
- FEOFILOFF, Paulo.  Análise de algoritmos: **Complexidade e problemas NP-completos.** Instituto de Matemática e Estatística da USP, 2021. Disponível em: https://www.ime.usp.br/~pf/analise_de_algoritmos/aulas/NPcompleto.html Acesso em: 02 out. 2021.
- FEOFILOFF, Paulo.  Análise de algoritmos: **Método guloso.** Instituto de Matemática e Estatística da USP, 2020. Disponível em: https://www.ime.usp.br/~pf/analise_de_algoritmos/aulas/guloso.html. Acesso em: 03 out. 2021.
- LUIZ, Atílio Gomes. **Coloração de grafos e suas aplicações.** In: V Workshop de Tecnologia da Informação do Sertão Central, 2015. Disponível em: https://www.ic.unicamp.br/~atilio/slidesWtisc.pdf. Acesso em: 30 set. 2021.
- OLIVEIRA, Maria Cristina F.; PARDO, Thiago A. S. **Coloração de grafos** - Modelagem Computacional em Grafos. Disponível em: https://edisciplinas.usp.br/pluginfile.php/5262366/mod_resource/content/2/6.%20Colora%C3%A7%C3%A3o%20de%20grafos.pdf. Acesso em 05 out. 2021.
- Oracle: **Classe LinkedList <E>.** Disponível em: https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html. Acesso em: 03 out. 2021.
- W3 School. **Java LinkedList.** Disponível em: https://www.w3schools.com/java/java_linkedlist.asp. Acesso em: 03 out. 2021.
- Wikipedia: **Graph coloring**. Disponível em: https://en.wikipedia.org/wiki/Graph_coloring. Acesso em: 30 set. 2021.
