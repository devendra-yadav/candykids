package com.candykids.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="items")
public class Items {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="cost_price")
	@NumberFormat(style=Style.NUMBER)
	private double costPrice;
	
	@Column(name="selling_price")
	@NumberFormat(style=Style.NUMBER)
	private double sellingPrice;
	
	@Column(name="image_path")
	private String imagePath;
	
	@Column(name="quantity")
	@NumberFormat(style=Style.NUMBER)
	private int quantity;
	
	@Column(name="supplier")
	private String supplier;
	
	@Column(name="entry_date")
	private LocalDateTime entryDate=LocalDateTime.now();
	
	@Column(name="comments")
	private String comments;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="category_id")
	private Category category;
	
	public Items() {
		
	}

	public Items(String title, String description, double costPrice, double sellingPrice, String imagePath, int quantity,
			String supplier, String comments, Category category) {
	
		this.title = title;
		this.description = description;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.imagePath = imagePath;
		this.quantity = quantity;
		this.supplier = supplier;
		this.comments = comments;
		this.category = category;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", title=" + title + ", description=" + description + ", costPrice="
				+ costPrice + ", sellingPrice=" + sellingPrice + ", imagePath=" + imagePath + ", quantity=" + quantity
				+ ", supplier=" + supplier + ", entryDate=" + entryDate + ", comments=" + comments + ", category="
				+ category + "]";
	}
	
}
