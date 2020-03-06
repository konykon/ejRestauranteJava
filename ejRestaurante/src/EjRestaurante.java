import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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
		double precioTotal = 0.0;

		String[] platos = new String[5];
		Double[] precios = new Double[5];

		Scanner in = new Scanner(System.in);
		for (int i = 0; i < platos.length; i++) {
			System.out.println("Introduce los platos y los precios: ");
			platos[i] = in.next();
			precios[i] = in.nextDouble();
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
		ArrayList<String> newPlatos = new ArrayList<>(Arrays.asList(platos));
		for (String platoPedido : platosPedidos) {
			if (!newPlatos.contains(platoPedido)) {
				System.out.println("el plato elegido " + platoPedido + " no existe");
			}
		}

		HashMap<String, Double> carta = new HashMap<>();
		for (int i = 0; i < platos.length; i++) {
			carta.put(platos[i], precios[i]);
		}

		HashMap<String, Double> order = new HashMap<>();
		for (String plato : platosPedidos) {
			Double count = order.get(plato);
			if (count == null) {
				count = 0.0;
			}
			order.put(plato, count + 1);
		}

		for (Map.Entry<String, Double> key : order.entrySet()) {
			String orderKey = key.getKey();
			if (!carta.containsKey(orderKey)) {
				order.remove(orderKey, key.getValue());
			}
		}

		for (String key : order.keySet()) {
			double quantity = order.get(key);
			double price = carta.get(key);
			precioTotal += quantity * price;
		}

		System.out.println("precio total: " + precioTotal);

	}
}