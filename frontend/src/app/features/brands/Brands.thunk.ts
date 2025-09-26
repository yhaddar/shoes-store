import {createAsyncThunk} from "@reduxjs/toolkit";
import {BrandAPIService} from "@/app/services/BrandAPIService";

export const BrandsThunk = createAsyncThunk(
    "brandsThunk",
    async () => {
        return await BrandAPIService.getBrands();
    }
)