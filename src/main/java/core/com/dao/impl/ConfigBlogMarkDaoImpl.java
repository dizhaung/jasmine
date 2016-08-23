package core.com.dao.impl;

import core.com.dao.ConfigBlogMarkDao;
import core.com.dao.mapper.ConfigBlogMarkMapper;
import core.com.model.ConfigBlogMark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangjianan on 16-8-23.
 */
@Repository
public class ConfigBlogMarkDaoImpl implements ConfigBlogMarkDao {

    @Autowired
    private ConfigBlogMarkMapper configBlogMarkMapper;

    @Override
    public int insertConfigBatch(List<ConfigBlogMark> configBlogMarkList) {
        return configBlogMarkMapper.insertConfigBatch(configBlogMarkList);
    }
}
