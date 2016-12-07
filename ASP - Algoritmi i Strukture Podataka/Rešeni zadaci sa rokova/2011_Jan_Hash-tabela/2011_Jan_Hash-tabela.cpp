#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

void INSERT(int* hash, int t, int& cnt)
{
  int addr;
  addr = t % 7;
  cnt++;
  while (hash[addr] != -1)
  {
	addr = (addr + 4 + t % 3) % 7;
	cnt++;
  }
  hash[addr] = t;
}
void main()
{
  int* hash = new int[7];
  for (int i = 0; i < 7; i++) hash[i] = -1;
  cout << "Unesite broj kljuceva:";
  int n;
  cin >> n;

  int cnt = 0;
  double Pnu = (7 - (double)n) / 7;
  double f = (double)n / 7;
  double m = n;
  double q = 7;
  for (int i = 0; i < n && i < 7; i++)
  {
	int t;
	cin >> t;
	if (i>0)
	{
	  Pnu += (i+1)*f*((7-double(n))/(q-1));
	  f *= (m - 1) / (q - 1);
	  m--; q--;
	}
	
	INSERT(hash, t, cnt);
  }
  Pnu += (n + 1)*f*((7 - double(n)) / (q - 1));
  for (int i = 0; i < 7; i++) cout << setw(3) << i << " ";
  cout << endl;
  for (int i = 0; i < 7; i++) cout << setw(3) << ((hash[i] != -1) ? to_string(hash[i]) : " ") << ' ';
  cout << endl << "Prosecan broj pristupa prilikom uspesne: " << (double)cnt / (double)n;
  cout << endl << "Prosecan broj pristupa prilikom neuspesne: " << Pnu << "  ALPHA: " << 1 / (1 - (double)n / 7) << endl;
}