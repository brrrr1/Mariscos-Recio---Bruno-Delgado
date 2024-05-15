package com.salesianostriana.dam.pruebaproyecto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Usuario implements UserDetails {

	@Id
	@GeneratedValue
	private long id;
	private String username;
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private String password;
	private int numPedidos;
	private String direccion;
	private boolean esAdmin;
	private boolean esEmpleado;
//	private List<Producto> listaFavoritos;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Pedido> pedidos = new ArrayList<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";

		if (esAdmin) {
			role += "ADMIN";
		} else if (esEmpleado) {
			role += "EMPLEADO";
		}

		if (!esAdmin && !esEmpleado) {
			role += "USER";
		}

		return List.of(new SimpleGrantedAuthority(role));
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	@Builder.Default
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Favoritos> favoritos = new ArrayList<>();

}
