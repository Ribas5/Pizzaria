
public class main {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente("Julia", "rua 24 de março");
		Cliente c2 = new Cliente("Marcos", "rua 25 de março");
		Cliente c3 = new Cliente("Carlos", "rua 26 de março");
		Garcom g = new Garcom("Pedro", 1.200,22,"99646-8908");
		Motoboy m = new Motoboy("Jonh",1.000, 19, "98588-4556","52222");
		Cozinheiro coz = new Cozinheiro("Marta",1.800, 35, "98855-2356");
		
		g.anotarPedido(c1, 1, 5);
		g.anotarPedidoEntrega(c2, 1, c3.getEndereco());
		
		g.mandarCozinhar(coz);
		
		g.entregarPedido(1);
		g.mandarMotoboy(m);
		m.entregarPedido(2);

		
		
	}

}
