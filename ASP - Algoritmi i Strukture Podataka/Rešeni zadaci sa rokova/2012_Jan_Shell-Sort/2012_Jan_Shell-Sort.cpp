#include <iostream>
#include <ctime>
#include <cstdlib>
#include <iomanip>

using namespace std;

void shellsort(int* a, int* h,int n, int t)
{
  int inc;
  for (int i = 0; i < t; i++)
  {
	inc = h[i];
	int k;
	for (int j = inc; j < n; j++)
	{

	  int y = a[j];
	  k = j - inc;
	  while (k >= 0 && y < a[k])
	  {
		a[k + inc] = a[k];
		k = k - inc;
	  }
	  a[k + inc] = y;

	}
  }
}
void main()
{
  srand(time(NULL));

  int* a;
  int n;
  cout << "Duzina niza?";
  cin >> n;
  a = new int[n];
  for (int i = 0; i < n; i++) a[i] = rand() % 1000;

 ////////////
  int t = log(n) / log(3);
  int* h = new int[t];
  h[t-1] = 1;
  for (int i = t-1; i >= 0; i--) h[i - 1] = 3 * h[i] + 1;
 ////////////

  shellsort(a,h,n,t);
  for (int i = 0; i < n; i++)
  {
	cout << setw(3) << a[i] << ' ';
	if ((i + 1) % 20 == 0) cout << endl;
  }
}