
export interface brandInerface {
    id: string,
    name: string,
    image: string,
}

export interface initialStateInterface {
    loading: boolean,
    data: brandInerface[] | null,
    error: null,
}