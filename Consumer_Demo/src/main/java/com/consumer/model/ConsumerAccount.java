package com.consumer.model;



import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ConsumerAccount {
	
	Integer accountNo;
	String ifseCode;
	String branch;
	String accountHolderName;
}
