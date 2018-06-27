package programacionDinamica;

public class Mochila {

	public void solve(int[] peso, int[] valor,int pesoMaximo) {
		int N = 4; // items
		int W = 5; // max peso
		int[][] opt = new int[N][W]; //matriz que guarda el valor de cada esecenario
		boolean[][] sol = new boolean[N][W]; // guarda si el elemento está presente
		for (int n = 0; n < N; n++) {
			for (int w = 0; w < W; w++) {
				int option1 = n < 1 ? n : opt[n - 1][w]; //El peso antes de agregar el elemento n, si n es 0 el peso es 0
				int option2 = Integer.MIN_VALUE; //este valor es menor que cualquier otro entero
				if (peso[n]<=w) {
					if(n>0) {
						option2 = valor[n]+opt[n-1][w-peso[n]];
					}else {
						option2 = valor[n];					
					}
				}
				opt[n][w] = Math.max(option1, option2);
				sol[n][w] = (option2 > option1);
			}
		}
//		System.out.println("Matriz opt:");
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<W; j++) {
//				System.out.print(opt[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("\nMatriz sol:");
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<W; j++) {
//				System.out.print(sol[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		// determinar la combinación óptima
		boolean[] esSolucion= new boolean[N];
		for (int n = N-1, w = W-1; n >= 0; n--) {
			if (sol[n][w]) {
				esSolucion [n] = true;
				w = w - peso[n];
			} else {
				esSolucion [n] = false;
			}
		}
		int pesoOptimo = 0;
		for(int n=0; n<N; n++) {
			if(esSolucion[n]) {
				pesoOptimo+=peso[n];
				System.out.println("El objeto"+(n+1)+" es solucion y pesa: "+peso[n]+".");
			}
//			System.out.println("El peso optimo es: "+pesoOptimo);
		}
		System.out.println("El peso optimo es: "+pesoOptimo);
	}
	
}
