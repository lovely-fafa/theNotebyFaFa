package dao.impl;

import dao.EmpDao;
import com.itheima.pojo.Emp;
import com.itheima.utils.XmlParserUtils;
import org.springframework.stereotype.Component;

import java.util.List;


// @Component("dao")
@Component
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        // String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        // System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse("E:\\程序员\\发发的笔记\\itheima_web_project\\springboot-web-req-resp\\src\\main\\resources\\emp.xml", Emp.class);
        return empList;
    }
}
