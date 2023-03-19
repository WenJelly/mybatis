package mybatis.test;

import com.mybatis.mapper.DynamicSqlMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/*
 *@Time：2023/3/16
 *@Author：Jelly
 */
public class DynamicSqlMapperTest {

    /**
     * 动态SQL:
     * 1.if:根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到SxQL中
     * 2.where: 当where标签中有内容时，会自动生戚where关键字，并且将内容前多余的and 或or去掉
     * 当where标签中没有内容时，此时here标签没有任何效果
     * 注意: where标签不能将其中内容后面多余的and或or去掉
     * 3.trim
     * 若标签中有内容时:
     * prefix|suffix﹔将trim标签中内容前面或后面添加指定内容
     * suffixOverrides|prefixOverrides:将trim标签中内容前面或后面去掉指定内容
     * 若标签中没有内容时，trim标签也没有任何效剽
     * 4.choose when otherwise 相当于if...else      ...else
     * when最少有一个,otherwise最多只有一个
     * 5.foreach
     * collection:设置需要茹环的数组或集合
     * item:表示数组或集合中的每一个数据separator:循环体之间的分割符
     * open:foreach标签所循坏的所有内容的开始符
     * close:foreach标签所循环的所有内容的结束符
     * separator:设置分割符
     * 6.sql标签
     * 设置sql片段
     * <sql id="empColumns">eid,emp_name,age,sex,email</sql>
     * 引用sql片段
     * select <include refid="empColumns">e'e
     */


    @Test
    public void testDeleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        int i = mapper.deleteMoreByArray(new Integer[]{1, 2});
        System.out.println(i);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<Emp> empByChoose = mapper.getEmpByChoose(new Emp(1, "JELLY1", 18, "男" , null));
        System.out.println(empByChoose);
    }

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Emp emp = new Emp(1, "JELLY1", null, "男", null);
        List<Emp> empByCondition = mapper.getEmpByCondition(emp);
        System.out.println(empByCondition);
    }

    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Emp emp1 = new Emp(null, "a", 100, "男", "1");
        Emp emp2 = new Emp(null, "a", 100, "男", "1");
        Emp emp3 = new Emp(null, "a", 100, "男", "1");
        Emp emp4 = new Emp(null, "a", 100, "男", "1");
        Emp emp5 = new Emp(null, "a", 100, "男", "1");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3, emp4, emp5);
        int i = mapper.insertMoreByList(emps);
        System.out.println(i);

    }

}
