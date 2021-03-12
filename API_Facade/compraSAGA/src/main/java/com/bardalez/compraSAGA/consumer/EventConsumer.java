package com.bardalez.compraSAGA.consumer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.bardalez.compraSAGA.model.Compra;
import com.bardalez.compraSAGA.model.CompraPK;
import com.bardalez.compraSAGA.model.TXCompra;
import com.bardalez.compraSAGA.producer.EventSenderMessage;
import com.bardalez.compraSAGA.repository.CompraRepository;

public class EventConsumer {
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private EventSenderMessage eventSenderMessage;

	@RabbitListener(queues="compraSAGA")
	public void receive(TXCompra txCompra) {
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy");
		String date_guardar = dateformat.format(date);
		try {
			Date newDate = dateformat.parse(date_guardar);
			Compra compraTemp = new Compra(new CompraPK(txCompra.getCodUser(),txCompra.getCodProd(), newDate),txCompra.getUnidades(),txCompra.getPrecioUnitario());
			compraRepository.save(compraTemp);
			
			//enviar el evento
			txCompra.setDate(newDate);
		    eventSenderMessage.sendMessage(txCompra);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}	
	}
	
	@RabbitListener(queues="rollbackCompra")
	public void receiveRollback(TXCompra txCompra) {
		//transaccion de compensacion
		Optional<Compra> compraTemp = compraRepository.findById(new CompraPK(txCompra.getCodUser(),txCompra.getCodProd(),txCompra.getDate()));
		compraRepository.delete(compraTemp.get());	
	}
}
