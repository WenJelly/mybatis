package test.com.mybatis.test;

import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
 *@Time：2023/3/18
 *@Author：Jelly
 */
public class MBGTest {

    @Test
    public void testMBG(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
            List<Emp> emps = mapper.selectByExample(null);
            emps.forEach(emp -> System.out.println(emp));
            //根据条件查询
            EmpExample empExample = new EmpExample();
            empExample.createCriteria().andEmpNameEqualTo("JELLY1").andAgeGreaterThanOrEqualTo(10);
            empExample.or().andDidIsNull();
            List<Emp> emps1 = mapper.selectByExample(empExample);
            emps1.forEach(emp -> System.out.println(emp));

            //选择性修改
            mapper.updateByPrimaryKeySelective(new Emp(1,"果冻",16,null,"2.23",null));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
