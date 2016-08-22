package com.gwt.calculator.server;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequiredData {
	
	
	    private Long id;

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }
	    
	    public Double decimalNumber;
	    
	    public String binaryNumber;
	    
	    public Date requestedTime;
	    
}
