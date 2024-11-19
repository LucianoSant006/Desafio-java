package com.challenge.Desafio_Injection_dependecy;

import com.challenge.Desafio_Injection_dependecy.entities.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.OrderService;
import service.ShippingService;
import service.TaxService;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioInjectionDependecyApplication implements CommandLineRunner {
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

	public static void main(String[] args) {
		SpringApplication.run(DesafioInjectionDependecyApplication.class, args);
	}

}
