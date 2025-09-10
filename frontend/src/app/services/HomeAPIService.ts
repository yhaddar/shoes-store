import axios from "axios";

export class HomeAPIService{
    private static host?: string = process.env.NEXT_PUBLIC_API_HOST;
    private static port?: string = process.env.NEXT_PUBLIC_API_PORT;

    public static async getBrandsWithShoes() {
        const response = await axios.get(`${this.host}:${this.port}/api/brand/with-shoes`);
        return response.data;
    }

}