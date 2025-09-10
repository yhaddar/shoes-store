import {createAsyncThunk} from "@reduxjs/toolkit";
import {HomeAPIService} from "@/app/services/HomeAPIService";


export const heroComponentThunk = createAsyncThunk(
    "homeThunk/heroComponentThunk",
    async () => {
        return await HomeAPIService.getBrandsWithShoes();
    }
)