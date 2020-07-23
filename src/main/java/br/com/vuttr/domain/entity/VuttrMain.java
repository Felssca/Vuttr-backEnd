package br.com.vuttr.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.jfr.Label;



@Entity
@Table(name="vuttr_main")
@ApiModel(description = "Entidade que representa o objeto Vuttr")
public class VuttrMain implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name="id_vuttr")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Length(min=3,max=200)
	@Label(value = "Title")
	@Column(name="txt_title")
	private String title;
	
	@NotBlank
	@Length(min=3,max=200)
	@Label(value = "Link")
	@Column(name="txt_link")
	private String link;
	
	@NotBlank
	@Length(min=3,max=200)
	@Label(value="Description of Tools")
	@Column(name="txt_description")
	private String description;

	
	@ManyToMany
	@JoinTable(name="vuttr_main_tags_list",
	joinColumns = @JoinColumn(name="fk_vuttr_main"),
	inverseJoinColumns = @JoinColumn(name="fk_vuttr_tags"))
	@ApiModelProperty(notes="Tabela Many-to-Many com tabela TAGS")
	private Collection <VuttrTags> tagsList = new ArrayList<VuttrTags>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Collection<VuttrTags> getTagsList() {
		return tagsList;
	}

	public void setTagsList(Collection<VuttrTags> tagsList) {
		this.tagsList = tagsList;
	}

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VuttrMain other = (VuttrMain) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	




	



}
