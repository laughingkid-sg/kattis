import java.util.ArrayList;

class BSTVertex {

  public BSTVertex parent, left, right;
  public int key;
  public int height;
  public int size; 

  BSTVertex(int v) { 
    key = v; 
    parent = left = right = null; 
    height = 0; 
    size = 1;
  }
}

class BST {
  public BSTVertex root;
  ArrayList<Integer> out;

  public BST() { root = null; }

  public int size() {
    return size(root);
  }

  public BSTVertex search(BSTVertex T, int v) {
    if (T == null)  return null;                     // not found
    else if (T.key == v) return T;                        // found
    else if (T.key < v)  return search(T.right, v);       // search to the right
    else                 return search(T.left, v);        // search to the left
  }

  public int height(BSTVertex T) {
    if (T == null)
        return -1;
    return T.height;
  }

  public int size(BSTVertex T) {
    if (T == null)
        return 0;
    return T.size;
  }

  public int getBalance(BSTVertex T) {
    if (T == null)
        return 0;
    return height(T.left) - height(T.right);
  }

  public void insert(int v) { 
    root = insert(root, v); 
  }

  public BSTVertex insert(BSTVertex T, int v) {
    if (T == null) 
      return new BSTVertex(v);

    if (T.key < v) { // search to the right
      T.right = insert(T.right, v);
      T.right.parent = T;
    }
    else if (v > T.key) { //search to the left
      T.left = insert(T.left, v);
      T.left.parent = T;
    } else return T;

    T.height = Math.max(height(T.left), height(T.right)) + 1;

    // Update Size
    T.size = size(T.left) + size(T.right) + 1;

    // Balance
    int balance = getBalance(T);

    // 4 cases
    // Left-Left Case
    if (balance > 1 && v < T.left.key)
      return rotateRight(T);

    // Right Right Case
    if (balance < -1 && v > T.right.key)
      return rotateLeft(T);

    // Left Right Case
    if (balance > 1 && v > T.left.key) {
      T.left = rotateLeft(T.left);
      return rotateRight(T);
    }
    
    // Right Left Case
    if (balance < -1 && v < T.right.key) {
      T.right = rotateRight(T.right);
      return rotateLeft(T);
    }

    return T;
  }

  public BSTVertex rotateLeft(BSTVertex T) {
    BSTVertex w = T.right;
    w.parent = T.parent;
    T.parent = w;
    T.right = w.left;
    if (w.left != null) 
      w.left.parent = T;
    w.left = T;

    T.height = Math.max(height(T.left), height(T.right)) + 1;
    w.height = Math.max(height(w.left), height(w.right)) + 1;

    T.size = size(T.left) + size(T.right) + 1;
    w.size = size(w.left) + size(w.right) + 1;

    return w;
  }

  public BSTVertex rotateRight(BSTVertex T) {
    BSTVertex w = T.left;
    w.parent = T.parent;
    T.parent = w;
    T.left = w.right;
    if (w.right != null)
      w.right.parent = T;
    w.right = T;

    T.height = Math.max(height(T.left), height(T.right)) + 1;
    w.height = Math.max(height(w.left), height(w.right)) + 1;

    T.size = size(T.left) + size(T.right) + 1;
    w.size = size(w.left) + size(w.right) + 1;

    return w;
  }

  public int findMin(BSTVertex T) {
    if (T.left == null) return T.key;                    // this is the min
    else return findMin(T.left);           // go to the left
  }

  public int successor(int v) { 
    BSTVertex vPos = search(root, v);
    return vPos == null ? -1 : successor(vPos);
  }

  public int successor(BSTVertex T) {
    if (T.right != null)                       // this subtree has right subtree
      return findMin(T.right);  // the successor is the minimum of right subtree
    else {
      BSTVertex par = T.parent;
      BSTVertex cur = T;
      // if par(ent) is not root and cur(rent) is its right children
      while ((par != null) && (cur == par.right)) {
        cur = par;                                         // continue moving up
        par = cur.parent;
      }
      return par == null ? -1 : par.key;           // this is the successor of T
    }
  }

  public void delete(int v) {
    if (root != null)
      root = delete(root, v);
  }

  public BSTVertex delete(BSTVertex T, int v) {
    if (T == null)  
      return T;              // cannot find the item to be deleted
    if (T.key < v)                                    // search to the right
      T.right = delete(T.right, v);
    else if (T.key > v)                               // search to the left
      T.left = delete(T.left, v);
    else {                                            // this is the node to be deleted
      if (T.left == null && T.right == null)                   // this is a leaf
        T = null;                                      // simply erase this node
      else if (T.left == null && T.right != null) {   // only one child at right        
        T.right.parent = T.parent;
        T = T.right;                                                 // bypass T        
      }
      else if (T.left != null && T.right == null) {    // only one child at left        
        T.left.parent = T.parent;
        T = T.left;                                                  // bypass T        
      }
      else {                                 // has two children, find successor
        int successorV = successor(v);
        T.key = successorV;         // replace this key with the successor's key
        T.right = delete(T.right, successorV);      // delete the old successorV
      }
    }

    if (T == null)  
      return T;   

    T.height = Math.max(height(T.left), height(T.right)) + 1;
    T.size = size(T.left) + size(T.right) + 1;

    int balance = getBalance(T);

    if (balance > 1 && getBalance(T.left) >= 0)
      return rotateRight(T);
 
        // Left Right Case
    if (balance > 1 && getBalance(T.left) < 0) {
      T.left = rotateLeft(T.left);
      return rotateRight(T);
    }
 
    // Right Right Case
    if (balance < -1 && getBalance(T.right) <= 0)
      return rotateLeft(T);

    // Right Left Case
    if (balance < -1 && getBalance(T.right) > 0) {
      T.right = rotateRight(T.right);
      return rotateLeft(T);
    }
    
    return T; 
  }
  
  public ArrayList<Integer> toArr() {
    out = new ArrayList<Integer>();
    toArr(root);
    return out;
  }

  public void toArr(BSTVertex T) {
    if (T == null) return;
    toArr(T.left);
    out.add(T.key);
    toArr(T.right);
  }

  public static void main(String[] args) {
    BST tree = new BST();
    tree.insert(1);
    tree.insert(2);
    tree.insert(3);
    tree.insert(4);
    tree.insert(5);
    tree.insert(6);

    tree.delete(2);

    ArrayList<Integer> new1 = tree.toArr();
    for(int j : new1) {
      //System.out.println(j);
    }
  }
  
}

