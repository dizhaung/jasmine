package core.com.dao.mapper;

import core.com.model.BlogLoan;
import core.com.model.BlogLoanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogLoanMapper {
    int countByExample(BlogLoanExample example);

    int deleteByExample(BlogLoanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogLoan record);

    int insertSelective(BlogLoan record);

    List<BlogLoan> selectByExampleWithBLOBs(BlogLoanExample example);

    List<BlogLoan> selectByExample(BlogLoanExample example);

    BlogLoan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogLoan record, @Param("example") BlogLoanExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogLoan record, @Param("example") BlogLoanExample example);

    int updateByExample(@Param("record") BlogLoan record, @Param("example") BlogLoanExample example);

    int updateByPrimaryKeySelective(BlogLoan record);

    int updateByPrimaryKeyWithBLOBs(BlogLoan record);

    int updateByPrimaryKey(BlogLoan record);

    int updateViewByGid(@Param("gid") String gid);
}