import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EjRestaurante {

	public static void main(String[] args) {

		// Fase 1
		int cinco = 5;
		int diez = 10;
		int veinte = 20;
		int cinquenta = 50;
		int cien = 100;
		int doscientos = 200;
		int quinientos = 500;
		int precioTotal = 0;

		// patatas, ensalada, mejillones, pan, olivas
		// 400, 630, 380, 60, 85

		String[] platos = new String[5];
		int[] precios = new int[5];

		Scanner in = new Scanner(System.in);
		for (int i = 0; i < platos.length; i++) {
			System.out.println("Introduce los platos y los precios: ");
			platos[i] = in.next();
			precios[i] = in.nextInt();
		}
		System.out.println(Arrays.toString(platos));
		System.out.println(Arrays.toString(precios));

		ArrayList<String> platosPedidos = new ArrayList<>();

		// Fase 2
		boolean hambre = true;
		int respuesta;
		while (hambre) {
			System.out.println("Que quiere para comer?");
			platosPedidos.add(in.next());
			System.out.println("Quiere algo mas? Introduce por Si:1, por No:0");
			respuesta = in.nextInt();
			if (respuesta == 1) {
				hambre = true;
			} else if (respuesta == 0) {
				hambre = false;
			} else {
				hambre = true;
				System.out.println("Solo se puede introducir por Si:1, por No:0");
				respuesta = in.nextInt();
			}
		}
		System.out.println(platosPedidos);

		// Fase 3
		for (int i = 0; i < platos.length; i++) {
			if (platosPedidos.contains(platos[i])) {
				precioTotal += precios[i];
			}
		}
		System.out.println("precio total: " + precioTotal);

		ArrayList<String> newPlatos = new ArrayList<String>(Arrays.asList(platos));
		for (String platoPedido : platosPedidos) {
			if (!newPlatos.contains(platoPedido)) {
				System.out.println("el plato elegido" + platoPedido + " no existe");
			}
		}

	}
}