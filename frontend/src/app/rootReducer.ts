import {combineReducers} from "redux";
import {HeroComponentStore} from "@/app/features/home/Home.slice";
import {BrandsStore} from "@/app/features/brands/Brands.slice";

export const rootReducer = combineReducers({
   heroComponent: HeroComponentStore.reducer,
   brands: BrandsStore.reducer,
});