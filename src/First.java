import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class First {
	
	public static void main(String[] args){
		double x, y1, y2, dy1;
		double a = 2;
		
		try {
			
			File f = new File("sigm.csv");
			PrintWriter pw = new PrintWriter(f);
			System.out.println("Start obliczen");
			for (x=-5; x<6; x+=0.2){
				y1 = 1/(1+Math.exp(-a*x));
				y2 = Math.tanh(a*x);
				dy1 = a*y1*(1-y1);
				pw.println(x+", "+y1+", "+y2+", "+dy1);
			}
			
			pw.close();
			System.out.println("Koniec obliczen");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
