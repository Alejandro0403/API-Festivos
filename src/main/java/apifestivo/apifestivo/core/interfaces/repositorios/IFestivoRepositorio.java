
package apifestivo.apifestivo.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apifestivo.apifestivo.dominio.entidades.festivo;

@Repository
public interface IFestivoRepositorio extends  JpaRepository<festivo, Integer> {

}
