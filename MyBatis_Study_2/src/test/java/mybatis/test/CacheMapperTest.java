package mybatis.test;

import com.mybatis.mapper.CacheMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/*
 *@Time：2023/3/17
 *@Author：Jelly
 */
public class CacheMapperTest {

    /**
     一级缓存:自动开启
     1.调用第二次且值相同的时候是从缓存中读取数据的,一级缓存是默认开启
     是sqlSession级别的,也就是说不同个mapper对象,但是是来自同一个sqlSession的话
     也能缓存,但是不同的sqlSession的话就不会缓存
     让缓存失效的方法
     2.任意一次增删改都会清楚缓存
     3.手动清空缓存,sqlSession.clearCache
     二级缓存:手动开启
     1.级别:SqlSessionFactory同一个创建出来的sqlSession都能够缓存
     a>在核心配置文件中，设营全局配置属性cacheEnabled="true"，默认为true。不需要设置
     b>在映射文性中设苦标签<cache />
     c>二级缓存必须在SqlSession关闭或提交之后有效
     commit or close
     d>查询的数据所转换的实件类类型必须实现序列化的接口使二级缓存失效的情况:
     两次查询之间执行了任意的塔动改,会便一级和二级缓存同时失效
     手动清空不会使二级缓存失效
     */

    //如果需要创建二级缓存就不能在使用utils创建了,因为里面每一个SqlSession都是由一个Factory创建的

    @Test
    public void testCache() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empByEid = mapper.getEmpByEid(1);
        System.out.println(empByEid);
        Emp empByEid1 = mapper.getEmpByEid(1);
        System.out.println(empByEid1);
    }

}
