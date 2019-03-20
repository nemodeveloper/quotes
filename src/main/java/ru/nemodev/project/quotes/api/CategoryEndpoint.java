package ru.nemodev.project.quotes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.nemodev.project.quotes.api.converter.CategoryToDTOConverter;
import ru.nemodev.project.quotes.api.dto.CategoryDTO;
import ru.nemodev.project.quotes.service.category.CategoryService;

import java.util.List;


/**
 * created by NemoDev on 19.07.2018 - 12:21
 */
@Controller
@RequestMapping("/v1/category")
@ResponseBody
public class CategoryEndpoint
{
    private final CategoryService categoryService;
    private final CategoryToDTOConverter categoryToDTOConverter;

    // TODO сделать RestRequestProcessor который икапсулирует логику обработку запросов
    @Autowired
    public CategoryEndpoint(CategoryService categoryService, CategoryToDTOConverter categoryToDTOConverter)
    {
        this.categoryService = categoryService;
        this.categoryToDTOConverter = categoryToDTOConverter;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<CategoryDTO> getList()
    {
        return categoryToDTOConverter.convertList(categoryService.getList());
    }
}
