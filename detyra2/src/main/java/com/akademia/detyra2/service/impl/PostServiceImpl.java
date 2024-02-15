package com.akademia.detyra2.service.impl;

import com.akademia.detyra2.entity.Post;
import com.akademia.detyra2.repository.impl.PostDaoImpl;
import com.akademia.detyra2.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostServiceImpl implements BaseService<Post, Integer> {

    @Autowired
    private PostDaoImpl postDao;

    @Override
    public Post save(Post post) throws Exception {
        return postDao.save(post);
    }

    @Override
    public Optional<Post> findById(Integer id) throws Exception {
        return postDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        postDao.deleteById(id);
    }

    @Override
    public List<Post> showAll() throws Exception {
        return postDao.showAll();
    }
}
