package dao_prueba;

import DAO.Departamento;
import DAO.DepartamentoDAO;
import DAO.DepartamentoImpl;

//Esta clase forma parte del otro proyecto, en el que ya he añadido el jar generado.

public class Prueba {

	public static void main(String[] args) {
		/* Empezará con una línea como la que sigue: */ 
		DepartamentoDAO depDAO =  new DepartamentoImpl( );
		Departamento dep = new Departamento(2, "INFORMÁTICA", "BARCELONA");
		Departamento depModificado = new Departamento(1, "INFORMÁTICA", "MADRID");
		 
		/* 1-- Inserta un nuevo departamento */ 
		depDAO.insertarDep(dep);
		/* 2-- Consulta el nuevo departamento */ 
		depDAO.consultarDep(dep.getDeptNo());
		/* 3-- Modifica algunos valores del nuevo departamento*/ 
		depDAO.modificarDep(dep.getDeptNo(), depModificado);
		System.out.println(depDAO.modificarDep(dep.getDeptNo(), depModificado));
		depDAO.consultarDep(dep.getDeptNo());
		/* 4-- Elimina el departamento creado */
		depDAO.eliminarDep(dep.getDeptNo());
		System.out.println(depDAO.modificarDep(dep.getDeptNo(), depModificado));
		depDAO.consultarDep(dep.getDeptNo());
		System.out.println("--------------");
	}

}
