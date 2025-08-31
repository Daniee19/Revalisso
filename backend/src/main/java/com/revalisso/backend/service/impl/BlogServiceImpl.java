package com.revalisso.backend.service.impl;

import com.revalisso.backend.dto.BlogDTO;
import com.revalisso.backend.entity.Blog;
import com.revalisso.backend.repository.BlogRepository;
import com.revalisso.backend.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<BlogDTO> getBlogByIdUsuario(Long id_usuario) {
        List<BlogDTO> lista = new ArrayList<BlogDTO>();
        blogRepository.findBlogsByIdUsuario(id_usuario).forEach(
                b -> {
                    lista.add(new BlogDTO(b));
                });
        return lista;
    }
}
