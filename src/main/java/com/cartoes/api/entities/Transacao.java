package com.cartoes.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "transacao")
public class Transacao implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;

	@Column(name = "data_Transacao", nullable = false)
	private Date dataTransacao;
	
	@Column(name = "cnpj", nullable = false, length = 14, unique = true)
	private String cnpj;

	@Column(name = "valor", nullable = false)
	private Double valor;
	
	@Column(name = "qdt_Parcelas", nullable = false)
	private int qdtParcelas;
	
	@Column(name = "juros", nullable = false)
	private double juros;
	
	@Column(name = "cartao_id", nullable = false)
	private int cartaoid;
	
	@JsonBackReference
	 @ManyToOne(fetch = FetchType.EAGER)
	 private Cartao cartao;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	private List<Cartao> cartoes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getqdtParcelas() {
		return qdtParcelas;
	}
	
	public void setqdtParcelas() {
		this.qdtParcelas = qdtParcelas;
	}
	
	public double getJuros() {
		return juros;
	}
	
	public void setJuros() {
		this.juros = juros;
	}
	
	public List<Cartao> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<Cartao> cartoes) {
		this.cartoes = cartoes;
	}

	@PreUpdate
	public void preUpdate() {
		dataTransacao = new Date();
	}

	@PrePersist
	public void prePersist() {
		dataTransacao = new Date();
	}

	@Override
	public String toString() {
		return "Transacao[" + "id=" + id + "," + "dataTransacao=" + dataTransacao + "," + "cnpj=" + cnpj + "," + "valor=" + valor + ","
				+ "qdtParcelas=" + qdtParcelas + "," + "juros=" + juros + "," + "cartao=" + cartao + "]";
	}
}
