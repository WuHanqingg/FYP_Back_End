package com.fyp.weathermonitor.entity.query;

import java.math.BigDecimal;


/**
 * 参数
 */
public class ThresholdQuery extends BaseParam {


	/**
	 * 
	 */
	private Long id;

	/**
	 * 阈值名称
	 */
	private String name;

	private String nameFuzzy;

	/**
	 * 阈值类型
	 */
	private Integer type;

	/**
	 * 阈值数值
	 */
	private BigDecimal value;


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

	public void setNameFuzzy(String nameFuzzy){
		this.nameFuzzy = nameFuzzy;
	}

	public String getNameFuzzy(){
		return this.nameFuzzy;
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

}
