package com.pack.model;

public class Inventory {
	private String usrid,pid;
	private int instock,buffer,pending;
	public Inventory()
	{
		super();
	}
	public Inventory(String usrid, String pid, int instock, int buffer, int pending) {
		super();
		this.usrid = usrid;
		this.pid = pid;
		this.instock = instock;
		this.buffer = buffer;
		this.pending = pending;
	}
	public String getUsrid() {
		return usrid;
	}
	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getInstock() {
		return instock;
	}
	public void setInstock(int instock) {
		this.instock = instock;
	}
	public int getBuffer() {
		return buffer;
	}
	public void setBuffer(int buffer) {
		this.buffer = buffer;
	}
	public int getPending() {
		return pending;
	}
	public void setPending(int pending) {
		this.pending = pending;
	}
	
	
	
}
