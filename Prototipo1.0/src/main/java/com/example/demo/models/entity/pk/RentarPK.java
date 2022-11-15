package com.example.demo.models.entity.pk;

import java.io.Serializable;
import java.util.Objects;

import com.example.demo.models.entity.Producto;
import com.example.demo.models.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RentarPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Producto producto;
	
	
}
