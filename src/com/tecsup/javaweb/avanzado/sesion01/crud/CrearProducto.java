package com.tecsup.javaweb.avanzado.sesion01.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tecsup.javaweb.avanzado.sesion01.jpa.Categoria;
import com.tecsup.javaweb.avanzado.sesion01.jpa.Producto;;

public class CrearProducto {
	private static final int CATEGORIAS_LACTEOS = 2;
	static EntityManagerFactory emf;
	static EntityManager em;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		emf=Persistence.createEntityManagerFactory("JavaWebAvanzado_sesion01_JPA");	
		em=emf.createEntityManager();
			
		try {
			em.getTransaction().begin();
			
			Categoria cat=em.find(Categoria.class,CATEGORIAS_LACTEOS);
			System.err.println(cat);
			Producto prod2 =  new Producto();
		
			prod2.setNombre("agua");
			prod2.setDescripcion("Descripcion de agua");
			
			Producto prod3 =  new Producto();
			
			prod3.setNombre("laive");
			prod3.setDescripcion("Descripcion de laive");
			
			
			cat.addProducto(prod2);
			
			em.persist(prod2);
            cat.addProducto(prod3);
			
			em.persist(prod3);
			em.getTransaction().commit();

		}catch(Exception e) {
			em.getTransaction().rollback();	
		}finally {
			em.close();
			emf.close();

		}
	}

}
