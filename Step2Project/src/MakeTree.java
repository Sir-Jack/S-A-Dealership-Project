public class MakeTree{
    
    private Node root;
 
    private static class Node {
        public Make key;
        public int balance;
        public int height;
        public Node left;
        public Node right;
        public Node parent;
 
        Node(Make key, Node parent) {
            this.key = key;
            this.parent = parent;
        }
    }
 
    public boolean insert(Make key) {
        if (root == null) {
            root = new Node(key, null);
            return true;
        }
 
        Node n = root;
        while (true) {
            if (n.key.compareTo(key) == 0)
                return false;
 
            Node parent = n;
 
            boolean goLeft = n.key.compareTo(key) > 0;
            n = goLeft ? n.left : n.right;
 
            if (n == null) {
                if (goLeft) {
                    parent.left = new Node(key, parent);
                } else {
                    parent.right = new Node(key, parent);
                }
                rebalance(parent);
                break;
            }
        }
        return true;
    }
 
    private void delete(Node node) {
        if (node.left == null && node.right == null) {
            if (node.parent == null) {
                root = null;
            } else {
                Node parent = node.parent;
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                rebalance(parent);
            }
            return;
        }
 
        if (node.left != null) {
            Node child = node.left;
            while (child.right != null) child = child.right;
            node.key = child.key;
            delete(child);
        } else {
            Node child = node.right;
            while (child.left != null) child = child.left;
            node.key = child.key;
            delete(child);
        }
    }
 
    public void delete(Make delKey) {
        if (root == null)
            return;
 
        Node child = root;
        while (child != null) {
            Node node = child;
            child = delKey.compareTo(node.key) == 1 ? node.right : node.left;
            if (delKey == node.key) {
                delete(node);
                return;
            }
        }
    }
 
    private void rebalance(Node n) {
        setBalance(n);
 
        if (n.balance == -2) {
            if (height(n.left.left) >= height(n.left.right))
                n = rotateRight(n);
            else
                n = rotateLeftThenRight(n);
 
        } else if (n.balance == 2) {
            if (height(n.right.right) >= height(n.right.left))
                n = rotateLeft(n);
            else
                n = rotateRightThenLeft(n);
        }
 
        if (n.parent != null) {
            rebalance(n.parent);
        } else {
            root = n;
        }
    }
 
    private Node rotateLeft(Node a) {
 
        Node b = a.right;
        b.parent = a.parent;
 
        a.right = b.left;
 
        if (a.right != null)
            a.right.parent = a;
 
        b.left = a;
        a.parent = b;
 
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
 
        setBalance(a, b);
 
        return b;
    }
 
    private Node rotateRight(Node a) {
 
        Node b = a.left;
        b.parent = a.parent;
 
        a.left = b.right;
 
        if (a.left != null)
            a.left.parent = a;
 
        b.right = a;
        a.parent = b;
 
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
 
        setBalance(a, b);
 
        return b;
    }
 
    private Node rotateLeftThenRight(Node n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }
 
    private Node rotateRightThenLeft(Node n) {
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }
 
    private int height(Node n) {
        if (n == null)
            return -1;
        return n.height;
    }
 
    private void setBalance(Node... nodes) {
        for (Node n : nodes) {
            reheight(n);
            n.balance = height(n.right) - height(n.left);
        }
    }
 
    public String printInorder() {
        String result = "";
        
        result += printInorder(root);
        
        return result;
    }
 
    private String printInorder(Node n) {
        
        String result = "";
        if (n != null) {
            result += printInorder(n.left);
            result += n.key.toString();
            result += printInorder(n.right);
        }
        
        return result;
    }
 
    private void reheight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }
    
    public Car findCar(Car newCar){
        Car checker = findCar(newCar, root);
        return checker;
    }
    
    private Car findCar(Car newCar, Node currentNode){
        Car resultantCheck = null;
        
        if(currentNode != null){
            resultantCheck = currentNode.key.findCar(newCar);
            if(resultantCheck == null){
                resultantCheck = findCar(newCar, currentNode.left);
                if(resultantCheck == null){
                    resultantCheck = findCar(newCar, currentNode.right);
                }
            }
        }
    
        return resultantCheck;
    }
    public Make findMake(String objective){
        Make testMake = new Make(objective);
        
        Make foundMake = findMake(testMake, root);
        
        return foundMake;
        
    }
    
    private Make findMake(Make objective, Node node){
        
        Make returnValue = null;
        
        if (node != null){
            if(node.key.compareTo(objective) == 0){
                returnValue = node.key;
            }else if(node.key.compareTo(objective) > 0){
                returnValue = findMake(objective, node.left);
            }else if(node.key.compareTo(objective) < 0){
                returnValue = findMake(objective, node.right);
            }
        }
        
        return returnValue;
        
    }
    
}
