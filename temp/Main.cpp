#include <iostream>
#include <fstream>

using namespace std;
bool isPrime(int n){
    	for(int i = 2; i * i <= n; i++)
    		if(n % i == 0)
    			return false;
    	return true;
	}
    
int main(int argc, char *argv[]) {
  if (argc < 2) {
    cout << "Usage: " << argv[0] << " <input filename>\n";
    return 1;
  }

  ifstream fin(argv[1]);
    
  // Output file stream object to 
  // write to file2.txt
  ofstream f(argv[2]);
      
  int t;
  fin >> t;
  int num = (int)(1e7);
	int mod = (int)(1e9 + 7);
	long pow = 1;
	while(num>0){
		num -= (int)(rand() % 3);
		pow <<= 1; 
		pow %= mod;
	}
  while(t-->0){
    int n;
    fin >> n;
    for(int i = 2; i <= n; i++){
				if(isPrime(i))
					f << i << " ";
    }
    f << endl;
  }

  return 0;
}
