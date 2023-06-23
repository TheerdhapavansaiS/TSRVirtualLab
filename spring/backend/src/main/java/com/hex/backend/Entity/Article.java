package com.hex.backend.Entity;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.hex.backend.Generators.StringPrefixedSeqIdGenerator;

@Entity
@Table(name="article")
public class Article {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "art_seq")
	@GenericGenerator(name = "art_seq",
		strategy="com.hex.backend.Generators.StringPrefixedSeqIdGenerator",
		parameters = {
				@Parameter(name = StringPrefixedSeqIdGenerator.INCREMENT_PARAM, value = "1"),
				@Parameter(name = StringPrefixedSeqIdGenerator.VALUE_PREFIX_PARAMETER, value = "ART"),
				@Parameter(name = StringPrefixedSeqIdGenerator.NUMBER_FORMAT_PARAMETER, value = "30%03d")
		})
	@Column(name="artid")
	private String artId;
	@Column(name="arttitle")
	private String artTitle;
	@Column(name="artdesc")
	private String artDesc;
	@Column(name="artdate")
	private Date artDate;
	@Column(name="artcatname")
	private String artCatName;
	

	public Article() {
		
	}


	public Article(String artId, String artTitle, String artDesc, Date artDate, String artCatName) {
		super();
		this.artId = artId;
		this.artTitle = artTitle;
		this.artDesc = artDesc;
		this.artDate = artDate;
		this.artCatName = artCatName;
	}


	public String getArtId() {
		return artId;
	}


	public void setArtId(String artId) {
		this.artId = artId;
	}


	public String getArtTitle() {
		return artTitle;
	}


	public void setArtTitle(String artTitle) {
		this.artTitle = artTitle;
	}


	public String getArtDesc() {
		return artDesc;
	}


	public void setArtDesc(String artDesc) {
		this.artDesc = artDesc;
	}


	public Date getArtDate() {
		return artDate;
	}


	public void setArtDate(Date artDate) {
		this.artDate = artDate;
	}


	public String getArtCatName() {
		return artCatName;
	}


	public void setArtCatName(String artCatName) {
		this.artCatName = artCatName;
	}


	@Override
	public String toString() {
		return "Article [artId=" + artId + ", artTitle=" + artTitle + ", artDesc=" + artDesc + ", artDate=" + artDate
				+ ", artCatName=" + artCatName + "]";
	}

}
