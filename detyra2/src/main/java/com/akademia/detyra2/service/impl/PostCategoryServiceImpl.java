package com.akademia.detyra2.service.impl;

import com.akademia.detyra2.entity.PostCategory;
import com.akademia.detyra2.repository.impl.PostCategoryImpl;
import com.akademia.detyra2.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostCategoryServiceImpl implements BaseService<PostCategory, Integer> {
    @Autowired
    private PostCategoryImpl postCategoryDao;

    @Override
    public PostCategory save(PostCategory postCategory) throws Exception {
        return postCategoryDao.save(postCategory);
    }

    @Override
    public Optional<PostCategory> findById(Integer id) throws Exception {
        return postCategoryDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        postCategoryDao.deleteById(id);
    }

    @Override
    public List<PostCategory> showAll() throws Exception {
        return postCategoryDao.showAll();
    }
}
