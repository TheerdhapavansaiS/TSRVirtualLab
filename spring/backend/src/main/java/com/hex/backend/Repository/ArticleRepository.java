package com.hex.backend.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hex.backend.Entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article,String> {
	
	public Object findByArtTitle(String title);
	public Object findByArtDate(Date dt);
	public List<Article> findByArtCatName(String name);

	 @Modifying
	 @Query(value="UPDATE ARTICLE SET ARTTITLE = :title WHERE ARTID = :id",nativeQuery=true)
	 public int updateArtTitle(@Param("title") String title,@Param("id") String id);
	 
	 @Modifying
	 @Query(value="UPDATE ARTICLE SET ARTDESC = :desc WHERE ARTID = :id",nativeQuery=true)
	 public int updateArtDescription(@Param("desc") String desc,@Param("id") String id);
	 
	 @Modifying
	 @Query(value="DELETE FROM ARTICLE WHERE ARTID = :id",nativeQuery=true)
	 public int deleteArticle(@Param("id") String id);

}
