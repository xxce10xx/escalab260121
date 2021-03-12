package com.bardalez.pagoSAGA.consumer;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.bardalez.pagoSAGA.model.Card;
import com.bardalez.pagoSAGA.model.Compra;
import com.bardalez.pagoSAGA.model.TXCompra;
import com.bardalez.pagoSAGA.producer.EventSenderMessage;
import com.bardalez.pagoSAGA.repository.CardRepository;
import com.bardalez.pagoSAGA.repository.CompraRepository;


public class EventConsumer {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private EventSenderMessage eventSenderMessage;
	
	//@Autowired
	//private EventSenderMessage eventSenderMessage;

	@RabbitListener(queues="pagoSAGA")
	public void receive(TXCompra txCompra) {
		
		Optional<Card> cardTemp = cardRepository.findById(txCompra.getCodCard());
		
		if(cardTemp.isPresent()) {
			double sumaGastos = 0;
			double costoCompra = txCompra.getPrecioUnitario()*txCompra.getUnidades();
			
			List<Compra> compras = cardTemp.get().getCompras();
			for(Compra compra : compras) {
				sumaGastos += compra.getGasto();
			}
			
			if((cardTemp.get().getSaldoOriginal() - sumaGastos) >= costoCompra) {
				Compra compraTemp = new Compra(cardTemp.get(),costoCompra, new Date());
				compraRepository.save(compraTemp);
			}else {
				eventSenderMessage.sendMessage(txCompra);
			}
			
		}
	
	}
}
