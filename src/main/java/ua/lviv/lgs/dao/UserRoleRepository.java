//package ua.lviv.lgs.dao;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import ua.lviv.lgs.domain.Role;
//
//public interface UserRoleRepository extends JpaRepository<Role, Integer>{
//	
//	@Query("select a.role from Role a, user b where b.userName = ? and a.userId = b.userId")
//	List<String> findRolesByUsername(String username);
//
//}
