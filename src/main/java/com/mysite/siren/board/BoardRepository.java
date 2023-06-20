package com.mysite.siren.board;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long>{
	Board findBySubject(String subject);
	Board findBySubjectAndContent(String subject, String content);
	List<Board> findBySubjectLike(String subject);
	Page<Board> findAll(Pageable pageable);
	@Modifying
	@Query("update Board p set p.hits = p.hits + 1 where p.id = :id")
	int updateView(@Param("id") Long id);
}
