package kr.co.fastcampus.eatgo.application;

import java.util.List;

import kr.co.fastcampus.eatgo.domain.Category;
import kr.co.fastcampus.eatgo.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    public Category addCategory(String name) {
        Category category = Category.builder().name(name).build();
        categoryRepository.save(category);
        return category;
    }
}
