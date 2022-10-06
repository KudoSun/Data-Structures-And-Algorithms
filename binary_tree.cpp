#include <bits/stdc++.h>
using namespace std;

class Node {
public:
	int data;
	Node* left;
	Node* right;

	// Val is the key or the value that
	// has to be added to the data part
	Node(int val)
	{
		data = val;

		// Left and right child for node
		// will be initialized to null
		left = NULL;
		right = NULL;
	}
};

//function for inorder traversal
vector<int> in_itr(Node* root){
    vector<int> inorder;
    if(root == NULL){
        return inorder;
    }
    stack<Node*> s;
    Node* temp = root;
    while(true){
        if(temp != NULL){
            s.push(temp);
            temp = temp->left;
        }
        else{
            if(s.empty()) break;
            temp = s.top();
            s.pop();
            inorder.push_back(temp->data);
            temp = temp->right;
        }
        
    }
    return inorder;
}


int main()
{

	/*create root*/
	Node* root = new Node(1);
	/* following is the tree after above statement

			1
			/ \
		NULL NULL
	*/

	root->left = new Node(2);
	root->right = new Node(3);
	/* 2 and 3 become left and right children of 1
				1
				/ \
				2	 3
			/ \	 / \
			NULL NULL NULL NULL
	*/

	root->left->left = new Node(4);
	/* 4 becomes left child of 2
			1
			/ \
		2	 3
		/ \	 / \
		4 NULL NULL NULL
		/ \
	NULL NULL
	*/

    vector<int> ans = in_itr(root);
    //printing inorder traversal
    for(int i=0;i<ans.size();i++){
        cout<<ans[i]<<" ";
    }

	return 0;
}
