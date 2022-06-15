package reto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Reto_NUWE_main {

	public static void main(String[] args) {
		
		System.out.println(isMerge("xcyc", "xc", "yc"));
		System.out.println(isMerge("xcyc", "yc", "xc"));
		System.out.println(isMerge("xcyc", "xc", "cy"));
		System.out.println(isMerge("xcyc", "cy", "xc"));
		System.out.println(isMerge("programar", "progr", "amar"));
		System.out.println(isMerge("programar", "pgr", "roamar"));
		System.out.println(isMerge("Making progress", "Mak pross", "inggre"));
		System.out.println(isMerge("More progress", "More ess", "pro"));
		System.out.println(isMerge("programar", "pro", "pro"));
	}

	public static boolean isMerge(String w, String grupo1, String grupo2) {
		/* Método que retorna true si grupo1 y grupo2 pueden formar, si no, retorna false w*/
		
		boolean isMerge = true; // booleana a retornar
		
		// Primero eliminamos el caso en que las longitudes no coinciden.
		
		int wordSize = w.length();
		int grupo1Size = grupo1.length();
		int grupo2Size = grupo2.length();
		
		if (wordSize != (grupo1Size + grupo2Size)) {	// Si grupo1 y grupo2 juntas tienen un tamaño diferente al de w
			isMerge = false;							// no pueden formar w.
		}
		
		// Si las longitudes coinciden, vamos eliminando letra a letra de w según vayamos encontrando
		// una pareja en grupo1 o grupo2, también eliminando la respectiva letra de éstos.
		
		while (isMerge && w.length() > 0) {				
			
			// Inicializo las variables con las que voy a hacer las comparaciones
			// Son strings porque puede ser que necesite comparar carácteres seguidos.
			String wcomp = String.valueOf(w.charAt(0));
			String comp1 = "", comp2 = "";
			
			grupo1Size = grupo1.length();
			grupo2Size = grupo2.length();
			
			// Elimino la posibilidad de acceder a un carácter de los grupos si éstos tienen tamaño 0
			if (grupo1Size > 0) comp1 = String.valueOf(grupo1.charAt(0));
			if (grupo2Size > 0) comp2 = String.valueOf(grupo2.charAt(0));

			// Si la primera letra de cada grupo es igual a la primera letra de w,
			// seguimos añadiendo letras de cada grupo a las variables para comparar
			// para ver si los carácteres siguientes también coinciden con los siguientes de w.
			
			if (wcomp.equals(comp1) && wcomp.equals(comp2)) {
				int contador = 1;										// El contador empieza en 1 porque ya tenemos guardado el charAt(0)
				int max = Math.min(grupo1Size, grupo2Size);				// El límite del contador será la longitud mínima de los grupos
				
				while (comp1.equals(comp2) && contador < max) {			// Mientras sean iguales, seguims añadiendo carácteres.
					comp1 += String.valueOf(grupo1.charAt(contador));
					comp2 += String.valueOf(grupo2.charAt(contador));
				}
			}	
			
			// La string que queremos comparar de w tiene que ser de tamaño igual al mínimo 
			// de las longitudes de los strings a comparar de los grupos.
			int maxPos = Math.min(comp1.length(), comp2.length());
			wcomp = w.substring(0, maxPos);
			
			// Comparamos si wcomp es igual a algún string, y si no, es que
			// no coinciden las letras y no se puede formar la palabra con los grupos
			if (wcomp.equals(comp1)) {
				w = w.substring(1,w.length());
				grupo1 = grupo1Size > 1 ? grupo1.substring(1,grupo1Size) : "";
				
			} else if (wcomp.equals(comp2)) {
				w = w.substring(1,w.length());
				grupo2 = grupo2Size > 1 ? grupo2.substring(1,grupo2Size) : "";
				
			} else {
				isMerge = false;
			}
			
		}
		return isMerge;
	}
}
