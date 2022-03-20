package servicios;

import dao.DaoAlumno;
import dao.DaoAsignaturas;


public class ServicioAlumno {

    public boolean ponerNotaAlumno(String dniAlumno, String asignatura, int notaAlumno) {
        DaoAlumno daoAlumno = new DaoAlumno();
        boolean esAlumno = daoAlumno.esAlumno(dniAlumno);

        if (esAlumno) {
            daoAlumno.agregarNota(dniAlumno, asignatura, notaAlumno);
        }
        return esAlumno;

    }

    public boolean puedeMatricularAsignatura(String dniAlumno, String asignatura) {
        DaoAlumno daoAlumno = new DaoAlumno();
        DaoAsignaturas daoAsignaturas = new DaoAsignaturas();
        boolean puedeMatricular = false;

        double dineroAlumno = daoAlumno.dineroTieneAlumno(dniAlumno);
        double costeMatricula = daoAsignaturas.costeMatricula(asignatura);

        if (dineroAlumno > costeMatricula) {
            puedeMatricular = true;
        }
        return puedeMatricular;
    }

    public boolean matricularAlumnoEnAsignatura(String dniAlumno, String asignatura) {
        DaoAlumno daoAlumno = new DaoAlumno();
        DaoAsignaturas daoAsignaturas = new DaoAsignaturas();
        boolean seHaLogrado = false;
        boolean puedeMatricularEstaClase = puedeMatricularAsignatura(dniAlumno, asignatura);
        int plazasAsignatura= daoAsignaturas.plazasAsignatura(asignatura);

        if (puedeMatricularEstaClase && plazasAsignatura>0) {

            daoAlumno.agregarAlumnoAsignatura(dniAlumno, asignatura);

            seHaLogrado = true;
        }
        return seHaLogrado;
    }


}
