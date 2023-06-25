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
	int num = (int)(0);
	int mod = (int)(1e9 + 7);
	long pow = 1;
	while(num>0){
		num -= (int)(Math.random() * 5 + 1);
		pow <<= 1; 
		pow %= mod;
	}
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
