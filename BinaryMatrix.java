public class BinaryMatrix {

    private int[] tree;        // Array que representa a árvore
    private int size;          // Número de elementos na árvore
    private final int EMPTY = Integer.MIN_VALUE; // Valor especial para indicar posição vazia

    // Construtor: inicializa o array com capacidade inicial fixa
    public BinaryMatrix(int initialCapacity) {
        tree = new int[initialCapacity];
        size = 0;

        // Preenche o array com o valor EMPTY
        for (int i = 0; i < tree.length; i++) {
            tree[i] = EMPTY;
        }
    }

    // Inserir um valor na árvore
    public void insert(int value) {
        if (tree[0] == EMPTY) { // Insere na raiz se estiver vazia
            tree[0] = value;
            size++;
            System.out.println("Inserindo " + value + " na posição 0 (raiz)");
            return;
        }

        int index = 0;
        while (index < tree.length) {
            if (tree[index] == EMPTY) { // Posição encontrada para inserção
                tree[index] = value;
                size++;
                System.out.println("Inserindo " + value + " na posição " + index);
                return;
            }

            // Determina o próximo índice com base no valor (esquerda ou direita)
            if (value < tree[index]) {
                index = 2 * index + 1; // Filho esquerdo
            } else if (value > tree[index]) {
                index = 2 * index + 2; // Filho direito
            } else {
                System.out.println("Valor " + value + " já existe na árvore.");
                return;
            }

            // Expande o array se o índice ultrapassar o tamanho atual
            if (index >= tree.length) {
                expandTree();
            }
        }
    }

    // Remover um valor da árvore
    public void remove(int value) {
        int index = find(value);
        if (index == -1) {
            System.out.println("Valor " + value + " não encontrado na árvore.");
            return;
        }

        System.out.println("Removendo valor " + value + " na posição " + index);
        tree[index] = EMPTY; // Marca o nó como vazio
        size--;
    }

    // Mostrar a raiz da árvore
    public void showRoot() {
        if (tree[0] == EMPTY) {
            System.out.println("A árvore está vazia!");
        } else {
            System.out.println("Raiz: " + tree[0]);
        }
    }

    // Percurso em ordem simétrica (InOrder)
    public void inOrder(int index) {
        if (index >= tree.length || tree[index] == EMPTY) {
            return;
        }

        inOrder(2 * index + 1); // Filho esquerdo
        System.out.print(tree[index] + " ");
        inOrder(2 * index + 2); // Filho direito
    }

    // Percurso pré-ordem (PreOrder)
    public void preOrder(int index) {
        if (index >= tree.length || tree[index] == EMPTY) {
            return;
        }

        System.out.print(tree[index] + " ");
        preOrder(2 * index + 1); // Filho esquerdo
        preOrder(2 * index + 2); // Filho direito
    }

    // Percurso pós-ordem (PostOrder)
    public void postOrder(int index) {
        if (index >= tree.length || tree[index] == EMPTY) {
            return;
        }

        postOrder(2 * index + 1); // Filho esquerdo
        postOrder(2 * index + 2); // Filho direito
        System.out.print(tree[index] + " ");
    }

    // Expansão do array
    private void expandTree() {
        int newCapacity = tree.length * 2;
        int[] newTree = new int[newCapacity];

        // Copia os elementos para o novo array
        for (int i = 0; i < tree.length; i++) {
            newTree[i] = tree[i];
        }

        // Preenche as novas posições com EMPTY
        for (int i = tree.length; i < newTree.length; i++) {
            newTree[i] = EMPTY;
        }

        tree = newTree; // Substitui o array original
        System.out.println("Expansão do array: nova capacidade = " + newCapacity);
    }

    // Localiza um valor e retorna seu índice, ou -1 se não encontrado
    private int find(int value) {
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
