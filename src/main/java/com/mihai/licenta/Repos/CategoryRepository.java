package com.mihai.licenta.Repos;

import com.mihai.licenta.Models.DBModels.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Created by mihai on 15.06.2017.
 */
public interface CategoryRepository extends JpaRepository<Categories, Long> {

    @Transactional
    @Query(nativeQuery = true,value = "SELECT DISTINCT(c.name) FROM categories c")
    Set<String> getAll();
}
