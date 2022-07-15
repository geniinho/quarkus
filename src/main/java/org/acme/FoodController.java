package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class FoodController {

    public Food update(Long id, Food food) {
        Food foodEntity = Food.findById(id);
        if (foodEntity == null) {
            throw new WebApplicationException("Food with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }
        foodEntity.setName(food.getName());
        foodEntity.setCalories(food.getCalories());
        return foodEntity;
    }

    public boolean isFoodNameIsNotEmpty(Food food) {
        return food.getName().isEmpty();
    }
}
