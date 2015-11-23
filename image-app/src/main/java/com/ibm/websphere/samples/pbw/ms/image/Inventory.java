/*******************************************************************************
 * Copyright (c) 2015 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.ibm.websphere.samples.pbw.ms.image;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
 
@Entity(name="Inventory")
@Table(name="INVENTORY", schema="APP")
@NamedQueries({@javax.persistence.NamedQuery(name="getItemsByCategory", query="select i from Inventory i where i.category = :category ORDER BY i.inventoryId"), @javax.persistence.NamedQuery(name="getItemsLikeName", query="select i from Inventory i where i.name like :name"), @javax.persistence.NamedQuery(name="removeAllInventory", query="delete from Inventory")})
public class Inventory implements Cloneable, Serializable {
	private static final long serialVersionUID = 7334114928798997450L;
	private static final int DEFAULT_MINTHRESHOLD = 50;
	private static final int DEFAULT_MAXTHRESHOLD = 200;
 
	@Id
	private String inventoryId;
	private String name;
	private String heading;
	private String description;
	private String pkginfo;
	private String image;
	private byte[] imgbytes;
	private float price;
	private float cost;
	private int quantity;
	private int category;
	private String notes;
	private boolean isPublic;
	private int minThreshold;
	private int maxThreshold;
 
	public Inventory() {
	}
 
	public Inventory(String key, String name, String heading, String desc, String pkginfo, String image, float price, float cost, int quantity, int category, String notes, boolean isPublic) {
		setInventoryId(key);
		setName(name);
		setHeading(heading);
		setDescription(desc);
		setPkginfo(pkginfo);
		setImage(image);
		setPrice(price);
		setCost(cost);
		setQuantity(quantity);
		setCategory(category);
		setNotes(notes);
		setIsPublic(isPublic);
		setMinThreshold(50);
		setMaxThreshold(200);
	}
 
	public Inventory(Inventory item) {
		setInventoryId(item.getInventoryId());
		setName(item.getName());
		setHeading(item.getHeading());
		setDescription(item.getDescription());
		setPkginfo(item.getPkginfo());
		setImage(item.getImage());
		setPrice(item.getPrice());
		setCost(item.getCost());
		setQuantity(item.getQuantity());
		setCategory(item.getCategory());
		setNotes(item.getNotes());
		setMinThreshold(50);
		setMaxThreshold(200);
		setIsPublic(item.isPublic());
	}
 
	public void increaseInventory(int quantity) {
		setQuantity(getQuantity() + quantity);
	}
 
	public int getCategory() {
		return this.category;
	}
 
	public void setCategory(int category) {
		this.category = category;
	}
 
	public float getCost() {
		return this.cost;
	}
 
	public void setCost(float cost) {
		this.cost = cost;
	}
 
	public String getDescription() {
		return this.description;
	}
 
	public void setDescription(String description) {
		this.description = description;
	}
 
	public String getHeading() {
		return this.heading;
	}
 
	public void setHeading(String heading) {
		this.heading = heading;
	}
 
	public String getImage() {
		return this.image;
	}
 
	public void setImage(String image) {
		this.image = image;
	}
 
	public String getName() {
		return this.name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	 
	public String getNotes() {
		return this.notes;
	}
 
	public void setNotes(String notes) {
		this.notes = notes;
	}
 
	public String getPkginfo() {
		return this.pkginfo;
	}
 
	public void setPkginfo(String pkginfo) {
		this.pkginfo = pkginfo;
	}
 
	public float getPrice() {
		return this.price;
	}
 
	public void setPrice(float price) {
		this.price = price;
	}
 
	public int getQuantity() {
		return this.quantity;
	}
 
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
 
	public int getMaxThreshold() {
		return this.maxThreshold;
	}
 
	public void setMaxThreshold(int maxThreshold) {
		this.maxThreshold = maxThreshold;
	}
 
	public int getMinThreshold() {
		return this.minThreshold;
	}
 
	public void setMinThreshold(int minThreshold) {
		this.minThreshold = minThreshold;
	}
 
	public String getInventoryId() {
		return this.inventoryId;
	}
 
	public void setInventoryId(String id) {
		this.inventoryId = id;
	}
 
	public String getID() {
		return this.inventoryId;
	}
 
	public void setID(String id) {
		this.inventoryId = id;
	}
 
	public boolean isPublic() {
		return this.isPublic;
	}
 
	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
 
	public void setPrivacy(boolean isPublic) {
		setIsPublic(isPublic);
	}
 
	public byte[] getImgbytes() {
		return this.imgbytes;
	}
 
	public void setImgbytes(byte[] imgbytes) {
		this.imgbytes = imgbytes;
	}
}
