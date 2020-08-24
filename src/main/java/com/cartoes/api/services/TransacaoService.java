package com.cartoes.api.services;

import java.sql.Date;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.cartoes.api.entities.Transacao;
import com.cartoes.api.repositories.TransacaoRepository;
import com.cartoes.api.utils.ConsistenciaException;

public class TransacaoService {

	public Optional<Transacao> buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Date data1 = (Date) new java.text.SimpleDateFormat("dd/MM/yyyy").parse("01/01/2020");
	//Date data2 = (Date) new java.text.SimpleDateFormat("dd/MM/yyyy").parse("31/01/2020");
	
	//if (data1.before(data2))
		// System.out.println("A data 1 é anterior a data 2");
		//if (data2.after(data1))
		 //System.out.println("A data 2 é posterior a data 1");
	
//}
}