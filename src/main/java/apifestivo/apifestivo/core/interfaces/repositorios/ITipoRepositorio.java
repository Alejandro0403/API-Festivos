package apifestivo.apifestivo.core.interfaces.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apifestivo.apifestivo.dominio.entidades.tipo;

@Repository
public interface ITipoRepositorio extends JpaRepository<tipo, Integer> {

}
