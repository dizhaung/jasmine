package core.com.dao.impl;

import core.com.dao.ConfigBlogMarkDao;
import core.com.dao.mapper.ConfigBlogMarkMapper;
import core.com.model.ConfigBlogMark;
import core.com.model.ConfigBlogMarkExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 标签记录表
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

    @Override
    public List<ConfigBlogMark> queryConfigByBlogGid(String blogGid) {
        ConfigBlogMarkExample example = new ConfigBlogMarkExample();
        example.createCriteria().andBlogGidEqualTo(blogGid);
        return configBlogMarkMapper.selectByExample(example);
    }

    @Override
    public List<ConfigBlogMark> queryConfigByMarkGid(String markGid) {
        ConfigBlogMarkExample example = new ConfigBlogMarkExample();
        example.createCriteria().andMarkGidEqualTo(markGid);
        return configBlogMarkMapper.selectByExample(example);
    }

    @Override
    public int deleteByBlog(String blogGid, List<String> markList) {
        ConfigBlogMarkExample example = new ConfigBlogMarkExample();
        example.createCriteria().andBlogGidEqualTo(blogGid)
                .andMarkGidIn(markList);
        return configBlogMarkMapper.deleteByExample(example);
    }
}
