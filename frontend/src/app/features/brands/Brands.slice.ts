import {initialStateInterface} from "@/app/features/brands/Brands.type";
import {createSlice} from "@reduxjs/toolkit";
import {BrandsThunk} from "@/app/features/brands/Brands.thunk";
import {Caching} from "@/app/utils/caching";

const initialState: initialStateInterface = {
    loading: false,
    data: [],
    error: null
}

export const BrandsStore = createSlice({
    name: "brandSlice",
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder
        .addCase(BrandsThunk.pending, state => {
            state.loading = true;
            state.data = null;
            state.error = null
        })
        .addCase(BrandsThunk.fulfilled, (state, action) => {
            state.loading = false;
            state.data = action.payload;
            state.error = null;
        })
        .addCase(BrandsThunk.rejected, (state, action) => {
            state.loading = true;
            state.data = null;
//            state?.error = action.error
        });
    }
})