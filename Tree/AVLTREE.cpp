#include <bits/stdc++.h>
using namespace std;

class Node
{
public:
    int data, height;
    Node *left;
    Node *right;

    Node(int val)
    {
        data = val;
        height = 1;
        left = right = NULL;
    }
};

int getheight(Node *root)
{
    if (!root)
        return 0;

    return root->height;
}

int getBalance(Node *root){
    return getheight(root->left)-getheight(root->right);
}

// Right Rotation

Node* rightRotation(Node* root){
    Node* child=root->left;
    Node* childRight=child->right;

    child->right=root;
    root->left=childRight;

    // Update the height
    root->height=1+max(getheight(root->left),getheight(root->right));
    child->height=1+max(getheight(child->left),getheight(child->right));
    return child;
}

// Left Rotation

Node* leftRotation(Node* root){
    Node* child=root->right;
    Node* childLeft=child->left;

    child->left=root;
    root->right=childLeft;

    // Update the height
    root->height=1+max(getheight(root->left),getheight(root->right));
    child->height=1+max(getheight(child->left),getheight(child->right));
    return child;
}

Node *insert(Node *root, int key)
{
    // Doesn't exist
    if (!root)
        return new Node(key);

    // Exist hai
    if (key < root->data) // left side
        root->left = insert(root->left, key);
    else if (key > root->data) // right side
        root->right = insert(root->right, key);
    else
        return root; // Duplicate elements are not allowed

    // Update height

    root->height = 1 + max(getheight(root->left), getheight(root->right));

    // Balance check
    int balance=getBalance(root);

    // Left Left case
    if(balance>1 && key<root->left->data){
        return rightRotation(root);
    }
    
    // Right Right case
    else if(balance<-1 && root->right->data<key){
        return leftRotation(root);
    }
    
    // Left Right case
    else if(balance>1 && key>root->left->data){
        root->left=leftRotation(root->left);
        return rightRotation(root);
    }
    
    // Right Left case
    else if(balance<-1 && root->right->data>key){
        root->right=rightRotation(root->right);
        return leftRotation(root);
    }

    // No Unbalancing
    else{
        return root;
    }

}

void preorder(Node* root){
    if(!root)return;

    preorder(root->left);
    preorder(root->right);
    cout<<root->data<<" ";
}

void inorder(Node* root){
    if(!root)return;

    inorder(root->left);
    cout<<root->data<<" ";
    inorder(root->right);
}

Node* deleteNode(Node* root,int key){
    if(!root)return NULL;

    if(key<root->data){
        root->left=deleteNode(root->left,key);
    }
    else if(key>root->data){
        root->right=deleteNode(root->right,key);
    }else{
        // leaf node
        if(!root->left && !root->right){
            delete root;
            return NULL;
        }
        // only one child left
        else if(!root->right && root->left){ // left child
            Node* temp=root->left;
            delete root;
            return temp;
        }
        else if(!root->left && root->right){ // right child
            Node* temp=root->right;
            delete root;
            return temp;
        }
        // both child exist
        else{
            // right side smallest element
            Node* curr=root->right;
            while(curr->left){
                curr=curr->left;
            }
            root->data=curr->data;
            root->right=deleteNode(root->right,root->data);
        }
    }

    // Update the height
    root->height=1+max(getheight(root->left),getheight(root->right));

    // Check the balance
    int balance=getBalance(root);
    
    // Left side
    if(balance>1){
        // LL
        if(getBalance(root->left)>=0){
            return rightRotation(root);
        }
        // LR
        else{
            root->left=leftRotation(root->left);
            return rightRotation(root);
        }
    }
    // Right side
    else if(balance<-1){
        // RR
        if(getBalance(root->right)<=0){
            return leftRotation(root);
        }
        // RL
        else{
            root->right=rightRotation(root->right);
            return leftRotation(root);
        }
    }else{
        return root;
    }
}

int main()
{
    Node *root = NULL;

    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 50);
    root = insert(root, 60);
    root = insert(root, 70);
    root = insert(root, 80);
    root=deleteNode(root,50);

    cout<<"Preorder"<<endl;
    preorder(root);

    cout<<"Inorder"<<endl;
    inorder(root);
}