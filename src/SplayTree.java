import java.util.Map;

public class SplayTree<K extends Comparable<K>, V> implements IMaping<K, V> {

    private Node root;

    private class Node {
        K key;
        V value;
        Node left, right, parent;

        public Node(K key, V value, Node parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }

    @Override
    public void add(K key, V value) {
        if (root == null) {
            root = new Node(key, value, null);
            return;
        }
        splay(key);
        int cmp = key.compareTo(root.key);
        if (cmp == 0) {
            root.value = value;
            return;
        }
        Node n = new Node(key, value, root);
        if (cmp < 0) {
            n.left = root.left;
            n.right = root;
            root.left = null;
        } else {
            n.right = root.right;
            n.left = root;
            root.right = null;
        }
        root = n;
    }

    @Override
    public V get(K key) {
        splay(key);
        if (root == null || key.compareTo(root.key) != 0) {
            return null;
        }
        return root.value;
    }

    @Override
    public boolean search(K key) {
        return get(key) != null;
    }

    private void rotate(Node n) {
        Node parent = n.parent;
        if (parent == null) {
            return;
        }
        Node grandparent = parent.parent;
        if (parent.left == n) {
            Node nl = n.right;
            n.right = parent;
            parent.left = nl;
        } else {
            Node nr = n.left;
            n.left = parent;
            parent.right = nr;
        }
        if (grandparent != null) {
            if (grandparent.left == parent) {
                grandparent.left = n;
            } else {
                grandparent.right = n;
            }
        }
        n.parent = grandparent;
        parent.parent = n;
        if (parent == root) {
            root = n;
        }
    }

    private void splay(K key) {
        if (root == null) {
            return;
        }
        Node n = root;
        while (true) {
            int cmp = key.compareTo(n.key);
            if (cmp == 0) {
                break;
            } else if (cmp < 0) {
                if (n.left == null) {
                    break;
                }
                if (key.compareTo(n.left.key) < 0) {
                    rotate(n.left);
                }
                if (n.left == null) {
                    break;
                }
                rotate(n);
            } else {
                if (n.right == null) {
                    break;
                }
                if (key.compareTo(n.right.key) > 0) {
                    rotate(n.right);
                }
                if (n.right == null) {
                    break;
                }
                rotate(n);
            }
        }
    }
}
