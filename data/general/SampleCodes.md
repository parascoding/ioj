# Samle Codes

## C++
```cpp=
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
```

## Java
```java=
import java.io.BufferedReader;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Get the path to the file to read from.
        File inputFile = new File("input.txt");

        // Create a BufferedReader to read from the file.
        BufferedReader br = new BufferedReader(new FileReader(args[0]));

        // Create a PrintWriter to write to the output file.
        PrintWriter ot = new PrintWriter(new FileWriter(args[1]));

        // Read each line from the file and write it to the output file.
        int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			int n = Integer.parseInt(br.readLine().trim());
			for(int i = 2; i <= n; i++){
				if(isPrime(i))
					ot.print(i + " ");
			}
			ot.println();
		}

        // Close the BufferedReader and PrintWriter.
        br.close();
        ot.close();
    }
    static boolean isPrime(int n){
    	for(int i = 2; i * i <= n; i++)
    		if(n % i == 0)
    			return false;
    	return true;
	}
    
}
```