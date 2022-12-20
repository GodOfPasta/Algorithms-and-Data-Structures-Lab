public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        // Создание дерева с помощью вставки узла
        tree.add(100);
        tree.add(10);
        tree.add(9);
        tree.add(11);
        tree.add(110);
        tree.add(120);

        System.out.println("Просмотр дерева в восходящем, нисходящем и последовательном порядке");
        tree.postorder(tree.root);
        System.out.println();
        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("Удаление нескольких узлов из дерева");
        System.out.print("После удаления '100' ");
        tree.delete(100);
        tree.preorder(tree.root);
        System.out.println();
        System.out.print("После удаления '9' ");
        tree.delete(9);
        tree.preorder(tree.root);
        System.out.println();
        System.out.print("После удаления '10' ");
        tree.delete(10);
        tree.preorder(tree.root);
        System.out.println();

        System.out.println("Создание вырожденного дерева путём ввода в него упорядоченных данных");
        tree.root = null;
        tree.add(100);
        tree.add(110);
        tree.add(120);
        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
        System.out.println();

        System.out.println("Поиск информации в дереве");
        System.out.println("'100' Содержится в дереве - " + tree.contains(100));
        System.out.println("'199' Содержится в дереве - " + tree.contains(199));
    }
}
