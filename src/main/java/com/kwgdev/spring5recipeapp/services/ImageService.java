package com.kwgdev.spring5recipeapp.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * created by kw on 8/16/2020 @ 3:51 AM
 */
public interface ImageService {

    void saveImageFile(Long recipeId, MultipartFile file);
}
