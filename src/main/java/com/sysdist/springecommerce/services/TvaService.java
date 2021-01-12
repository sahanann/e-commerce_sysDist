package com.sysdist.springecommerce.services;

import com.sysdist.springecommerce.models.Category;
import org.springframework.stereotype.Service;

@Service
public class TvaService {

    public TvaService() {}

    public int tvaPercent(Category category) {
        if (category.getId() == 1)
            return 6;
        else
            return 21;
    }
}
