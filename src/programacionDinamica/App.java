package programacionDinamica;

public class App {

	public static void main(String[] args) {
		Mochila m = new Mochila();
		int[] pesos = {3,2,1,2};
		int[] valor= {6,9,5,6};
		m.solve(pesos,valor,4);
	}

}
