/**
 * 红黑树：根节点为黑色，先添加的节点默认为红色。左倾红黑树
 * @param <K>
 * @param <V>
 */
public class RBTree<K extends Comparable<K>,V > {
    private static final boolean RED=true;
    private static final boolean BLACK=false;
    private class Node{
        private Node left;
        private Node right;
        private K key;
        private V value;
        private boolean color;

        public Node(K key,V value,Node left,Node right,boolean color){
            this.key=key;
            this.value=value;
            this.left=left;
            this.right=right;
            this.color=color;
        }
        public Node(K key,V value){
            this(key,value,null,null,RED);
        }
    }
    private int size;
    private Node root;
    public RedBlackTreeMap(){
        size=0;
        root = null;
    }
    private boolean isRed(Node node){
        if(node==null)
            return BLACK;
        return node.color;
    }
    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private Node leftRote(Node node){
        Node x = node.right;
        node.right=x.left;
        x.left=node;

        x.color=node.color;
        node.color=RED;
        return x;
    }
    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRote(Node node){
        Node x = node.left;
        node.left=x.right;
        x.right=node;
        x.color=node.color;
        node.color=RED;
        return x;
    }
    //颜色翻转
    private Node flipColors(Node node){
        node.color=RED;
        node.left.color=BLACK;
        node.right.color=BLACK;
        return node;
    }
    public void add(K key, V value) {
        root = add(key,value,root);
        root.color=BLACK;//根节点永远是黑色
    }
    //根据key 添加节点，并返回这个节点所在的根节点
    private Node add(K key,V value,Node node){
        if(node==null){
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)>0){
            node.right=add(key,value,node.right);
        }else if(key.compareTo(node.key)<0){
            node.left = add(key,value,node.left);
        }else {
            node.value=value;
        }

        //调节节点平衡
        if(isRed(node.right)&& !isRed(node.left))
            node=leftRote(node);
        if(isRed(node.left) && isRed(node.left.left))
            node = rightRote(node);
        if(isRed(node.right) && isRed(node.left))
            node = flipColors(node);
        return node;

    }
    //根据key查找有没有这个节点，如果有则返回这个节点
    private Node findNode(K key,Node node){
        if(node!=null){
            if(key.compareTo(node.key)==0){
                return node;
            }else if(key.compareTo(node.key)>0){
                return findNode(key,node.right);
            }else //小于零
            {
                return findNode(key,node.left);
            }
        }
        return null;
    }
    private Node findmin(Node node){
        if(node.left==null){
            return node;
        }
        return findmin(node.left);
    }
    public boolean contains(K key) {
        Node findNode = findNode(key,root);
        return findNode==null?false:true;
    }
    public V get(K key) {
        Node node = findNode(key,root);
        return node==null?null:node.value;
    }
    public void set(K key, V newValue) {
        Node node = findNode(key,root);
        if(node==null){
            throw new IllegalArgumentException("the node is not exists!");
        }
        node.value = newValue;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size==0;
    }
}
