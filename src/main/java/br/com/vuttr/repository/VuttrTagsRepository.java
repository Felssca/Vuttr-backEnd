package br.com.vuttr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.vuttr.domain.entity.VuttrMain;
import br.com.vuttr.domain.entity.VuttrTags;

@Repository
public interface VuttrTagsRepository extends JpaRepository<VuttrTags, Integer> {
	
	@Query("SELECT m FROM VuttrTags m WHERE m.title LIKE %:word%")
	Optional<List<VuttrMain>> searchByTagsLike(@Param("word") String word);

}
