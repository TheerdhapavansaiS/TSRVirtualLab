package com.hex.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hex.backend.Entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String>{
	
	public Admin[] findByAdminName(String name);
	public Admin findByAdminPhone(long phone);
	public Admin findByAdminMail(String mail);
	
	
    @Modifying
    @Query(value = "UPDATE ADMIN SET ADMINPASSWORD = :pass WHERE ADMINID = :id", nativeQuery=true)
    public int updatePassword(@Param("pass") String pass, @Param("id") String id);
    
    @Modifying
    @Query(value="UPDATE ADMIN SET ADMINMAIL = :mail WHERE ADMINID = :id",nativeQuery=true)
    public int updateMail(@Param("mail") String mail,@Param("id") String id);
    
    @Modifying
    @Query(value="UPDATE ADMIN SET ADMINPHONE = :phone WHERE ADMINID = :id",nativeQuery=true)
    public int updatePhone(@Param("phone") long phone,@Param("id") String id);
    
    @Modifying
    @Query(value="DELETE FROM ADMIN WHERE ADMINID = :id",nativeQuery=true)
    public int deleteAdmin(@Param("id") String id);

}
