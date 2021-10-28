import java.util.ArrayList;

class AVLVertex {

  public AVLVertex parent, left, right;
  public int key;
  public int height;
  public int size; 

  AVLVertex(int v) {
    key = v; 
    parent = left = right = null; 
    height = 0; 
    size = 1;
  }
}

class AVL {
  public AVLVertex root;
  ArrayList<Integer> out;

  public AVL() { root = null; }

  public int size() {
    return size(root);
  }

  public int size(AVLVertex T) {
    if (T == null)
        return 0;
    return T.size;
  }

  public int height(AVLVertex T) {
    if (T == null)
        return -1;
    return T.height;
  }

  public AVLVertex search(AVLVertex T, int v) {
    if (T == null)  return null;                     // not found
    else if (T.key == v) return T;                        // found
    else if (T.key < v)  return search(T.right, v);       // search to the right
    else                 return search(T.left, v);        // search to the left
  }

  public int findMin(AVLVertex T) {
    if (T.left == null) return T.key;                    // this is the min
    else return findMin(T.left);           // go to the left
  }

  public int successor(int v) { 
    AVLVertex vPos = search(root, v);
    return vPos == null ? -1 : successor(vPos);
  }

  public int successor(AVLVertex T) {
    if (T.right != null)                       // this subtree has right subtree
      return findMin(T.right);  // the successor is the minimum of right subtree
    else {
      AVLVertex par = T.parent;
      AVLVertex cur = T;
      // if par(ent) is not root and cur(rent) is its right children
      while ((par != null) && (cur == par.right)) {
        cur = par;                                         // continue moving up
        par = cur.parent;
      }
      return par == null ? -1 : par.key;           // this is the successor of T
    }
  }

  public int balanceFactor(AVLVertex T) {
    if (T == null)
        return 0;
    return height(T.left) - height(T.right);
  }

  public void insert(int v) { 
    root = insert(root, v); 
  }

  public AVLVertex insert(AVLVertex T, int v) {
    if (T == null) 
      return new AVLVertex(v);

    if (T.key < v) { // search to the right
      T.right = insert(T.right, v);
      T.right.parent = T;
    }
    else if (T.key > v) { //search to the left
      T.left = insert(T.left, v);
      T.left.parent = T;
    } else return T; // unqiue case

    T.height = Math.max(height(T.left), height(T.right)) + 1;

    // Update Size
    T.size = size(T.left) + size(T.right) + 1;

    // Balance
    int balance = balanceFactor(T);

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

  public AVLVertex rotateLeft(AVLVertex T) {

    AVLVertex w = T.right;
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

  public AVLVertex rotateRight(AVLVertex T) {

    AVLVertex w = T.left;
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

  public void delete(int v) {
    if (root != null)
      root = delete(root, v);
  }

  public AVLVertex delete(AVLVertex T, int v) {
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

    int balance = balanceFactor(T);

    if (balance > 1 && balanceFactor(T.left) >= 0)
      return rotateRight(T);
 
        // Left Right Case
    if (balance > 1 && balanceFactor(T.left) < 0) {
      T.left = rotateLeft(T.left);
      return rotateRight(T);
    }
 
    // Right Right Case
    if (balance < -1 && balanceFactor(T.right) <= 0)
      return rotateLeft(T);

    // Right Left Case
    if (balance < -1 && balanceFactor(T.right) > 0) {
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

  public void toArr(AVLVertex T) {
    if (T == null) return;
    toArr(T.left);
    out.add(T.key);
    toArr(T.right);
  }

  public void inorder() { 
    inorder(root);
    System.out.println();
  }

  // helper method to perform inorder traversal
  public void inorder(AVLVertex T) {
    if (T == null) return;
    inorder(T.left);                               // recursively go to the left
    System.out.printf(" %d", T.key);                      // visit this BST node
    inorder(T.right);                             // recursively go to the right
  }

  
  public static void main(String[] args) {
    AVL T = new AVL();
    /*
    ArrayList<Integer> new1 = tree.toArr();
    for(int j : new1) {
      System.out.println(j);
    }*/

    T.insert(15);
    T.insert(23);
    T.insert(6);
    T.insert(71);
    T.insert(50);
    T.insert(4);
    T.insert(7);
    T.insert(5);


    T.inorder(); 
  }
  
}

