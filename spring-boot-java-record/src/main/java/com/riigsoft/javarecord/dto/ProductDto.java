package com.riigsoft.javarecord.dto;

import java.math.BigDecimal;
/***
 * @author Abdallah Mahmoud
 * @linkedin https://www.linkedin.com/in/abdallahmahmud/
 * */
public record ProductDto(Long id, String name, BigDecimal unitPrice) {
}
