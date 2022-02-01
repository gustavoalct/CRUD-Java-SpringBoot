package com.projetoGustavo;

import com.projetoGustavo.domain.*;
import com.projetoGustavo.domain.enums.EstadoPagamento;
import com.projetoGustavo.domain.enums.TipoCliente;
import com.projetoGustavo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {  // instanciacao por meio do CommandLineRunner, permiti implementar um metodo auxiliar

	// Reponsavel por salvar no banco
	@Autowired // instancia automaticamente
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	// classe principal
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

	public void run(String... args) throws Exception{
		// popular o banco de dados
		Categoria cat1 = new Categoria(null, "Infmatica");
		Categoria cat2 = new Categoria(null, "Escritorio  ");

		// popular banco com produtos
		Produto p1 = new Produto(null,"Computador",2000.00); // categoria computador
		Produto p2 = new Produto(null,"Impressora",300.00); // categoria escitorio
		Produto p3 = new Produto(null,"mouse",80.00); // categoria computador

		// categoria recebe a instanciacao dos produtos
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		// a categoria 2 escritorio - somente a impressora esta associada
		cat2.getProdutos().addAll(Arrays.asList(p2));

		// produtos associando a categoria, TEM QUE FAZER PARA OS DOIS LADOS
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		// relacionando cada produto em sua categoria, Categoria repository responsavel por salvar no banco de dados
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));


		//Estado e cidade
		Estado est1 = new Estado(null, "MG");
		Estado est2 = new Estado(null, "SP");

		Cidade c1 = new Cidade(null, "Guape", est1);
		Cidade c2 = new Cidade(null, "Peruibe", est2 );
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1)); // relacionando no estado as cidades
		est2.getCidades().addAll(Arrays.asList(c2,c3));

		// salvar, ATENÇÃO NA ORDEM, 1:n o --> menor vem primeiro
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));

		Cliente cli1 = new Cliente(null, "Maria silva", "Maria@gmail.com", "123423767812", TipoCliente.PESSOAFISICA); // ṕossui dois telefones
		cli1.getTelefones().addAll(Arrays.asList("989098909", "9897909890"));

		Endereco e1 = new Endereco(null, "Aparecida silva", "315", "ap 120", "centro", "37177000", cli1, c1);
		Endereco e2 = new Endereco(null, "Joao silva", "3125", "ap 220", "centro", "37177010", cli1, c2);

		// cliente e seu endereco
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));


		// PEDIDOS
		// gerar uma data para inserir no banco
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyyy hh:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/02/2021 10:30"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("20/12/2011 23:19"), cli1, e2);

		// instanciar pagamentos
		Pagamento pgto1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pgto1);

		Pagamento pgto2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("10/09/2019 19:10"), null);
		ped2.setPagamento(pgto2);

		// associar o cliente com os pedidos
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));

		// salvar no banco de dados

		// PEDIDOS
		ItemPedido ip1 = new ItemPedido(ped1, p1, 2,2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 3, 90.00);
		ItemPedido ip3 = new ItemPedido (ped2, p2, 2, 800.90);

		// associar os itens de pedidos com os pedidos
		ped1.getItens().addAll(Arrays.asList(ip2, ip1));
		ped2.getItens().addAll(Arrays.asList(ip3));

		// associando itensPedidos aos produtos
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2, ip3));

	}

}
