package com.cartoes.api.controllers;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cartoes.api.entities.Transacao;
import com.cartoes.api.services.TransacaoService;
import com.cartoes.api.services.TransacaoService;
import com.cartoes.api.utils.ConsistenciaException;

@RestController
@RequestMapping("/api/transacao")
@CrossOrigin(origins = "*")
public class TransacaoController {

	private static final Logger log = LoggerFactory.getLogger(TransacaoController.class);
	@Autowired
	private TransacaoService TransacaoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Transacao> buscarPorId(@PathVariable("id") int id) {
		try {
			log.info("Controller: buscando cliente com id: {}", id);

			Optional<Transacao> transacao = TransacaoService.buscarPorId(id);
			return ResponseEntity.ok(transacao.get());
		} catch (Exception e) {
			log.error("Controller: Ocorreu um erro na aplicação: {}", e.getMessage());
			return ResponseEntity.status(500).body(new Transacao());
		}
	}
}
