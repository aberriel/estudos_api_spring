package com.sinqia.teste_api.models.carros;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * A anotação @Data já adiciona os getter e setter
 */

@NoArgsConstructor
@Data
@Entity
public class Carro {
	
	public Carro() { }

	public Carro(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Carro(Long id, String nome, String descricao, String urlFoto, String urlVideo,
				 String latitude, String longitude, String tipo) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao != null ? descricao : "NO DESCRIPTION";
		this.urlFoto = urlFoto != null ? urlFoto : "NO PHOTO";
		this.urlVideo = urlVideo != null ? urlVideo : "NO VIDEO";
		this.latitude = latitude != null ? latitude : "";
		this.longitude = longitude != null ? longitude : "";
		this.tipo = tipo != null ? tipo : "";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }

	@Column(name="nome", length=255)
	private String nome;
	public String getNome() { return this.nome; }
	public void setNome(String nome) { this.nome = nome; }

	@Column(name="descricao", length=255, nullable=true)
	private String descricao;
	public String getDescricao() { return this.descricao; }
	public void setDescricao(String descricao) { this.descricao = descricao; }

	@Column(name="url_foto", length=255, nullable=true)
	private String urlFoto;
	public String getUrlFoto() { return this.urlFoto; }
	public void setUrlFoto(String urlFoto) { this.urlFoto = urlFoto; }

	@Column(name="url_video", length=255, nullable=true)
	private String urlVideo;
	public String getUrlVideo() { return this.urlVideo; }
	public void setUrlVideo(String urlVideo) { this.urlVideo = urlVideo; }

	@Column(name="latitude", length=255, nullable=true)
	private String latitude;
	public String getLatitude() { return this.latitude; }
	public void setLatitude(String latitude) { this.latitude = latitude; }

	@Column(name="longitude", length=255, nullable=true)
	private String longitude;
	public String getLongitude() { return this.longitude; }
	public void setLongitude(String longitude) { this.longitude = longitude; }

	@Column(name="tipo", length=255, nullable=true)
	private String tipo;
	public String getTipo() { return this.tipo; }
	public void setTipo(String tipo) { this.tipo = tipo; }
}