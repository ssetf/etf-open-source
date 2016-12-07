#include <iostream>
#include <iomanip>
using namespace std;

void Heapsort(int* a, int n)
{
  //Heap creation
  for (int i = 1; i < n; i++)
  {
	int NewHeapElement = a[i];
	int Son = i;
	int Father=Son/2;
	if (Son % 2 == 0)Father--;
	while (Son>0 && NewHeapElement < a[Father])
	{
	  a[Son] = a[Father];
	  Son = Father;
	  Father = Son / 2;
	  if (Son % 2 == 0) Father--;
	}
	a[Son] = NewHeapElement;
  }

  for (int i = n - 1; i > 0; i--)
  {
	int LastHeapElement = a[i];
	a[i] = a[0];
	int Father = 0;
	int Son;
	if (i > 2 && a[2] < a[1]) Son = 2;
	else Son = 1;

	//Places new largest element at root
	while (Son < i && a[Son] < LastHeapElement && i!=1)
	{
	  a[Father] = a[Son];
	  Father = Son;
	  Son = 2 * Father+1;
	  if ((Son + 1) <= (i - 1) && a[Son + 1] < a[Son]) Son++; //Takes the greater son
	}
	a[Father] = LastHeapElement;
  }
}
void main()
{
  int n;
  cout << 3 / 2;
  cout << "Duzina niza?";
  cin >> n;
  int* a = new int[n];
  cout << "\nUnesite clanove:";
  for (int i = 0; i < n; i++) cin >> a[i];
  cout << "\nSortirani niz je:\n";
  Heapsort(a, n);
  for (int i = 0; i < n; i++) cout << setw(3) << a[i];
}