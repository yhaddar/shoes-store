import {createSlice} from "@reduxjs/toolkit";
import {heroComponentThunk} from "@/app/features/home/Home.thunk";
import { initialStateType } from "./Home.type";

const initialState: initialStateType = {
    loading: true,
    data: null,
    error: null
}

export const HeroComponentStore = createSlice({
    name: "heroComponentStore",
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder
            .addCase(heroComponentThunk.pending, state => {
                state.loading = true;
                state.data = null;
                state.error = null;
            })
            .addCase(heroComponentThunk.fulfilled, (state, action) => {
                state.loading = false;
                state.data = action.payload;
                state.error = null;
            })
            .addCase(heroComponentThunk.rejected, (state, action) => {
                state.loading = true;
                state.data = null;
                // state.error = action.payload
            });

    }
});