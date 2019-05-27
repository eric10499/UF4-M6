package DAO;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class DepartamentoImpl implements DepartamentoDAO {

	static ODB db;


	public ODB getOdb() {
		return db;
	}

	public void setOdb(ODB db) {
		this.db = db;
	}

	public DepartamentoImpl() {
		this.db = ODBFactory.open("Departamento.DB");
	}

	@Override
	public boolean insertarDep(Departamento dep) {
		try {
			db.store(dep);
			return true;
		} catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean eliminarDep(int deptno) {
		try {
			Objects<Departamento> objects = db.getObjects(Departamento.class);
			for(Departamento dep : objects) {
				if(dep.getDeptNo() == deptno) {
					db.delete(dep);
				}
			} 
			return true;
		} catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean modificarDep(int deptno, Departamento dep) {
		try {
			Objects<Departamento> objects = db.getObjects(Departamento.class);
			for(Departamento depart : objects) {
				if(depart.getDeptNo() == deptno) {
					depart.setDeptNo(dep.getDeptNo());
					depart.setdNombre(dep.getdNombre());
					depart.setLoc(dep.getLoc());
					db.store(depart);
				}
			} 
			return true;
		} catch(Exception e){
			return false;
		}
	}

	@Override
	public Departamento consultarDep(int deptno) {
		Departamento departamentoElegido = null;
		Objects<Departamento> objects = db.getObjects(Departamento.class);
		for(Departamento depart : objects) {
			if(depart.getDeptNo() == deptno) {
				System.out.println(depart.getDeptNo() + " - " + depart.getdNombre() + " - " + depart.getLoc());
				departamentoElegido = depart;
			}
		}
		return departamentoElegido;
	}

}
