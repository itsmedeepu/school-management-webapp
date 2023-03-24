import java.util.HashMap;
import java.util.List;

import com.deepak.Admin.Admin;
import com.deepak.Admin.AdminDaoImp;
import com.deepak.Student.Student;
import com.deepak.Teacher.Teacher;

public class Test {

	public static void main(String[] args) {
//		Student student = new Student();
//		student.setId("STU001");
//		student.setName("test");
//		student.setEmail("test@gmail");
//		student.setPhone("478596325");
//		student.setGender("Male");
//		student.setDob("2022-02-14");
//		student.setAddress("banglaore");
		AdminDaoImp adminDaoImp = new AdminDaoImp();
		List<HashMap<String, String>> updateAdmin = adminDaoImp.getAllSubjects();
		updateAdmin.forEach(e->System.out.println(e.get("subjectid")+" "+e.get("subjectname")));

	}

}
