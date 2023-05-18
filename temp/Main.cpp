#include <iostream>
#include <fstream>

using namespace std;

int main(int argc, char *argv[]) {
  if (argc < 2) {
    cout << "Usage: " << argv[0] << " <input filename>\n";
    return 1;
  }

  ifstream in(argv[1]);
    
  // Output file stream object to 
  // write to file2.txt
  ofstream f(argv[2]);
      
  // Reading file.txt completely using 
  // END OF FILE eof() method
  while(!in.eof())
  {
    // string to extract line from 
    // file.txt
    string text;
        
    // extracting line from file.txt
    getline(in, text);
        
    // Writing the extracted line in 
    // file2.txt
    f << text << endl;
  }

  return 0;
}
