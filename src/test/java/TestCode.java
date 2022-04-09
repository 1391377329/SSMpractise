import com.sqt.bean.Department;
import com.sqt.bean.DepartmentExample;
import com.sqt.bean.Employee;
import com.sqt.bean.EmployeeExample;
import com.sqt.dao.mapper.DepartmentMapper;
import com.sqt.dao.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringMVC.xml"})
public class TestCode {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void test1(){

//        System.out.println("--------------------------");
//        System.out.println(departmentMapper);
//        System.out.println("--------------------------");
//        departmentMapper.insert(new Department(1,"测试部"));
//        departmentMapper.insert(new Department(2,"开发部"));
//        List<Department> list = departmentMapper.selectByExample(new DepartmentExample());
//        list.forEach(System.out::println);
//        employeeMapper.insert(new Employee(null,"张三",18,"男",1));
//        employeeMapper.insert(new Employee(null,"李四",19,"女",2));

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        for(int i=0;i<1000;i++){
            String UID = UUID.randomUUID().toString().substring(0, 5);
            mapper.insert(new Employee(null,UID+i,(int)((Math.random()*100)/10),"男",1));
        }

        System.out.println(sqlSession);

    }
}
