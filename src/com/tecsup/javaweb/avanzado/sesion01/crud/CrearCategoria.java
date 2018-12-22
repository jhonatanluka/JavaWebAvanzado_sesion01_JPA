package com.tecsup.javaweb.avanzado.sesion01.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tecsup.javaweb.avanzado.sesion01.jpa.Categoria;

public class CrearCategoria {
	

	static EntityManagerFactory emf;
	static EntityManager em;
		
	
	public static void main(String[] args) {
		
		
	emf=Persistence.createEntityManagerFactory("JavaWebAvanzado_sesion01_JPA");	
	em=emf.createEntityManager();
		
	try {
		em.getTransaction().begin();
		
		Categoria emp =  new Categoria();
		
		emp.setNombre("Gaseosa");
		emp.setDescripcion("Descripcion de gaseosa");
		em.persist(emp);
		
		em.getTransaction().commit();

	}catch(Exception e) {
		em.getTransaction().rollback();	
	}finally {
		em.close();
		emf.close();

	}
//	em.close();
//	emf.close();
	}
}
