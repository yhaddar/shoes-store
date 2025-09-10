export interface shoesSecondaryResponse {
    color: string;
    image: string;
    size: number;
}
export interface shoesForBrand {
    id: string;
    name: string;
    image: string;
    color: string;
    price: number;
    discount: number;
    stock: number;
    release_date: string;
    description: string | null;
    shoesSecondary: shoesSecondaryResponse[];
}

export interface brandWithShoes {
    brand: string;
    shoes: shoesForBrand | null;
}

export interface initialStateType {
    loading: boolean,
    data: brandWithShoes[] | null,
    error: null
}