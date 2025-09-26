import axios from "axios";

export class BrandAPIService {

    private static host?: string = process.env.NEXT_PUBLIC_API_HOST;
    private static port?: string = process.env.NEXT_PUBLIC_API_PORT;
    private static key?: string = 'brand';

    public static async getBrands() {
        const data = await axios.get(`${this.host}:${this.port}/api/${this.key}`);
        return await data.data;
    }
}