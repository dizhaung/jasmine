package core.com.dao.mapper;

import core.com.model.BlogLoan;
import core.com.model.BlogLoanExample;
import core.com.model.BlogLoanWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogLoanMapper {
    int countByExample(BlogLoanExample example);

    int deleteByExample(BlogLoanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogLoanWithBLOBs record);

    int insertSelective(BlogLoanWithBLOBs record);

    List<BlogLoanWithBLOBs> selectByExampleWithBLOBs(BlogLoanExample example);

    List<BlogLoan> selectByExample(BlogLoanExample example);

    BlogLoanWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogLoanWithBLOBs record, @Param("example") BlogLoanExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogLoanWithBLOBs record, @Param("example") BlogLoanExample example);

    int updateByExample(@Param("record") BlogLoan record, @Param("example") BlogLoanExample example);

    int updateByPrimaryKeySelective(BlogLoanWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BlogLoanWithBLOBs record);

    int updateByPrimaryKey(BlogLoan record);

    int updateViewByGid(@Param("gid") String gid);
}