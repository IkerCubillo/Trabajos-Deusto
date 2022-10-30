public class Main {
	public static void main(String[] args) {
		Asignatura a = new Asignatura();
		Asignatura a1 = new Asignatura();
		
		Asignatura[] aAsignaturas = {a,a1};
		
		Estudiante e = new Estudiante("Bruce Wayne", "0000", 1);
		e.anyadirAsignatura(a);
		e.anyadirAsignatura(a1);
		
		Grado g = new Grado("CdDeIA");
		g.anyadirEstudiante(e);
		
		System.out.println(g);
	}
}
