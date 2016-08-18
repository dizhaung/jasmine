package core.com.dao.impl;

import core.com.dao.BlogDao;
import org.springframework.stereotype.Repository;

/**
 * Blog dao
 * Created by wangjianan on 16-8-18.
 */
@Repository
public class BlogDaoImpl implements BlogDao {

    @Override
    public int insert() {
//        return blogMapper.insertSelective(blog);
        return 0;
    }
}
