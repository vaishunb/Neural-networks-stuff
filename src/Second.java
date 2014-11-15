import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Second {

	public static void main(String[] args) {
		
		double x0, x1, x2; // neuron inputs
		double w0, w1, w2; // weights
		double z; // AND - 4th column of data, using for teaching
		double u; // Neuron (Adder) - sum of all impulses
		double y; // Output - OR?
		double deps, eps;
		double[][] x = new double[][] { { 1, 0, 0, 0 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 }, { 1, 1, 1, 1 } }; //data
		double a = 2; // must be not too height
		double alfa = 0.1; // Learning rate
		
		w0 = Math.random();
		w1 = Math.random();
		w2 = Math.random();

		try {

			File f = new File("sigm2.csv");
			PrintWriter pw = new PrintWriter(f);

			for (int i = 1; i < 200; i++) {
				for (int j = 0; j < 4; j++) {
					x0 = x[j][0];
					x1 = x[j][1];
					x2 = x[j][2];
					z = x[j][3];
					u = w0*x0 + w1*x1 + w2*x2; //(added x0) NEURON - is a sum of all impulses (implulse: Wi*Xi)
					y = 1 / (1 + Math.exp(-a * u));
					deps = (y - z) * a * y * (1 - y);
					w0 = w0 - alfa * deps * x0; //(added x0 and changed w1 to w0)
					w1 = w1 - alfa * deps * x1; // update every weight
					w2 = w2 - alfa * deps * x2;
					eps = 0.5 * (y - z) * (y - z);
					pw.println(i + ", " + j + ", " + w0 + ", " + w1 + ", " + w2 + ", " + eps );
				}

//				for (int j = 0; j < 4; j++) {
//					x0 = x[j][0];
//					x1 = x[j][1];
//					x2 = x[j][2];
//					z = x[j][3];
//					u = w0 + w1 * x1 + w2 * x2;
//					y = 1 / (1 + Math.exp(-a * u));
//					pw.println(x0 + ", " + x1 + ", " + x2 + ", " + z + ", " + y);
//				}

			}

			pw.close();
			System.out.println("Koniec obliczen");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
