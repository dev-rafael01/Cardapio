package restaurante.cardapio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restaurante.cardapio.food.Food;
import restaurante.cardapio.food.FoodResponseDTO;
import restaurante.cardapio.foodRepository.FoodRepository;

@RestController 
@RequestMapping(value = "/food")
@CrossOrigin(origins = "*", allowedHeaders = "*") // <-- ADICIONA ESTA LINHA 
public class FoodController {

    @Autowired 
    private FoodRepository  foodepository;


    @PostMapping 
    public void saveFood(@RequestBody FoodResponseDTO data)
    {
        Food foodData = new Food(data);
        foodepository.save(foodData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping 
    public List<FoodResponseDTO> getAll()
    {
       List<FoodResponseDTO> foodlist = foodepository.findAll().stream().map(FoodResponseDTO::new).toList();

       return foodlist;
 
    }
}


