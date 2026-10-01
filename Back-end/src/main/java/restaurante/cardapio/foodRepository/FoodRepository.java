package restaurante.cardapio.foodRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurante.cardapio.food.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
