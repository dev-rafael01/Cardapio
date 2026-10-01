import { useEffect, useState } from 'react';
import { useFoodDataMutate } from '../hooks/userFoodDataMutate';
import type { FoodData } from '../../interface/FoodData';
import "./modal.css";

interface InputProps {
    label: string;
    value: string | number;
    updateValue: (value: any) => void;
}

interface ModalProps {
    closeModal() : void
}

const Input = ({ label, value, updateValue }: InputProps) => {
    return (
        <div className="input-group">
            <label>{label}</label>
            <input
                value={value}
                onChange={(event) => updateValue(event.target.value)}
            />
        </div>
    );
};

export function CreateModal({ closeModal }: ModalProps) {
    const [title, setTitle] = useState("");
    const [price, setPrice] = useState(0);
    const [image, setImage] = useState("");
    
    // O useFoodDataMutate() devolve o objeto do useMutation, 
    // então desestruturamos a função mutate de dentro dele:
    const { mutate, isSuccess } = useFoodDataMutate();

    const submit = () => {
        const foodData: FoodData = {
            title,
            price,
            image
        };
        
        // Chama o envio dos dados
        mutate(foodData);
    };

    useEffect(() => {
        if(!isSuccess) return
        closeModal();
    }, [isSuccess])

    return (
        <div className='modal-overflow'>
            <div className='modal-body'>
                <h2>Cadastre um novo item no cardápio</h2>
                <form className='input-container'>
                    <Input label="title" value={title} updateValue={(value) => setTitle(String(value))} />
                    <Input label="price" value={price} updateValue={(value) => setPrice(Number(value))} />
                    <Input label="image" value={image} updateValue={(value) => setImage(String(value))} />
                </form>
                {/* Garante que o botão seja do tipo button para não recarregar a página num <form> */}
                <button type="button" onClick={submit} className='btn-secondary'>
                    Postar
                </button>
            </div>
        </div>
    );
}
