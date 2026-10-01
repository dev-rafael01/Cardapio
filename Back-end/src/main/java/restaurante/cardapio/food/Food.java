package restaurante.cardapio.food;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "foods")
@Entity (name = "foods")
public class Food {

    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String image;
    private Integer price;
    private String title;

    public Food(){

    }

    public Food(long id, String image, Integer price, String title) {
        this.id = id;
        this.image = image;
        this.price = price;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Food other = (Food) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public Food(FoodResponseDTO data)
    {
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
    }




    

    

}



