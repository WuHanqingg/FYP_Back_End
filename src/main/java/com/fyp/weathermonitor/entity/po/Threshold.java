package com.fyp.weathermonitor.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.io.Serializable;


/**
 *
 */
public class Threshold implements Serializable {


	/**
	 *
	 */
	private Long id;

	/**
	 * 阈值名称
	 */
	private String name;

	/**
	 * 阈值类型
	 */
	private Integer type;

	/**
	 * 阈值数值
	 */
	private BigDecimal value;

	/**
	 * 阈值单位
	 */
	private String unit;


	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setType(Integer type){
		this.type = type;
	}

	public Integer getType(){
		return this.type;
	}

	public void setValue(BigDecimal value){
		this.value = value;
	}

	public BigDecimal getValue(){
		return this.value;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return this.unit;
	}

	@Override
	public String toString (){
		return "id:"+(id == null ? "空" : id)+"，阈值名称:"+(name == null ? "空" : name)+"，阈值类型:"+(type == null ? "空" : type)+"，阈值数值:"+(value == null ? "空" : value)+"，阈值单位:"+(unit == null ? "空" : unit);
	}
}
