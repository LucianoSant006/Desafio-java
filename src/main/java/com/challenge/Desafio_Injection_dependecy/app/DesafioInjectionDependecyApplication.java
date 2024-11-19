package com.challenge.Desafio_Injection_dependecy.app;

import com.challenge.Desafio_Injection_dependecy.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.challenge.Desafio_Injection_dependecy.service.OrderService;
import com.challenge.Desafio_Injection_dependecy.service.ShippingService;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.challenge.Desafio_Injection_dependecy"})
public class DesafioInjectionDependecyApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {

		SpringApplication.run(DesafioInjectionDependecyApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite seu código de produto");
		int code = sc.nextInt();
		System.out.println("Digite o valor básico");
		double basicvalue = sc.nextDouble();
		System.out.println("Digite o desconto");
		double discount = sc.nextDouble();

		Order od = new Order(code,basicvalue,discount);
		OrderService service = new OrderService(new ShippingService());

		double result = service.Total(od);
		System.out.print("Código do pedido "+code);
		System.out.println();
		System.out.printf("Valor Total %.2f",result);

	}



}
