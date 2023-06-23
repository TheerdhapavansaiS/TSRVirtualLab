package com.hex.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hex.backend.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String>{
	
	public Category findBycatName(String name);
	
	@Modifying
    @Query(value="DELETE FROM CATEGORY WHERE CATNAME = :name",nativeQuery=true)
    public int deleteCategory(@Param("name") String name);

}
