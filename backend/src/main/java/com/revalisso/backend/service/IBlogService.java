package com.revalisso.backend.service;

import com.revalisso.backend.dto.BlogDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBlogService {
    public List<BlogDTO> getBlogByIdUsuario(Long id_usuario);
}
