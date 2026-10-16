Questão 1: O Java Collections Framework (JCF) é uma arquitetura unificada criada para armazenar e manipular grupos de objetos em Java. Lançado a partir do Java 2 (JDK 1.2), ele fornece um conjunto de interfaces, implementações prontas (classes) e algoritmos que padronizam a forma como os desenvolvedores lidam com estruturas de dados comuns, como listas, conjuntos, filas e mapas.

Questão 2: As interfaces List, Set e Map são os pilares do framework de coleções do Java (e de diversas outras linguagens). A principal diferença entre elas está na forma como organizam, gerenciam e permitem o acesso aos dados.
Abaixo estão as características comportamentais de cada uma e os cenários ideais para sua utilização.

📊 Tabela Comparativa de Comportamento


Característica	List (Lista)	Set (Conjunto)	Map (Mapa / Dicionário)
Estrutura básica	Coleção indexada de elementos simples.	Coleção não indexada de elementos únicos.	Estrutura de Chave-Valor (Dicionário).
Ordenação	Mantém a ordem de inserção.	Depende da implementação (ex: HashSet não mantém; LinkedHashSet mantém).	Depende da implementação (ex: HashMap não mantém; LinkedHashMap mantém).
Duplicidade	Permite elementos duplicados.	Não permite elementos duplicados.	Chaves são únicas; Valores podem ser duplicados.
Acesso aos dados	Através de um índice numérico (get(0)).	Através de iteração (percurso) ou busca direta.	Através da chave associada (get(chave)).


1. List (Lista)

Uma lista comporta-se como uma fila sequencial. Ela se importa com a ordem em que os elementos chegam e aceita repetições sem problemas.
• Comportamento: Sequencial, ordenada e permissiva a duplicatas.
• Quando usar: Quando a ordem dos dados importa e você precisa acessar os elementos pela sua posição física (índice), ou quando o mesmo elemento pode aparecer mais de uma vez.
• Exemplos Práticos:
	• Histórico de navegação: Uma lista de URLs visitadas por um usuário, onde a ordem cronológica importa e o usuário pode visitar o mesmo site várias vezes.
	• Carrinho de compras: Uma lista de produtos adicionados. Se o cliente adicionar dois itens iguais, ambos devem aparecer ali.
	• Feed de notícias: Uma sequência de postagens ordenadas pela data de publicação.

2. Set (Conjunto)

Um conjunto funciona como os conjuntos matemáticos. Ele não garante uma ordem específica (na maioria das implementações) e garante de forma rígida que nenhum elemento seja inserido duas vezes.
• Comportamento: Focado em unicidade. Tentar adicionar um elemento que já existe na coleção não surtirá efeito.
• Quando usar: Quando você precisa garantir que não existam elementos duplicados na sua coleção e a ordem dos fatores não é a prioridade número um.
• Exemplos Práticos:
	• CPFs ou E-mails cadastrados: Uma coleção de CPFs de clientes em um sorteio. Ninguém pode ter o CPF inserido duas vezes para burlar o sistema.
	• Tags de um blog: Um conjunto de palavras-chave associadas a um artigo (ex: [#tecnologia, #programacao]). Não faz sentido repetir a mesma tag no mesmo texto.
	• Lista de presença: Registrar os alunos que compareceram à aula. Se o nome do aluno for registrado duas vezes, o sistema ignora a segunda inserção.

3. Map (Mapa)

O mapa não herda diretamente a interface Collection porque trabalha com pares de dados: uma chave (que funciona como um identificador único) e um valor (o dado associado àquela chave).
• Comportamento: Associação direta. Encontrar um valor através de sua chave é extremamente rápido.
• Quando usar: Quando você precisa mapear um dado a outro, simulando um dicionário ou catálogo, onde você busca algo sabendo o seu identificador único.
• Exemplos Práticos:
	• Dicionário de tradução: Onde a palavra em inglês é a chave e a tradução em português é o valor
	• Cache de usuários logados: Onde o Token JWT (ID da sessão) é a chave e o objeto com os dados do usuário é o valor.
	• Estoque de produtos: Onde o código de barras ou SKU é a chave e a quantidade disponível em estoque é o valor 

Questão 3: 
 Ordem dos Elementos

• HashSet: Não garante nenhuma ordem para os elementos. A disposição dos itens depende inteiramente do cálculo do hashCode e pode mudar inclusive quando novos elementos são adicionados.
• LinkedHashSet: Mantém os elementos estritamente na ordem em que foram inseridos. Se você iterar pelo conjunto, os elementos surgirão exatamente na mesma sequência da inserção.
• TreeSet: Mantém os elementos sempre ordenados. Essa ordenação segue a ordem natural dos objetos (se implementarem a interface Comparable, como Strings e Números) ou as regras de um Comparator customizado fornecido no construtor.

2. Complexidade de Tempo (Busca, Inserção e Remoção)

• HashSet: Oferece performance de O(1) para as operações básicas de busca (contains), inserção (add) e remoção (remove). É a opção mais rápida, assumindo que a função de hash disperse bem os elementos para evitar colisões.
• LinkedHashSet: Também oferece performance de O(1) para as operações básicas. O custo adicional para manter os ponteiros da lista ligada afeta minimamente o tempo de inserção e remoção, sendo ligeiramente mais lento que o HashSet puro, mas com o mesmo comportamento assintótico.
• TreeSet: Possui complexidade O(log n) para busca, inserção e remoção. Por precisar rebalancear a árvore a cada modificação e fazer comparações (compareTo ou compare) para achar a posição correta, ele é consideravelmente mais lento que as opções baseadas em hash.

3. Uso de Memória

• HashSet: É o mais eficiente em consumo de memória entre os três. Ele armazena os elementos nos buckets de uma tabela hash interna.
• LinkedHashSet: Tem o maior consumo de memória. Além da estrutura tradicional da tabela hash, ele precisa manter uma lista duplamente ligada rodando por trás, o que exige dois ponteiros adicionais (before e after) para cada elemento inserido.
• TreeSet: Tem um consumo de memória de médio a alto. Cada elemento inserido torna-se um nó em uma árvore rubro-negra, exigindo referências para o nó pai, nó esquerdo, nó direito e uma variável booleana para armazenar a cor do nó (vermelho ou preto).
