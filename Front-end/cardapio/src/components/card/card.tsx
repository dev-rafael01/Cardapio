import "./card.css"

interface Cardprops{
 price: number,
 image: string,
 title: string
 
}

export function Card({price ,image, title}: Cardprops) {
    return(
        <div className="card"> 
        <img src={image}/>
        <h2>{title}</h2>
        <p>
            <b>Valor:</b>{price}
        </p>
     
        </div>
    )
    
}