#include "Stack.h"
#include <iostream>

using namespace std;


struct AVLNode
{
  AVLNode* left;
  AVLNode* right;
  int data;
  int hl, hr; //heightleft heightright

  AVLNode(int hll,int hrr, int dat,AVLNode* l = nullptr, AVLNode* r = nullptr)
	: hl(hll)
	, hr(hrr)
	, data(dat)
	, left(l)
	, right(r)
  {
  }

  ~AVLNode()
  {
	if (right != nullptr) delete right;
	else if (left != nullptr) delete left;
	else delete this;
  }
};

AVLNode* Adjust(Stack<AVLNode*>& S)
{
  AVLNode* Node = S.POP();
  AVLNode* Son = Node;
  while (!S.EMPTY())
  {
	AVLNode* aux = S.POP();
	if (Son == aux->right) aux->hr++;
	else aux->left++;
	if (abs(aux->hl - aux->hr) > 1) return aux;
	Son = aux;
  }
}
void main()
{
  try
  {
	//Ovo je deo gde se generise nekakav stek i stablo, sto se u zadatku pretpostavlja da vec imamo?
	//Pravi AVL stablo sa 238str, slika 9.8 c)
	Stack<AVLNode*> S;
	AVLNode* root = new AVLNode(1,2,6);
	root->left = new AVLNode(0,0,3);
	root->right = new AVLNode(1,1,9);
	root->right->left = new AVLNode(0,0,8);
	root->right->right = new AVLNode(0,0,11);
	S.PUSH(root);
	S.PUSH(root->right);
	S.PUSH(root->right->right);

	//Ubacuje novi cvor
	AVLNode* X = new AVLNode(0, 0, 10);
	root->right->right->left = X;
	S.PUSH(X);

	//Poziv trazene funkcije
	cout << Adjust(S)->data << endl;

  }
  catch (runtime_error e) { cout << endl<<e.what() << endl; }
}