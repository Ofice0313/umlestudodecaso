package com.caleb.umlestudodecaso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caleb.umlestudodecaso.domain.Address;
import com.caleb.umlestudodecaso.domain.Category;
import com.caleb.umlestudodecaso.domain.City;
import com.caleb.umlestudodecaso.domain.Client;
import com.caleb.umlestudodecaso.domain.ItemOrder;
import com.caleb.umlestudodecaso.domain.Payment;
import com.caleb.umlestudodecaso.domain.PaymentWithBillet;
import com.caleb.umlestudodecaso.domain.PaymentWithCard;
import com.caleb.umlestudodecaso.domain.Pedido;
import com.caleb.umlestudodecaso.domain.Product;
import com.caleb.umlestudodecaso.domain.State;
import com.caleb.umlestudodecaso.domain.enums.StatePayment;
import com.caleb.umlestudodecaso.domain.enums.TypeClient;
import com.caleb.umlestudodecaso.repositories.AddressRepository;
import com.caleb.umlestudodecaso.repositories.CategoryRepository;
import com.caleb.umlestudodecaso.repositories.CityRepository;
import com.caleb.umlestudodecaso.repositories.ClientRepository;
import com.caleb.umlestudodecaso.repositories.ItemPedidoRepository;
import com.caleb.umlestudodecaso.repositories.PaymentRepositoriy;
import com.caleb.umlestudodecaso.repositories.PedidoRepository;
import com.caleb.umlestudodecaso.repositories.ProductRepository;
import com.caleb.umlestudodecaso.repositories.StateRepository;

@SpringBootApplication
public class UmlestudodecasoApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PaymentRepositoriy paymentRepositoriy;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(UmlestudodecasoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		State state1 = new State(null, "Minais Gerais");
		State state2 = new State(null, "São Paulo");
		
		City city1 = new City(null, "Uberlândia", state1);
		City city2 = new City(null, "São Paulo", state2);
		City city3 = new City(null, "Campinas", state2);
		
		state1.getCities().addAll(Arrays.asList(city1));
		state2.getCities().addAll(Arrays.asList(city2, city3));
		
		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(city1, city2, city3));
		
		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "2334411233", TypeClient.NATURAL_PERSON);
		
		cli1.getPhones().addAll(Arrays.asList("879073527", "845367282"));
		
		Address address1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "5355262", cli1, city1);
		Address address2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, city2);
		
		cli1.getAddresses().addAll(Arrays.asList(address1, address2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(address1, address2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido pedido1 = new Pedido(null,sdf.parse( "30/09/2024 00:00"), cli1, address1);
		Pedido pedido2 = new Pedido(null,sdf.parse( "10/10/2024 00:00"), cli1, address2);
		
		Payment payment1 = new PaymentWithCard(null, StatePayment.PAID_OFF, pedido1, 6);
		pedido1.setPayment(payment1);
		
		Payment payment2 = new PaymentWithBillet(null, StatePayment.PENDENT, pedido2, sdf.parse("20/07/2024 00:00"), null);
		pedido2.setPayment(payment2);
		
		cli1.getOrders().addAll(Arrays.asList(pedido1, pedido2)); 
		
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		paymentRepositoriy.saveAll(Arrays.asList(payment1, payment2));
		
		ItemOrder io1 = new ItemOrder(pedido1, p1, 0.00, 1, 2000.00);
		ItemOrder io2 = new ItemOrder(pedido1, p3, 0.00, 2, 80.00);
		ItemOrder io3 = new ItemOrder(pedido2, p2, 100.00, 1, 800.00);
		
		pedido1.getItens().addAll(Arrays.asList(io1, io2));
		pedido2.getItens().addAll(Arrays.asList(io3));
		
		p1.getItens().addAll(Arrays.asList(io1));
		p2.getItens().addAll(Arrays.asList(io3));
		p3.getItens().addAll(Arrays.asList(io2));
		
		itemPedidoRepository.saveAll(Arrays.asList(io1, io2, io3));
		

	}

}
