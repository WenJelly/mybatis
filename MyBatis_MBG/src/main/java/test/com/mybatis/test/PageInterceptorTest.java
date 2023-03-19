package test.com.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
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
public class PageInterceptorTest {

    /**
     * 演示分页功能
     * limit index pageSize
     * index:当前页的起始索引
     * pageSize:每页显示的条数
     * pageNum:当前页的页码
     * index=(pageNum-1) * pageSize
     *
     * 使用分页插件功能:
     * 1.需要在查询功能之前开启分页
     * PageHelper.startPage(2,4);
     * 2.在查询功能之后获取分页相关信息
     * PageInfo<Emp> page = new PageInfo<>(list,5);
     * list表示分页数据
     * 5表示当前导航分页数量
     *
     */


    @Test
    public void testMBG() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            //分页功能
            PageHelper.startPage(2,4);
            List<Emp> emps = mapper.selectByExample(null);
            emps.forEach(emp -> System.out.println(emp));
            PageInfo<Emp> page = new PageInfo<>(emps,5);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
