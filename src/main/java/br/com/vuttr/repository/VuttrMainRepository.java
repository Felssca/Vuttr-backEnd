package br.com.vuttr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.vuttr.domain.entity.VuttrMain;
import io.swagger.annotations.ApiModel;

@Repository
@ApiModel(description = "Repositorio de acesso a base de dados JPA")
public interface VuttrMainRepository extends JpaRepository<VuttrMain, Integer> {
	
	@Query("SELECT m FROM VuttrMain m WHERE m.title LIKE %:word%")
	Optional<List<VuttrMain>> searchByTitleLike(@Param("word") String word);

}
