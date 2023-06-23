package com.hex.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hex.backend.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
	
	public Object findByuserName(String name);
	public Object findByuserAddress(String addr);
	public Object findByuserPhone(long phone);
	
	@Modifying
    @Query(value = "UPDATE USER SET USERPASSWORD = :pass WHERE USERID = :id", nativeQuery=true)
    public int updatePassword(@Param("pass") String pass, @Param("id") String id);
	
	@Modifying
    @Query(value="UPDATE USER SET USERMAIL = :mail WHERE USERID = :id",nativeQuery=true)
    public int updateMail(@Param("mail") String mail,@Param("id") String id);
    
    @Modifying
    @Query(value="UPDATE USER SET USERPHONE = :phone WHERE USERID = :id",nativeQuery=true)
    public int updatePhone(@Param("phone") long phone,@Param("id") String id);
    
    @Modifying
    @Query(value="DELETE FROM USER WHERE USERID = :id",nativeQuery=true)
    public int deleteAdmin(@Param("id") String id);
}
